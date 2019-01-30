package classWorkshop;

public class Animal {
    int hunger;
    int thirst;

    public Animal() {
        hunger = 50;
        thirst = 50;
    }

    public void eat() {
        hunger -= 1;
    }

    public void drink() {
        thirst -= 1;
    }

    public void play() {
        hunger += 1;
        thirst += 1;
    }
}
