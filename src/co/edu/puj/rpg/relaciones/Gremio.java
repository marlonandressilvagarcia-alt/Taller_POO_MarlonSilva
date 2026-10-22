package co.edu.puj.rpg.relaciones;

import java.util.ArrayList;
import java.util.List;

public class Gremio {
    private String nombre;
    private List<Personaje> miembros;

    public Gremio(String nombre) {
        this.nombre = nombre;
        this.miembros = new ArrayList<>();
    }

    public String getnombre() {
        return nombre;
    }

    public void agregarMiembro(Personaje p) {
        if (p != null) {
            if (!this.miembros.contains(p)) {
                this.miembros.add(p);
                if (p.getGremio() != this) {
                    p.unirseAGremio(this);
                }
            }
        }
    }
}