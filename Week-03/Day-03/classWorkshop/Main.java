package classWorkshop;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;


public class Main {
    public static void main(String[] args) {

        // 09 - Dominoes
        Dominoes domino = new Dominoes();
        domino.printDominoes();
        domino.reorderDominoes();
        System.out.println();
        domino.printDominoes();
        System.out.println();
    }
}
