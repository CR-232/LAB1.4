import java.util.concurrent.CountDownLatch;

public class Daniel {

    public static void start() {
        Thread Th1 = new Thread(() -> {
            try {
                /* ===== cascadă Th1 ===== */
                System.out.println("Th1:");
                int idx = 1, total = 0;
                while (idx <= 100) {
                    int a = idx, b = idx + 2;
                    if (b > 100) break;
                    int sum = a + b;
                    total += sum;
                    System.out.printf("Th1: %d+%d=%d (total=%d)%n", a, b, sum, total);
                    idx += 4;
                }

                /* ===== imediat după cascadă – Prenume ===== */
                Utils.printDelay("Prenume: Daniel & Marius");
                Main.done1.countDown(); // permite lui Th2 să pornească
            } catch (Exception e) { Thread.currentThread().interrupt(); }
        });

        Thread Th2 = new Thread(() -> {
            try {
                Main.done1.await(); // aşteaptă să termine Th1 (text inclus)

                /* ===== cascadă Th2 ===== */
                System.out.println("Th2:");
                int idx = 99, total = 0;
                while (idx >= 1) {
                    int a = idx, b = idx - 2;
                    if (b < 1) break;
                    int sum = a + b;
                    total += sum;
                    System.out.printf("Th2: %d+%d=%d (total=%d)%n", a, b, sum, total);
                    idx -= 4;
                }

                /* ===== imediat după cascadă – Numele ===== */
                Utils.printDelay("Nume: Garstea & Gluhu");
                Main.done2.countDown(); // permite lui Th3 să pornească
            } catch (Exception e) { Thread.currentThread().interrupt(); }
        });

        Th1.start(); Th2.start();
    }
}