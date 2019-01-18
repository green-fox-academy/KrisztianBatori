import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 23 - I won't cheat on exam
        for (int i = 0; i < 5; i++) {
            System.out.println("I won't cheat on the exam!");
        }

        // 24 - Print even
        for (int i = 1; i < 501; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }

        // 25 - Multiplication Table
        int usrNr = scanner.nextInt();

        for (int i = 1; i < 11; i++) {
            System.out.println(i + " * " + usrNr + " = " + usrNr * i);
        }

        // 26 - Count from to
        boolean loop = true;
        do {
            int usrNr1 = scanner.nextInt();
            int usrNr2 = scanner.nextInt();
            if (usrNr2 <= usrNr1) {
                System.out.println("The second number should be bigger");
            }
            else {
                loop = !loop;
                for (int i = usrNr1; i < usrNr2; i++) {
                    System.out.println(i);
                }
            }
        } while (loop);

        // 27 - FizzBuzz
        for (int i = 1; i < 101; i++) {
            String text;
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            }
            else if (i % 3 == 0) {
                System.out.println("Fizz");
            }
            else if (i % 5 == 0) {
                System.out.println("Buzz");
            }
            else {
                System.out.println(i);
            }
        }

        // 28 - Draw triangle
        int triangleRows = scanner.nextInt();
        for (int i = 1; i <= triangleRows; i++) {
            System.out.println("*".repeat(i));
        }

        // 29 - Draw pyramid
        int pyramidRows = scanner.nextInt();
        int stars = 1;
        int space = pyramidRows - 1;
        for (int i = 1; i <= pyramidRows; i++) {
            System.out.println(" ".repeat(space) + "*".repeat(stars));
            stars += 2;
            space -= 1;
        }

        // 30 - Draw Diamond
        int diamondRows = scanner.nextInt();
        int diamondStars = diamondRows % 2 == 0 ? 2 : 1;
        int diamondSpace = diamondRows / 2;
        for (int i = 1; i <= diamondRows / 2; i++) {
            System.out.println(" ".repeat(diamondSpace) + "*".repeat(diamondStars));
            diamondStars += 2;
            diamondSpace -= 1;
        }
        if (diamondRows % 2 == 0) {
            diamondStars -= 2;
            diamondSpace += 1;
        }
        for (int i = -1; i < diamondRows / 2; i++) {
            System.out.println(" ".repeat(diamondSpace) + "*".repeat(diamondStars));
            diamondStars -= 2;
            diamondSpace += 1;
        }

        // 31 - Draw Square
        int squareRows = scanner.nextInt();
        int squareSpace = squareRows - 2;
        System.out.println("%".repeat(squareRows));
        for (int i = 1; i < squareRows - 1; i++) {
            System.out.println("%" + " ".repeat(squareSpace) + "%");
        }
        System.out.println("%".repeat(squareRows));

        // 32 - Draw Diagonal
        int diagonalRows = scanner.nextInt();
        int diagonalFirstSpace = 0;
        int diagonalSecondSpace = diagonalRows - 3;
        System.out.println("%".repeat(diagonalRows));
        for (int i = 1; i < diagonalRows - 1; i++) {
            System.out.println("%" + " ".repeat(diagonalFirstSpace) + "%" + " ".repeat(diagonalSecondSpace) + "%");
            diagonalFirstSpace += 1;
            diagonalSecondSpace -= 1;
        }
        System.out.println("%".repeat(diagonalRows));


        // 33 - Guess the number
        int storedNumber = 42;
        int usrNumber = scanner.nextInt();
        while (usrNumber != storedNumber) {
            if (usrNumber < storedNumber) {
                System.out.println("The stored number is higher");
            }
            else {
                System.out.println("The stored number is lower");
            }
            usrNumber = scanner.nextInt();
        }
        System.out.println("You found the number: " + usrNumber);

        // 34 - Parametric Average
        int countNr = scanner.nextInt();
        double sum = 0.;

        for(int i = 0; i < countNr; i++) {
            sum += scanner.nextInt();
        }
        System.out.println("Sum: " + sum + ", Average: " + sum / countNr);

        // 35 - Draw chess table
        String squareA = "%%";
        String squareB = " ";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.printf(squareA + squareB);
            }
            String temp = squareA;
            squareA = squareB;
            squareB = temp;
            System.out.println();
        }

        // +1 - Find a substring
        System.out.println(subStr("this is what I'm searching in", "searching"));
        System.out.println(subStr("this is what I'm searching in", "not"));
    }

    public static int subStr(String input, String q) {
        return input.toLowerCase().indexOf(q.toLowerCase());
    }
}
