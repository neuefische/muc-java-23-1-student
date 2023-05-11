import student.Student;

public class Main {
    public static void main(String[] args) {

        // Variablennamen = Im camelCase schreiben
        // d.h. anfangs klein geschrieben

        // Neues Studenten-Objekt erzeugt/ gemacht
        // <Klassentyp> <variablenName> = new <Klassentyp>();
        Student ramiMalek = new Student();

        // Eigenschaften vom Studenten-Objekt "ramiMalek" definiert
        ramiMalek.setActiveStudent(true);
        ramiMalek.setAge(41);
        ramiMalek.setName("Rami Malek");

        System.out.println(ramiMalek.printStudentName());
    }
}
