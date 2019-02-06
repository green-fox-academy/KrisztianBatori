package cloning;


class Student extends Person implements Cloneable {
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

    @Override
    public Student clone() throws CloneNotSupportedException {
        return (Student)super.clone();
    }

    public void skipDays(int numberOfDays) {
        skippedDays += numberOfDays;
    }
}
