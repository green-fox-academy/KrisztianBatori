package zoo;

public abstract class Animal {
    protected String name;
    protected String gender;
    protected int age;

    public String getName() {
        return name;
    }
    public String getGender() {
        return gender;
    }
    public int getAge() {
        return age;
    }
    public abstract int convertAgeToHumanAge();
    public abstract String breed();
}
