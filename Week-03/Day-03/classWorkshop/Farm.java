package classWorkshop;

import java.util.ArrayList;
import java.util.List;

public class Farm {
    List<Animal> animals;
    int freeSpace = 10;

    public Farm(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    public void breed() {
        if (freeSpace > 0) {
            animals.add(new Animal());
            freeSpace -= 1;
        }
    }

    public void slaughter() {
        Animal leastHungryAnimal = animals.get(0);
        for (int i = 1; i < animals.size(); i++) {
            if (animals.get(i).hunger < leastHungryAnimal.hunger) {
                leastHungryAnimal = animals.get(i);
            }
        }
        animals.remove(leastHungryAnimal);
    }
}
