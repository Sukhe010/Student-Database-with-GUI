package com.example.studentapp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // Adds a new student record to the database
    public static void addStudent(Student student) throws SQLException {
        Connection con = DBConnection.getConnection(); // Establish connection to DB
        String query = "INSERT INTO students (id, name, age, grade) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query); // Prepare query with placeholders
        ps.setInt(1, student.getId());          // Set ID in the query
        ps.setString(2, student.getName());     // Set name in the query
        ps.setInt(3, student.getAge());         // Set age in the query
        ps.setString(4, student.getGrade());    // Set grade in the query
        ps.executeUpdate();                     // Execute the insert operation
        ps.close();                             // Close the prepared statement
        con.close();                            // Close the database connection
    }

    // Retrieves all students from the database and returns them as a list
    public static List<Student> getAllStudents() throws SQLException {
        Connection con = DBConnection.getConnection(); // Establish DB connection
        String query = "SELECT * FROM students";       // SQL query to fetch all records
        Statement st = con.createStatement();          // Create statement object
        ResultSet rs = st.executeQuery(query);         // Execute query and store results
        List<Student> list = new ArrayList<>();        // List to store retrieved students

        // Iterate through the result set and create Student objects
        while (rs.next()) {
            Student s = new Student(
                    rs.getInt("id"),              // Get ID from result set
                    rs.getString("name"),         // Get name
                    rs.getInt("age"),             // Get age
                    rs.getString("grade")         // Get grade
            );
            list.add(s); // Add each student to the list
        }

        rs.close();   // Close result set
        st.close();   // Close statement
        con.close();  // Close database connection

        return list;  // Return the list of students
    }

    // Updates an existing student's data in the database by ID
    public static void updateStudent(Student student) throws SQLException {
        Connection con = DBConnection.getConnection(); // Connect to DB
        String query = "UPDATE students SET name=?, age=?, grade=? WHERE id=?";
        PreparedStatement ps = con.prepareStatement(query); // Prepare query

        ps.setString(1, student.getName());   // Set new name
        ps.setInt(2, student.getAge());       // Set new age
        ps.setString(3, student.getGrade());  // Set new grade
        ps.setInt(4, student.getId());        // Set ID for WHERE clause
        ps.executeUpdate();                   // Execute the update query

        ps.close();   // Close statement
        con.close();  // Close connection
    }

    // Deletes a student from the database using their ID
    public static void deleteStudent(int id) throws SQLException {
        Connection con = DBConnection.getConnection(); // DB connection
        String query = "DELETE FROM students WHERE id=?"; // SQL delete query
        PreparedStatement ps = con.prepareStatement(query); // Prepare statement
        ps.setInt(1, id);    // Set ID to delete
        ps.executeUpdate();  // Execute the delete query
        ps.close();          // Close statement
        con.close();         // Close connection
    }
}
