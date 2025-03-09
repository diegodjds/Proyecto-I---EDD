/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class Casilla {
    private String id;
    private boolean esMina;
    private boolean esMarcada;
    private boolean esRevelada;
    private int minasAdyacentes;

    public Casilla(String id) {
        this.id = id;
        this.esMina = false;
        this.esMarcada = false;
        this.esRevelada = false;
        this.minasAdyacentes = 0;
    }

    public String getId() {
        return id;
    }

    public boolean esMina() {
        return esMina;
    }

    public void setMina(boolean esMina) {
        this.esMina = esMina;
    }

    public boolean esMarcada() {
        return esMarcada;
    }

    public void setMarcada(boolean esMarcada) {
        this.esMarcada = esMarcada;
    }

    public boolean esRevelada() {
        return esRevelada;
    }

    public void setRevelada(boolean esRevelada) {
        this.esRevelada = esRevelada;
    }

    public int getMinasAdyacentes() {
        return minasAdyacentes;
    }

    public void setMinasAdyacentes(int minasAdyacentes) {
        this.minasAdyacentes = minasAdyacentes;
    }
}