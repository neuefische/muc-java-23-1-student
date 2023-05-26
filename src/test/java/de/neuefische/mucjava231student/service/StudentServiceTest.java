package de.neuefische.mucjava231student.service;

import de.neuefische.mucjava231student.model.ComputerScienceStudent;
import de.neuefische.mucjava231student.model.Student;
import de.neuefische.mucjava231student.repository.StudentRepository;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @Test
    void randomStudent_shouldReturnAValidStudentsObject_whenTwoStudentsAreInStudentsArray() {
        // GIVEN
        Student jackTorrance = new ComputerScienceStudent("1", "Jack Torrance", 37, false,"Java");
        Student wendyTorrance = new ComputerScienceStudent("2", "Wendy Torrance", 35, false,"Mongo");

        Student [] expectedStudents = {jackTorrance, wendyTorrance};

        StudentRepository studentRepository = new StudentRepository(expectedStudents);
        StudentService studentService = new StudentService(studentRepository);

        // WHEN
        Student randomStudent = studentService.randomStudent();

        // THEN
        assertNotNull(randomStudent);
    }

    @Test
    void randomStudent_shouldReturnAValidStudentObject_whenOneStudentIsInStudentsArray() {
        // GIVEN
        Student jackTorrance = new ComputerScienceStudent("1", "Jack Torrance", 37, false,"Java");
        Student [] expectedStudents = {jackTorrance};

        StudentRepository studentRepository = new StudentRepository(expectedStudents);
        StudentService studentService = new StudentService(studentRepository);

        // WHEN
        Student randomStudent = studentService.randomStudent();

        // THEN
        assertNotNull(randomStudent);
    }

    @Test
    void randomStudent_shouldReturnNoStudentObject_whenNoStudentsAreInStudentsArray() {
        // GIVEN
        Student [] expectedStudents = {};

        StudentRepository studentRepository = new StudentRepository(expectedStudents);
        StudentService studentService = new StudentService(studentRepository);

        // WHEN + THEN
        assertThrows(NoSuchElementException.class, () -> {
            studentService.randomStudent();
        });
    }
}