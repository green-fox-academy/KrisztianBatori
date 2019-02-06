package thegardenapplication;

import java.util.ArrayList;

public class TheGardenApplication {

    public static void main(String[] args) {

        Garden garden = new Garden(new ArrayList<>() {{
            add(new Flower("yellow"));
            add(new Flower("blue"));
            add(new Tree("purple"));
            add(new Tree("orange"));
        }});

        garden.getNeedyPlants();
        System.out.println();
        garden.waterPlants(40);
        garden.getNeedyPlants();

        System.out.println();
        garden.waterPlants(70);
        garden.getNeedyPlants();

    }
}
