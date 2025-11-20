package main;

import daniel.DanielThread;
import marius.MariusThread;
import gabi.GabiThread;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Pornire laborator Threads ===\n");

        DanielThread daniel = new DanielThread();
        MariusThread marius = new MariusThread();


        daniel.startThreads();
        marius.startThreads();


        System.out.println("\n=== Toate firele de execuție s-au încheiat ===");
    }
}