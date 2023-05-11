package student;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.concurrent.ThreadLocalRandom;

public class StudentDb {

    private Student [] students;

    public StudentDb(Student [] students) {
        // Bestehendes Studenten-Array kopieren
        this.students = students.clone();
    }

    public Student[] getAllStudents() {
        return students;
    }

    public Student randomStudent(){
        if(students.length == 0) {
            throw new NoSuchElementException("Die StudentenDb ist leer!");
        }

        int randomNumberBetween0AndStudentsArrayLength = ThreadLocalRandom.current().nextInt(0, students.length);
        return students[randomNumberBetween0AndStudentsArrayLength];
    }

    @Override
    public String toString() {
        return "StudentDb{" +
                "students=" + Arrays.toString(students) +
                '}';
    }
}
