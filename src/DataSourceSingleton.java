import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Claudio Santana Student Nr. 2017180 reference Amilcar Pontes
 *
 */

public class DataSourceSingleton {

	// THIS PART OF THE CODE CREATES THE CONNECTION WITH THE DATABASE
	// INFORMING THE HOSTNAME, PORT, DATABASE, USER AND PASSWORD
	private String db = "jdbc:mysql://52.50.23.197:3306/world";
	private String un = "cctstudent";
	private String pw = "Pass1234!";

	// THIS VARIABLES ARE GLOBAL, TO BE ACCESSED FROM ANY OF THE METHODS
	private Connection conn;
	private Statement stmt;

	// Private Static instance of this class - FOLLOWING SINGLETON PATTERN
	private static DataSourceSingleton instance = new DataSourceSingleton();

	// CONSTRUCTOR USING SINGLETON PATTERN
	private DataSourceSingleton() {

		// THIS CONSTRUCTOR HAS TO CREATE ONLY THE CONNECTION AND THE STATEMENT
		try {

			// Get a connection to the database
			conn = DriverManager.getConnection(db, un, pw);

			// Get a statement from the connection
			stmt = conn.createStatement();

		} catch (SQLException se) {
			System.out.println("SQL Exception:");

			// Loop through the SQL Exceptions
			while (se != null) {
				System.out.println("State  : " + se.getSQLState());
				System.out.println("Message: " + se.getMessage());
				System.out.println("Error  : " + se.getErrorCode());

				se = se.getNextException();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// THIS IS A GENERIC METHOD. IT MEANS, ANY SELECT STATEMENT
	// THAT WE PASS WILL USE THE
	// QUERY VARIABLE
	public ResultSet select(String query) {
		// Execute the query
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;
	}

	// THIS IS A GENERIC METHOD. IT MEANS, ANY SELECT STATEMENT
	// THAT WE PASS WILL USE THE
	// QUERY VARIABLE
	public boolean save(String query) {

		try {

			// AS AN INSERT STATEMENT DOES NOT RETURN VALUES, 
			// THERE IS NO NEED OF A RESULT SET
			stmt.execute(query);
			return true;
		} catch (SQLException e) {

			System.out.println("Error trying to save this register!");
			return false;
		}

	}

	// THIS METHOD CLOSES THE STATEMENT AND THE CONNECTION
	public void closing() {
		try {
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// SINGLETON GETTER
	public static DataSourceSingleton getInstance() {
		return instance;
	}

}
