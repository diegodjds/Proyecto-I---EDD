/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class Cola {
    private Nodo frente;
    private Nodo fin;

    public Cola() {
        this.frente = null;
        this.fin = null;
    }

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

    public boolean estaVacia() {
        return frente == null;
    }
}