package thegardenapplication;

public class Flower {
    String color;
    double waterAmount;

    public void watering(int wateringAmount) {
        wateringAmount += wateringAmount * 0.75;
    }
}
