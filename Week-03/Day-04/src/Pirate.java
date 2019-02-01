public class Pirate {
    public boolean hasParrot;
    public boolean isDead = false;
    public boolean isToxicated = false;
    public boolean isSleeping = false;
    public int currentDrinkCapacity = 0;
    private int drinkCapacity = 5;

    public Pirate(boolean hasParrot) {
        this.hasParrot = hasParrot;
    }

    public void drinkSomeRum() {
        if (isDead) {
            System.out.println("he's dead");
        }
        else {
            currentDrinkCapacity += 1;
            isToxicated = true;
        }
    }

    public String howsItGoingMate() {
        if (isDead) {
            return "he's dead";
        }
        else if (isSleeping) {
            return "he's sleeping";
        }
        else if (isToxicated && currentDrinkCapacity != 5) {
            currentDrinkCapacity += 1;
            return "Pour me anudder!";
        }
        else {
            isToxicated = false;
            isSleeping = true;
            return "Arghh, I'ma Pirate. How d'ya d'ink its goin?";
        }
    }

    public void passOut() {
        isSleeping = true;
    }

    public void die() {
        isDead = true;
    }

    public void brawl(Pirate enemyPirate) {
        if (!enemyPirate.isDead) {
            int fate = (int)(Math.random() * 3);
            if (fate == 0) {
                die();
            }
            else if (fate == 1) {
                enemyPirate.die();
            }
            else {
                passOut();
                enemyPirate.passOut();
            }
        }
    }
}
