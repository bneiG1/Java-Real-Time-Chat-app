package teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import chat.User;

public class JUnit_tests {

	@Test
	void email_test() {

		User email_correct = new User("User_correct", "adresa@email.com", "123");
		User email_incorrect = new User("user_incorrect", "adresaemail.com", "321");

		assertEquals(true, User.email_pattern(email_correct.getEmail()), "Adresa de email este corecta!");
		assertEquals(false, User.email_pattern(email_incorrect.getEmail()), "Adresa de email nu este corecta!");

	}

	@Test
	void auth_test() {

		User user_login_data_correct = new User("admin", "admin", "admin");
		User user_login_data_incorrect = new User("Wololooo!", "null", "All your base are belong to us.");

		assertEquals(true, User.auth_user(user_login_data_correct.getUsername(), user_login_data_correct.getPassword()),
				"Date de conectare corecte!");
		assertEquals(false,
				User.auth_user(user_login_data_incorrect.getUsername(), user_login_data_incorrect.getPassword()),
				"Date de conectare incorecte!");

	}

}
