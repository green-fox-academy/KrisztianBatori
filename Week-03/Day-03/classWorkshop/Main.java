package classWorkshop;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;


public class Main {
    public static void main(String[] args) {

        // 12 - SharpieSet
        SharpieSet sharpies = new SharpieSet(new ArrayList<>() {{
                add(new Sharpie("Green", 5.213f));
                add(new Sharpie("Red", 6.345f));
                add(new Sharpie("Gray", 1.324f));
                add(new Sharpie("Black", 4.2134f));
                add(new Sharpie("Yellow", 7.435345f));
            }});

    }
}
