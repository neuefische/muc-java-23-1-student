package de.neuefische.mucjava231student.service;

import de.neuefische.mucjava231student.model.Student;
import de.neuefische.mucjava231student.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents(){
        return studentRepository.getAllStudents();
    }

    public Student getStudentById(String id){
        return studentRepository.getStudentById(id);
    }

    public Student addStudent(Student student){
        return studentRepository.addStudent(student);
    }

    public void deleteStudent(String id){
        studentRepository.deleteStudent(id);
    }

    public Student updateStudent(Student student){
        return studentRepository.updateStudent(student);
    }
}
