package de.neuefische.mucjava231student.repository;

import de.neuefische.mucjava231student.model.Student;

import java.util.Arrays;

public class StudentRepository {

    private Student[] students;

    public StudentRepository(Student [] students) {
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
