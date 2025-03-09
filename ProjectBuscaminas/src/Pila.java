/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * La clase Pila representa una estructura de datos de tipo pila (LIFO: Last In, First Out).
 * Permite almacenar y manipular elementos en un orden específico, donde el último elemento en entrar
 * es el primero en salir.
 *
 * @author Diego
 * @version 1.0
 */
public class Pila {
    private Nodo tope;
    
    /**
     * Constructor de la clase Pila.
     * Inicializa una pila vacía.
     */

    public Pila() {
        this.tope = null;
    }

    /**
     * Agrega un elemento a la cima de la pila.
     *
     * @param valor El valor a agregar a la pila.
     */
    public void push(String valor) {
        Nodo nuevoNodo = new Nodo(valor);
        nuevoNodo.setSiguiente(tope);
        tope = nuevoNodo;
    }

    /**
     * Elimina y devuelve el elemento en la cima de la pila.
     *
     * @return El valor del elemento eliminado, o null si la pila está vacía.
     */
    public String pop() {
        if (tope == null) {
            return null;
        }
        String valor = tope.getValor();
        tope = tope.getSiguiente();
        return valor;
    }

    /**
     * Verifica si la pila está vacía.
     *
     * @return true si la pila está vacía, false en caso contrario.
     */
    public boolean estaVacia() {
        return tope == null;
    }
}