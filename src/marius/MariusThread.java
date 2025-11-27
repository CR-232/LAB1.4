package marius;

import java.util.ArrayList;
import java.util.List;

public class MariusThread extends Thread {

    @Override
    public void run() {
        startThreads();
    }

    public void startThreads() {

        int[] mas = new int[100];
        for (int i = 0; i < mas.length; i++)
            mas[i] = (int) (Math.random() * 100);

        // colectăm pozițiile numerelor impare
        List<Integer> pozitiiImpare = new ArrayList<>();
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] % 2 != 0)
                pozitiiImpare.add(i);
        }

        Thread th = new Thread(() -> {
            int sum = 0;
            // începând de la ultimul element
            for (int i = pozitiiImpare.size() - 1; i > 0; i -= 2) {
                sum += pozitiiImpare.get(i) + pozitiiImpare.get(i - 1);
            }
            System.out.println("Suma pozițiilor impare (Marius, din spate): " + sum);
        });

        try {
            th.start();
            th.join();
        } catch (InterruptedException e) {}
    }
}