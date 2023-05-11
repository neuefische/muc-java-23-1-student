package student;

import java.util.Objects;

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

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", isActiveStudent=" + isActiveStudent +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (age != student.age) return false;
        if (isActiveStudent != student.isActiveStudent) return false;
        if (!Objects.equals(id, student.id)) return false;
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (isActiveStudent ? 1 : 0);
        return result;
    }
}
