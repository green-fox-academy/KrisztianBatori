package flyable;

import zoo.Animal;

public class Bird extends Animal implements Flyable {
    Bird(String name) {
        this.name = name;
        this.age = 0;
        this.gender = "Undefined";
    }

    @Override
    public String breed() {
        return "laying eggs";
    }

    @Override
    public int convertAgeToHumanAge() {
        return age * 8;
    }

    @Override
    public void land() {
        System.out.println("Bird is on ground.");
    }

    @Override
    public void fly() {
        System.out.println("Bird is flying.");
    }

    @Override
    public void takeOff() {
        System.out.println("Bird has left the ground.");
    }
}
