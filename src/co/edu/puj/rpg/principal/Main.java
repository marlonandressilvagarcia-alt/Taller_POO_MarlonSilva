package co.edu.puj.rpg.principal;

import java.util.Scanner;
import co.edu.puj.rpg.modelo.Personaje;
import co.edu.puj.rpg.modelo.enemigo.Enemigo;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Personaje p = new Personaje("Steve", 100, 20, 50.0);
        Enemigo e = new Enemigo("Dragon", 80, 15, 10.0);
        int op = 0;
        StringBuilder log = new StringBuilder();

        do {
            System.out.println("\n1.Atacar 2.Poción 3.Estado 4.Tienda 5.Huir");
            System.out.print("Opción: ");

            if (sc.hasNextInt()) {
                op = sc.nextInt();
                switch (op) {
                    case 1 -> {
                        p.atacar(e);
                        log.append("Atacó.\n");
                        if (!e.isEstaVivo()) {
                            p.setNivel(p.getNivel() + 1);
                            System.out.println("¡Enemigo derrotado! Subiste de nivel.");
                        }
                    }
                    case 2 -> { p.usarPocion(20); log.append("Usó poción.\n"); }
                    case 3 -> System.out.printf("Vida: %d | Oro: %.2f\n", p.getPuntosVida(), p.getOro());
                    case 4 -> {
                        double oroAnt = p.getOro();
                        p.setOro(oroAnt - 25.0);
                        if (p.getOro() < oroAnt) {
                            System.out.println("¡Poción comprada!");
                            p.usarPocion(50);
                        }
                    }
                    case 5 -> System.out.println("Huyendo...");
                    default -> System.out.println("Opción inválida.");
                }
            } else {
                sc.next();
            }

            if (log.length() > 0) System.out.println(log);

        } while (p.isEstaVivo() && e.isEstaVivo() && op != 5);

        sc.close();
    }
}