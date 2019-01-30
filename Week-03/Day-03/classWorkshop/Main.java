package classWorkshop;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;


public class Main {
    public static void main(String[] args) {

        // 13 - Farm
        Farm farm = new Farm(new ArrayList<>() {{
            add(new Animal());
            add(new Animal());
            add(new Animal());
            add(new Animal());
            add(new Animal());
            add(new Animal());
            add(new Animal());
        }});
    }
}
