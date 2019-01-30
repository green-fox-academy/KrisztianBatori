package classWorkshop;

import java.util.ArrayList;
import java.util.List;

public class SharpieSet {
    List<Sharpie> sharpies;

    public SharpieSet(ArrayList<Sharpie> sharpies) {
        this.sharpies = sharpies;
    }

    public void countUsable() {
        int counter = 0;
        for (Sharpie sharpie: sharpies) {
            if (sharpie.inkAmount > 0.0f) {
                counter ++;
            }
        }
        System.out.println(counter);
    }

    public void removeTrash() {
        List<Sharpie> sharpies_copy = sharpies;

        for (int i = 0; i < sharpies.size(); i++) {
            if (sharpies.get(i).inkAmount <= 0.0f) {
                sharpies_copy.remove(sharpies.get(i));
            }
        }

        sharpies = sharpies_copy;
    }
}
