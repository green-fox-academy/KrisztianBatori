public class SumDigit {
    public static void main(String[] args) {
    }

    public static int sumDigits(int digits) {
        if (digits / 10 == 0) {
            return digits;
        }
        else {
            return sumDigits(digits % 10) + sumDigits(digits / 10);
        }
    }
}
