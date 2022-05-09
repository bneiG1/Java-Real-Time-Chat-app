package database;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * Clasa Add_friend.
 * 
 * @author Goga Iosif-Beniamin
 * @version 1.0
 * 
 * @see java.io.BufferedReader;
 * @see java.io.InputStreamReader;
 * @see java.sql.Connection;
 * @see java.sql.DriverManager;
 * @see java.sql.Connection;
 * @see java.sql.PreparedStatement;
 * @see java.sql.Statement;
 */
public class Add_friend {
	/**
	 * Functia add_friends(username, usename_friend) - se foloseste de Clasa
	 * "Connection_to_db" pentru a stabilii conexiunea la baza de date si insereaza
	 * in tabela friends numele utilizatorului si numele prietenului utilizatorului.
	 * 
	 * @param username        (String) Numele de utilizator.
	 * @param username_friend (String) Numele utilizatorului pe care dorim sa il
	 *                        adaugam la lista de prieteni.
	 * @throws Exception
	 */
	public static void add_friends(String username, String username_friend) throws Exception {

		Connection conn = Connection_to_db.db_connection();

		PreparedStatement ps = conn.prepareStatement("insert into friends values(?,?)");
		Statement stmt = conn.createStatement();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		ps.setString(1, username);
		ps.setString(2, username_friend);
		int i = ps.executeUpdate();

		conn.close();
	}

}
