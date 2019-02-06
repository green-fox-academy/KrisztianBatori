package flyable;

public class Helicopter extends Vehicle implements Flyable {

    Helicopter(int weight) {
        this.weight = weight;
        this.wheels = 0;
    }

    @Override
    public void land() {
        System.out.println("Helicopter landed.");
    }

    @Override
    public void fly() {
        System.out.println("Helicopter is flying.");
    }

    @Override
    public void takeOff() {
        System.out.println("Helicopter is being taken off.");
    }

    @Override
    public double getSpeed() {
        return weight * 0.3245;
    }
}
