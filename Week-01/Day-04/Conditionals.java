import java.util.Scanner;

public class Conditionals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 18 - Odd or Even
        if (scanner.nextInt() % 2 == 0) {
            System.out.println("Even.");
        }
        else {
            System.out.println("Odd.");
        }

        // 19 - One two a lot
        int number = scanner.nextInt();

        if (number <= 0) {
            System.out.println("Not enough");
        }
        else if (number == 1) {
            System.out.println("One");
        }
        else if (number == 2) {
            System.out.println("Two");
        }
        else if (number > 2) {
            System.out.println("A lot");
        }

        // 20 - Print bigger
        int nr1 = scanner.nextInt();
        int nr2 = scanner.nextInt();
        System.out.println(nr1 > nr2 ? nr1 : nr2);

        // 21 - Party Indicator
        int girlNr = scanner.nextInt();
        int boyNr = scanner.nextInt();
        int allNr = Integer.sum(girlNr, boyNr);

        if (girlNr == 0) {
            System.out.println("Sausage party 😬");
        }
        else if (boyNr == girlNr && allNr >= 20) {
            System.out.println("The party is excellent!");
        }
        else if (boyNr != girlNr && allNr >= 20) {
            System.out.println("Quite cool party!");
        }
        else if (allNr < 20) {
            System.out.println("Average party...");
        }

        // 22 - Conditional variable mutation
        double a = 24;
        int out = 0;
        if (a % 2 == 0) {
            out += 1;
        }

        System.out.println(out);

        int b = 13;
        String out2 = "";
        if (b <= 20 && b >= 10) {
            out2 = "Sweet!";
        }
        else if (b < 10) {
            out2 = "Less!";
        }
        else if (b > 20) {
            out2 = "More!";
        }

        System.out.println(out2);

        int c = 123;
        int credits = 100;
        boolean isBonus = false;
        if (credits >= 50 && !isBonus) {
            c -= 2;
        }
        else if (credits < 50 && !isBonus) {
            c -= 1;
        }

        System.out.println(c);

        int d = 8;
        int time = 120;
        String out3 = "";
        if (d % 4 == 0 && time <= 200) {
            out3 = "check";
        }
        else if (time > 200) {
            out3 = "Time out";
        }
        else {
            out3 = "Run Forest Run!";
        }

        System.out.println(out3);
    }
}
