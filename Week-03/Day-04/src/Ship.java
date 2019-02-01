import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ship {
    List<Pirate> crewNumber;
    Pirate captain;
    private String captainName;

    Ship() {

    }

    public void fillShip() {
        captain = new Pirate(true);
        int crewNumber = 5 + (int)(Math.random() * 6);
        this.crewNumber = new ArrayList<>() {{
            for (int i = 0; i < crewNumber; i++) {
                add(i, new Pirate(false));
            }
        }};
    }
    public void setCaptainName (String captainName) {
        this.captainName = captainName;
    }

    public void shipData() {
        System.out.println("Captain: " + captainName + ".");
        System.out.println("Consumed rums: " + captain.currentDrinkCapacity + ".");
        System.out.print("State: ");
        if (captain.isDead) {
            System.out.println("Dead.");
        }
        else if (captain.isSleeping) {
            System.out.println("Passed out.");
        }
        else if (captain.isToxicated) {
            System.out.println("Drunk.");
        }
        else {
            System.out.println("Alive.");
        }
        System.out.println("Alive pirates: " + aliveCrewMembers());
    }

    public int aliveCrewMembers() {

        return (int)crewNumber.stream().filter(pirate -> !pirate.isDead).count();
    }

    public boolean battle(Ship enemyShip) {
        if (aliveCrewMembers() - captain.currentDrinkCapacity > enemyShip.aliveCrewMembers() - enemyShip.captain.currentDrinkCapacity) {
            enemyShip.lossPirates(1 + (int)(Math.random() * 6));
            party();
            return true;
        }
        else {
            lossPirates(1 + (int)(Math.random() * 6));
            enemyShip.party();
            return false;
        }
    }

    public void lossPirates(int losses) {
        if (crewNumber.size() <= losses) {
            crewNumber.clear();
            return;
        }
        for (int i = 0; i <= losses; i++) {
            crewNumber.remove(crewNumber.get(i));
            i -= 1;
            losses -= 1;
        }
    }

    public void party() {
        if (!captain.isToxicated) {
            captain.drinkSomeRum();
        }
        System.out.println(captainName + ": " + captain.howsItGoingMate());
        crewNumber = crewNumber.stream()
                .map(pirate -> {
                    if (!pirate.isToxicated) {
                        pirate.drinkSomeRum();
                    }
                    return pirate;
                })
                .collect(Collectors.toList());
        crewNumber = crewNumber.stream()
                .map(pirate -> {
                    if (pirate.isToxicated) {
                        System.out.println("Pirate: " + pirate.howsItGoingMate());
                    }
                    return pirate;
                })
                .collect(Collectors.toList());
        crewNumber = crewNumber.stream()
                .map(pirate -> {
                    if (pirate.currentDrinkCapacity > 2) {
                        pirate.brawl(crewNumber.get((int)(Math.random() * crewNumber.size())));
                    }
                    return pirate;
                })
                .collect(Collectors.toList());
        crewNumber = crewNumber.stream()
                .map(pirate -> {
                    if (pirate.isToxicated) {
                        System.out.println("Pirate: " + pirate.howsItGoingMate());
                    }
                    return pirate;
                })
                .collect(Collectors.toList());
    }
}
