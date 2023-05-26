package de.neuefische.mucjava231student.service;

import de.neuefische.mucjava231student.model.Student;
import de.neuefische.mucjava231student.repository.StudentRepository;

import java.util.NoSuchElementException;
import java.util.concurrent.ThreadLocalRandom;

public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student randomStudent(){
        Student[] students = studentRepository.getAllStudents();

        if(students.length == 0) {
            throw new NoSuchElementException("Die StudentenDb ist leer!");
        }

        int randomNumberBetween0AndStudentsArrayLength = ThreadLocalRandom.current().nextInt(0, students.length);
        return students[randomNumberBetween0AndStudentsArrayLength];
    }
}
