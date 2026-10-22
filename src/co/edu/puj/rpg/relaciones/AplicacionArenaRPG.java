package co.edu.puj.rpg.relaciones;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AplicacionArenaRPG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        List<Personaje> personajes = new ArrayList<>();
        List<Gremio> gremios = new ArrayList<>();
        List<Escuadron> escuadrones = new ArrayList<>();

        escuadrones.add(new Escuadron("Escuadrón Alfa"));

        do {
            System.out.println("\n=== MENÚ ARENA DE HÉROES RPG ===");
            System.out.println("1. Crear Personaje");
            System.out.println("2. Crear Gremio");
            System.out.println("3. Reclutar Personaje a Escuadrón");
            System.out.println("4. Equipar Arma a Personaje");
            System.out.println("5. Mostrar Estado Detallado (Personaje y Corazón RPG)");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del personaje: ");
                    String nombreP = scanner.nextLine();
                    System.out.print("Ingrese el nivel inicial: ");
                    int nivelP = scanner.nextInt();

                    Personaje nuevoP = new Personaje(nombreP, nivelP);
                    personajes.add(nuevoP);
                    System.out.println("¡Personaje creado con éxito!");
                    break;

                case 2:
                    System.out.print("Ingrese el nombre del gremio: ");
                    String nombreG = scanner.nextLine();
                    Gremio nuevoG = new Gremio(nombreG);
                    gremios.add(nuevoG);
                    System.out.println("¡Gremio creado con éxito!");
                    break;

                case 3:
                    if (personajes.isEmpty() || escuadrones.isEmpty()) {
                        System.out.println("Debe crear al menos un personaje y un escuadrón primero.");
                        break;
                    }
                    System.out.println("Seleccione el personaje a reclutar:");
                    for (int i = 0; i < personajes.size(); i++) {
                        System.out.println(i + ". " + personajes.get(i));
                    }
                    int idxP = scanner.nextInt();

                    escuadrones.get(0).reclutarPersonaje(personajes.get(idxP));
                    System.out.println("¡Personaje añadido al escuadrón exitosamente!");
                    break;

                case 4:
                    if (personajes.isEmpty()) {
                        System.out.println("No hay personajes registrados.");
                        break;
                    }
                    System.out.println("Seleccione el personaje:");
                    for (int i = 0; i < personajes.size(); i++) {
                        System.out.println(i + ". Personaje #" + i);
                    }
                    int idxPers = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Ingrese el nombre del arma: ");
                    String nombreArma = scanner.nextLine();
                    System.out.print("Ingrese el daño base del arma: ");
                    int danioArma = scanner.nextInt();

                    Arma arma = new Arma(nombreArma, danioArma);
                    personajes.get(idxPers).equiparArma(arma);
                    break;

                case 5:
                    if (personajes.isEmpty()) {
                        System.out.println("No hay personajes para mostrar.");
                        break;
                    }
                    System.out.println("\n--- REPORTE DETALLADO DE LA ARENA ---[cite: 11]");
                    StringBuilder sb = new StringBuilder();
                    for (Personaje p : personajes) {
                        sb.append(p.toString()).append("\n");
                    }
                    System.out.println(sb.toString());
                    break;

                case 6:
                    System.out.println("Cerrando la Arena de Héroes...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 6);

        scanner.close();
    }
}