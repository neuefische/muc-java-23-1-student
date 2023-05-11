package student;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StudentDbTest {

    @Test
    void getAllStudents_shouldReturnOneStudent_whenOneStudentIsInStudentsArray() {
        // GIVEN
        Student jackTorrance = new Student("1", "Jack Torrance", 37, false);
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
        Student jackTorrance = new Student("1", "Jack Torrance", 37, false);
        Student wendyTorrance = new Student("2", "Wendy Torrance", 35, false);
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
        Student jackTorrance = new Student("1", "Jack Torrance", 37, false);
        Student wendyTorrance = new Student("2", "Wendy Torrance", 35, false);
        Student [] expectedStudents = {jackTorrance, wendyTorrance};

        StudentDb studentDb = new StudentDb(expectedStudents);

        String expectedStudentsString = "StudentDb{students=[Student{id='1', name='Jack Torrance', age=37, isActiveStudent=false}, Student{id='2', name='Wendy Torrance', age=35, isActiveStudent=false}]}";

        // WHEN
        String actualStudentDbString = studentDb.toString();

        // THEN
        assertEquals(expectedStudentsString, actualStudentDbString);
    }

    @Test
    void randomStudent_shouldReturnAValidStudentsObject_whenTwoStudentsAreInStudentsArray() {
        // GIVEN
        Student jackTorrance = new Student("1", "Jack Torrance", 37, false);
        Student wendyTorrance = new Student("2", "Wendy Torrance", 35, false);
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
        Student jackTorrance = new Student("1", "Jack Torrance", 37, false);
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