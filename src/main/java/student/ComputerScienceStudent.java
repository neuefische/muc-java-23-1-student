package student;

import java.util.Objects;

public class ComputerScienceStudent extends Student{



    String major;


    public ComputerScienceStudent(){}

    public ComputerScienceStudent(String id, String name, int age, boolean isActiveStudent, String major) {
        super(id, name, age, isActiveStudent);
        this.major = major;
    }

    public ComputerScienceStudent(String name) {
        super.setName(name);
    }


    // von Citizen Interface
    public void payTaxes(double amount) {
        // Implementation of the payTaxes method
        System.out.println("Student is paying taxes: $" + amount);
    }

    public String getID() {
        return super.getId();
    }


    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ComputerScienceStudent that = (ComputerScienceStudent) o;
        return Objects.equals(major, that.major);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), major);
    }

    @Override
    public String toString() {
        return "ComputerScienceStudent{" +
                "major='" + major + '\'' +
                '}';
    }



}
