public class Marius {

    public static void start() {
        Thread Th3 = new Thread(() -> {
            try {
                Main.done2.await(); // aşteaptă Th2 (text inclus)

                /* ===== rând unic cu valorile ===== */
                StringBuilder sb = new StringBuilder();
                for (int i = 234; i <= 987; i++) sb.append("Th3:").append(i).append(' ');
                System.out.println(sb.toString().trim());

                /* ===== imediat după rând – Disciplina ===== */
                Utils.printDelay("Disciplina: Programare concurentă și distributivă");
                Main.done3.countDown(); // permite lui Th4 să pornească
            } catch (Exception e) { Thread.currentThread().interrupt(); }
        });

        Thread Th4 = new Thread(() -> {
            try {
                Main.done3.await(); // aşteaptă Th3 (text inclus)

                /* ===== rând unic cu valorile ===== */
                StringBuilder sb = new StringBuilder();
                for (int i = 890; i >= 123; i--) sb.append("Th4:").append(i).append(' ');
                System.out.println(sb.toString().trim());

                /* ===== imediat după rând – Grupa ===== */
                Utils.printDelay("Grupa: CR_232");
            } catch (Exception e) { Thread.currentThread().interrupt(); }
        });

        Th3.start(); Th4.start();
    }
}