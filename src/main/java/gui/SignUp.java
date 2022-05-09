package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

import chat.User;
import database.Sign_up;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Color;

/**
 * Clasa SignUp.
 * 
 * @author Goga Iosif-Beniamin
 * @version 1.0
 * 
 * @see java.awt.EventQueue;
 * @see javax.swing.JFrame;
 * @see javax.swing.JLabel;
 * @see java.awt.BorderLayout;
 * @see javax.swing.JTextField;
 * @see java.awt.Font;
 * @see javax.swing.SwingConstants;
 * @see chat.User;
 * @see database.Sign_up;
 * @see javax.swing.JButton;
 * @see javax.swing.JPasswordField;
 * @see javax.swing.JSeparator;
 * @see javax.swing.AbstractAction;
 * @see java.awt.event.ActionEvent;
 * @see javax.swing.Action;
 * @see java.awt.event.ActionListener;
 * @see org.eclipse.wb.swing.FocusTraversalOnArray;
 * @see java.awt.Component;
 * @see java.awt.Color;
 */
public class SignUp {

	JFrame SignupFrame;
	private JTextField username;
	private JPasswordField password;
	private JTextField email;

	/**
	 * Functia main - aceasta functie porneste executia intregii aplicatii.
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp window = new SignUp();
					window.SignupFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Functia SignUp() - initializeaza interfata grafica, prin intermediul careia
	 * putem continua catre alte functii ale aplicatiei.
	 */
	public SignUp() {
		initialize();
	}

	/**
	 * Functia initialize() - creaza toate elementele care vor fi afisate in
	 * interiorul interfetei grafice.
	 */
	private void initialize() {
		SignupFrame = new JFrame("Sign-up");
		SignupFrame.setResizable(false);
		SignupFrame.setBounds(100, 100, 350, 550);
		SignupFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SignupFrame.getContentPane().setLayout(null);

		JLabel Headder = new JLabel("Sign-up");
		Headder.setHorizontalAlignment(SwingConstants.CENTER);
		Headder.setLabelFor(SignupFrame);
		Headder.setFont(new Font("Tahoma", Font.PLAIN, 50));
		Headder.setBounds(0, 0, 334, 87);
		SignupFrame.getContentPane().add(Headder);

		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		usernameLabel.setBounds(10, 104, 314, 35);
		SignupFrame.getContentPane().add(usernameLabel);

		username = new JTextField();
		username.setToolTipText("Please enter your username...");
		usernameLabel.setLabelFor(username);
		username.setFont(new Font("Tahoma", Font.PLAIN, 20));
		username.setBounds(20, 150, 304, 35);
		SignupFrame.getContentPane().add(username);
		username.setColumns(10);

		JLabel passwordlabel = new JLabel("Password:");
		passwordlabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		passwordlabel.setBounds(10, 279, 304, 35);
		SignupFrame.getContentPane().add(passwordlabel);

		password = new JPasswordField();
		password.setToolTipText("Please enter your password...");
		passwordlabel.setLabelFor(password);
		password.setFont(new Font("Tahoma", Font.PLAIN, 20));
		password.setBounds(20, 327, 304, 35);
		SignupFrame.getContentPane().add(password);
		password.setColumns(10);

		final JLabel ErrorLabel = new JLabel("");
		ErrorLabel.setForeground(Color.RED);
		ErrorLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		ErrorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ErrorLabel.setBounds(10, 85, 314, 14);
		SignupFrame.getContentPane().add(ErrorLabel);

		JButton SignupButton = new JButton("Sign-up");
		SignupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				User sign_up_user = new User(username.getText(), email.getText(), password.getText());
				try {
					if (sign_up_user.email_pattern(sign_up_user.getEmail()) == true) {
						Sign_up.sign_up(sign_up_user.getUsername(), sign_up_user.getEmail(),
								sign_up_user.getPassword());
						SignupFrame.setVisible(false);
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									LogIn login_window = new LogIn();

									final JLabel Error = new JLabel("Succes!");
									Error.setFont(new Font("Tahoma", Font.BOLD, 10));
									Error.setHorizontalAlignment(SwingConstants.CENTER);
									Error.setForeground(Color.GREEN);
									Error.setBounds(30, 282, 284, 14);
									login_window.LoginFrame.getContentPane().add(Error);

									login_window.LoginFrame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					} else {
						System.out.println("Sign-up error!" + email.getText());

						ErrorLabel.setText("Invalid email address!");
					}
				}

				catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});

		SignupButton.setToolTipText("Click the button to sign-up...");
		SignupButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		SignupButton.setBounds(111, 373, 119, 42);
		SignupFrame.getContentPane().add(SignupButton);

		JLabel or = new JLabel("OR");
		or.setHorizontalAlignment(SwingConstants.CENTER);
		or.setFont(new Font("Tahoma", Font.PLAIN, 18));
		or.setBounds(121, 426, 102, 13);
		SignupFrame.getContentPane().add(or);

		JButton LoginButton = new JButton("Login");
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignupFrame.setVisible(false);
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
		});

		LoginButton.setToolTipText("Click the button to login...");
		LoginButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		LoginButton.setBounds(111, 450, 119, 42);
		SignupFrame.getContentPane().add(LoginButton);

		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		emailLabel.setBounds(10, 187, 314, 35);
		SignupFrame.getContentPane().add(emailLabel);

		email = new JTextField();
		email.setFont(new Font("Tahoma", Font.PLAIN, 20));
		email.setBounds(20, 233, 304, 35);
		SignupFrame.getContentPane().add(email);
		email.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 85, 314, 2);
		SignupFrame.getContentPane().add(separator);

	}

}
