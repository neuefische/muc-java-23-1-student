package de.neuefische.mucjava231student.exception;

public class StudentNotFoundException extends RuntimeException{
        public StudentNotFoundException(String studentId) {
            super("Student with id " + studentId + " not found");
        }
}
