package de.neuefische.mucjava231student.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleStudentNotFoundException(StudentNotFoundException exception) {
        Map<String, Object> error = new LinkedHashMap<>();

        error.put("message", exception.getMessage());
        error.put("timestamp", Instant.now());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
