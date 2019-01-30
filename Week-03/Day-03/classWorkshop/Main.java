package classWorkshop;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;


public class Main {
    public static void main(String[] args) {

        // +1 - 5 trees
        ArrayList<Tree> trees = new ArrayList<>() {{
            add(new Tree("Yellow Birch", Color.YELLOW, 12, "Male"));
            add(new Tree("Mopane", Color.GREEN, 23, "Female"));
            add(new Tree("Olive", Color.PINK, 5, "Female"));
            add(new Tree("Black walnut", Color.BLACK, 8, "Male"));
            add(new Tree("Gymea Lily", Color.RED, 44, "Male"));
        }};
    }
}
