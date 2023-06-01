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
        if(!students.containsKey(id)){
            throw new StudentNotFoundException(id);
        }
        return students.get(id);
    }

    public Student addStudent(Student student){
        students.put(student.id(), student);
        return getStudentById(student.id());
    }

    public void deleteStudent(String id){
        if (!students.containsKey(id)) {
            throw new StudentNotFoundException(id);
        }
        students.remove(id);
    }

    public Student updateStudent(String id, Student student){
        if(!students.containsKey(id)){
            throw new StudentNotFoundException(id);
        }
        students.remove(id);
        students.put(id, student);
        return getStudentById(id);
    }

}
