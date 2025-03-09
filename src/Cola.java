/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * La clase Cola representa una estructura de datos de tipo cola (FIFO: First In, First Out).
 * Permite almacenar y manipular elementos en un orden específico, donde el primer elemento en entrar
 * es el primero en salir.
 *
 * @author Diego
 * @version 1.0
 */
public class Cola {
    private Nodo frente;
    private Nodo fin;

    /**
     * Constructor de la clase Cola.
     * Inicializa una cola vacía.
     */
    public Cola() {
        this.frente = null;
        this.fin = null;
    }

    /**
     * Agrega un elemento al final de la cola.
     *
     * @param valor El valor a agregar a la cola.
     */
    public void encolar(String valor) {
        Nodo nuevoNodo = new Nodo(valor);
        if (frente == null) {
            frente = nuevoNodo;
            fin = nuevoNodo;
        } else {
            fin.setSiguiente(nuevoNodo);
            fin = nuevoNodo;
        }
    }

    /**
     * Elimina y devuelve el elemento al frente de la cola.
     *
     * @return El valor del elemento eliminado, o null si la cola está vacía.
     */
    public String desencolar() {
        if (frente == null) {
            return null;
        }
        String valor = frente.getValor();
        frente = frente.getSiguiente();
        if (frente == null) {
            fin = null;
        }
        return valor;
    }

    /**
     * Verifica si la cola está vacía.
     *
     * @return true si la cola está vacía, false en caso contrario.
     */
    public boolean estaVacia() {
        return frente == null;
    }
}