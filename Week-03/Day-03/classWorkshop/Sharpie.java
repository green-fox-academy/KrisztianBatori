package classWorkshop;

public class Sharpie {
    String color;
    float width;
    float inkAmount = 100.0f;

    public Sharpie(String newColor, float newWidth) {
        color = newColor;
        width = newWidth;
    }

    public void use() {
        inkAmount -= 100.0;
    }
}
