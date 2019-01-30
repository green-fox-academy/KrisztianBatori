package classWorkshop;

public class Station {
    int gasAmount;

    public void refill(Car car) {
        car.gasAmount += car.capacity;
        gasAmount -= car.capacity;
    }
}
