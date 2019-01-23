import java.util.*;

public class ListsMapsStringsHardOnes {
    public static void main(String[] args) {

        // +1 - Sub int
        System.out.println(subInt(1, new int[] {1, 11, 34, 52, 61}));
        System.out.println(subInt(9, new int[] {1, 11, 34, 52, 61}));

        // +2 - Sub string
        String[] searchArr = new String[] {"this", "is", "what", "I'm", "searching"};
        System.out.println(subStrList("ching", searchArr));
        System.out.println(subStrList("not", searchArr));

        // +4 - Josephus problem
        // The formula was copied from wikipedia ( f(2j) = 2f(j) - 1 AND f(2j + 1) = 2f(j) + 1 )
        System.out.println(josephus(1));
        System.out.println(josephus(2));
        System.out.println(josephus(7));
        System.out.println(josephus(12));
        System.out.println(josephus(41));

        // +5 - Armstrong number
        System.out.println(isArmstrong(371));
        System.out.println(isArmstrong(153));
        System.out.println(isArmstrong(1634));

        // +3 - Guess my number
        Scanner scanner = new Scanner(System.in);
        int playerLives = 5;
        int rangeMin = 1;
        int rangeMax = 100;
        int randomNumber;
        boolean numberGuessing = true;
        boolean gameOver = false;

        while (numberGuessing) {
            System.out.printf("Customize range (Default: 1-100)? Type 'Y' if you want to: " );
            String answer = scanner.next();
            if (answer.equals("Y")) {
                System.out.printf("Please type in the two numbers separated by space or newline: ");
                rangeMin = scanner.nextInt();
                rangeMax = scanner.nextInt();
            }
            Random rn = new Random();
            int range = rangeMax - rangeMin + 1;
            randomNumber = rn.nextInt(range) + rangeMin;
            System.out.println("I've the number between " + rangeMin + "-" + rangeMax + ". You have " + playerLives + " lives.");
            while (numberGuessing) {
                int userGuess = scanner.nextInt();
                if (userGuess > randomNumber || userGuess < randomNumber) {
                    playerLives -= 1;
                    if (userGuess > randomNumber) {
                        System.out.println("Too high. You have " + playerLives + " lives left.");
                    }
                    else {
                        System.out.println("Too low. You have " + playerLives + " lives left.");
                    }

                    if (playerLives == 0) {
                        gameOver = true;
                        break;
                    }
                } else {
                    numberGuessing = false;
                }
            }
            if (gameOver) {
                System.out.println("You have 0 lives. You lost!");
                break;
            }
        }
        if (!gameOver) {
            System.out.println("Congratulation! You won!");
        }
    }


    public static List<Integer> subInt (Integer num, int[] list) {
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < list.length; i++) {
            if (((Integer)list[i]).toString().contains(num.toString())) {
                resultList.add(i);
            }
        }
        return resultList;
    }

    public static int subStrList (String str, String[] list) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].contains(str)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean isArmstrong(int num) {
        char[] digits = ((Integer)num).toString().toCharArray();
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            sum += Math.pow((double)digits[i] - 48, (double)digits.length);
        }
        return sum == num;
    }

    public static int josephus(int num) {
        if (num == 1) {
            return 1;
        }
        else if (num % 2 == 0) {
            return 2 * josephus(num / 2) - 1;
        }
        else {
            return 2 * josephus(num / 2) + 1;
        }
    }
}
