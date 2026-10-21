package co.edu.puj.rpg.principal;

import java.util.Scanner;
import co.edu.puj.rpg.modelo.Guerrero;
import co.edu.puj.rpg.modelo.Personaje;
import co.edu.puj.rpg.modelo.Mago;
import co.edu.puj.rpg.modelo.enemigo.Enemigo;
import co.edu.puj.rpg.modelo.Inventario;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // Método para renderizar la matriz del tablero en consola
    public static void mostrarTablero(char[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("[" + matriz[i][j] + "]");
            }
            System.out.println(); // Salto de línea por cada fila
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Inicialización de componentes principales (Escuadrón, Enemigos e Inventario genérico)
        List<Personaje> escuadron = new ArrayList<>();
        escuadron.add(new Guerrero("Thorin", 120, 15, 50.0));
        escuadron.add(new Mago("Gandalf", 80, 25, 50.0));

        List<Enemigo> enemigos = new ArrayList<>();
        Enemigo e = new Enemigo("Dragon", 80, 15, 10.0);
        enemigos.add(e);

        Inventario<String> inventarioPociones = new Inventario<>();
        inventarioPociones.agregar("Poción de Vida");

        StringBuilder log = new StringBuilder();
        int op = 0;

        // Inicialización de la matriz del tablero (5x5)
        char[][] tablero = new char[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                tablero[i][j] = '.';
            }
        }

        // Posiciones iniciales en el mapa
        tablero[0][0] = 'G';
        tablero[4][4] = 'E';

        // 2. Ciclo Principal de Batalla (do-while) evaluando unidades vivas en ambos bandos
        do {
            System.out.println("\n--- MAPA DE BATALLA ---");
            mostrarTablero(tablero);

            // 4. Turno del Jugador - Iterar sobre cada héroe vivo usando for-each
            for (Personaje combatiente : escuadron) {
                if (!combatiente.estaVivo()) continue;

                System.out.println("\nTurno de: " + combatiente.getNombre() + " (Vida: " + combatiente.getPuntosVida() + ")");
                System.out.println("1. Atacar (Ataque Especial)  2. Usar Inventario  3. Mover en Tablero  5. Huir");
                System.out.print("Opción: ");

                if (sc.hasNextInt()) {
                    op = sc.nextInt();
                    switch (op) {
                        case 1 -> {
                            if (!enemigos.isEmpty()) {
                                Enemigo objetivoActual = enemigos.get(0);
                                combatiente.realizarAtaqueEspecial(objetivoActual);
                                log.append(combatiente.getNombre()).append(" ejecutó ataque especial.\n");
                            } else {
                                System.out.println("No hay enemigos vivos.");
                            }
                        }
                        case 2 -> {
                            combatiente.usarPocion(20);
                            log.append(combatiente.getNombre()).append(" usó una poción del inventario.\n");
                        }
                        case 3 -> {
                            tablero[combatiente.getPosicionX()][combatiente.getPosicionY()] = '.';
                            combatiente.setPosicionX(Math.min(4, combatiente.getPosicionX() + 1));
                            tablero[combatiente.getPosicionX()][combatiente.getPosicionY()] = 'G';
                            System.out.println("¡Personaje movido en el tablero!");
                        }
                        case 5 -> {
                            System.out.println("Huyendo de la batalla...");
                            op = 5;
                        }
                        default -> System.out.println("Opción inválida.");
                    }
                } else {
                    sc.next();
                }
            }

            // 5. Turno del Ente Enemigo (Acción automática básica)
            if (!enemigos.isEmpty() && !escuadron.isEmpty() && op != 5) {
                Enemigo enemigoActivo = enemigos.get(0);
                Personaje objetivoHeroe = escuadron.get(0);
                objetivoHeroe.recibirDano(enemigoActivo.getPuntosAtaque());
                System.out.println("¡El enemigo " + enemigoActivo.getNombre() + " atacó a " + objetivoHeroe.getNombre() + "!");
            }

            if (log.length() > 0) {
                System.out.println("\n[LOG]:\n" + log);
                log.setLength(0); // Limpiar log del turno
            }

            // 6. Limpieza de Bajas con removeIf() al cierre del turno
            escuadron.removeIf(x -> !x.estaVivo());
            enemigos.removeIf(x -> !x.isEstaVivo());

        } while (!escuadron.isEmpty() && !enemigos.isEmpty() && op != 5);


        // Evaluación de los resultados finales según la guía:
        if (enemigos.isEmpty()) {
            System.out.println("\n ¡VICTORIA! Todos los enemigos del escuadrón hostil han sido eliminados.");
        } else if (escuadron.isEmpty()) {
            System.out.println("\n DERROTA. El escuadrón héroe ha sido aniquilado.");
        } else if (op == 5) {
            System.out.println("\n Partida finalizada por huida.");
        }

        System.out.println("\n--- FIN DE LA SIMULACIÓN DE BATALLA ---");
        sc.close();

        System.out.println("\n--- FIN DE LA SIMULACIÓN DE BATALLA ---");
        sc.close();
    }
}