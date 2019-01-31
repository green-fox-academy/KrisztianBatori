public class NumberAdder {
    public static void main(String[] args) {
        countTo(100);
    }

    public static void countTo (int n) {
        if (n == 1) {
            System.out.println(n);
            return;
        }
        else {
            countTo(n - 1);
            System.out.println(n);
            return;
        }
    }
}
