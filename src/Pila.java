/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class Pila {
    private Nodo tope;

    public Pila() {
        this.tope = null;
    }

    public void push(String valor) {
        Nodo nuevoNodo = new Nodo(valor);
        nuevoNodo.setSiguiente(tope);
        tope = nuevoNodo;
    }

    public String pop() {
        if (tope == null) {
            return null;
        }
        String valor = tope.getValor();
        tope = tope.getSiguiente();
        return valor;
    }

    public boolean estaVacia() {
        return tope == null;
    }
}