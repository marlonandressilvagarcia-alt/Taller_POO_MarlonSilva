package co.edu.puj.rpg.modelo;

import co.edu.puj.rpg.modelo.enemigo.Enemigo;

public class Guerrero extends Personaje {

    protected int fuerzaEscudo;

    public Guerrero(String nombre, int vidaMaxima, int puntosAtaque, double oro) {
        super(nombre, vidaMaxima, puntosAtaque, oro);
        this.fuerzaEscudo = 15; // Valor inicial para el escudo
    }

    @Override
    public  void realizarAtaqueEspecial(Enemigo objetivo) {
        int danoEspecial = this.ataqueBase * 2;
        objetivo.recibirDano(danoEspecial);
        System.out.println(this.nombre + " ejecutó un golpe certero especial.");
    }

    public void atacar(Enemigo objetivo, boolean modoFuria) {
        int danoFinal = this.ataqueBase;
        if (modoFuria) {
            danoFinal *= 1.5;
            System.out.println("¡Ataque en modo furia activado!");
        }
        objetivo.recibirDano((int) danoFinal);
    }

    public int getFuerzaEscudo() {
        return fuerzaEscudo;
    }

    public void setFuerzaEscudo(int fuerzaEscudo) {
        this.fuerzaEscudo = fuerzaEscudo;
    }
}