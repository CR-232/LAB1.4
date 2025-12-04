public class Utils {
    public static void printDelay(String text) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try { Thread.sleep(100); }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        System.out.println();
    }
}