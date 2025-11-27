package main;

import daniel.DanielThread;
import marius.MariusThread;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== Pornire laborator Threads ===\n");

        Thread daniel = new DanielThread();
        Thread marius = new MariusThread();

        daniel.start();
        marius.start();

        try {
            daniel.join();
            marius.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n=== Toate firele de execuție s-au încheiat ===");

        // Informația despre studenți
        String studenti = "Nume: Garstea, Prenume: Daniel, Grupa CR-232\n" +
                "Nume: Gluhu, Prenume: Marius, Grupa: CR-232";

        for (char c : studenti.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(100); // interval de 100 ms între caractere
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(); // linie nouă la final
    }
}