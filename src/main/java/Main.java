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




        int a = 1;
        int b = 1;

//        a == b;

        String s1 = "Hi";
        String s2 = "Hi";

        s1.equals(s2);

        Student student = new Student("Rami");
        System.out.println(student.hashCode());
    }
}
