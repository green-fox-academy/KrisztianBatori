package zoo;

public class Mammal extends Animal {

    Mammal(String name) {
        this.name = name;
        this.age = 0;
        this.gender = "Undefined";
    }

    @Override
    public String breed() {
        return "pushing miniature versions out";
    }

    @Override
    public int convertAgeToHumanAge() {
        return age;
    }
}
