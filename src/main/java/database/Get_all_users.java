package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Clasa Get_all_users.
 * 
 * @author Goga Iosif-Beniamin
 * @version 1.0
 * 
 * @see java.sql.Connection;
 * @see java.sql.ResultSet;
 * @see java.sql.Statement;
 * @see java.util.ArrayList;
 * @see java.util.List;
 */
public class Get_all_users {
	/**
	 * Functia get_add_users(username) - se foloseste de Clasa "Connection_to_db"
	 * pentru a stabilii conexiunea la baza de date si extrage o lista de nume de
	 * utilizatori, mai putin numele utilizatorului "username".
	 * 
	 * @param username (String) Numele de utilizator.
	 * @return users (List<String>) Returneaza o lista de nume de utilizatori.
	 * @throws Exception
	 */
	public static List<String> get_all_users(String username) throws Exception {

		Connection conn = Connection_to_db.db_connection();

		String user;
		List<String> users = new ArrayList();
		String query = "Select usersUid FROM users WHERE usersUid <> " + "'" + username + "'";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);

		while (rs.next()) {
			user = rs.getString(1);
			users.add(user);
			System.out.println(user);
		}

		return users;

	}

}
