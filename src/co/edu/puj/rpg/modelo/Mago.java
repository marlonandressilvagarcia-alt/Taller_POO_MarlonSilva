package co.edu.puj.rpg.modelo;

import co.edu.puj.rpg.modelo.enemigo.Enemigo;

public class Mago extends Personaje {
    protected int puntosMana;

    public Mago(String nombre, int vidaMaxima, int puntosAtaque, double oro) {
        super(nombre, vidaMaxima, puntosAtaque, oro);
        this.puntosMana = 100;
    }

    @Override
    public  void realizarAtaqueEspecial(Enemigo objetivo) {
        if (this.puntosMana >= 20) {
            this.puntosMana -= 20;
            int danoMagico = this.ataqueBase + 15;
            objetivo.recibirDano(danoMagico);
        }
    }

    public int getPuntosMana() {
        return puntosMana;
    }

    public void setPuntosMana(int puntosMana) {
        this.puntosMana = puntosMana;
    }
}