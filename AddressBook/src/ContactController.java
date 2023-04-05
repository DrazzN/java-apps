import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.text.View;

public class ContactController implements ActionListener {
	ContactView view = new ContactView();
	ContactModel model = new ContactModel();
	public ContactController() {
		view.saveButton.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Event Source :" + e.getSource());
		System.out.println("Event ActionCommand :" + e.getActionCommand());
		
		String name = view.nameField.getText();
        String email = view.emailField.getText();
        String phone = view.phoneField.getText();
        String gender = view.maleRadioButton.isSelected() ? "Male" : "Female";
	    String course = (String)view.courseComboBox.getSelectedItem();
	    String language = view.javaCheckBox.getText()+","+view.pythonCheckBox.getText()+","+view.cCheckBox.getText();
	    model.
	}
	public static void main(String[] args) {
		new ContactController();
	}

}
