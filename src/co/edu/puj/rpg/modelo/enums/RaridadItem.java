package co.edu.puj.rpg.modelo.enums;

public enum RaridadItem {
    // Constantes con su respectivo multiplicador (ej. 1.0, 1.5, 2.5)
    COMUN(1.0),
    RARO(1.5),
    LEGENDARIO(2.5);

    private final double multiplicadorStat;

    RaridadItem(double multiplicadorStat) {
        this.multiplicadorStat = multiplicadorStat;
    }

    public double getMultiplicadorStat() {
        return multiplicadorStat;
    }
}