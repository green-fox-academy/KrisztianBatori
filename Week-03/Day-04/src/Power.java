public class Power {
    public static void main(String[] args) {
        System.out.println(powerN(3, 8));
    }

    public static int powerN (int base, int exponent) {
        if (exponent == 1) {
            return base;
        }
        else {
            return base * powerN(base, exponent - 1);
        }
    }
}
