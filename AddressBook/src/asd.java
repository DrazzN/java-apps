private void saveStudent() {
	        // get the data from the UI components
	        String name = nameField.getText();
	        String email = emailField.getText();
	        String phone = phoneField.getText();
	        String gender = maleRadioButton.isSelected() ? "Male" : "Female";
		    String course = (String)courseComboBox.getSelectedItem();
		    String language = (String)languageComboBox.getSelectedItem();
		        
		        // create a new Student object
		    Student student = new Student();
		    student.setName(name);
		    student.setEmail(email);
		    student.setPhone(phone);
		    student.setGender(gender);
		    student.setCourse(course);
		    student.setLanguage(language);
		    saveToDatabase(student);
		    nameField.setText("");
		    emailField.setText("");
		    phoneField.setText("");
		    maleRadioButton.setSelected(true);
		    femaleRadioButton.setSelected(false);
		    courseComboBox.setSelectedIndex(0);
		    languageComboBox.setSelectedIndex(0);
		    }

	    private void saveToDatabase() {
	        String url = "jdbc:mysql://localhost:3306/mydatabase";
	        String username = "root";
	        String password = "";
	        try (Connection conn = DriverManager.getConnection(url, username, password)) {
	            String sql = "INSERT INTO students (name, email, phone, gender, course, language) VALUES (?, ?, ?, ?, ?, ?)";
	            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	                stmt.setString(1, student.getName());
	                stmt.setString(2, student.getEmail());
	                stmt.setString(3, student.getPhone());
	                stmt.setString(4, student.getGender());
	                stmt.setString(5, student.getCourse());
	                stmt.setString(6, student.getLanguage());
	                stmt.executeUpdate();
	                JOptionPane.showMessageDialog(this, "Student saved successfully.");
	            }
	        } catch (SQLException ex) {
	            JOptionPane.showMessageDialog(this, "Error saving student: " + ex.getMessage());
	        }
	    }

	    public static void main(String[] args) {
	        new StudentForm();
	    }
	
	