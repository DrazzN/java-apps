import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.text.View;

public class ContactModel {

	ContactView view = new ContactView();
	
		public ContactModel() {
		        // constructor with no arguments
		    }
		void saveTodatabase() {
			String sql = "INSERT INTO students (name, email, phone, gender, course, language) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, view.nameField.getName());
                stmt.setString(2, view.emailField.getEmail());
                stmt.setString(3, view.phoneField.getPhone());
                stmt.setString(4, view.contactmodel.getGender());
                stmt.setString(5, view.contactmodel.getCourse());
                stmt.setString(6, view.lan.getLanguage());
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Student saved successfully.");
            } catch (SQLException ex) {
            	JOptionPane.showMessageDialog(null, "Error saving student: " + ex.getMessage());
            }
		}



	}

