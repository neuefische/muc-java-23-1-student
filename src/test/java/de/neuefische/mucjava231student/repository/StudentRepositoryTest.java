package de.neuefische.mucjava231student.repository;

import de.neuefische.mucjava231student.model.ComputerScienceStudent;
import de.neuefische.mucjava231student.model.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTest {

    @Test
    void getAllStudents_shouldReturnOneStudent_whenOneStudentIsInStudentsArray() {
        // GIVEN
        Student jackTorrance = new ComputerScienceStudent("1", "Jack Torrance", 37, false,"Java");
        Student [] expectedStudents = {jackTorrance};

        StudentRepository studentRepository = new StudentRepository(expectedStudents);

        // WHEN
        Student [] actualStudents = studentRepository.getAllStudents();

        // THEN
        assertArrayEquals(expectedStudents, actualStudents);
    }

    @Test
    void getAllStudents_shouldReturnTwoStudents_whenTwoStudentsAreInStudentsArray() {
        // GIVEN
        Student jackTorrance = new ComputerScienceStudent("1", "Jack Torrance", 37, false,"Java");
        Student wendyTorrance = new ComputerScienceStudent("2", "Wendy Torrance", 35, false,"JavaFX");
        Student [] expectedStudents = {jackTorrance, wendyTorrance};

        StudentRepository studentRepository = new StudentRepository(expectedStudents);

        // WHEN
        Student [] actualStudents = studentRepository.getAllStudents();

        // THEN
        assertArrayEquals(expectedStudents, actualStudents);
    }

    @Test
    void studentDbToString_shouldReturnExpectedString_whenTwoStudentsAreInStudentsArray() {
        // GIVEN
        Student jackTorrance = new ComputerScienceStudent("1", "Jack Torrance", 37, false,"Java");
        Student wendyTorrance = new ComputerScienceStudent("2", "Wendy Torrance", 35, false,"Mongo");
        Student [] expectedStudents = {jackTorrance, wendyTorrance};

        StudentRepository studentRepository = new StudentRepository(expectedStudents);

        String expectedStudentsString = "StudentDb{students=[ComputerScienceStudent{major='Java'}, ComputerScienceStudent{major='Mongo'}]}";
        System.out.println(jackTorrance);
        // WHEN
        String actualStudentDbString = studentRepository.toString();

        // THEN
        assertEquals(expectedStudentsString, actualStudentDbString);
    }


}