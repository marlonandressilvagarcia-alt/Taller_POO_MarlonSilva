package co.edu.puj.rpg.relaciones;

public class Arma {
    private String nombre;
    private int danio;

    public Arma(String nombre, int danio) {
        this.nombre = nombre;
        this.danio = danio;
    }

    public int getDanio() {
        return this.danio;
    }
}
