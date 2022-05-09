package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Clasa Get_friends.
 * 
 * @author Goga Iosif-Beniamin
 * @version 1.0
 * 
 * @see java.sql.Connection;
 * @see java.sql.DriverManager;
 * @see java.sql.ResultSet;
 * @see java.sql.Statement;
 */
public class Verify_if_username_exists {
	/**
	 * Functia verify_if_Username_exists(username) - e foloseste de Clasa
	 * "Connection_to_db" pentru a stabilii conexiunea la baza de date si cauta in
	 * tabela "users" daca exista un utilizator cu numele "username".
	 * 
	 * @param username (String) Numele de utilizator.
	 * @throws Exception
	 */
	public void verify_if_Username_exists(String username) throws Exception {

		Connection conn = Connection_to_db.db_connection();

		String f1, f2, f3;
		String query = "Select * FROM users WHERE usersUid=" + "'" + username + "'";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			f1 = rs.getString(1);
			f2 = rs.getString(2);
			f3 = rs.getString(3);
			System.out.println("Username: " + f1 + ",\nEmail: " + f2 + ",\nPassword: " + f3);

		}

	}

}
