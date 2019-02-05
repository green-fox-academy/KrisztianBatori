package thegardenapplication;

import java.util.ArrayList;

public class Garden {
    ArrayList<Plant> plants;

    public void waterPlants(int waterAmount) {
        int plantsNeededWaterCount = (int)plants.stream()
                                        .filter(plant -> plant.type.equals("Tree") && plant.waterAmount < 10)
                                        .count();
        plantsNeededWaterCount += (int)plants.stream()
                                        .filter(plant -> plant.type.equals("Flower") && plant.waterAmount < 5)
                                        .count();

        waterAmount /= plantsNeededWaterCount;

        for (int i = 0; i < plants.size(); i++) {
            plants.get(i).watering(waterAmount);
        }
    }

}
