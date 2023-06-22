package de.neuefische.mucjava231student.service;

import de.neuefische.mucjava231student.exception.StudentNotFoundException;
import de.neuefische.mucjava231student.model.Student;
import de.neuefische.mucjava231student.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(String id){
        return studentRepository.findById(id);
    }

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public Student updateStudent(String id, Student studentUpdate){
        studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
        Student updatedStudent = studentUpdate.withId(studentUpdate, id);

        return studentRepository.save(updatedStudent);
    }

    public void deleteStudent(String id){
        studentRepository.deleteById(id);
    }
}
