package cloning;

public class Cloning {
    public static void main(String[] args) {

        Student john = new Student("John Doe", 20, "male", "BME");
        john.skipDays(5);
        john.introduce();
        john.getGoal();

        Student johnTheClone = new Student();

        try {
            johnTheClone = john.clone();
        } catch (Exception e) {

        }

        johnTheClone.introduce();
        john.getGoal();
    }
}
