/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Random;

public class Tablero {
    private int filas;
    private int columnas;
    private int minas;
    private Casilla[][] casillas;
    private ListaEnlazada minasPosiciones;

    public Tablero(int filas, int columnas, int minas) {
        this.filas = filas;
        this.columnas = columnas;
        this.minas = minas;
        this.casillas = new Casilla[filas][columnas];
        this.minasPosiciones = new ListaEnlazada();
        inicializarTablero();
        colocarMinas();
        calcularMinasAdyacentes();
    }

    private void inicializarTablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                String id = String.valueOf((char) ('A' + j)) + (i + 1);
                casillas[i][j] = new Casilla(id);
            }
        }
    }

    private void colocarMinas() {
        Random random = new Random();
        int minasColocadas = 0;

        while (minasColocadas < minas) {
            int fila = random.nextInt(filas);
            int columna = random.nextInt(columnas);
            String id = String.valueOf((char) ('A' + columna)) + (fila + 1);

            if (!minasPosiciones.contiene(id)) {
                casillas[fila][columna].setMina(true);
                minasPosiciones.agregar(id);
                minasColocadas++;
            }
        }
    }
    
     public void colocarMinasEn(int fila, int columna) {
            String id = String.valueOf((char) ('A' + columna)) + (fila + 1);
            if (!minasPosiciones.contiene(id)) {
                casillas[fila][columna].setMina(true);
                minasPosiciones.agregar(id);
            }
    }

    public void calcularMinasAdyacentes() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (!casillas[i][j].esMina()) {
                    int minasAdyacentes = 0;
                    for (int x = -1; x <= 1; x++) {
                        for (int y = -1; y <= 1; y++) {
                            if (x == 0 && y == 0) continue;
                            int nuevaFila = i + x;
                            int nuevaColumna = j + y;
                            if (nuevaFila >= 0 && nuevaFila < filas && nuevaColumna >= 0 && nuevaColumna < columnas) {
                                if (casillas[nuevaFila][nuevaColumna].esMina()) {
                                    minasAdyacentes++;
                                }
                            }
                        }
                    }
                    casillas[i][j].setMinasAdyacentes(minasAdyacentes);
                }
            }
        }
    }

    public Casilla getCasilla(int fila, int columna) {
        return casillas[fila][columna];
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public int getMinas() {
        return minas;
    }
}