import java.util.Scanner;

public class UserInputScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 14 - Hello User
        System.out.printf("Please give me your name: ");
        String userName = scanner.nextLine();
        System.out.println("Hello " + userName);

        // 15 - Mile to Km Converter
        System.out.printf("Please give the distance in kilometers (km): ");
        int userDistance = scanner.nextInt();
        System.out.println("The distance converted to miles: " + userDistance * 0.6214);

        // 16 - Animals and legs
        System.out.println("Please give me two numbers: ");
        int chickens = scanner.nextInt();
        int pigs = scanner.nextInt();

        System.out.println("The first number represents the chickens, second is the pigs. The animals now have: " + ((chickens * 2) + (pigs * 4)));

        // 17 - Average of Input
        System.out.println("Please give me 5 numbers:");
        int usrNr1 = scanner.nextInt();
        int usrNr2 = scanner.nextInt();
        int usrNr3 = scanner.nextInt();
        int usrNr4 = scanner.nextInt();
        int usrNr5 = scanner.nextInt();
        int usrSum = usrNr1 + usrNr2 + usrNr3 + usrNr4 + usrNr5;

        System.out.println("Sum: " + usrSum + ", Average: " + usrSum / 5.);
    }
}
