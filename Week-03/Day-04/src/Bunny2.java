public class Bunny2 {
    public static void main(String[] args) {
        System.out.println(computeEars(10));
    }

    public static int computeEars (int bunnies) {
        if (bunnies == 1) {
            return 2;
        }
        else if (bunnies % 2 == 1) {
            return 2 + computeEars(bunnies - 1);
        }
        else {
            return 3 + computeEars(bunnies - 1);
        }
    }
}
