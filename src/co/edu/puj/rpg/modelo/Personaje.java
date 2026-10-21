package co.edu.puj.rpg.modelo;
import co.edu.puj.rpg.modelo.enemigo.Enemigo;

public abstract class Personaje implements ICombatiente {
    protected String nombre;
    protected int vida;
    protected int ataqueBase;
    protected int posicionX;
    protected int posicionY;

    private int vidaMaxima;
    private int nivel;
    private double oro;
    private boolean estaVivo;

    public Personaje(String nombre, int vidaMaxima, int puntosAtaque, double oro) {
        this.nombre = nombre;
        this.vidaMaxima = vidaMaxima;
        this.vida = vidaMaxima;
        this.ataqueBase = puntosAtaque;
        this.oro = oro;
        this.nivel = 1;
        this.estaVivo = true;
        this.posicionX = 0;
        this.posicionY = 0;
    }

    public abstract void realizarAtaqueEspecial(Enemigo objetivo);

    @Override
    public void defender(int danoRecibido) {
        recibirDano(danoRecibido);
    }

    public boolean estaVivo() {
        return this.vida > 0;
    }

    public void recibirDano(int cantidad) {
        this.vida -= cantidad;
        if (this.vida <= 0) {
            this.vida = 0;
            this.estaVivo = false;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public int getPuntosVida() {
        return vida;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public int getPuntosAtaque() {
        return ataqueBase;
    }

    public int getNivel() {
        return nivel;
    }

    public double getOro() {
        return oro;
    }

    public boolean isEstaVivo() {
        return estaVivo();
    }

    public void setPuntosVida(int vidaNueva) {
        if (vidaNueva <= 0) {
            this.vida = 0;
            this.estaVivo = false;
        } else if (vidaNueva > vidaMaxima) {
            this.vida = vidaMaxima;
            this.estaVivo = true;
        } else {
            this.vida = vidaNueva;
            this.estaVivo = true;
        }
    }

    public void setOro(double oro) {
        if (oro < 0.0) {
            System.out.println("Operación rechazada: saldo insuficiente.");
        } else {
            this.oro = oro;
        }
    }

    public void setNivel(int nivel) {
        if (nivel < 1) {
            System.out.println("Asignación de nivel restringida (valor inválido)");
        } else {
            this.nivel = nivel;
        }
    }



    public void usarPocion(int cantidadRestaurada) {
        setPuntosVida(this.vida + cantidadRestaurada);
    }

    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }
}