package com.example.studentapp;

// Import necessary Swing and utility classes
import javax.swing.*;                      // For GUI components like JFrame, JButton, JLabel, etc.
import javax.swing.table.DefaultTableModel; // For displaying table of student data
import java.util.List;                     // For working with lists of Student objects

public class StudentGUI {
    public static void main(String[] args) {
        // Create the main window
        JFrame frame = new JFrame("Student Management"); // Title of the window
        frame.setSize(600, 500);                         // Set the size of the window
        frame.setLayout(null);                           // Use absolute positioning (no layout manager)

        // --- Create and place form labels and input fields ---

        JLabel nameLabel = new JLabel("Name:");          // Label for Name
        nameLabel.setBounds(50, 30, 60, 25);              // Position of the Name label

        JTextField nameField = new JTextField();          // Input field for Name
        nameField.setBounds(120, 30, 150, 25);             // Position of Name field

        JLabel ageLabel = new JLabel("Age:");             // Label for Age
        ageLabel.setBounds(50, 70, 60, 25);                // Position of Age label

        JTextField ageField = new JTextField();           // Input field for Age
        ageField.setBounds(120, 70, 150, 25);              // Position of Age field

        JLabel gradeLabel = new JLabel("Grade:");         // Label for Grade
        gradeLabel.setBounds(50, 110, 60, 25);             // Position of Grade label

        JTextField gradeField = new JTextField();         // Input field for Grade
        gradeField.setBounds(120, 110, 150, 25);           // Position of Grade field

        JLabel idLabel = new JLabel("ID:");               // Label for ID
        idLabel.setBounds(50, 150, 60, 25);                // Position of ID label

        JTextField idField = new JTextField();            // Input field for ID
        idField.setBounds(120, 150, 150, 25);              // Position of ID field

        // --- Create buttons for CRUD operations ---

        JButton addBtn = new JButton("Add");              // Button to add student
        addBtn.setBounds(300, 30, 100, 30);                // Position of Add button

        JButton updateBtn = new JButton("Update");        // Button to update student
        updateBtn.setBounds(300, 70, 100, 30);             // Position of Update button

        JButton deleteBtn = new JButton("Delete");        // Button to delete student
        deleteBtn.setBounds(300, 110, 100, 30);            // Position of Delete button

        JButton viewBtn = new JButton("View All");        // Button to view all students
        viewBtn.setBounds(300, 150, 100, 30);              // Position of View All button

        // --- Table and scroll pane for displaying student data ---
        JTable table = new JTable();                      // Table to show students
        JScrollPane scrollPane = new JScrollPane(table);  // Scroll pane wraps the table
        scrollPane.setBounds(50, 200, 500, 200);           // Position and size of the table area

        // --- Add all components to the frame ---

        frame.add(nameLabel); frame.add(nameField);       // Add name label and field
        frame.add(ageLabel); frame.add(ageField);         // Add age label and field
        frame.add(gradeLabel); frame.add(gradeField);     // Add grade label and field
        frame.add(idLabel); frame.add(idField);           // Add ID label and field

        frame.add(addBtn);                                // Add Add button
        frame.add(updateBtn);                             // Add Update button
        frame.add(deleteBtn);                             // Add Delete button
        frame.add(viewBtn);                               // Add View All button
        frame.add(scrollPane);                            // Add table scroll pane

        // --- Define the button actions using lambda expressions ---

        // Add Button: Adds a new student
        addBtn.addActionListener(e -> {
            try {
                // Create a Student object using data from text fields
                Student s = new Student(
                        Integer.parseInt(idField.getText()),  // Parse ID to int
                        nameField.getText(),                  // Get name text
                        Integer.parseInt(ageField.getText()), // Parse age to int
                        gradeField.getText()                  // Get grade text
                );
                // Add student to database
                StudentDAO.addStudent(s);
                // Show success dialog
                JOptionPane.showMessageDialog(frame, "Student added!");
            } catch (Exception ex) {
                // Show error message if something goes wrong
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
            }
        });

        // Update Button: Updates existing student data
        updateBtn.addActionListener(e -> {
            try {
                // Create updated Student object from text fields
                Student s = new Student(
                        Integer.parseInt(idField.getText()),
                        nameField.getText(),
                        Integer.parseInt(ageField.getText()),
                        gradeField.getText()
                );
                // Call DAO to update record
                StudentDAO.updateStudent(s);
                JOptionPane.showMessageDialog(frame, "Student updated!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
            }
        });

        // Delete Button: Deletes a student by ID
        deleteBtn.addActionListener(e -> {
            try {
                // Get ID from input field
                int id = Integer.parseInt(idField.getText());
                // Call DAO to delete student
                StudentDAO.deleteStudent(id);
                JOptionPane.showMessageDialog(frame, "Student deleted!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
            }
        });

        // View Button: Loads all students and displays in table
        viewBtn.addActionListener(e -> {
            try {
                // Get all students from DB
                List<Student> students = StudentDAO.getAllStudents();
                // Define column names for the table
                String[] columns = {"ID", "Name", "Age", "Grade"};
                // Create a table model
                DefaultTableModel model = new DefaultTableModel(columns, 0);
                // Add each student to the table model
                for (Student s : students) {
                    Object[] row = {s.getId(), s.getName(), s.getAge(), s.getGrade()};
                    model.addRow(row);
                }
                // Set model to table
                table.setModel(model);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
            }
        });

        // --- Final frame setup ---
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit on close
        frame.setVisible(true);                               // Show the window
    }
}
