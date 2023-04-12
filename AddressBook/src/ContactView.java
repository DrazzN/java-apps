import java.awt.*;
import java.text.NumberFormat;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ContactView extends JFrame{
	JPanel leftPanel = new JPanel(new GridLayout(9, 3));
	JLabel jlbName = new JLabel("Name:");
	JTextField jTxfName = new JTextField();
	
    JLabel jlbEmail = new JLabel("Email:");
    JTextField jTxfEmail = new JTextField();
    
    JLabel jlbPhone = new JLabel("Phone:");

    NumberFormat integerFormat = NumberFormat.getIntegerInstance();
    JFormattedTextField jTxPhone = new JFormattedTextField(integerFormat);
//    JTextField jTxPhone = new JTextField();
    
    JLabel jlbGender = new JLabel("Gender:");
    ButtonGroup group = new ButtonGroup();
    JRadioButton male = new JRadioButton("Male");    
    JRadioButton female = new JRadioButton("Female");
    
    JLabel jlbCourse = new JLabel("Course:");
    JCheckBox jChkJava = new JCheckBox("Java");
    JCheckBox jChkPython = new JCheckBox("Python");
    JCheckBox jChkC = new JCheckBox("C");
    JCheckBox jChkPHP = new JCheckBox("PHP");
    
    JLabel jlbLan = new JLabel("Language:");
    JComboBox<String> courseComboBox = new JComboBox<>(new String[]{"BCA", "BIT", "BIM", "BCS"});
    
    JButton jBtnSave = new JButton("Save");
    JButton jBtnEdit = new JButton("Edit");
    JButton jBtnCancel = new JButton("Cancel");

    JPanel rightPanel = new JPanel();
    
    String[] columns = {"ID", "Name", "Email", "Phone", "Gender", "Course", "Language"};
    
    DefaultTableModel model = new DefaultTableModel(columns, 0);
    JTable table = new JTable(model);

    JScrollPane scrollPane = new JScrollPane(table);
    public ContactView() {
        setTitle("Address Book");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200,800);
        setLocationRelativeTo(null);
        prepareGUI();
        setVisible(true);   
    }
    
    void prepareGUI() {
        Container window = getContentPane();
        window.setLayout(new GridLayout(1, 2));
        
        window.add(leftPanel);
        leftPanel.setBorder(BorderFactory.createTitledBorder("Contact Edit"));

        leftPanel.add(jlbName);
        leftPanel.add(jTxfName);
        leftPanel.add(new JLabel());
        leftPanel.add(jlbEmail);
        leftPanel.add(jTxfEmail);
        leftPanel.add(new JLabel());
        leftPanel.add(jlbPhone);
        leftPanel.add(jTxPhone);
        leftPanel.add(new JLabel());
 
        group.add(male);
        group.add(female);
        
        leftPanel.add(jlbGender);
        leftPanel.add(male);
        leftPanel.add(female);
        
        leftPanel.add(jlbCourse);
        leftPanel.add(courseComboBox);
        leftPanel.add(new JLabel());
        
        leftPanel.add(jlbLan);
        leftPanel.add(jChkJava);
        leftPanel.add(jChkPython);

        leftPanel.add(new JLabel());
        leftPanel.add(jChkC);
        leftPanel.add(jChkPHP);
        

        leftPanel.add(jBtnSave);
        leftPanel.add(jBtnEdit);
        leftPanel.add(jBtnCancel);
        
        window.add(rightPanel);
        rightPanel.setBorder(BorderFactory.createTitledBorder("Address Book"));

        rightPanel.add(scrollPane);
    }
}
