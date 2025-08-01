package com.example.studentapp; // Declares the package the class belongs to

// Student class represents a student entity with id, name, age, and grade
public class Student {

    // Private instance variables (encapsulation principle)
    private int id;         // Unique identifier for the student
    private String name;    // Name of the student
    private int age;        // Age of the student
    private String grade;   // Grade/class of the student

    // Constructor: initializes a new Student object with given values
    public Student(int id, String name, int age, String grade) {
        this.id = id;           // Sets the student's ID
        this.name = name;       // Sets the student's name
        this.age = age;         // Sets the student's age
        this.grade = grade;     // Sets the student's grade
    }

    // Getter method for 'id'
    public int getId() {
        return id;
    }

    // Getter method for 'name'
    public String getName() {
        return name;
    }

    // Getter method for 'age'
    public int getAge() {
        return age;
    }

    // Getter method for 'grade'
    public String getGrade() {
        return grade;
    }

    // Setter method for 'id'
    public void setId(int id) {
        this.id = id;
    }

    // Setter method for 'name'
    public void setName(String name) {
        this.name = name;
    }

    // Setter method for 'age'
    public void setAge(int age) {
        this.age = age;
    }

    // Setter method for 'grade'
    public void setGrade(String grade) {
        this.grade = grade;
    }
}
