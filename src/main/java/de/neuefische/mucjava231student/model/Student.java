package de.neuefische.mucjava231student.model;

public record Student(
        String id,
        String name,
        int age,
        boolean isActiveStudent,
        String teacherId
) {

    public Student withId(Student previousStudent, String newId) {
        return new Student(newId, previousStudent.name(), previousStudent.age(), previousStudent.isActiveStudent());
    }

    public Student(String id, String name, int age, boolean isActiveStudent) {
        this(id, name, age, isActiveStudent, null);
    }
}
