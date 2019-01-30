package classWorkshop;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;


public class Main {
    public static void main(String[] args) {

        // 14 - Blog
        Blog blogPosts = new Blog(new ArrayList<>() {{
            add(new BlogPost("Boss", "Attention", "Important stuff", new Date(2019, 9, 1)));
            add(new BlogPost("King", "Servants!", "Not important stuff", new Date(1433, 12, 31)));
            add(new BlogPost("HR", "Important!", "Stuff", new Date(2019, 1, 2)));
        }});
    }
}
