package database;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import chat.Message;

/**
 * Clasa Get_friends.
 * 
 * @author Goga Iosif-Beniamin
 * @version 1.0
 * 
 * @see java.io.BufferedReader;
 * @see java.io.InputStreamReader;
 * @see java.sql.Connection;
 * @see java.sql.DriverManager;
 * @see java.sql.PreparedStatement;
 * @see java.sql.ResultSet;
 * @see java.sql.Statement;
 * @see java.time.LocalDateTime;
 * @see java.time.format.DateTimeFormatter;
 */
public class Sign_up {
	/**
	 * Functia sign_up(username, email, password) - se foloseste de Clasa
	 * "Connection_to_db" pentru a stabilii conexiunea la baza de date si insereaza
	 * in tabela "users" un utilizator nou, avand datele introduse ca si parametrii.
	 * 
	 * @param username (String) Numele de utilizator.
	 * @param email    (String) Adresa de email a utilizatorului.
	 * @param password (String) Parola utilizatorului.
	 * @throws Exception
	 */
	public static void sign_up(String username, String email, String password) throws Exception {

		Connection conn = Connection_to_db.db_connection();

		PreparedStatement ps = conn.prepareStatement("insert into users values(?,?,?)");
		Statement stmt = conn.createStatement();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		ps.setString(1, username);
		ps.setString(2, email);
		ps.setString(3, password);

		int i = ps.executeUpdate();

		conn.close();
	}
}
