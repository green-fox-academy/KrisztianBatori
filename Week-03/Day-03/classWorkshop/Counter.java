package classWorkshop;

public class Counter {
    int initialValue;
    int currentValue = initialValue;

    public Counter() {
    }

    public Counter (int newValue) {
        initialValue = newValue;
        currentValue = initialValue;
    }

    public void add() {
        currentValue += 1;
    }

    public void add(int newValue) {
        currentValue += newValue;
    }

    public int get() {
        return currentValue;
    }

    public void reset() {
        currentValue = initialValue;
    }
}
