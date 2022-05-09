package gui;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import database.Add_friend;
import database.Get_all_users;
import database.Get_friends;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import java.awt.Window.Type;
import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

/**
 * Clasa User.
 * 
 * @author Goga Iosif-Beniamin
 * @version 1.0
 * 
 * @see java.awt.Component;
 * @see java.awt.EventQueue;
 * @see javax.swing.JFrame;
 * @see javax.swing.JLabel;
 * @see java.awt.Font;
 * @see javax.swing.JTextField;
 * @see javax.swing.SwingUtilities;
 * @see database.Add_friend;
 * @see database.Get_all_users;
 * @see database.Get_friends;
 * @see javax.swing.JButton;
 * @see java.awt.event.ActionListener;
 * @see java.awt.event.ActionEvent;
 * @see javax.swing.JScrollBar;
 * @see java.awt.Window.Type;
 * @see javax.swing.JPanel;
 * @see com.jgoodies.forms.layout.FormLayout;
 * @see com.jgoodies.forms.layout.ColumnSpec;
 * @see com.jgoodies.forms.layout.RowSpec;
 * @see com.jgoodies.forms.layout.FormSpecs;
 * @see javax.swing.JScrollPane;
 * @see javax.swing.ScrollPaneConstants;
 */
public class Add_friends {

	JFrame AddFriendFrame;

	/**
	 * Functia Add_friends(username) - initializeaza interfata grafica, prin
	 * intermediul careia adaugam prieteni noi in lista de prieteni.
	 * 
	 * @param username (String) Numele de utilizator.
	 * @throws Exception
	 */
	public Add_friends(String username) throws Exception {
		initialize(username);
	}

	/**
	 * Functia initialize(username) - creaza toate elementele care vor fi afisate in
	 * interiorul interfetei grafice.
	 * 
	 * @param username (final String) Numele de utilizator.
	 * @throws Exception
	 */
	private void initialize(final String username) throws Exception {
		AddFriendFrame = new JFrame("Add friends");
		AddFriendFrame.setResizable(false);
		AddFriendFrame.setBounds(100, 100, 400, 300);
		AddFriendFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		AddFriendFrame.getContentPane().setLayout(null);

		JLabel Header = new JLabel("Add friends:");
		Header.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Header.setBounds(10, 11, 364, 25);
		AddFriendFrame.getContentPane().add(Header);

		JScrollPane FriendsScrollPane = new JScrollPane();
		FriendsScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		FriendsScrollPane.setBounds(10, 44, 364, 206);
		AddFriendFrame.getContentPane().add(FriendsScrollPane);

		JPanel FriendsPanel = new JPanel();
		FriendsScrollPane.setViewportView(FriendsPanel);

		FormLayout Layout = new FormLayout();

		Layout.appendColumn(FormSpecs.UNRELATED_GAP_COLSPEC);
		Layout.appendColumn(ColumnSpec.decode("240px"));

		Layout.appendColumn(FormSpecs.UNRELATED_GAP_COLSPEC);
		Layout.appendColumn(ColumnSpec.decode("69px"));

		int col_2 = 2;
		int col_4 = 4;
		int row = 2;

		for (final String u : Get_all_users.get_all_users(username)) {

			Layout.appendRow(FormSpecs.UNRELATED_GAP_ROWSPEC);
			Layout.appendRow(RowSpec.decode("50px"));

			FriendsPanel.setLayout(Layout);

			JLabel FriendNameLabel = new JLabel(u);
			FriendNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			FriendsPanel.add(FriendNameLabel, "" + col_2 + "," + row + ", fill, fill");

			JButton AddFriendButton = new JButton("Add");
			AddFriendButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					try {
						Add_friend.add_friends(username, u);

					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});

			AddFriendButton.setFont(new Font("Tahoma", Font.BOLD, 14));
			FriendsPanel.add(AddFriendButton, "" + col_2 + "," + row + ", fill, fill");

			FriendsPanel.add(AddFriendButton, "" + col_4 + "," + row + ", fill, fill");
			row = row + 2;
		}

	}
}
