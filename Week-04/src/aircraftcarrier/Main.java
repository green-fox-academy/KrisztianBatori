import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Carrier carrier1 = new Carrier(new ArrayList<Aircraft>() {{
            add(new Aircraft("F35", 12, 50));
            add(new Aircraft("F35", 12, 50));
            add(new Aircraft("F35", 12, 50));
            add(new Aircraft("F16", 8, 30));
            add(new Aircraft("F16", 8, 30));
        }}, 2352, 50000);

        Carrier carrier2 = new Carrier(new ArrayList<Aircraft>() {{
            for (int i = 0; i < 7; i++) {
                add(new Aircraft("F16", 8, 30));
            }
        }}, 3056, 68000);

        carrier1.fill();
        carrier1.getStatus();
        System.out.println();
        carrier2.fill();
        carrier2.getStatus();
        System.out.println();
        System.out.println("======= FIGHT =======");
        carrier1.fight(carrier2);
        System.out.println();
        carrier1.getStatus();
        System.out.println();
        carrier2.getStatus();


    }
}
