package student;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.ThreadLocalRandom;

public class StudentDb {

    private List<Student> students;

    public StudentDb(Student [] students) {
        // Bestehendes Studenten-Array kopieren
        this.students = Arrays.asList(students);
    }

    public Student[] getAllStudents() {
        return students.toArray(new Student[0]);
    }

    public Student randomStudent(){
        if(students.isEmpty()) {
            throw new NoSuchElementException("Die StudentenDb ist leer!");
        }

        int randomNumberBetween0AndStudentsArrayLength = ThreadLocalRandom.current().nextInt(0, students.size());
        return students.get(randomNumberBetween0AndStudentsArrayLength);
    }

    @Override
    public String toString() {
        return "StudentDb{" +
                "students=" + students +
                '}';
    }
}
