package co.edu.puj.rpg.modelo;

import co.edu.puj.rpg.modelo.enemigo.Enemigo;
import co.edu.puj.rpg.modelo.enums.TipoPersonaje;
import co.edu.puj.rpg.modelo.enums.EstadoPersonaje;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public abstract class Personaje implements ICombatiente {
    protected String nombre;
    protected int vida;
    protected int ataqueBase;
    protected int posicionX;
    protected int posicionY;

    private int vidaMaxima;
    private int nivel;
    private double oro;

    // 1 y 2. Reemplazamos el booleano por nuestros nuevos Enums requeridos
    private TipoPersonaje tipoPersonaje;
    private EstadoPersonaje estado;

    // 3. Actualizamos el constructor para exigir el TipoPersonaje e inicializar el estado
    public Personaje(String nombre, int vidaMaxima, int puntosAtaque, double oro, TipoPersonaje tipoPersonaje) {
        this.nombre = nombre;
        this.vidaMaxima = vidaMaxima;
        this.vida = vidaMaxima;

        // 4. Opcional pero recomendado: aplicamos el bonificador del enum al ataque base
        this.ataqueBase = (int) (puntosAtaque * tipoPersonaje.getBonificadorAtaqueBase());

        this.oro = oro;
        this.nivel = 1;
        this.tipoPersonaje = tipoPersonaje;
        this.estado = EstadoPersonaje.VIVO; // Inicialización por defecto exigida por la guía
        this.posicionX = 0;
        this.posicionY = 0;
    }

    public abstract void realizarAtaqueEspecial(Enemigo objetivo);

    @Override
    public void defender(int danoRecibido) {
        recibirDano(danoRecibido);
    }

    // Adaptamos el método para que consulte el enum en lugar del booleano
    public boolean estaVivo() {
        return this.estado == EstadoPersonaje.VIVO;
    }

    public void recibirDano(int cantidad) {
        this.vida -= cantidad;
        if (this.vida <= 0) {
            this.vida = 0;
            this.estado = EstadoPersonaje.DERROTADO; // Actualizamos usando el estado del enum
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

    // Mantenemos la compatibilidad con tu lógica anterior
    public boolean isEstaVivo() {
        return estaVivo();
    }

    // Getters y Setters para los nuevos Enums
    public TipoPersonaje getTipoPersonaje() {
        return tipoPersonaje;
    }

    public void setTipoPersonaje(TipoPersonaje tipoPersonaje) {
        this.tipoPersonaje = tipoPersonaje;
    }

    public EstadoPersonaje getEstado() {
        return estado;
    }

    public void setEstado(EstadoPersonaje estado) {
        this.estado = estado;
    }

    public void setPuntosVida(int vidaNueva) {
        if (vidaNueva <= 0) {
            this.vida = 0;
            this.estado = EstadoPersonaje.DERROTADO;
        } else if (vidaNueva > vidaMaxima) {
            this.vida = vidaMaxima;
            this.estado = EstadoPersonaje.VIVO;
        } else {
            this.vida = vidaNueva;
            this.estado = EstadoPersonaje.VIVO;
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

    //Parte del taller de Integración de Set, Map, Enumeraciones y Excepciones en el
    //Proyecto RPG

    // Colección para habilidades únicas (sin duplicados)
    private Set<String> habilidades = new HashSet<>();

    // Colección para logros (sin duplicados y ordenados alfabéticamente)
    private Set<String> logros = new TreeSet<>();

    /**
     * 3.1 & 3.3: Intenta agregar la habilidad al conjunto HashSet.
     * Retorna true si fue agregada con éxito, false si ya existía.
     */
    public boolean aprenderHabilidad(String habilidad) {
        return this.habilidades.add(habilidad);
    }

    /**
     * 3.3: Devuelve la referencia o vista del conjunto de habilidades aprendidas.
     */
    public Set<String> obtenerHabilidades() {
        return this.habilidades;
    }

    /**
     * 3.2 & 3.3: Agrega un nuevo logro al TreeSet ordenado alfabéticamente.
     * Retorna true si es nuevo y false si ya había sido desbloqueado.
     */
    public boolean registrarLogro(String logro) {
        return this.logros.add(logro);
    }

    /**
     * 3.3: Retorna el conjunto de logros asegurando la iteración en orden alfabético natural.
     */
    public Set<String> listarLogrosOrdenados() {
        return this.logros;
    }
}