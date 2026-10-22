package co.edu.puj.rpg.relaciones;

import java.util.ArrayList;
import java.util.List;

public class Escuadron {
    private String nombre;
    private List<Personaje> miembros;

    public Escuadron(String nombre) {
        this.nombre = nombre;
        this.miembros = new ArrayList<>();
    }

    public void reclutarPersonaje(Personaje p) {
        if (p != null && !this.miembros.contains(p)) {
            this.miembros.add(p);
        }
    }

    public void expulsarPersonaje(Personaje p) {
        if (p != null) {
            this.miembros.remove(p);
        }
    }
}