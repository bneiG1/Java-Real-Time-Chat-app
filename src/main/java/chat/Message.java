package chat;

import java.time.format.DateTimeFormatter;

import database.Connection_to_db;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;

/**
 * Clasa Message.
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
 */

public class Message {

	String Username_sender;
	String Username_reciver;
	String Message;

	/**
	 * Variabila now reprezinta data curenta.
	 */

	/* cred ca variabila date e redundanta */
	DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();

	/**
	 * Constructorul clasei Message
	 * 
	 * @param username_sender  (String) Numele utilizatorului care doreste sa
	 *                         initializeze o conversatie.
	 * @param username_reciver (String) Numele utilizatorului care va primii
	 *                         mesajul.
	 * @param message          (String) Mesajul pe care "username_sender" il va
	 *                         trimite.
	 * @param now              (LocalDateTime) Data curenta sub forma "yyyy/MM/dd
	 *                         HH:mm:ss".
	 */
	public Message(String username_sender, String username_reciver, String message, LocalDateTime now) {

		this.Username_sender = username_sender;
		this.Username_reciver = username_reciver;
		this.Message = message;
		this.now = LocalDateTime.now();
	}

	/**
	 * Functia de getUsername_sender().
	 * 
	 * @return Username_sender (String) Numele utilizatorului care doreste sa
	 *         initializeze o conversatie.
	 */
	public String getUsername_sender() {
		return Username_sender;
	}

	/**
	 * Functia de setUsername_sender().
	 * 
	 * @param username_sender (String)
	 * @return Username_sender Numele utilizatorului care va primii mesajul.
	 */
	public void setUsername_sender(String username_sender) {
		Username_sender = username_sender;
	}

	/**
	 * Functia de getUsername_reciver().
	 * 
	 * @return Username_reciver Numele utilizatorului care va primii mesajul.
	 */
	public String getUsername_reciver() {
		return Username_reciver;
	}

	/**
	 * Functia de setUsername_reciver().
	 * 
	 * @param username_reciver (String) Numele utilizatorului care va primii
	 *                         mesajul.
	 */
	public void setUsername_reciver(String username_reciver) {
		Username_reciver = username_reciver;
	}

	/**
	 * Functia de getMessage().
	 * 
	 * @return Message (String) Mesajul pe care "username_sender" il va trimite.
	 */
	public String getMessage() {
		return Message;
	}

	/**
	 * Functia de setMessage().
	 * 
	 * @param message (String) Mesajul pe care "username_sender" il va trimite.
	 */
	public void setMessage(String message) {
		Message = message;
	}

	/**
	 * Functia de getNow().
	 * 
	 * @return now (LocalDateTime) Data curenta sub forma "yyyy/MM/dd HH:mm:ss".
	 */
	public LocalDateTime getNow() {
		return now;
	}

	/**
	 * Functia de setNow().
	 * 
	 * @param now (LocalDateTime) Data curenta sub forma "yyyy/MM/dd HH:mm:ss".
	 */
	public void setNow(LocalDateTime now) {
		this.now = now;
	}

	/**
	 * Functia de toString()
	 * 
	 * @return Returneaza un string format din "(String)Username_sender",
	 *         "(String)Username_reciver", "(String)Message" si "(String)now".
	 */
	@Override
	public String toString() {
		return "Message [Username_sender=" + Username_sender + ", Username_reciver=" + Username_reciver + ", Message="
				+ Message + ", now=" + now + "]";
	}

	/**
	 * Functia send_message() - aceasta functie stabileste o conexiune la baza de
	 * date si insereaza in tabela "messages" toate atributele clasei Messages
	 * 
	 * @param m (Message) Obiectul format din Username_sender, Username_reciver,
	 *          Message, now.
	 * @throws Exception
	 */
	public static void send_message(Message m) throws Exception {

		Connection conn = Connection_to_db.db_connection();

		PreparedStatement ps = conn.prepareStatement("insert into messages values(?,?,?,?)");
		Statement stmt = conn.createStatement();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		DateTimeFormatter data = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

		String now_to_string = now.format(formatter);

		ps.setString(1, m.getUsername_sender());
		ps.setString(2, m.getUsername_reciver());
		ps.setString(3, m.getMessage());
		ps.setString(4, now_to_string);

		int i = ps.executeUpdate();

		conn.close();
	}

}
