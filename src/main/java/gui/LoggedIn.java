package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import chat.User;
import database.Add_friend;
import database.Get_friends;

import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JSplitPane;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Choice;
import javax.swing.JToggleButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLayeredPane;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.ScrollPane;
import java.awt.Panel;
import javax.swing.JSeparator;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SpringLayout;
import java.awt.FlowLayout;
import javax.swing.ScrollPaneConstants;

/**
 * Clasa LoggedIn.
 * 
 * @author Goga Iosif-Beniamin
 * @version 1.0
 * 
 * @see javax.swing.JFrame;
 * @see chat.User;
 * @see database.Add_friend;
 * @see database.Get_friends;
 * @see javax.swing.JToolBar;
 * @see javax.swing.SwingConstants;
 * @see javax.swing.Timer;
 * @see javax.swing.JSplitPane;
 * @see javax.swing.JMenuBar;
 * @see javax.swing.JRadioButtonMenuItem;
 * @see java.awt.Choice;
 * @see javax.swing.JToggleButton;
 * @see javax.swing.GroupLayout;
 * @see javax.swing.GroupLayout.Alignment;
 * @see javax.swing.JLayeredPane;
 * @see org.eclipse.wb.swing.FocusTraversalOnArray;
 * @see java.awt.Component;
 * @see javax.swing.JDesktopPane;
 * @see javax.swing.JInternalFrame;
 * @see javax.swing.JLabel;
 * @see java.awt.Font;
 * @see javax.swing.JScrollPane;
 * @see java.awt.ScrollPane;
 * @see java.awt.Panel;
 * @see javax.swing.JSeparator;
 * @see javax.swing.JCheckBoxMenuItem;
 * @see javax.swing.JMenuItem;
 * @see javax.swing.ImageIcon;
 * @see javax.swing.JList;
 * @see javax.swing.ListSelectionModel;
 * @see javax.swing.JButton;
 * @see java.awt.event.ActionListener;
 * @see java.awt.event.ActionEvent;
 * @see javax.swing.JPanel;
 * @see java.awt.GridBagLayout;
 * @see java.awt.GridBagConstraints;
 * @see javax.swing.BoxLayout;
 * @see java.awt.GridLayout;
 * @see net.miginfocom.swing.MigLayout;
 * @see java.awt.Insets;
 * @see com.jgoodies.forms.layout.FormLayout;
 * @see com.jgoodies.forms.layout.ColumnSpec;
 * @see com.jgoodies.forms.layout.RowSpec;
 * @see com.jgoodies.forms.layout.FormSpecs;
 * @see javax.swing.border.LineBorder;
 * @see java.awt.Color;
 * @see javax.swing.SpringLayout;
 * @see java.awt.FlowLayout;
 * @see javax.swing.ScrollPaneConstants;
 */
public class LoggedIn {

	JFrame LoggedinFrame;

	/**
	 * Fucntia LoggedIn(u) - initializeaza interfata grafica, prin intermediul
	 * careia putem continua catre alte functii ale aplicatiei.
	 * 
	 * @param u (User) Utilizatorul conectat.
	 * @throws Exception
	 */
	public LoggedIn(User u) throws Exception {
		initialize(u);
	}

	/**
	 * Functia initialize(u) - creaza toate elementele care vor fi afisate in
	 * interiorul interfetei grafice.
	 * 
	 * @param u (User) Utilizatoru conectat.
	 * @throws Exception
	 */

	private void initialize(final User u) throws Exception {
		LoggedinFrame = new JFrame("Friend list");
		LoggedinFrame.setResizable(false);
		LoggedinFrame.setBounds(100, 100, 333, 555);
		LoggedinFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LoggedinFrame.getContentPane().setLayout(null);

		JLabel Username = new JLabel(u.getUsername());
		Username.setFont(new Font("Tahoma", Font.PLAIN, 30));
		Username.setBounds(10, 11, 170, 51);
		LoggedinFrame.getContentPane().add(Username);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 60, 297, 2);
		LoggedinFrame.getContentPane().add(separator);

		JButton ProfileButton = new JButton("P");
		ProfileButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				/**
				 * Launch the application.
				 */

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							User_data window = new User_data(u);
							window.UserData.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		ProfileButton.setMnemonic('P');
		ProfileButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		ProfileButton.setBounds(197, 11, 50, 50);
		LoggedinFrame.getContentPane().add(ProfileButton);

		JButton AddFriendButton = new JButton("+");
		AddFriendButton.setMnemonic('+');
		AddFriendButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				/**
				 * Launch the application.
				 */
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Add_friends window = new Add_friends(u.getUsername());
							window.AddFriendFrame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});

			}
		});

		AddFriendButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		AddFriendButton.setBounds(257, 11, 50, 50);
		LoggedinFrame.getContentPane().add(AddFriendButton);

		JScrollPane FriendsScrollPane = new JScrollPane();
		FriendsScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		FriendsScrollPane.setBounds(10, 73, 297, 432);
		LoggedinFrame.getContentPane().add(FriendsScrollPane);

		JPanel FriendsPanel = new JPanel();
		FriendsScrollPane.setViewportView(FriendsPanel);

		FormLayout Layout = new FormLayout();

		Layout.appendColumn(FormSpecs.UNRELATED_GAP_COLSPEC);
		Layout.appendColumn(ColumnSpec.decode("180px"));

		Layout.appendColumn(FormSpecs.UNRELATED_GAP_COLSPEC);
		Layout.appendColumn(ColumnSpec.decode("65px"));

		int col_2 = 2;
		int col_4 = 4;
		int row = 2;
		for (final String f : Get_friends.get_friends(u.getUsername())) {

			Layout.appendRow(FormSpecs.UNRELATED_GAP_ROWSPEC);
			Layout.appendRow(RowSpec.decode("65px"));

			FriendsPanel.setLayout(Layout);

			JLabel Username_friend_Label = new JLabel(f);
			Username_friend_Label.setFont(new Font("Tahoma", Font.BOLD, 20));
			FriendsPanel.add(Username_friend_Label, "" + col_2 + "," + row + ", fill, fill");

			JButton ChatButton = new JButton("Chat");
			ChatButton.setFont(new Font("Tahoma", Font.BOLD, 13));
			ChatButton.setAlignmentX(Component.CENTER_ALIGNMENT);

			ChatButton.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					/**
					 * Launch the application.
					 */
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								Chat chat_frame = new Chat(u.getUsername(), f);
								chat_frame.ChatFrame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});

				}

			});

			FriendsPanel.add(ChatButton, "" + col_4 + "," + row + ", fill, fill");
			row = row + 2;
		}

	}
}
