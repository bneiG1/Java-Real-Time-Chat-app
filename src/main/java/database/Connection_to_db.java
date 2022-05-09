package database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Clasa Connection_to_db.
 * 
 * @author Goga Iosif-Beniamin
 * @version 1.0
 * @see java.sql.Connection
 * @see java.sql.DriverManager
 */
public class Connection_to_db {
	/**
	 * Functia db_connection() - aceasta functie stabileste conexiunea la baza de
	 * date.
	 * 
	 * @return conn (Connection) prin aceasta variabila se realizeaza conexiunea la
	 *         baza de date.
	 * @throws Exception
	 */
	public static Connection db_connection() throws Exception {

		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "loginsystem";
		String driver = "com.mysql.cj.jdbc.Driver";
		String userName = "root";
		String psw = "";
		Class.forName(driver).newInstance();
		conn = DriverManager.getConnection(url + dbName, userName, psw);
		return conn;
	}

}
