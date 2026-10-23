package co.edu.puj.rpg.exception;

public abstract class JuegoException extends Exception {
    public JuegoException(String mensaje) {
        super(mensaje);
    }
}