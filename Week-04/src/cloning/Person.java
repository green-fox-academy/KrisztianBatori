package cloning;

class Person {
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
