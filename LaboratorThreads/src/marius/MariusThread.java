package marius;

import java.util.Random;

public class MariusThread {
    private int[] mas = new int[100];

    public MariusThread() {
        Random r = new Random();
        for (int i = 0; i < mas.length; i++) mas[i] = r.nextInt(100) + 1;
    }

    public void startThreads() {
        Thread t1 = new Thread(() -> {
            System.out.println("=== Th1 Marius ===");
            int sumaPare = 0;
            for (int i = 0; i < mas.length; i++) if (mas[i] % 2 == 0) sumaPare += mas[i];
            System.out.println("Suma numerelor pare: " + sumaPare);
        });

        Thread t2 = new Thread(() -> {
            System.out.println("=== Th2 Marius ===");
            int max = 0;
            for (int v : mas) if (v > max) max = v;
            System.out.println("Max: " + max);
        });

        t1.start();
        t2.start();
        try { t1.join(); t2.join(); } catch (InterruptedException e) { }
        System.out.println("Lucrare realizată de Marius - CR232\n");
    }
}