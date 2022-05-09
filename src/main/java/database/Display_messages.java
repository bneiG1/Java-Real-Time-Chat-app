package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Clasa Display_messages.
 * 
 * @author Goga Iosif-Beniamin
 * @version 1.0
 * 
 * @see java.sql.Connection;
 * @see java.sql.ResultSet;
 * @see java.sql.Statement;
 * @see java.util.ArrayList;
 * @see java.util.HashMap;
 * @see java.util.List;
 * @see java.util.Map;
 */
public class Display_messages {

	/**
	 * Functia get_messages(username_sender, username_reciver) - se foloseste de
	 * Clasa "Connection_to_db" pentru a stabilii conexiunea la baza de date si
	 * extrage toate mesajele transmise intre doi utilizatori.
	 * 
	 * @param username_sender  (String) Numele de utilizator
	 * @param username_reciver (String) Numele de utilizator
	 * @return messages_list (List<Map>) Returneaza o lista de map-uri de mesaje,
	 *         sub forma: "user_sender" are cheia "s", "user_reciver" are cheia "r",
	 *         "message" are cheia "m", iar "date" are cheia "d".
	 * 
	 * @throws Exception
	 */
	public static List<Map> get_messages(String username_sender, String username_reciver) throws Exception {

		Connection conn = Connection_to_db.db_connection();

		String user_sender, user_reciver, message, date;

		List<Map> messages_list = new ArrayList();
		String query = "Select * FROM messages WHERE Username_sender=" + "'" + username_sender
				+ "' AND Username_reciver=" + "'" + username_reciver + "' OR Username_sender=" + "'" + username_reciver
				+ "' AND Username_reciver=" + "'" + username_sender + "' ORDER BY Date DESC";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {

			Map<String, String> messages = new HashMap();

			user_sender = rs.getString(1);
			messages.put("s", user_sender);

			user_reciver = rs.getString(2);
			messages.put("r", user_reciver);

			message = rs.getString(3);
			messages.put("m", message);

			date = rs.getString(4);
			messages.put("d", date);

			System.out.println(messages);
			messages_list.add(messages);

		}
		System.out.println(messages_list);
		return messages_list;

	}

}
