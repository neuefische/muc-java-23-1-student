package de.neuefische.mucjava231student.repository;

import de.neuefische.mucjava231student.exception.StudentNotFoundException;
import de.neuefische.mucjava231student.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {



}
