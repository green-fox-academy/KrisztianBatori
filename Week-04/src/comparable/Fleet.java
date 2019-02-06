package comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by aze on 2017.03.29..
 */
public class Fleet {
    private ArrayList<Thing> things;

    public Fleet() {
        things = new ArrayList<>();
    }

    public void add(Thing thing) {
        things.add(thing);
    }

    @Override
    public String toString() {
        ArrayList<Thing> thingsCompleted = (ArrayList<Thing>) things.stream().filter(thing -> thing.completed).collect(Collectors.toList());
        ArrayList<Thing> thingsNotCompleted = (ArrayList<Thing>) things.stream().filter(thing -> !thing.completed).collect(Collectors.toList());
        Collections.sort(thingsCompleted);
        Collections.sort(thingsNotCompleted);

        ArrayList<Thing> mergedList = new ArrayList<>();
        mergedList.addAll(thingsCompleted);
        mergedList.addAll(thingsNotCompleted);

        String result = "";
        for(int i = 0; i < mergedList.size(); i++) {
            result += (i+1) + " " + mergedList.get(i) + "\n";
        }
        return result;
    }
}
