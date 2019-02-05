package aircraftcarrier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Carrier {
    public ArrayList<Aircraft> aircrafts;
    private int ammoStorage;
    public int healthPoints;

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
            // Attacking enemy carrier.
            enemyCarrier.healthPoints -= getTotalDamage();
            if (enemyCarrier.healthPoints <= 0) {
                break;
            }
            aircrafts = (ArrayList<Aircraft>)aircrafts.stream()
                    .map(aircraft -> {
                        aircraft.fight();
                        return aircraft;
                    })
                    .collect(Collectors.toList());
            fill();

            // Enemy carrier counter-attacking.
            healthPoints -= enemyCarrier.getTotalDamage();
            if (healthPoints <= 0) {
                break;
            }
            enemyCarrier.aircrafts = (ArrayList<Aircraft>)enemyCarrier.aircrafts.stream()
                    .map(aircraft -> {
                        aircraft.fight();
                        return aircraft;
                    })
                    .collect(Collectors.toList());
            enemyCarrier.fill();
        }
    }

    public int getTotalDamage() {
        return Arrays.stream(
                aircrafts.stream()
                        .map(aircraft -> aircraft.base_damage * aircraft.ammo_store)
                        .mapToInt(i -> i)
                        .toArray()
        ).sum();
    }

    public void getStatus() {
        if (healthPoints <= 0) {
            System.out.println("It's dead Jim :(");
        }
        else {
            System.out.println("HP: " + healthPoints + ", Aircraft count: " + aircrafts.size() + ", Ammo Storage: " + ammoStorage + ", Total damage: " + getTotalDamage());
            System.out.println("Aircrafts:");
            for (Aircraft aircraft: aircrafts) {
                System.out.println("Type: " + aircraft.type + ", Ammo: " + aircraft.ammo_store + ", Base Damage: " + aircraft.base_damage + ", All Damage: " + aircraft.fight());
            }
        }
    }
}
