import javax.swing.*;
import java.awt.*;

public class ContactView extends JFrame {
    
    JPanel leftPanel = new JPanel(new GridLayout(8,3));
    
    JLabel nameLabel = new JLabel("Name:");
    JLabel emailLabel = new JLabel("Email:");
    JLabel phoneLabel = new JLabel("Phone:");
    JLabel genderLabel = new JLabel("Gender:");
    JLabel courseLabel = new JLabel("Course:");
    JLabel languageLabel = new JLabel("Language:");
    JTextField nameField = new JTextField();
    JTextField emailField = new JTextField();
    JTextField phoneField = new JTextField();
    GridBagConstraints gbc = new GridBagConstraints();

    
    ButtonGroup bGroup = new ButtonGroup();
    JRadioButton maleRadioButton = new JRadioButton("Male");
    JRadioButton femaleRadioButton = new JRadioButton("Female");
    
    JComboBox<String> courseComboBox = new JComboBox<>(new String[]{"BCA", "BSW", "BA"});
    
    JCheckBox javaCheckBox = new JCheckBox("Java");
    JCheckBox pythonCheckBox = new JCheckBox("Python");
    JCheckBox cCheckBox = new JCheckBox("C");
    
    JButton saveButton = new JButton("Save");
    JButton editButton = new JButton("Edit");
    JButton deleteButton = new JButton("Delete");
    
    JPanel rightPanel = new JPanel();
    
    public ContactView() {
    	setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 300);
		prepareGUI();
		setLocationRelativeTo(null);
		setVisible(true);
    }
    
    void prepareGUI() {
    	
    	leftPanel.add(nameLabel);
        leftPanel.add(nameField);
        leftPanel.add(new JLabel());
        leftPanel.add(emailLabel);
        leftPanel.add(emailField);
        leftPanel.add(new JLabel());
        leftPanel.add(phoneLabel);
//        gbc.gridx = 3;
//        gbc.gridy = 2;
//        gbc.gridwidth = 2;
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        leftPanel.add(phoneField, gbc);
        leftPanel.add(phoneField);
        leftPanel.add(new JLabel());
        leftPanel.add(genderLabel);
        leftPanel.add(maleRadioButton);
        leftPanel.add(femaleRadioButton);
        leftPanel.add(courseLabel);
        leftPanel.add(courseComboBox);
        leftPanel.add(new JLabel());
        leftPanel.add(languageLabel);
        leftPanel.add(javaCheckBox);
        leftPanel.add(pythonCheckBox);
        leftPanel.add(new JLabel());
        leftPanel.add(cCheckBox);
        leftPanel.add(new JLabel());
        leftPanel.add(saveButton);
        leftPanel.add(editButton);
        leftPanel.add(deleteButton);
        leftPanel.setLayout(new GridLayout(8,2));
        
        setLayout(new GridLayout(1, 2));
        leftPanel.setBorder(BorderFactory.createTitledBorder("Contact Information"));
        add(leftPanel);

        rightPanel.setBorder(BorderFactory.createTitledBorder("View Information"));
        add(rightPanel);
    }

}
