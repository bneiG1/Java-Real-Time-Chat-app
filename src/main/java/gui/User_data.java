package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import java.util.ArrayList;
import java.util.List;
import java.awt.GridLayout;
import javax.swing.JLabel;

import chat.User;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 * Clasa User_data.
 * 
 * @author Goga Iosif-Beniamin
 * @version 1.0
 * 
 * @see java.awt.EventQueue;
 * @see javax.swing.JFrame;
 * @see java.awt.Window.Type;
 * @see java.util.ArrayList;
 * @see java.util.List;
 * @see java.awt.GridLayout;
 * @see javax.swing.JLabel;
 * @see chat.User;
 * @see java.awt.GridBagLayout;
 * @see java.awt.GridBagConstraints;
 * @see java.awt.Insets;
 */
public class User_data {

	JFrame UserData;

	/**
	 * Functia User_data(u) - initializeaza interfata grafica, prin intermediul
	 * careia putem continua catre alte functii ale aplicatiei.
	 * 
	 * @param u (User) Utilizatorul conectat.
	 */
	public User_data(User u) {
		initialize(u);
	}

	/**
	 * Functia initialize() - creaza toate elementele care vor fi afisate in
	 * interiorul interfetei grafice.
	 */
	private void initialize(User u) {
		UserData = new JFrame();
		UserData.setResizable(false);
		UserData.setType(Type.UTILITY);
		UserData.setBounds(100, 100, 250, 170);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		UserData.getContentPane().setLayout(gridBagLayout);

		List<String> data = new ArrayList(u.print_user_data(u.getUsername()));

		JLabel Username = new JLabel("Username: " + data.get(0));
		GridBagConstraints gbc_Username = new GridBagConstraints();
		gbc_Username.insets = new Insets(0, 0, 5, 0);
		gbc_Username.gridx = 0;
		gbc_Username.gridy = 0;
		UserData.getContentPane().add(Username, gbc_Username);

		JLabel Email = new JLabel("Email: " + data.get(1));
		GridBagConstraints gbc_Email = new GridBagConstraints();
		gbc_Email.insets = new Insets(0, 0, 5, 0);
		gbc_Email.gridx = 0;
		gbc_Email.gridy = 1;
		UserData.getContentPane().add(Email, gbc_Email);

		JLabel Password = new JLabel("Password: " + data.get(2));
		GridBagConstraints gbc_Password = new GridBagConstraints();
		gbc_Password.gridx = 0;
		gbc_Password.gridy = 2;
		UserData.getContentPane().add(Password, gbc_Password);
	}

}
