/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * La clase Buscaminas representa la interfaz gráfica del juego Buscaminas.
 * Permite al usuario interactuar con el tablero, realizar movimientos, guardar y cargar partidas,
 * y utilizar algoritmos de búsqueda (BFS o DFS) para revelar casillas.
 *
 * @author Diego
 * @version 1.0
 */

public class Buscaminas extends JFrame {
    private Tablero tablero;
    private JButton[][] botones;
    private JPanel panelTablero;
    private JComboBox<String> metodoBusqueda;
    private FileChooser fileChooser = new FileChooser();
    private int banderasColocadas = 0;
    
     /**
     * Constructor de la clase Buscaminas.
     * Inicializa el tablero, los botones y la interfaz gráfica.
     *
     * @param filas    Número de filas del tablero.
     * @param columnas Número de columnas del tablero.
     * @param minas    Número de minas en el tablero.
     */

    public Buscaminas(int filas, int columnas, int minas) {
        this.tablero = new Tablero(filas, columnas, minas);
        this.botones = new JButton[filas][columnas];
        this.panelTablero = new JPanel(new GridLayout(filas, columnas));
        this.metodoBusqueda = new JComboBox<>(new String[]{"BFS", "DFS"});

        setTitle("Buscaminas");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inicializarInterfaz();
    }
     /**
     * Inicializa la interfaz gráfica del juego.
     * Configura los botones, el panel del tablero y los listeners de eventos.
     */

    private void inicializarInterfaz() {
        JPanel panelSuperior = new JPanel();
        panelSuperior.add(new JLabel("Método de búsqueda:"));
        panelSuperior.add(metodoBusqueda);
        add(panelSuperior, BorderLayout.NORTH);
        JButton botonGuardar = new JButton("Guardar");
        panelSuperior.add(botonGuardar);

        botonGuardar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String save = "";
                 for (int i = 0; i < tablero.getFilas(); i++) {
                    for (int j = 0; j < tablero.getColumnas(); j++) {
                        if(tablero.getCasilla(i,j).esMarcada()) save = save + "M";
                        if(tablero.getCasilla(i,j).esMina()) save = save + "B";
                        else if(tablero.getCasilla(i,j).esRevelada()) save = save + "R";
                        else if (!tablero.getCasilla(i,j).esMarcada()) save = save + "C";
                        if(j != tablero.getColumnas()-1) save = save + ",";
                    }
                     if(i != tablero.getFilas()-1)save = save + ";";
                 }
                 System.out.println(save);
                 fileChooser.guardarArchivo(save);
            }
        });
        // Crear los botones del tablero
        for (int i = 0; i < tablero.getFilas(); i++) {
            for (int j = 0; j < tablero.getColumnas(); j++) {
                JButton boton = new JButton();
                boton.setPreferredSize(new Dimension(50, 50));
                
                 // Cambiar el color de fondo de cada casilla a amarillo
                boton.setBackground(Color.YELLOW);
                boton.setOpaque(true);
                boton.setBorderPainted(false); // Opcional: quitar el borde para un aspecto más uniforme
                
                // Listener para clic izquierdo (revelar casilla)
                boton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        onCasillaClic((JButton) e.getSource());
                    }
                });
                // Listener para clic derecho (marcar con bandera)
                boton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (SwingUtilities.isRightMouseButton(e)) {
                            onCasillaClicDerecho((JButton) e.getSource());
                        }
                    }
                });
                botones[i][j] = boton;
                panelTablero.add(boton);
            }
        }

        add(panelTablero, BorderLayout.CENTER);
    }
    /**
     * Maneja el evento de clic en una casilla.
     * Revela la casilla y realiza el barrido correspondiente (BFS o DFS).
     *
     * @param boton El botón que representa la casilla clickeada.
     */
    private void onCasillaClic(JButton boton) {
        for (int i = 0; i < tablero.getFilas(); i++) {
            for (int j = 0; j < tablero.getColumnas(); j++) {
                if (botones[i][j] == boton) {
                    Casilla casilla = tablero.getCasilla(i, j);
                    if (casilla.esMina()) {
                        JOptionPane.showMessageDialog(this, "¡Has perdido!");
                        reiniciarJuego();
                    } else {
                        if (metodoBusqueda.getSelectedItem().equals("BFS")) {
                            barridoBFS(i, j);
                        } else {
                            barridoDFS(i, j);
                        }
                    }
                    checkWin();
                    return;
                }
            }
        }
    }
    /**
     * Verifica si el jugador ha ganado el juego.
     * El jugador gana si todas las casillas sin minas han sido reveladas.
     */
    private void checkWin(){
        int count = 0;
        int bombas = 0;
        for (int i = 0; i < tablero.getFilas(); i++) {
            for (int j = 0; j < tablero.getColumnas(); j++) {
                if( !tablero.getCasilla(i,j).esRevelada()){
                    count++;
                }
                if( tablero.getCasilla(i,j).esMina()){
                    bombas++;
                }
            }
        }
        if (bombas == count){
            JOptionPane.showMessageDialog(this, "¡Has Ganado!");
            reiniciarJuego();
        }
    }
    /**
     * Maneja el evento de clic derecho en una casilla.
     * Marca o desmarca la casilla con una bandera.
     *
     * @param boton El botón que representa la casilla clickeada.
     */
    private void onCasillaClicDerecho(JButton boton) {
        System.out.println("xd");
        for (int i = 0; i < tablero.getFilas(); i++) {
            for (int j = 0; j < tablero.getColumnas(); j++) {
                if (botones[i][j] == boton) {
                    Casilla casilla = tablero.getCasilla(i, j);
                    if (!casilla.esRevelada()) {
                        if (casilla.esMarcada()) {
                            casilla.setMarcada(false);
                            boton.setText("");
                            banderasColocadas--;
                        } else if (banderasColocadas < tablero.getMinas()) {
                            casilla.setMarcada(true);
                            boton.setText("🚩");
                            banderasColocadas++;
                        }
                    }
                    return;
                }
            }
        }
    }
    /**
     * Realiza un barrido en anchura (BFS) desde la casilla especificada.
     * Revela todas las casillas vacías conectadas y las casillas adyacentes con números.
     *
     * @param fila    Fila de la casilla inicial.
     * @param columna Columna de la casilla inicial.
     */
    private void barridoBFS(int fila, int columna) {
        Cola cola = new Cola();
        cola.encolar(fila + "," + columna);

        while (!cola.estaVacia()) {
            String[] coordenadas = cola.desencolar().split(",");
            int i = Integer.parseInt(coordenadas[0]);
            int j = Integer.parseInt(coordenadas[1]);
            Casilla casilla = tablero.getCasilla(i, j);

            if (!casilla.esRevelada()) {
                casilla.setRevelada(true);
                botones[i][j].setText(String.valueOf(casilla.getMinasAdyacentes()));
                botones[i][j].setEnabled(false);

                if (casilla.getMinasAdyacentes() == 0) {
                    for (int x = -1; x <= 1; x++) {
                        for (int y = -1; y <= 1; y++) {
                            if (x == 0 && y == 0) continue;
                            int nuevaFila = i + x;
                            int nuevaColumna = j + y;
                            if (nuevaFila >= 0 && nuevaFila < tablero.getFilas() && nuevaColumna >= 0 && nuevaColumna < tablero.getColumnas()) {
                                cola.encolar(nuevaFila + "," + nuevaColumna);
                            }
                        }
                    }
                }
            }
        }
    }
    /**
     * Realiza un barrido en profundidad (DFS) desde la casilla especificada.
     * Revela todas las casillas vacías conectadas y las casillas adyacentes con números.
     *
     * @param fila    Fila de la casilla inicial.
     * @param columna Columna de la casilla inicial.
     */
    private void barridoDFS(int fila, int columna) {
        Pila pila = new Pila();
        pila.push(fila + "," + columna);

        while (!pila.estaVacia()) {
            String[] coordenadas = pila.pop().split(",");
            int i = Integer.parseInt(coordenadas[0]);
            int j = Integer.parseInt(coordenadas[1]);
            Casilla casilla = tablero.getCasilla(i, j);

            if (!casilla.esRevelada()) {
                casilla.setRevelada(true);
                botones[i][j].setText(String.valueOf(casilla.getMinasAdyacentes()));
                botones[i][j].setEnabled(false);

                if (casilla.getMinasAdyacentes() == 0) {
                    for (int x = -1; x <= 1; x++) {
                        for (int y = -1; y <= 1; y++) {
                            if (x == 0 && y == 0) continue;
                            int nuevaFila = i + x;
                            int nuevaColumna = j + y;
                            if (nuevaFila >= 0 && nuevaFila < tablero.getFilas() && nuevaColumna >= 0 && nuevaColumna < tablero.getColumnas()) {
                                pila.push(nuevaFila + "," + nuevaColumna);
                            }
                        }
                    }
                }
            }
        }
    }
    /**
     * Carga las minas en el tablero desde una cadena de texto.
     *
     * @param save Cadena de texto que representa el estado del tablero.
     */
    public void cargarBombas(String save){
        String[] filas = save.split(";");
         for (int i = 0; i < tablero.getFilas(); i++) {
            String[] columnas = filas[i].split(",");
            for (int j = 0; j < tablero.getColumnas(); j++) {
                switch(columnas[j]){
                    case "MB" -> {
                    tablero.colocarMinasEn(i, j);
                    }
                    case "B" -> {
                    tablero.colocarMinasEn(i, j);
                    }
                }
            }
         }
         tablero.calcularMinasAdyacentes();
    }
    /**
     * Carga una partida desde una cadena de texto.
     * Restaura el estado del tablero y la interfaz gráfica.
     *
     * @param save Cadena de texto que representa el estado del tablero.
     */
    
    public void cargarPartida(String save){
        cargarBombas(save);
        String[] filas = save.split(";");
         for (int i = 0; i < tablero.getFilas(); i++) {
            String[] columnas = filas[i].split(",");
            for (int j = 0; j < tablero.getColumnas(); j++) {
                switch(columnas[j]){
                    case "M" -> {
                    tablero.getCasilla(i,j).setMarcada(true);
                    botones[i][j].setText("🚩");
                    banderasColocadas++;
                    }
                    case "MR" -> {
                    tablero.getCasilla(i,j).setRevelada(true);
                    tablero.getCasilla(i,j).setMarcada(true);
                    botones[i][j].setText("🚩");
                    banderasColocadas++;
                    }
                    case "MB" -> {
                    tablero.getCasilla(i,j).setMarcada(true);
                    botones[i][j].setText("🚩");
                    banderasColocadas++;
                    }
                    case "B" -> {
                        // No se hace nada, es una mina
                    }
                    case "R" -> {
                    tablero.getCasilla(i,j).setRevelada(true);
                    }
                    default -> {
                    tablero.getCasilla(i,j).setMina(false);
                    }
                }
            }
         }
        // Actualizar la interfaz gráfica 
        for (int i = 0; i < tablero.getFilas(); i++) {
          for (int j = 0; j < tablero.getColumnas(); j++) {
              if (tablero.getCasilla(i,j).esRevelada()){
                botones[i][j].setText(String.valueOf(tablero.getCasilla(i,j).getMinasAdyacentes()));
                botones[i][j].setEnabled(false);  
              }
          }
        }
    }
    /**
     * Reinicia el juego, cerrando la ventana actual y abriendo una nueva.
     */
    private void reiniciarJuego() {
        new Interfaz().setVisible(true);
        this.dispose();
    }
}