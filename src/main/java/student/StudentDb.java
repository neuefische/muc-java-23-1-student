package student;

import java.util.Arrays;

public class StudentDb {

    private Student [] students;

    public StudentDb(Student [] students) {
        // Bestehendes Studenten-Array kopieren
        this.students = students.clone();
    }

    public Student[] getAllStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "StudentDb{" +
                "students=" + Arrays.toString(students) +
                '}';
    }
}
