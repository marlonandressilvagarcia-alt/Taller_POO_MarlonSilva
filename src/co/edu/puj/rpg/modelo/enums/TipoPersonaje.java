package co.edu.puj.rpg.modelo.enums;

public enum TipoPersonaje {
    GUERRERO(1.2, 1.5),
    MAGO(1.8, 0.8),
    ARQUERO(1.5, 1.0);

    private final double bonificadorAtaqueBase;
    private final double bonificadorDefensaBase;

    TipoPersonaje(double bonificadorAtaqueBase, double bonificadorDefensaBase) {
        this.bonificadorAtaqueBase = bonificadorAtaqueBase;
        this.bonificadorDefensaBase = bonificadorDefensaBase;
    }

    public double getBonificadorAtaqueBase() {
        return bonificadorAtaqueBase;
    }

    public double getBonificadorDefensaBase() {
        return bonificadorDefensaBase;
    }
}