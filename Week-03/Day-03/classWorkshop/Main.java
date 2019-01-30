package classWorkshop;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;


public class Main {
    public static void main(String[] args) {

        // 08 - Dice set
        DiceSet diceSet = new DiceSet();
        diceSet.roll();

        while (!diceSet.getCurrent().equals(new ArrayList<Integer>() {{ for (int i = 0; i < 6; i++) { add(6); } }}))
        {
            if (!diceSet.getCurrent().contains(6)) {
                diceSet.reroll();
            }
            else {
                for (int i = 0; i < diceSet.getCurrent().size(); i++) {
                    if (diceSet.getCurrent(i) != 6) {
                        diceSet.reroll(i);
                        break;
                    }
                }
            }
        }
        System.out.println(diceSet.getCurrent());

    }
}
