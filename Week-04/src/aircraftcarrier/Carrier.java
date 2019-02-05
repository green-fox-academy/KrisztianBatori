package aircraftcarrier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Carrier {
    private ArrayList<Aircraft> aircrafts;
    private int ammoStorage;
    private int healthPoints;

    Carrier(ArrayList<Aircraft> aircrafts, int ammoStorage, int healthPoints) {
        this.aircrafts = aircrafts;
        this.ammoStorage = ammoStorage;
        this.healthPoints = healthPoints;
    }

    public void add(Aircraft aircraft) {
        aircrafts.add(aircraft);
    }

    public void fill() {
        if (ammoStorage < 0) {
            throw new IllegalArgumentException("The aircraft has no ammo.");
        }

        if (ammoStorage < 1000) {
            aircrafts = (ArrayList<Aircraft>)aircrafts.stream()
                    .map(aircraft -> {
                        if (aircraft.isPriority) {
                            ammoStorage = aircraft.refill(ammoStorage);
                        }
                        return aircraft;
                    })
                    .collect(Collectors.toList());
            aircrafts = (ArrayList<Aircraft>)aircrafts.stream()
                    .map(aircraft -> {
                        if (!aircraft.isPriority) {
                            ammoStorage = aircraft.refill(ammoStorage);
                        }
                        return aircraft;
                    })
                    .collect(Collectors.toList());
        }
        else {
            for (int i = 0; i < aircrafts.size(); i++) {
                ammoStorage = aircrafts.get(i).refill(ammoStorage);
            }
        }
    }

    public void fight(Carrier enemyCarrier) {
        while (ammoStorage != 0) {
            fill();
            aircrafts = (ArrayList<Aircraft>)aircrafts.stream()
                    .map(aircraft -> {
                        aircraft.fight();
                        return aircraft;
                    })
                    .collect(Collectors.toList());
        }
    }

    public void getStatus() {
        if (healthPoints <= 0) {
            System.out.println("It's dead Jim :(");
        }
        else {
            int totalDamage = Arrays.stream(
                    aircrafts.stream()
                            .map(aircraft -> aircraft.base_damage * aircraft.ammo_store)
                            .mapToInt(i -> i)
                            .toArray()
            ).sum();
            System.out.println("HP: " + healthPoints + ", Aircraft count: " + aircrafts.size() + ", Ammo Storage: " + ammoStorage + ", Total damage: " + totalDamage);
            System.out.println("Aircrafts:");
            for (Aircraft aircraft: aircrafts) {
                System.out.println("Type: " + aircraft.type + ", Ammo: " + aircraft.ammo_store + ", Base Damage: " + aircraft.base_damage + ", All Damage: " + aircraft.fight());
            }
        }
    }
}
