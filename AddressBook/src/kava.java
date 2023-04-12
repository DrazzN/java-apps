import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class kava {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel model;
    private Connection conn;

	ContactView view = new ContactView();
    public kava() {
        // Create the JFrame
        frame = new JFrame("Contacts");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the JTable and its model
        String[] columns = {"ID", "Name", "Email", "Phone", "Gender", "Course", "Language"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        frame.getContentPane().add(scrollPane);

        // Set the size and make the frame visible
        frame.setSize(800, 600);
        frame.setVisible(true);

        // Connect to the database
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/addressbook";
            String username = "root";
            String password = "";
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }

        // Fill the table with data from the database
        try {
            String query = "SELECT * FROM contact";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                long phone = rs.getLong("phone");
                String gender = rs.getString("gender");
                String course = rs.getString("course");
                String language = rs.getString("language");
                Object[] row = {id, name, email, phone, gender, course, language};
                model.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new kava();
    }
}
