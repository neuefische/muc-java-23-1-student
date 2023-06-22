package de.neuefische.mucjava231student.controller;

import de.neuefische.mucjava231student.model.Student;
import de.neuefische.mucjava231student.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable String id){
        return studentService.getStudentById(id);
    }

    @GetMapping("/teacher/{id}")
    public Optional<Student> getStudentByTeacherId(@PathVariable String id){
        return studentService.getStudentByTeacherId(id);
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable String id, @RequestBody Student student){
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable String id){
        studentService.deleteStudent(id);
    }
}
