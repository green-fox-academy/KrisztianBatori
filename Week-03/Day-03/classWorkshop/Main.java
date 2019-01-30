package classWorkshop;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;


public class Main {
    public static void main(String[] args) {

        // 02 - Blog post
        BlogPost post1 = new BlogPost(
                "John Doe",
                "Lorem Ipsum",
                "Lorem ipsum dolor sit amet.",
                new Date(2000, 5, 4));

        BlogPost post2 = new BlogPost("Tim Urban",
                "Wait but why",
                "A popular long-form, stick-figure-illustrated blog about almost everything.",
                new Date(2010, 10, 10));

        BlogPost post3 = new BlogPost("William Turton",
                "One Engineer Is Trying to Get IBM to Reckon With Trump",
                "Daniel Hanley, a cybersecurity engineer at IBM, doesn’t want to be the center of attention." +
                        "When I asked to take his picture outside one of IBM’s New York City offices, he told me that he wasn’t" +
                        "really into the whole organizer profile thing.",
                new Date(2017, 3, 28));
}
