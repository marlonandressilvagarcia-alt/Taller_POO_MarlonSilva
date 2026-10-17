package co.edu.puj.rpg.modelo.enemigo;

import co.edu.puj.rpg.modelo.Personaje;

public class Enemigo {
    private String nombre;
    private int puntosVida;
    private int vidaMaxima;
    private int puntosAtaque;
    private int nivel;
    private double oro;
    private boolean estaVivo;


    public Enemigo(String nombre, int vidaMaxima, int puntosAtaque, double oro) {
        this.nombre = nombre;
        this.vidaMaxima = vidaMaxima;
        this.puntosVida = vidaMaxima;
        this.puntosAtaque = puntosAtaque;
        this.oro = oro;
        this.nivel = 1;
        this.estaVivo = true;
    }
    // Firmas de la API pública de comportamiento
    public void atacar(Personaje personaje) {
        personaje.recibirDaño(this.puntosAtaque);
        System.out.println("El enemigo " + this.nombre + " te atacó y causó " + this.puntosAtaque + " de daño.");    }
    public void usarPocion(int cantidadRestaurada) {
        setPuntosVida(this.puntosVida + cantidadRestaurada);    }
    public void recibirDano(int cantidadDano) {
        setPuntosVida(this.puntosVida - cantidadDano);    }

    public String getNombre(){
        return nombre;
    }
    public int getPuntosVida(){
        return puntosVida;
    }
    public int getVidaMaxima(){
        return vidaMaxima;
    }
    public int getPuntosAtaque(){
        return puntosAtaque;
    }
    public int getNivel(){
        return nivel;
    }
    public double getOro(){
        return oro;
    }
    public boolean isEstaVivo(){
        return estaVivo;
    }


    public void setPuntosVida(int vida){
        if (vida <= 0){
            vidaMaxima = 0;
            estaVivo = false;
        } else if (vida > puntosVida) {
            puntosVida = vidaMaxima;
            estaVivo = true;
        }else {
            puntosVida = vida;
            estaVivo = true;
        }
    }
    public void setOro(double oro){
        if (oro < 0.0){
            System.out.println("Operación rechazada: saldo insuficiente.");
        }else {
            this.oro = oro;
        }
    }
    public void setNivel(int nivel){
        if (nivel < 1){
            System.out.println("Asignacion de nivel restringuido (valor invalido)");
        }else {
            this.nivel = nivel;
        }
    }

}
