package student;

public class StudentDb {

    private Student [] students;

    public StudentDb(Student [] students) {
        this.students = students.clone();
    }
}
