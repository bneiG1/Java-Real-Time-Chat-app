package chat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clasa User.
 * 
 * @author Goga Iosif-Beniamin
 * @version 1.0
 * 
 * @see java.sql.Connection;
 * @see java.sql.DriverManager;
 * @see java.sql.ResultSet;
 * @see java.sql.SQLException;
 * @see java.sql.Statement;
 * @see java.util.ArrayList;
 * @see java.util.List;
 * @see java.util.regex.Matcher;
 * @see java.util.regex.Pattern;
 */
public class User {

	String username;
	String email;
	String password;

	/**
	 * Constructorul clasei User, acest constructor este folosit pentru a inregistra
	 * un utilizator nou si de a-l introduce in baza de date
	 * 
	 * @param username (String) Numele de utilizator.
	 * @param email    (String) Adresa de email a utilizatorului.
	 * @param password (String) Parola utilizatorului.
	 */
	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}

	/**
	 * Constructorul clase User, acest constructor este folosit pentru a conecta
	 * utilizatorul la aplicatia de mesagerie.
	 * 
	 * @param username (String) Numele de utilizator care va fi cautat in baza de
	 *                 date si validat.
	 * @param password (String) Parola utilizatorului care va fi cautata in baza de
	 *                 date si va fi validata.
	 */
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/**
	 * Functia de getUsername().
	 * 
	 * @return username (String) Numele de utilizator.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Functia de setUsername(username).
	 * 
	 * @param username (String) Numele de utilizator.
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Functia de getEmail().
	 * 
	 * @return email (String) Adresa de email a utilizatorului.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Functia de setEmail(email).
	 * 
	 * @param email (String) Adresa de email a utilizatorului.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Functia de getPassword().
	 * 
	 * @return password (String) Parola utilizatorului.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Functia de setPassword(password)
	 * 
	 * @param password (String) Parola utilizatorului.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Functia de toString().
	 * 
	 * @return Returneaza un string format din "(String)username", "(String)email",
	 *         "(String)password".
	 */
	@Override
	public String toString() {
		return "User [username=" + username + ", email=" + email + ", password=" + password + "]";
	}

	/**
	 * Functia email_pattern(email) - aceasta functie primeste ca si argument o
	 * variabila de tip string si verifica daca aceasta este sub forma unei adrese
	 * de email.
	 * 
	 * @param email (String) Adresa de email a utilizatorului.
	 * @return true, daca "email" este de forma unei adrese de email sau false, daca
	 *         nu este sub forma unei adrese de email.
	 * 
	 */
	public static boolean email_pattern(String email) {
		Pattern email_regex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

		Matcher matcher = email_regex.matcher(email);
		return matcher.find();
	}

	/**
	 * Functia auth_user(username, password) - aceasta functie stabileste o
	 * conexiune la baza de date si cauta in tabela "users" randul cu
	 * usersUid="username" si usersPwd="password".
	 * 
	 * @param username (String) Numele de utilizator.
	 * @param password (String) Parola utilizatorului.
	 * @return true, daca utilizatoru a fost gasit, sau false, daca utilizatorul nu
	 *         a fost gasit.
	 */
	public static boolean auth_user(String username, String password) {

		String username_from_db = "", password_from_db = "";
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "loginsystem";
		String driver = "com.mysql.cj.jdbc.Driver";
		String userName = "root";
		String psw = "";
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url + dbName, userName, psw);

			String query = "SELECT usersUid, usersPwd FROM users WHERE usersUid=" + "'" + username + "' AND usersPwd="
					+ "'" + password + "'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				username_from_db = rs.getString(1);
				password_from_db = rs.getString(2);

			} // end while
			conn.close();
		} // end try
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (username.equals(username_from_db) && password.equals(password_from_db)) {
			return true;
		}

		return false;
	}

	/**
	 * Functia print_user_data - aceasta functie afiseaza username-ul, parola si
	 * adresa de email a utilizatorului
	 * 
	 * @param username_login (String) Numele de utilizator.
	 * @return user_data (List<String>) O lista cu datele utilizatorului
	 */
	public static List print_user_data(String username_login) {
		List<String> user_data = new ArrayList();
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "loginsystem";
		String driver = "com.mysql.cj.jdbc.Driver";
		String userName = "root";
		String password = "";
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url + dbName, userName, password);

			String f1, f2, f3;
			String query = "Select * FROM users WHERE usersUid=" + "'" + username_login + "'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				f1 = rs.getString(1);
				user_data.add(f1);
				f2 = rs.getString(2);
				user_data.add(f2);
				f3 = rs.getString(3);
				user_data.add(f3);
			} // end while
			conn.close();
		} // end try
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return user_data;
	}

}
