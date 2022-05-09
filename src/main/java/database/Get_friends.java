package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Clasa Get_friends.
 * 
 * @author Goga Iosif-Beniamin
 * @version 1.0
 * 
 * @see java.sql.Connection;
 * @see java.sql.ResultSet;
 * @see java.sql.Statement;
 * @see java.util.ArrayList;
 * @see java.util.Arrays;
 * @see java.util.List;
 */
public class Get_friends {
	/**
	 * Functia get_friends(username) - se foloseste de Clasa "Connection_to_db"
	 * pentru a stabilii conexiunea la baza de date si extrage o lista cu toti
	 * prietenii utilizatorului "username".
	 * 
	 * @param username (String) Numele utilizatorului.
	 * @return friends (List<String>) Returneaza o lista de prieteni ai
	 *         utilizatorului "username"
	 * @throws Exception
	 */
	public static List<String> get_friends(String username) throws Exception {

		Connection conn = Connection_to_db.db_connection();

		String friend;
		List<String> friends = new ArrayList();
		String query = "Select Username_friend FROM friends WHERE Username=" + "'" + username + "'";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);

		while (rs.next()) {
			friend = rs.getString(1);
			friends.add(friend);
			System.out.println(friend);
		}

		return friends;

	}

}
