package gui;

import chat.*;
import database.*;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Color;

/**
 * Clasa LogIn.
 * 
 * @author Goga Iosif-Beniamin
 * @version 1.0
 * 
 * @see chat.*;
 * @see database.*;
 * @see java.awt.EventQueue;
 * @see javax.swing.JFrame;
 * @see javax.swing.JLabel;
 * @see java.awt.BorderLayout;
 * @see javax.swing.JTextField;
 * @see java.awt.Font;
 * @see javax.swing.SwingConstants;
 * @see javax.swing.JButton;
 * @see javax.swing.JSeparator;
 * @see javax.swing.JPasswordField;
 * @see javax.swing.AbstractAction;
 * @see java.awt.event.ActionEvent;
 * @see javax.swing.Action;
 * @see java.awt.event.ActionListener;
 * @see org.eclipse.wb.swing.FocusTraversalOnArray;
 * @see java.awt.Component;
 * @see java.awt.Color;
 */
public class LogIn {

	JFrame LoginFrame;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Functia main - aceasta functie porneste executia intregii aplicatii.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn login_window = new LogIn();
					login_window.LoginFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Functia LogIn() - initializeaza interfata grafica, prin intermediul careia
	 * putem continua catre alte functii ale aplicatiei.
	 */
	public LogIn() {
		initialize();
	}

	/**
	 * Functia initialize() - creaza toate elementele care vor fi afisate in
	 * interiorul interfetei grafice.
	 */

	private void initialize() {
		LoginFrame = new JFrame("Login");
		LoginFrame.setResizable(false);
		LoginFrame.setBounds(100, 100, 350, 550);
		LoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LoginFrame.getContentPane().setLayout(null);

		JLabel Headder = new JLabel("Login");
		Headder.setHorizontalAlignment(SwingConstants.CENTER);
		Headder.setLabelFor(LoginFrame);
		Headder.setFont(new Font("Tahoma", Font.PLAIN, 50));
		Headder.setBounds(0, 0, 334, 87);
		LoginFrame.getContentPane().add(Headder);

		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		usernameLabel.setBounds(10, 98, 314, 35);
		LoginFrame.getContentPane().add(usernameLabel);

		username = new JTextField();
		username.setToolTipText("Please enter your username...");
		usernameLabel.setLabelFor(username);
		username.setFont(new Font("Tahoma", Font.PLAIN, 20));
		username.setBounds(20, 144, 304, 35);
		LoginFrame.getContentPane().add(username);
		username.setColumns(10);

		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		passwordLabel.setBounds(10, 190, 304, 35);
		LoginFrame.getContentPane().add(passwordLabel);

		password = new JPasswordField();
		password.setToolTipText("Please enter your password...");
		passwordLabel.setLabelFor(password);
		password.setFont(new Font("Tahoma", Font.PLAIN, 20));
		password.setBounds(20, 236, 304, 35);
		LoginFrame.getContentPane().add(password);
		password.setColumns(10);

		final JLabel Error = new JLabel("");
		Error.setFont(new Font("Tahoma", Font.BOLD, 10));
		Error.setHorizontalAlignment(SwingConstants.CENTER);
		Error.setForeground(Color.RED);
		Error.setBounds(30, 282, 284, 14);
		LoginFrame.getContentPane().add(Error);

		JButton LoginButton = new JButton("Login");
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				final User User_login = new User(username.getText(), password.getText());

				if (User_login.auth_user(User_login.getUsername(), User_login.getPassword()) == true) {
					LoginFrame.setVisible(false);

					/**
					 * Launch the application.
					 */
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								LoggedIn window = new LoggedIn(User_login);
								window.LoggedinFrame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				} else {
					System.out.println("Login Error!");
					Error.setText("Username or password are incorrect!");

				}

			}
		});

		LoginButton.setToolTipText("Click the button to login...");
		LoginButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		LoginButton.setBounds(111, 308, 119, 42);
		LoginFrame.getContentPane().add(LoginButton);

		JLabel or = new JLabel("OR");
		or.setHorizontalAlignment(SwingConstants.CENTER);
		or.setFont(new Font("Tahoma", Font.PLAIN, 18));
		or.setBounds(121, 361, 102, 13);
		LoginFrame.getContentPane().add(or);

		JButton SignupButton = new JButton("Sign-up\r\n");
		SignupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginFrame.setVisible(false);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							SignUp signup_window = new SignUp();
							signup_window.SignupFrame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});

			}
		});

		SignupButton.setToolTipText("Click the button to sign-up...");
		SignupButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		SignupButton.setBounds(111, 385, 119, 42);
		LoginFrame.getContentPane().add(SignupButton);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 85, 314, 2);
		LoginFrame.getContentPane().add(separator);

	}

}
