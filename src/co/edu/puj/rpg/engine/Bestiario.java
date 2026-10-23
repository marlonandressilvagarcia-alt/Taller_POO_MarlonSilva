package co.edu.puj.rpg.engine;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Bestiario {

    private Map<String, Integer> contadorEnemigos;
    private Map<String, Double> estadisticasGlobales;

    public Bestiario() {
        this.contadorEnemigos = new HashMap<>();
        this.estadisticasGlobales = new TreeMap<>();
    }

    public void registrarVictoria(String nombreEnemigo) {
        int derrotasActuales = contadorEnemigos.getOrDefault(nombreEnemigo, 0);
        contadorEnemigos.put(nombreEnemigo, derrotasActuales + 1);
    }

    public boolean verificarEnemigoRegistrado(String nombreEnemigo) {
        return contadorEnemigos.containsKey(nombreEnemigo);
    }

    public void mostrarReporteBestiario() {
        System.out.println("=== REPORTE DEL BESTIARIO ===");
        for (Map.Entry<String, Integer> entry : contadorEnemigos.entrySet()) {
            System.out.println("Enemigo: " + entry.getKey() + " | Derrotas: " + entry.getValue());
        }
    }

    public void registrarEstadisticaItem(String nombreItem, double valor) {
        estadisticasGlobales.put(nombreItem, valor);
    }

    public void mostrarEstadisticasOrdenadas() {
        System.out.println("=== CATÁLOGO / ESTADÍSTICAS ORDENADAS ===");
        for (Map.Entry<String, Double> entry : estadisticasGlobales.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}