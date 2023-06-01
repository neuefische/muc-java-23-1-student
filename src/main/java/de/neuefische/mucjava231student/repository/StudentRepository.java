package de.neuefische.mucjava231student.repository;

import de.neuefische.mucjava231student.exception.StudentNotFoundException;
import de.neuefische.mucjava231student.model.Student;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository {

    private final Map<String, Student> students = new LinkedHashMap<>();

    public List<Student> getAllStudents(){
        return List.copyOf(students.values());
    }

    public Student getStudentById(String id) throws StudentNotFoundException {
        Student studentToFind =  students.get(id);
        if(studentToFind == null){
            throw new StudentNotFoundException(id);
        }
        return studentToFind;
    }

    public Student addStudent(Student student){
        return students.put(student.id(), student);
    }

    public void deleteStudent(String id){
        Student studentToDelete = getStudentById(id);
        students.remove(studentToDelete.id());
    }

    public Student updateStudent(Student student){
        return students.replace(student.id(), student);
    }

}
