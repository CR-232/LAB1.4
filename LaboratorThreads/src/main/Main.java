package main;

import daniel.DanielThread;
import marius.MariusThread;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Pornire laborator Threads ===\n");

        DanielThread daniel = new DanielThread();
        MariusThread marius = new MariusThread();
        GabiThread gabi = new GabiThread();

        daniel.startThreads();
        marius.startThreads();
        gabi.startThreads();

        System.out.println("\n=== Toate firele de execuție s-au încheiat ===");
    }
}