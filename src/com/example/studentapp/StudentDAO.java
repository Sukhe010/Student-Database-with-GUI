/*

package com.example.studentapp;

import java.sql.*;

public class StudentDAO {

    public static void addStudent(Student student) throws SQLException {
        Connection con = DBConnection.getConnection();
        String query = "INSERT INTO students (id, name, age, grade) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, student.getId());
        ps.setString(2, student.getName());
        ps.setInt(3, student.getAge());
        ps.setString(4, student.getGrade());
        ps.executeUpdate();
        ps.close();
        con.close();
    }
}
*/

package com.example.studentapp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public static void addStudent(Student student) throws SQLException {
        Connection con = DBConnection.getConnection();
        String query = "INSERT INTO students (id, name, age, grade) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, student.getId());
        ps.setString(2, student.getName());
        ps.setInt(3, student.getAge());
        ps.setString(4, student.getGrade());
        ps.executeUpdate();
        ps.close();
        con.close();
    }

    public static List<Student> getAllStudents() throws SQLException {
        Connection con = DBConnection.getConnection();
        String query = "SELECT * FROM students";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        List<Student> list = new ArrayList<>();
        while (rs.next()) {
            Student s = new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("grade")
            );
            list.add(s);
        }
        rs.close();
        st.close();
        con.close();
        return list;
    }

    public static void updateStudent(Student student) throws SQLException {
        Connection con = DBConnection.getConnection();
        String query = "UPDATE students SET name=?, age=?, grade=? WHERE id=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, student.getName());
        ps.setInt(2, student.getAge());
        ps.setString(3, student.getGrade());
        ps.setInt(4, student.getId());
        ps.executeUpdate();
        ps.close();
        con.close();
    }

    public static void deleteStudent(int id) throws SQLException {
        Connection con = DBConnection.getConnection();
        String query = "DELETE FROM students WHERE id=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        con.close();
    }
}