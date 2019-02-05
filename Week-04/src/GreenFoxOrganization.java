import java.lang.*;
import java.util.ArrayList;
import java.util.List;

public class GreenFoxOrganization {

    public static class Person {
        String name;
        int age;
        String gender;
        String introduction = ".";
        String goal = "Live for the moment.";

        Person() {
            this("Jane Doe", 30, "female");
        }

        Person(String name, int age, String gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public void introduce () {
            System.out.println("Hi, I'm " + name + ", a " + age + " year old " + gender + introduction);
        }

        public void getGoal() {
            System.out.println("My goal is: " + goal);
        }
    }

    public static class Student extends Person {
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
        public void introduce() {
            super.introduction = " from " + previousOrganization + " who skipped " + skippedDays + " days from the course already.";
            super.introduce();
        }

        @Override
        public void getGoal() {
            super.goal = "Be a junior software developer.";
            super.getGoal();
        }

        public void skipDays(int numberOfDays) {
            skippedDays += numberOfDays;
        }
    }

    public static class Mentor extends Person {
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
        public void introduce() {
            super.introduction = " " + level + " mentor.";
            super.introduce();
        }

        @Override
        public void getGoal() {
            super.goal = "Educate brilliant junior software developers.";
            super.getGoal();
        }
    }

    public static class Sponsor extends Person {
        String company;
        int hiredStudents;

        public void hire() {
            hiredStudents += 1;
        }

        Sponsor() {
            super();
            company = "Google";
            hiredStudents = 0;
        }

        Sponsor(String name, int age, String gender, String company) {
            super(name, age, gender);
            this.company = company;
        }

        @Override
        public void introduce() {
            super.introduction = " who represents " + company + " and hired " + hiredStudents + " students so far.";
            super.introduce();
        }

        @Override
        public void getGoal() {
            super.goal = "Hire brilliant junior software developers.";
            super.getGoal();
        }
    }

    public static class Cohort {
        String name;
        List<Student> students;
        List<Mentor> mentors;

        Cohort(String name) {
            this.name = name;
            students = new ArrayList<>();
            mentors = new ArrayList<>();
        }

        public void addStudent(Student student) {
            students.add(student);
        }

        public void addMentor(Mentor mentor) {
            mentors.add(mentor);
        }

        public void info() {
            System.out.println("The " + name + " cohort has " + students.size() + " students and " + mentors.size() + " mentors.");
        }
    }

    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();

        Person mark = new Person("Mark", 46, "male");
        people.add(mark);
        Person jane = new Person();
        people.add(jane);
        Student john = new Student("John Doe", 20, "male", "BME");
        people.add(john);
        Student student = new Student();
        people.add(student);
        Mentor gandhi = new Mentor("Gandhi", 148, "male", "senior");
        people.add(gandhi);
        Mentor mentor = new Mentor();
        people.add(mentor);
        Sponsor sponsor = new Sponsor();
        people.add(sponsor);
        Sponsor elon = new Sponsor("Elon Musk", 46, "male", "SpaceX");
        people.add(elon);

        student.skipDays(3);

        for (int i = 0; i < 5; i++) {
            elon.hire();
        }

        for (int i = 0; i < 3; i++) {
            sponsor.hire();
        }

        for(Person person : people) {
            person.introduce();
            person.getGoal();
        }

        Cohort awesome = new Cohort("AWESOME");
        awesome.addStudent(student);
        awesome.addStudent(john);
        awesome.addMentor(mentor);
        awesome.addMentor(gandhi);
        awesome.info();
    }
}
