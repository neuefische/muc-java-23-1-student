package student;

import org.junit.jupiter.api.Test;

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
}