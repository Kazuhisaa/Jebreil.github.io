public class student {
    String name;
    int age;
    String gradeLevel;

    public student(String name, int age, String gradeLevel) {
        this.name = name;
        this.age = age;
        this.gradeLevel = gradeLevel;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Grade Level: " + gradeLevel);
    }
}
