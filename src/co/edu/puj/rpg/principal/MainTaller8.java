package co.edu.puj.rpg.principal;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import co.edu.puj.rpg.engine.Bestiario;
import co.edu.puj.rpg.modelo.Personaje;
import co.edu.puj.rpg.modelo.Guerrero;
import co.edu.puj.rpg.modelo.enums.TipoPersonaje;
import co.edu.puj.rpg.modelo.enums.EstadoPersonaje;
import co.edu.puj.rpg.exception.SinManaException;

public class MainTaller8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bestiario bestiario = new Bestiario();

        Personaje personajeActivo = null;
        Set<String> habilidadesPersonaje = new HashSet<>();
        TreeSet<String> logrosGlobales = new TreeSet<>();

        int opcion = 0;

        do {
            System.out.println("\n--- MENÚ INTERACTIVO PRINCIPAL ---");
            System.out.println("1. Crear Personaje");
            System.out.println("2. Asignar Habilidad Única");
            System.out.println("3. Registrar Victoria en Bestiario y Logros");
            System.out.println("4. Ejecutar Ataque Especial");
            System.out.println("5. Consultar Bestiario y Logros");
            System.out.println("6. Salir");
            System.out.print("Selecciona una opción: ");

            try {
                if (sc.hasNextInt()) {
                    opcion = sc.nextInt();
                    sc.nextLine();

                    switch (opcion) {
                        case 1 -> {
                            System.out.print("Ingresa el nombre del personaje: ");
                            String nombre = sc.nextLine();

                            System.out.println("Selecciona el tipo de personaje:");
                            System.out.println("1. GUERRERO");
                            System.out.println("2. MAGO");
                            int tipoOp = sc.nextInt();
                            sc.nextLine();

                            TipoPersonaje tipo = (tipoOp == 2) ? TipoPersonaje.MAGO : TipoPersonaje.GUERRERO;

                            personajeActivo = new Guerrero(nombre, 100, 20, 50.0, tipo);
                            habilidadesPersonaje.clear();

                            System.out.println("Personaje creado exitosamente. Estado inicial: " + EstadoPersonaje.VIVO);
                        }
                        case 2 -> {
                            if (personajeActivo == null) {
                                System.out.println("Primero debes crear un personaje.");
                                break;
                            }
                            System.out.print("Ingresa el nombre de la nueva habilidad: ");
                            String habilidad = sc.nextLine();

                            boolean agregado = habilidadesPersonaje.add(habilidad);
                            if (!agregado) {
                                System.out.println("La habilidad '" + habilidad + "' ya está aprendida por el personaje.");
                            } else {
                                System.out.println("Habilidad '" + habilidad + "' asignada con éxito.");
                            }
                        }
                        case 3 -> {
                            System.out.print("Ingresa el nombre del enemigo derrotado: ");
                            String enemigo = sc.nextLine();

                            bestiario.registrarVictoria(enemigo);
                            System.out.println("Victoria sobre '" + enemigo + "' registrada en el Bestiario.");

                            String logro = "Derrotar a " + enemigo;
                            if (logrosGlobales.add(logro)) {
                                System.out.println("Nuevo logro desbloqueado y registrado automáticamente: " + logro);
                            }
                        }
                        case 4 -> {
                            if (personajeActivo == null) {
                                System.out.println("Primero debes crear un personaje.");
                                break;
                            }
                            System.out.print("Ingresa el costo de maná del ataque especial: ");
                            int costoMana = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Ingresa el maná actual del personaje: ");
                            int manaActual = sc.nextInt();
                            sc.nextLine();

                            try {
                                if (costoMana > manaActual) {
                                    throw new SinManaException("Error de combate: Maná insuficiente (" + manaActual + " actual vs " + costoMana + " requerido).");
                                }
                                System.out.println("Ataque especial ejecutado con éxito. Consumiendo " + costoMana + " de maná.");
                            } catch (SinManaException e) {
                                System.err.println("[Excepción Capturada]: " + e.getMessage());
                            }
                        }
                        case 5 -> {
                            System.out.println("\n--- REPORTE GENERAL DE AVANCE ---");
                            bestiario.mostrarReporteBestiario();

                            System.out.println("\n--- LOGROS DEL JUGADOR ---");
                            if (logrosGlobales.isEmpty()) {
                                System.out.println("Aún no hay logros registrados.");
                            } else {
                                for (String l : logrosGlobales) {
                                    System.out.println(" - " + l);
                                }
                            }
                        }
                        case 6 -> {
                            System.out.println("Saliendo del simulador del taller.");
                        }
                        default -> System.out.println("Opción no válida.");
                    }
                } else {
                    System.err.println("Error: Debes ingresar un número válido.");
                    sc.next();
                }
            } catch (InputMismatchException e) {
                System.err.println("Error de entrada: Se esperaba un valor numérico.");
                sc.nextLine();
            }
        } while (opcion != 6);

        sc.close();
        System.out.println("=== FIN DEL PROGRAMA ===");
    }
}