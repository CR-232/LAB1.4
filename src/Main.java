class MyThread extends Thread {
    private final int iterations;

    public MyThread(ThreadGroup group, String name, int iterations) {
        super(group, name);
        this.iterations = iterations;
    }

    public MyThread(String name, int iterations) {
        super(name);
        this.iterations = iterations;
    }

    @Override
    public void run() {
        for (int i = 1; i <= iterations; i++) {
            System.out.println(getName() + " – iteratia " + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println(getName() + " a fost intrerupt.");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {

        // ---------------- G6 ----------------
        ThreadGroup G6 = new ThreadGroup("G6");
        Thread ThA_G6 = new MyThread(G6, "ThA_G6", 3);

        // --------------- Standalone threads ---------------
        Thread Th1 = new MyThread("Th1", 4);
        Thread Th2 = new MyThread("Th2", 3);

        // ---------------- G2 ----------------
        ThreadGroup G2 = new ThreadGroup("G2");
        Thread Th1_G2 = new MyThread(G2, "Th1_G2", 2);

        // ---------------- G3 ----------------
        ThreadGroup G3 = new ThreadGroup(G2, "G3");
        Thread ThA_G3 = new MyThread(G3, "ThA_G3", 2);
        Thread ThB_G3 = new MyThread(G3, "ThB_G3", 3);
        Thread ThC_G3 = new MyThread(G3, "ThC_G3", 4);
        Thread ThD_G3 = new MyThread(G3, "ThD_G3", 3);

        Thread Th2_G2 = new MyThread(G2, "Th2_G2", 3);
        Thread Th3_G2 = new MyThread(G2, "Th3_G2", 3);

        // ---------------- Pornirea thread-urilor ----------------
        ThA_G6.start();

        Th1.start();
        Th2.start();

        Th1_G2.start();

        ThA_G3.start();
        ThB_G3.start();
        ThC_G3.start();
        ThD_G3.start();

        Th2_G2.start();
        Th3_G2.start();

        // Optional: join la final pentru a astepta terminarea tuturor
        try {
            ThA_G6.join();

            Th1.join();
            Th2.join();

            Th1_G2.join();

            ThA_G3.join();
            ThB_G3.join();
            ThC_G3.join();
            ThD_G3.join();

            Th2_G2.join();
            Th3_G2.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Toate thread-urile au terminat.");
    }
}
//wdf