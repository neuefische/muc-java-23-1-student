package de.neuefische.mucjava231student.model;

import java.util.Objects;

public class BiologyStudent extends Student{
    private String specialization;
    
    public BiologyStudent() {}
    
    public BiologyStudent(String specialization) {
        this.specialization = specialization;
    }

    public BiologyStudent(String name, String specialization) {
        super(name);
        this.specialization = specialization;
    }

    public BiologyStudent(String id, String name, int age, boolean isActiveStudent, String specialization) {
        super(id, name, age, isActiveStudent);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BiologyStudent that = (BiologyStudent) o;
        return Objects.equals(specialization, that.specialization);
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), specialization);
    }
    @Override
    public String toString() {
        return "BiologyStudent{" +
                "specialization='" + specialization + '\'' +
                '}';
    }
}
