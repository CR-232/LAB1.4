import java.util.concurrent.CountDownLatch;

public class Main {
    static final CountDownLatch done1 = new CountDownLatch(1);
    static final CountDownLatch done2 = new CountDownLatch(1);
    static final CountDownLatch done3 = new CountDownLatch(1);

    public static void main(String[] args) {
        Daniel.start();
        Marius.start();
    }
}