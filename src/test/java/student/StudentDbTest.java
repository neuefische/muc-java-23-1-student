package student;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StudentDbTest {

    @Test
    void getAllStudents_shouldReturnOneStudent_whenOneStudentIsInStudentsArray() {
        // GIVEN
        Student jackTorrance = new ComputerScienceStudent("1", "Jack Torrance", 37, false,"Java");
        Student [] expectedStudents = {jackTorrance};

        StudentDb studentDb = new StudentDb(expectedStudents);

        // WHEN
        Student [] actualStudents = studentDb.getAllStudents();

        // THEN
        assertArrayEquals(expectedStudents, actualStudents);
    }

    @Test
    void getAllStudents_shouldReturnTwoStudents_whenTwoStudentsAreInStudentsArray() {
        // GIVEN
        Student jackTorrance = new ComputerScienceStudent("1", "Jack Torrance", 37, false,"Java");
        Student wendyTorrance = new ComputerScienceStudent("2", "Wendy Torrance", 35, false,"JavaFX");
        Student [] expectedStudents = {jackTorrance, wendyTorrance};

        StudentDb studentDb = new StudentDb(expectedStudents);

        // WHEN
        Student [] actualStudents = studentDb.getAllStudents();

        // THEN
        assertArrayEquals(expectedStudents, actualStudents);
    }

    @Test
    void studentDbToString_shouldReturnExpectedString_whenTwoStudentsAreInStudentsArray() {
        // GIVEN
        Student jackTorrance = new ComputerScienceStudent("1", "Jack Torrance", 37, false,"Java");
        Student wendyTorrance = new ComputerScienceStudent("2", "Wendy Torrance", 35, false,"Mongo");
        Student [] expectedStudents = {jackTorrance, wendyTorrance};

        StudentDb studentDb = new StudentDb(expectedStudents);

        String expectedStudentsString = "StudentDb{students=[ComputerScienceStudent{major='Java'}, ComputerScienceStudent{major='Mongo'}]}";
        System.out.println(jackTorrance);
        // WHEN
        String actualStudentDbString = studentDb.toString();

        // THEN
        assertEquals(expectedStudentsString, actualStudentDbString);
    }

    @Test
    void randomStudent_shouldReturnAValidStudentsObject_whenTwoStudentsAreInStudentsArray() {
        // GIVEN
        Student jackTorrance = new ComputerScienceStudent("1", "Jack Torrance", 37, false,"Java");
        Student wendyTorrance = new ComputerScienceStudent("2", "Wendy Torrance", 35, false,"Mongo");

        Student [] expectedStudents = {jackTorrance, wendyTorrance};

        StudentDb studentDb = new StudentDb(expectedStudents);

        // WHEN
        Student randomStudent = studentDb.randomStudent();

        // THEN
        assertNotNull(randomStudent);
    }

    @Test
    void randomStudent_shouldReturnAValidStudentObject_whenOneStudentIsInStudentsArray() {
        // GIVEN
        Student jackTorrance = new ComputerScienceStudent("1", "Jack Torrance", 37, false,"Java");
        Student [] expectedStudents = {jackTorrance};

        StudentDb studentDb = new StudentDb(expectedStudents);

        // WHEN
        Student randomStudent = studentDb.randomStudent();

        // THEN
        assertNotNull(randomStudent);
    }

    @Test
    void randomStudent_shouldReturnNoStudentObject_whenNoStudentsAreInStudentsArray() {
        // GIVEN
        Student [] expectedStudents = {};

        StudentDb studentDb = new StudentDb(expectedStudents);

        // WHEN + THEN
        assertThrows(NoSuchElementException.class, () -> {
            studentDb.randomStudent();
        });
    }
}