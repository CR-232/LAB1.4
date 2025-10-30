public class lab2 {
    public static void main(String[] args) {

        // Grupul principal (implicit)
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();

        // Subgrupurile conform cerinței
        ThreadGroup G6 = new ThreadGroup(mainGroup, "G6");
        ThreadGroup G2 = new ThreadGroup(mainGroup, "G2");
        ThreadGroup G3 = new ThreadGroup(G2, "G3");

        // Fire din grupul G6
        Thread ThA = new Thread(G6, "ThA");
        ThA.setPriority(3);

        // Fire din grupul principal (Main)
        Thread Th1_main = new Thread(mainGroup, "Th1");
        Th1_main.setPriority(4);

        Thread Th2_main = new Thread(mainGroup, "Th2");
        Th2_main.setPriority(3);

        // Fire din grupul G2
        Thread Th1_G2 = new Thread(G2, "Th1");
        Th1_G2.setPriority(2);

        Thread Th2_G2 = new Thread(G2, "Th2");
        Th2_G2.setPriority(3);

        Thread Th3_G2 = new Thread(G2, "Th3");
        Th3_G2.setPriority(3);

        // Fire din grupul G3 (subgrup al G2)
        Thread Tha = new Thread(G3, "Tha");
        Tha.setPriority(2);

        Thread Thb = new Thread(G3, "Thb");
        Thb.setPriority(3);

        Thread Thc = new Thread(G3, "Thc");
        Thc.setPriority(4);

        Thread Thd = new Thread(G3, "Thd");
        Thd.setPriority(3);

        // Afișăm informațiile pentru toate firele
        System.out.println("=== Structura de fire și grupe ===");
        printThreadInfo(mainGroup);
    }

    public static void printThreadInfo(ThreadGroup group) {
        // Obținem firele din grup
        Thread[] threads = new Thread[group.activeCount()];
        group.enumerate(threads, false);

        for (Thread t : threads) {
            if (t != null) {
                System.out.println("Fir: " + t.getName() +
                        " | Grup: " + group.getName() +
                        " | Prioritate: " + t.getPriority());
            }
        }

        // Obținem subgrupurile și le parcurgem recursiv
        ThreadGroup[] subGroups = new ThreadGroup[group.activeGroupCount()];
        group.enumerate(subGroups, false);

        for (ThreadGroup g : subGroups) {
            if (g != null) {
                printThreadInfo(g);
            }
        }
    }
}
