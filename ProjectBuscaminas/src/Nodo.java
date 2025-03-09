/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * La clase Nodo representa un nodo en una lista enlazada.
 * Cada nodo contiene un valor y una referencia al siguiente nodo en la lista.
 *
 * @author Diego
 * @version 1.0
 */
public class Nodo {
    private String valor;
    private Nodo siguiente;
    
    /**
     * Constructor de la clase Nodo.
     * Inicializa un nuevo nodo con el valor especificado.
     *
     * @param valor El valor a almacenar en el nodo.
     */

    public Nodo(String valor) {
        this.valor = valor;
        this.siguiente = null;
    }

    /**
     * Obtiene el valor almacenado en el nodo.
     *
     * @return El valor del nodo.
     */
    public String getValor() {
        return valor;
    }

    /**
     * Obtiene la referencia al siguiente nodo en la lista.
     *
     * @return El siguiente nodo en la lista, o null si no hay ninguno.
     */
    public Nodo getSiguiente() {
        return siguiente;
    }

    /**
     * Establece la referencia al siguiente nodo en la lista.
     *
     * @param siguiente El siguiente nodo en la lista.
     */

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}