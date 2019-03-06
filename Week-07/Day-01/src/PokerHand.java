import java.lang.reflect.Array;
import java.nio.file.Files;
import java.util.*;

public class PokerHand {
    private char[] pokerhand;
    HashMap<Character, Integer> pokerSymbols = new HashMap<>() {{
        put('A', 14);
        put('K', 13);
        put('Q', 12);
        put('J', 11);
        put('9', 9);
        put('8', 8);
        put('7', 7);
        put('6', 6);
        put('5', 5);
        put('4', 4);
        put('3', 3);
        put('2', 2);
    }};
    public ArrayList<Integer[]> pairs = new ArrayList<>();

    PokerHand(String pokerhand) {
        this.pokerhand = pokerhand.toCharArray();
    }

    public String getPokerhand() {
        return Arrays.toString(pokerhand);
    }

    public int highestValue() {

        int highCard = pokerSymbols.get(pokerhand[0]);

        for (int i = 2; i < 9; i += 2) {
            int pokerValue = pokerSymbols.get(pokerhand[i]);

            if (pokerValue > highCard) {
                highCard = pokerValue;
            }
        }

        return highCard;
    }

    public int findHighestPair() {

        HashMap<Character, Integer> counts = new HashMap<>();

        for (int i = 0; i < 9; i += 2) {
            if (!counts.containsKey(pokerhand[i])) {
                counts.put(pokerhand[i], 1);
            }
            else {
                counts.replace(pokerhand[i], counts.get(pokerhand[i]) + 1);
            }
        }

        for (Character ch:
             counts.keySet()) {
            if (counts.get(ch) > 1) {
                pairs.add(new Integer[] {pokerSymbols.get(ch), pokerSymbols.get(ch)});
            }
        }

        if (pairs.size() != 0) {
            Integer[] maxPair = pairs.get(0);

            for (Integer[] pair:
                    pairs) {
                if (Integer.sum(pair[0], pair[1]) > Integer.sum(maxPair[0], maxPair[1])) {
                    maxPair = pair;
                }
            }

            return Integer.sum(maxPair[0], maxPair[1]);
        }
        else {
            return 0;
        }

    }



    public boolean determineWinner(PokerHand pokerHand) {

        if (findHighestPair() != pokerHand.findHighestPair()) {

            return findHighestPair() > pokerHand.findHighestPair();
        }
        else {
            return this.highestValue() > pokerHand.highestValue();
        }
    }
}