import java.lang.*;

public class GreenFoxOrganization {

    class Person {
        String name;
        int age;
        String gender;

        Person() {
            this("Jane Doe", 30, "female");
        }

        Person(String name, int age, String gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public void introduce () {
            System.out.println("Hi, I'm " + name + ", a " + age + " year old " + gender + ".");
        }

        public void getGoal() {
            System.out.println("My goal is: Live for the moment!");
        }
    }

    class Student extends Person {
        String previousOrganization;
        int skippedDays;

        Student() {
            super();
            previousOrganization = "The School of Life";
            skippedDays = 0;
        }

        Student(String name, int age, String gender, String previousOrganization) {
            super(name, age, gender);
            this.previousOrganization = previousOrganization;
            this.skippedDays = 0;
        }

        @Override
        public void getGoal() {
            System.out.println("Be a junior software developer.");
        }

        @Override
        public void introduce() {
            super.introduce();
            System.out.println("from " + previousOrganization + "who skipped " + skippedDays + "days from the course already");
        }

        public void skipDays(int numberOfDays) {
            skippedDays += numberOfDays;
        }
    }

    class Mentor extends Person {
        String level;

        Mentor() {
            super();
            level = "intermediate";
        }

        Mentor(String name, int age, String gender, String level) {
            super(name, age, gender);
            this.level = level;
        }

        @Override
        public void getGoal() {
            System.out.println("Educate brilliant junior software developers.");
        }

        @Override
        public void introduce() {
            super.introduce();
            System.out.println(level + " mentor.");
        }
    }

    public static void main(String[] args) {


    }
}
