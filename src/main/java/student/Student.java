package student;

// Klassennamen = Anfangs GroßGeschrieben
// UpperCamelCase
public class Student {

    String id;
    String name;
    int age;
    boolean isActiveStudent;

    public Student() {}

    public Student(String id, String name, int age, boolean isActiveStudent) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.isActiveStudent = isActiveStudent;
    }

    public String printStudentName() {
        return "Name: " + name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isActiveStudent() {
        return isActiveStudent;
    }

    public void setActiveStudent(boolean activeStudent) {
        isActiveStudent = activeStudent;
    }
}
