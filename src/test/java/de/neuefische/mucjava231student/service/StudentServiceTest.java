package de.neuefische.mucjava231student.service;

import de.neuefische.mucjava231student.exception.StudentNotFoundException;
import de.neuefische.mucjava231student.model.Student;
import de.neuefische.mucjava231student.repository.StudentRepository;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    private final StudentRepository studentRepository = mock(StudentRepository.class);
    private final StudentService studentService = new StudentService(studentRepository);

    @Test
    void getAllStudents_whenNoStudentsAvailable_thenReturnEmptyList() {
        // GIVEN
        List<Student> expected = List.of();
        // WHEN
        when(studentRepository.findAll()).thenReturn(expected);
        List<Student> actual = studentService.getAllStudents();
        // THEN
        assertEquals(expected, actual);
        verify(studentRepository).findAll();
    }

    @Test
    void getAllStudents_whenStudentsAvailable_thenReturnListOfStudents() {
        // GIVEN
        List<Student> expected = List.of(
                new Student("1", "Hans", 28, true),
                new Student("2", "Peter", 30, true),
                new Student("3", "Klaus", 25, true)
        );
        // WHEN
        when(studentRepository.findAll()).thenReturn(expected);
        List<Student> actual = studentService.getAllStudents();
        // THEN
        assertEquals(expected, actual);
        verify(studentRepository).findAll();
    }

    @Test
    void getStudentById_whenStudentWithGivenIdExist_thenReturnStudentById() {
        // GIVEN
        Optional<Student> expected = Optional.of(new Student("1", "Hans", 28, true));
        // WHEN
        when(studentRepository.findById("1")).thenReturn(expected);
        Optional<Student> actual = studentService.getStudentById("1");
        // THEN
        assertEquals(expected, actual);
        verify(studentRepository).findById("1");
    }

    @Test
    void getStudentById_whenStudentWithGivenIdNotExist_thenThrowStudentNotFoundException() {
        // GIVEN
        String id = "1";
        // WHEN
        when(studentRepository.findById(id)).thenThrow(new StudentNotFoundException(id));
        // THEN
        assertThrows(StudentNotFoundException.class, () -> studentService.getStudentById(id));
        verify(studentRepository).findById(id);
    }

    @Test
    void addStudent_whenCalled_thenSaveAndReturnStudent() {
        // GIVEN
        Student expected = new Student("1", "Hans", 28, true);
        // WHEN
        when(studentRepository.save(expected)).thenReturn(expected);
        Student actual = studentService.addStudent(expected);
        // THEN
        assertEquals(expected, actual);
        verify(studentRepository).save(expected);
    }

    @Test
    void deleteStudent_whenStudentWithGivenIdExist_thenDeleteStudentAndNoReturn() {
        // GIVEN
        String id = "1";
        Student studentToDelete = new Student(id, "Hans", 28, true);
        studentRepository.save(studentToDelete);
        // WHEN
        when(studentRepository.findById(id)).thenReturn(Optional.of(studentToDelete));
        doNothing().when(studentRepository).deleteById(id);
        studentService.deleteStudent(id);
        // THEN
        verify(studentRepository).deleteById(id);
    }

    @Test
    void deleteStudent_whenStudentWithGivenIdNotExist_thenThrowStudentNotFoundException() {
        // GIVEN
        String id = "1";
        // WHEN
        doThrow(StudentNotFoundException.class).when(studentRepository).deleteById(id);
        // THEN
        assertThrows(StudentNotFoundException.class, () -> studentService.deleteStudent(id));
        verify(studentRepository).deleteById(id);
    }


    @Test
    void updateStudent_whenStudentExist_thenUpdateAndReturnStudent() {
        // GIVEN
        String id = "1";
        Student expected = new Student("1", "Hans", 28, false);
        // WHEN
        when(studentRepository.findById(id)).thenReturn(Optional.of(expected));
        when(studentRepository.save(expected)).thenReturn(expected);
        Student actual = studentService.updateStudent(id, expected);
        // THEN
        assertEquals(expected, actual);
        verify(studentRepository).save(expected);
    }
}