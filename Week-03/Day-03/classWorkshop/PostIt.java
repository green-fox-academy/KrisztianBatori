package classWorkshop;

import java.awt.*;

public class PostIt {
    Color backgroundColor;
    String text;
    Color textColor;

    public PostIt () {
        this (null, null, null);
    }

    public PostIt (Color newColor, String newText, Color newTextColor) {
        backgroundColor = newColor;
        text = newText;
        textColor = newTextColor;
    }
}
