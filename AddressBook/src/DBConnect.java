import java.sql.*;

public class DBConnect {
private Connection connection;
void connect() throws SQLException {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    String url = "jdbc:mysql://localhost/addressbook";
    String username = "root";
    String password = "";
    connection = DriverManager.getConnection(url, username, password);
	
}
  public void savetodatabase(String name, String email, int phone ,String gender, String course, String language) throws SQLException, ClassNotFoundException {
	  connect();
	  try {
		
	    String query = "SELECT COUNT(*) FROM contact";
	    PreparedStatement stmt = connection.prepareStatement(query);
	                ResultSet resultSet = stmt.executeQuery();
	                resultSet.next();
	                int count = resultSet.getInt(1);
	    
	    query = "INSERT INTO `contact`(`id`,`name`, `email`, `phone`, `gender`, `course`, `language`) VALUES (?,?,?,?,?,?,?)";
	    stmt = connection.prepareStatement(query);
	    stmt.setInt(1, count+1);
	    stmt.setString(2, name);
	    stmt.setString(3, email);
	    stmt.setInt(4, phone);
	    stmt.setString(5, gender);
	    stmt.setString(6, course);
	    stmt.setString(7, language);

	      int rowsInserted = stmt.executeUpdate();
	      System.out.println(rowsInserted + " rows inserted");

	      stmt.close();
	      connection.close();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
  }
  public ResultSet showContacts() throws SQLException {
	  connect();
	  String query = "SELECT * FROM contact";
	  ResultSet rs = null;
	  try {
		  PreparedStatement stmt = connection.prepareStatement(query);
		  rs = stmt.executeQuery();
	      
	  } catch (SQLException e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
	  }
	 
	return rs;  
  }
}