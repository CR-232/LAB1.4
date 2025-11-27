package daniel;

import java.util.ArrayList;
import java.util.List;

public class DanielThread extends Thread {

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

        Thread th1 = new Thread(() -> {
            int sum = 0;
            for (int i = 0; i < pozitiiImpare.size() - 1; i += 2) {
                sum += pozitiiImpare.get(i) + pozitiiImpare.get(i + 1);
            }
            System.out.println("Suma pozițiilor impare (din față): " + sum);
        });

        try {
            th1.start();
            th1.join();
        } catch (InterruptedException e) {}

        // mesaj final animat (opțional)
        String text = "Daniel a terminat thread-ul.";
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try { Thread.sleep(80); } catch (InterruptedException e) {}
        }
        System.out.println();
    }
}