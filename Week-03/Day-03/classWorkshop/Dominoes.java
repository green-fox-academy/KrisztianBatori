package classWorkshop;

import java.util.ArrayList;
import java.util.Arrays;

public class Dominoes {
    private ArrayList<Integer[]> original_domino_list = new ArrayList<>();

    public Dominoes() {
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                original_domino_list.add(new Integer[] {i, j});
            }
        }
    }

    public void printDominoes() {
        for (Integer[] domino: original_domino_list) {
            System.out.print("[" + domino[0] + " " + domino[1] + "] ");
        }
    }

    public void reorderDominoes() {

        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                original_domino_list.add(new Integer[] {i, j});
            }
        }

        ArrayList<Integer[]> new_domino_list = new ArrayList<>();
        ArrayList<Integer[]> original_domino_list_copy = original_domino_list;
        int randomInitialDominoIndex = (int)(Math.random() * 36);
        new_domino_list.add( new Integer[] {
                        original_domino_list_copy.get(randomInitialDominoIndex)[0],
                        original_domino_list_copy.get(randomInitialDominoIndex)[1]
                    }
                );
        original_domino_list_copy.remove(original_domino_list_copy.get(randomInitialDominoIndex));

        while (!original_domino_list_copy.isEmpty()) {
            Integer[] last_Domino = new_domino_list.get(new_domino_list.size() - 1);
            for (Integer[] nextDomino: original_domino_list_copy) {
                if (new_domino_list.get(new_domino_list.size() - 1)[1].equals(nextDomino[0])) {
                    new_domino_list.add(nextDomino);
                    original_domino_list_copy.remove(nextDomino);
                    break;
                }
            }
            if (Arrays.equals(last_Domino, new_domino_list.get(new_domino_list.size() - 1))) {
                reorderDominoes();
                break;
            }
        }

        original_domino_list = new_domino_list;
    }
}
