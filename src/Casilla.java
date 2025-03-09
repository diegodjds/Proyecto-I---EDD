/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * La clase Casilla representa una casilla individual en el tablero del juego Buscaminas.
 * Cada casilla tiene un identificador único, puede contener una mina, estar marcada con una bandera,
 * estar revelada y tener un número que indica la cantidad de minas adyacentes.
 *
 * @author TuNombre
 * @version 1.0
 */
public class Casilla {
    private String id;
    private boolean esMina;
    private boolean esMarcada;
    private boolean esRevelada;
    private int minasAdyacentes;
    
    /**
     * Constructor de la clase Casilla.
     * Inicializa una nueva casilla con un identificador único.
     *
     * @param id El identificador único de la casilla.
     */

    public Casilla(String id) {
        this.id = id;
        this.esMina = false;
        this.esMarcada = false;
        this.esRevelada = false;
        this.minasAdyacentes = 0;
    }

    /**
     * Obtiene el identificador único de la casilla.
     *
     * @return El identificador de la casilla.
     */
    public String getId() {
        return id;
    }

    /**
     * Indica si la casilla contiene una mina.
     *
     * @return true si la casilla contiene una mina, false en caso contrario.
     */
    public boolean esMina() {
        return esMina;
    }

    /**
     * Establece si la casilla contiene una mina.
     *
     * @param esMina true si la casilla contiene una mina, false en caso contrario.
     */
    public void setMina(boolean esMina) {
        this.esMina = esMina;
    }

    /**
     * Indica si la casilla está marcada con una bandera.
     *
     * @return true si la casilla está marcada, false en caso contrario.
     */
    public boolean esMarcada() {
        return esMarcada;
    }

    /**
     * Establece si la casilla está marcada con una bandera.
     *
     * @param esMarcada true si la casilla está marcada, false en caso contrario.
     */
    public void setMarcada(boolean esMarcada) {
        this.esMarcada = esMarcada;
    }

    /**
     * Indica si la casilla ha sido revelada.
     *
     * @return true si la casilla ha sido revelada, false en caso contrario.
     */
    public boolean esRevelada() {
        return esRevelada;
    }

    /**
     * Establece si la casilla ha sido revelada.
     *
     * @param esRevelada true si la casilla ha sido revelada, false en caso contrario.
     */
    public void setRevelada(boolean esRevelada) {
        this.esRevelada = esRevelada;
    }

    /**
     * Obtiene el número de minas en las casillas adyacentes.
     *
     * @return El número de minas adyacentes.
     */
    public int getMinasAdyacentes() {
        return minasAdyacentes;
    }

    /**
     * Establece el número de minas en las casillas adyacentes.
     *
     * @param minasAdyacentes El número de minas adyacentes.
     */
    public void setMinasAdyacentes(int minasAdyacentes) {
        this.minasAdyacentes = minasAdyacentes;
    }
}