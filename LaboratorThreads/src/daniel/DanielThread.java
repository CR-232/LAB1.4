package daniel;

import java.util.Random;

public class DanielThread {
    private int[] mas = new int[100];

    public DanielThread() {
        Random r = new Random();
        for (int i = 0; i < mas.length; i++) mas[i] = r.nextInt(100) + 1;
    }

    public void startThreads() {
        Thread th1 = new Thread(() -> {
            System.out.println("=== Th1 Daniel: Condiția 1 ===");
            int sum = 0;
            for (int i = 0; i < mas.length - 1; i += 2) {
                if (mas[i] % 2 != 0 && mas[i + 1] % 2 != 0)
                    sum += (i + (i + 1));
            }
            System.out.println("Suma (de la început): " + sum);
        });

        Thread th2 = new Thread(() -> {
            System.out.println("=== Th2 Daniel: Condiția 2 ===");
            int sum = 0;
            for (int i = mas.length - 1; i > 0; i -= 2) {
                if (mas[i] % 2 != 0 && mas[i - 1] % 2 != 0)
                    sum += (i + (i - 1));
            }
            System.out.println("Suma (de la sfârșit): " + sum);
        });

        th1.start();
        th2.start();
        try { th1.join(); th2.join(); } catch (InterruptedException e) { e.printStackTrace(); }

        String text = "Lucrare realizată de Garstea Daniel - CR232";
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try { Thread.sleep(100); } catch (InterruptedException e) { }
        }
        System.out.println("\n");
    }
}