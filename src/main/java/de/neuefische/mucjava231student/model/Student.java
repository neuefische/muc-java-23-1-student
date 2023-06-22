package de.neuefische.mucjava231student.model;

public record Student(
        String id,
        String name,
        int age,
        boolean isActiveStudent
) {

    public Student withId(Student previousStudent, String newId) {
        return new Student(newId, previousStudent.name(), previousStudent.age(), previousStudent.isActiveStudent());
    }
}
