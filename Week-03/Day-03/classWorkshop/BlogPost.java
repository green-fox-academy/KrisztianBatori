package classWorkshop;

import java.util.Date;

public class BlogPost {
    String authorName;
    String title;
    String text;
    Date publicationDate;

    public BlogPost (String newAuName, String newTitle, String newText, Date newDate) {
        authorName = newAuName;
        title = newTitle;
        text = newText;
        publicationDate = newDate;
    }
}
