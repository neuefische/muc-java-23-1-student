package student;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class StudentDb {

    private final Map<String, Student> students = new HashMap<>();

    public StudentDb(Student [] students) {
        // Bestehendes Studenten-Array kopieren
        for (Student student : students) {
            this.students.put(student.getId(), student);
        }
    }

    public Student[] getAllStudents() {
        return students.values().toArray(new Student[0]);
    }

    public Student randomStudent(){
        if(students.isEmpty()) {
            throw new NoSuchElementException("Die StudentenDb ist leer!");
        }

        int randomNumberBetween0AndStudentsArrayLength = ThreadLocalRandom.current().nextInt(0, students.size());
        return new ArrayList<>(students.values()).get(randomNumberBetween0AndStudentsArrayLength);
    }

    @Override
    public String toString() {
        return "StudentDb{" +
                "students=" + students +
                '}';
    }
}
