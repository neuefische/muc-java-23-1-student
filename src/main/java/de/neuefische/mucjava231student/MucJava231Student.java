package de.neuefische.mucjava231student;

import de.neuefische.mucjava231student.service.NewsProductionService;
import de.neuefische.mucjava231student.service.StudentService;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MucJava231Student {

    private NewsProductionService newsProductionService;

    private StudentService studentService;

    public MucJava231Student(NewsProductionService newsProductionService, StudentService studentService) {
        this.newsProductionService = newsProductionService;
        this.studentService = studentService;
    }

    @PostConstruct
    public void init() {
        newsProductionService.addSubscriber(studentService);
    }

    public static void main(String[] args) {
        SpringApplication.run(MucJava231Student.class, args);
    }
}