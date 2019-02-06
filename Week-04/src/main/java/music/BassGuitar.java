package main.java.music;

public class BassGuitar extends StringedInstrument {
    public BassGuitar() {
        this.numberOfStrings = 4;
    }

    public BassGuitar(int numberOfStrings) {
        this.numberOfStrings = numberOfStrings;
    }

    @Override
    public void sound() {
        System.out.println("Bass Guitar, a " + numberOfStrings + "-stringed instrument that goes Duum-duum-duum");
    }
}
