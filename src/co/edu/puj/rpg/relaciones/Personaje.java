package co.edu.puj.rpg.relaciones;

public class Personaje {
    private String nombre;
    private int nivel;
    private Arma armaEquipada;

    private Gremio gremio;
    private CorazonRPG corazon;

    public Personaje(String nombre, int nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.armaEquipada = null;
        this.corazon = new CorazonRPG(100, 50);
    }

    public void equiparArma(Arma nuevaarma){
        this.armaEquipada = nuevaarma;
        System.out.println(this.nombre + " ha equipado el arma correctamente.");
    }
    public void desequiparArma() {
        if (this.armaEquipada != null) {
            System.out.println(this.nombre + " ha guardado su arma. Ahora está desarmado.");
            this.armaEquipada = null;
        } else {
            System.out.println(this.nombre + " ya se encuentra desarmado, no hay arma para retirar.");
        }
    }
    public int calcularAtaqueTotal() {
        int ataqueBase = this.nivel * 5;
        if (this.armaEquipada != null) {
            ataqueBase += this.armaEquipada.getDanio();
        }
        return ataqueBase;
    }

    public void unirseAGremio(Gremio nuevoGremio) {
        if (nuevoGremio != null && this.gremio != nuevoGremio) {
            this.gremio = nuevoGremio;
            nuevoGremio.agregarMiembro(this);
        }
    }

    public Gremio getGremio() {
        return this.gremio;
    }
}