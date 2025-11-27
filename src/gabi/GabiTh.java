package gabi;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GabiThread extends Thread {

    private int[] valori;
    private List<Integer> pozitiiImpare;

    @Override
    public void run() {
        genereazaValori();
        gasestePozitiiImpare();
        pornesteFire();
    }

    private void genereazaValori() {
        valori = new int[100];
        Random r = new Random();
        for (int i = 0; i < valori.length; i++) {
            valori[i] = r.nextInt(100);
        }
    }

    private void gasestePozitiiImpare() {
        pozitiiImpare = new ArrayList<>();
        for (int i = 0; i < valori.length; i++) {
            if (valori[i] % 2 != 0) {
                pozitiiImpare.add(i);
            }
        }
    }

    private void pornesteFire() {
        Thread t1 = new Thread(new SumaPozitiilor(pozitiiImpare));
        Thread t2 = new Thread(new AfisarePozitii(pozitiiImpare));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ignored) {}
    }

    // --- Runnable 1 ---
    private static class SumaPozitiilor implements Runnable {
        private final List<Integer> pozitii;

        public SumaPozitiilor(List<Integer> pozitii) {
            this.pozitii = pozitii;
        }

        @Override
        public void run() {
            int suma = 0;
            for (int i = 0; i < pozitii.size(); i++) {
                suma += pozitii.get(i);
            }
            System.out.println("Suma tuturor pozițiilor impare: " + suma);
        }
    }

    // --- Runnable 2 ---
    private static class AfisarePozitii implements Runnable {
        private final List<Integer> pozitii;

        public AfisarePozitii(List<Integer> pozitii) {
            this.pozitii = pozitii;
        }

        @Override
        public void run() {
            System.out.println("Pozițiile impare găsite: " + pozitii);
        }
    }
}
