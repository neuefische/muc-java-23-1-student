package de.neuefische.mucjava231student.model;

import java.util.Objects;

public class ComputerScienceStudent extends Student{
    private String favouriteProgrammingLanguage;

    public ComputerScienceStudent(){}

    public ComputerScienceStudent(String id, String name, int age, boolean isActiveStudent, String major) {
        super(id, name, age, isActiveStudent);
        this.favouriteProgrammingLanguage = major;
    }

    public ComputerScienceStudent(String name) {
        super.setName(name);
    }

    public String getFavouriteProgrammingLanguage() {
        return favouriteProgrammingLanguage;
    }
    public void setFavouriteProgrammingLanguage(String favouriteProgrammingLanguage) {
        this.favouriteProgrammingLanguage = favouriteProgrammingLanguage;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ComputerScienceStudent that = (ComputerScienceStudent) o;
        return Objects.equals(favouriteProgrammingLanguage, that.favouriteProgrammingLanguage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), favouriteProgrammingLanguage);
    }

    @Override
    public String toString() {
        return "ComputerScienceStudent{" +
                "major='" + favouriteProgrammingLanguage + '\'' +
                '}';
    }
}
