/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Random;

/**
 * La clase Tablero representa el tablero del juego Buscaminas.
 * Contiene una matriz de casillas y métodos para manipular el estado del juego,
 * como colocar minas, calcular minas adyacentes y obtener información sobre las casillas.
 *
 * @author Diego
 * @version 1.0
 */

public class Tablero {
    private int filas;
    private int columnas;
    private int minas;
    private Casilla[][] casillas;
    private ListaEnlazada minasPosiciones;

    /**
     * Constructor de la clase Tablero.
     * Inicializa el tablero con el número de filas, columnas y minas especificado.
     *
     * @param filas    Número de filas del tablero.
     * @param columnas Número de columnas del tablero.
     * @param minas    Número de minas en el tablero.
     */
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

    /**
     * Inicializa el tablero creando una casilla en cada posición.
     */
    private void inicializarTablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                String id = String.valueOf((char) ('A' + j)) + (i + 1);
                casillas[i][j] = new Casilla(id);
            }
        }
    }

    /**
     * Coloca las minas en el tablero de manera aleatoria.
     */
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
    
    /**
     * Coloca una mina en la posición especificada.
     *
     * @param fila    Fila donde se colocará la mina.
     * @param columna Columna donde se colocará la mina.
     */
     public void colocarMinasEn(int fila, int columna) {
            String id = String.valueOf((char) ('A' + columna)) + (fila + 1);
            if (!minasPosiciones.contiene(id)) {
                casillas[fila][columna].setMina(true);
                minasPosiciones.agregar(id);
            }
    }

     /**
     * Calcula el número de minas adyacentes para cada casilla que no contiene una mina.
     */
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

    /**
     * Obtiene la casilla en la posición especificada.
     *
     * @param fila    Fila de la casilla.
     * @param columna Columna de la casilla.
     * @return La casilla en la posición especificada.
     */
    public Casilla getCasilla(int fila, int columna) {
        return casillas[fila][columna];
    }

    /**
     * Obtiene el número de filas del tablero.
     *
     * @return El número de filas del tablero.
     */
    public int getFilas() {
        return filas;
    }

    /**
     * Obtiene el número de columnas del tablero.
     *
     * @return El número de columnas del tablero.
     */
    public int getColumnas() {
        return columnas;
    }

    /**
     * Obtiene el número de minas en el tablero.
     *
     * @return El número de minas en el tablero.
     */
    public int getMinas() {
        return minas;
    }
}