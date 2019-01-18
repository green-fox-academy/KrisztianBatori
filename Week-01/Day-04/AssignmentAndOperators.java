public class AssignmentAndOperators {
    public static void main(String[] args) {
        // 07 - Favourite Number
        int FavouriteNumber = 9;
        System.out.println("My favourite number is: " + FavouriteNumber);

        // 08 - Swap
        int a1 = 123;
        int b1 = 526;

        int temp = a1;
        a1 = b1;
        b1 = temp;

        System.out.println(a1);
        System.out.println(b1);

        // 09 - BMI
        double massInKg = 81.2;
        double heightInM = 1.78;

        System.out.println("Bmi: " + (massInKg / (heightInM * heightInM)));

        // 10 - Define Basic Info
        String name = "Batori";
        int age = 21;
        double height = 1.74;
        boolean married = false;

        System.out.println(name);
        System.out.println(age);
        System.out.println(height);
        System.out.println(married);

        // 11 - Variable Mutation
        int a = 3;
        a += 10;

        System.out.println(a);

        int b = 100;
        b -= 7;

        System.out.println(b);

        int c = 44;
        c *= 2;

        System.out.println(c);

        int d = 125;
        d /= 5;

        System.out.println(d);

        int e = 8;
        e = (int) Math.pow(e, 3);

        System.out.println(e);

        int f1 = 123;
        int f2 = 345;
        System.out.println(f1 > f2);

        int g1 = 350;
        int g2 = 200;
        System.out.println((g2 * 2) > g1);

        int h = 135798745;
        System.out.println(h % 11 == 0);

        int i1 = 10;
        int i2 = 3;
        System.out.println(i1 > Math.pow(i2, 2) && i1 < Math.pow(i2, 3));

        int j = 1521;
        System.out.println(j % 3 == 0 || j % 5 == 0);

        String k = "Apple";
        k = k.repeat(4);

        System.out.println(k);

        // 12 - Cuboid
        int Length = 10;
        int Width = 10;
        int Height = 10;

        System.out.println("Surface area: " + ( 2 * ( (Length * Width) + (Height * Width) + (Length * Height) ) ) );
        System.out.println("Volume: " + Length * Width * Height);

        // 13 - Seconds in a day
        int currentHours = 14;
        int currentMinutes = 34;
        int currentSeconds = 42;

        System.out.println("Seconds (overall): " + (currentSeconds + currentMinutes * 60 + currentHours * 3600));
    }
}
