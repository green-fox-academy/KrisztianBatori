package thegardenapplication;

public class Flower extends Plant {
    Flower(String color) {
        super.color = color;
        super.type = "Flower";
        super.absorbAmount = 0.75;
    }
}
