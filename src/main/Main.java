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
        } catch (InterruptedException e) {}

        System.out.println("\n=== Toate firele de execuție s-au încheiat ===");
    }
}