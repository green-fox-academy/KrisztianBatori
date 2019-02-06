package zoo;

public class Reptile extends Animal {
    Reptile(String name) {
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
        return age * 16;
    }
}
