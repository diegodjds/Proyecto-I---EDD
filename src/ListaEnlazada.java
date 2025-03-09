/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * La clase ListaEnlazada representa una lista enlazada simple.
 * Permite almacenar y manipular una secuencia de nodos, donde cada nodo contiene un valor
 * y una referencia al siguiente nodo en la lista.
 *
 * @author Diego
 * @version 1.0
 */
public class ListaEnlazada {
    private Nodo cabeza;
    
    /**
     * Constructor de la clase ListaEnlazada.
     * Inicializa una lista enlazada vacía.
     */

    public ListaEnlazada() {
        this.cabeza = null;
    }

    /**
     * Agrega un nuevo nodo con el valor especificado al final de la lista.
     *
     * @param valor El valor a agregar a la lista.
     */
    public void agregar(String valor) {
        Nodo nuevoNodo = new Nodo(valor);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
    }
    
    /**
     * Imprime todos los valores de los nodos en la lista enlazada.
     */
    public void print() {
       for(Nodo i = cabeza; i != null; i = i.getSiguiente()){
           System.out.println(i.getValor());
       }
    }


    /**
     * Verifica si la lista enlazada contiene un nodo con el valor especificado.
     *
     * @param valor El valor a buscar en la lista.
     * @return true si el valor está presente en la lista, false en caso contrario.
     */
    public boolean contiene(String valor) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.getValor().equals(valor)) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }
}