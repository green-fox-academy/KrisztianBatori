package zoo;

public class Bird extends Animal {
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
}
