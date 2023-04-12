import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;

public class ContactController implements ActionListener{
	ContactView view = new ContactView();
	//		ContactModel model = new ContactModel();
	DBConnect dbConnect = new DBConnect();
	public ContactController() throws SQLException {

		view.jBtnSave.addActionListener(this);	


	}
	public void viewContacts() throws SQLException{
		view.model.setRowCount(0);
		
		ResultSet rsv = dbConnect.showContacts();
		while (rsv.next()) {
			int id = rsv.getInt("id");
			String name = rsv.getString("name");
			String email = rsv.getString("email");
			long phone = rsv.getLong("phone");
			String gender = rsv.getString("gender");
			String course = rsv.getString("course");
			String language = rsv.getString("language");
			//          System.out.print(name);
			Object[] row = {id, name, email, phone, gender, course, language};
			view.model.addRow(row);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
			if (e.getSource() == view.jBtnSave) {
				String name = view.jTxfName.getText().toString();
				String email = view.jTxfName.getText().toString();
				int phone = Integer.parseInt(view.jTxPhone.getValue().toString());
				String gender="None";
				if (view.male.isSelected()) {
					// Male radio button is selected
					gender = "Male";
				} else if (view.female.isSelected()) {
					// Female radio button is selected
					gender = "Female";
				}
				String selectedCourse = (String) view.courseComboBox.getSelectedItem();
				ArrayList<String> list = new ArrayList<>();

				if (view.jChkJava.isSelected()) {
					list.add("Java");
				}

				if (view.jChkPython.isSelected()) {
					list.add("Python");
				}

				if (view.jChkC.isSelected()) {
					list.add("C++");
				}

				if (view.jChkPHP.isSelected()) {
					list.add("PHP");
				}

				String selectedLanguages = String.join(",", list);
				try {
					dbConnect.savetodatabase(name, email, phone, gender, selectedCourse, selectedLanguages);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				try {
					viewContacts();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			} else {
				JOptionPane.showMessageDialog(null, "NOT SUPORTED");
			}

		}

		public static void main(String[] args) throws SQLException {
			new ContactController();

		}


}
