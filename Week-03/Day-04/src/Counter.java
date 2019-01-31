public class Counter {
    public static void main(String[] args) {
        countDown(100);
    }

    public static void countDown (int n) {
        if (n <= 0) {
            System.out.println(n);
            return;
        }
        System.out.println(n);
        countDown(n - 1);
    }
}
