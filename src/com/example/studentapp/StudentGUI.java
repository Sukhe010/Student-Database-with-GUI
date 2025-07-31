/*

package com.example.studentapp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Form");
        frame.setSize(400, 300);
        frame.setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 30, 60, 25);
        frame.add(nameLabel);
        JTextField nameField = new JTextField();
        nameField.setBounds(120, 30, 150, 25);
        frame.add(nameField);

        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setBounds(50, 70, 60, 25);
        frame.add(ageLabel);
        JTextField ageField = new JTextField();
        ageField.setBounds(120, 70, 150, 25);
        frame.add(ageField);

        JLabel gradeLabel = new JLabel("Grade:");
        gradeLabel.setBounds(50, 110, 60, 25);
        frame.add(gradeLabel);
        JTextField gradeField = new JTextField();
        gradeField.setBounds(120, 110, 150, 25);
        frame.add(gradeField);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(50, 150, 60, 25);
        frame.add(idLabel);
        JTextField idField = new JTextField();
        idField.setBounds(120, 150, 150, 25);
        frame.add(idField);

        JButton addBtn = new JButton("Add");
        addBtn.setBounds(150, 200, 100, 30);
        frame.add(addBtn);

        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Student s = new Student(
                        Integer.parseInt(idField.getText()),
                        nameField.getText(),
                        Integer.parseInt(ageField.getText()),
                        gradeField.getText()
                    );
                    StudentDAO.addStudent(s);
                    JOptionPane.showMessageDialog(frame, "Student added!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
                }
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
*/

package com.example.studentapp;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.List;

public class StudentGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Management");
        frame.setSize(600, 500);
        frame.setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 30, 60, 25);
        JTextField nameField = new JTextField();
        nameField.setBounds(120, 30, 150, 25);

        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setBounds(50, 70, 60, 25);
        JTextField ageField = new JTextField();
        ageField.setBounds(120, 70, 150, 25);

        JLabel gradeLabel = new JLabel("Grade:");
        gradeLabel.setBounds(50, 110, 60, 25);
        JTextField gradeField = new JTextField();
        gradeField.setBounds(120, 110, 150, 25);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(50, 150, 60, 25);
        JTextField idField = new JTextField();
        idField.setBounds(120, 150, 150, 25);

        JButton addBtn = new JButton("Add");
        addBtn.setBounds(300, 30, 100, 30);
        JButton updateBtn = new JButton("Update");
        updateBtn.setBounds(300, 70, 100, 30);
        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(300, 110, 100, 30);
        JButton viewBtn = new JButton("View All");
        viewBtn.setBounds(300, 150, 100, 30);

        JTable table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 200, 500, 200);

        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(ageLabel);
        frame.add(ageField);
        frame.add(gradeLabel);
        frame.add(gradeField);
        frame.add(idLabel);
        frame.add(idField);
        frame.add(addBtn);
        frame.add(updateBtn);
        frame.add(deleteBtn);
        frame.add(viewBtn);
        frame.add(scrollPane);

        addBtn.addActionListener(e -> {
            try {
                Student s = new Student(
                        Integer.parseInt(idField.getText()),
                        nameField.getText(),
                        Integer.parseInt(ageField.getText()),
                        gradeField.getText()
                );
                StudentDAO.addStudent(s);
                JOptionPane.showMessageDialog(frame, "Student added!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
            }
        });

        updateBtn.addActionListener(e -> {
            try {
                Student s = new Student(
                        Integer.parseInt(idField.getText()),
                        nameField.getText(),
                        Integer.parseInt(ageField.getText()),
                        gradeField.getText()
                );
                StudentDAO.updateStudent(s);
                JOptionPane.showMessageDialog(frame, "Student updated!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
            }
        });

        deleteBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                StudentDAO.deleteStudent(id);
                JOptionPane.showMessageDialog(frame, "Student deleted!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
            }
        });

        viewBtn.addActionListener(e -> {
            try {
                List<Student> students = StudentDAO.getAllStudents();
                String[] columns = {"ID", "Name", "Age", "Grade"};
                DefaultTableModel model = new DefaultTableModel(columns, 0);
                for (Student s : students) {
                    Object[] row = {s.getId(), s.getName(), s.getAge(), s.getGrade()};
                    model.addRow(row);
                }
                table.setModel(model);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
