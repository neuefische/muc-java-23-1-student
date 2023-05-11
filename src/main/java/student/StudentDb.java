package student;

public class StudentDb {

    private Student [] students;

    public StudentDb() {
        // Leeres Array mit 10 verfügbaren Plätzen erstellen
        this.students = new Student[10];
    }

    public StudentDb(Student [] students) {
        // Bestehendes Studenten-Array kopieren
        this.students = students.clone();
    }
}
