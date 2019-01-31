public class Bunny1 {
    public static void main(String[] args) {
        System.out.println(computeEars(30));
    }

    public static int computeEars (int bunnies) {
        if (bunnies == 1) {
            return 2;
        }
        else {
            return 2 + computeEars(bunnies - 1);
        }
    }
}
