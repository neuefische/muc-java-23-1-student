package student;

public class StudentDb {

    private Student [] students;

    public StudentDb(Student [] students) {
        // Bestehendes Studenten-Array kopieren
        this.students = students.clone();
    }

    public Student[] getAllStudents() {
        return students;
    }
}
