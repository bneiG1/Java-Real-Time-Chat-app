package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import chat.Message;
import database.Display_messages;

import javax.swing.JSeparator;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Dictionary;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.Canvas;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;
import javax.swing.JInternalFrame;
import javax.swing.JScrollBar;
import javax.swing.border.EtchedBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.border.TitledBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.SpringLayout;

public class Test1234 {

	JFrame ChatFrame;
	private JTextField WriteMessageTextArea;

	/**
	 * Create the application.
	 */
	public Test1234(String username_sender, String username_reciver) throws Exception {
		initialize(username_sender, username_reciver);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final String username_sender, final String username_reciver) throws Exception {
		ChatFrame = new JFrame("Chat");
		ChatFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\benig\\Desktop\\Faculta\\An 2\\Semestrul 1\\P3 (Programare 3)\\Laborator\\(Real-time Chat)_Proiect-P3\\src\\main\\java\\img\\logo_site.png"));
		ChatFrame.setBounds(100, 100, 500, 420);
		ChatFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		ChatFrame.getContentPane().setLayout(null);

		JLabel ChatLabel = new JLabel("Chat");
		ChatLabel.setBounds(367, 11, 107, 31);
		ChatLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ChatLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		ChatFrame.getContentPane().add(ChatLabel);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 53, 464, 2);
		ChatFrame.getContentPane().add(separator);

		WriteMessageTextArea = new JTextField();
		WriteMessageTextArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		WriteMessageTextArea.setBounds(10, 328, 380, 42);
		ChatFrame.getContentPane().add(WriteMessageTextArea);
		WriteMessageTextArea.setColumns(10);

		final JButton SendMessageButton = new JButton("Send");
		SendMessageButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		SendMessageButton.setToolTipText("Press the button to send the message...");
		SendMessageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();

				if (WriteMessageTextArea.getText().trim().equals("")) {
					SendMessageButton.setToolTipText("Please write a message first!");

				} else {
					SendMessageButton.setToolTipText("Press the button to send the message...");

					Message m = new Message(username_sender, username_reciver, WriteMessageTextArea.getText().trim(),
							now);
					try {
						Message.send_message(m);
					} catch (Exception e1) {
						e1.printStackTrace();
					}

				}

				WriteMessageTextArea.setText("");
			}
		});
		SendMessageButton.setBounds(400, 328, 74, 42);
		ChatFrame.getContentPane().add(SendMessageButton);

		JLabel NumePrieten = new JLabel(username_reciver);
		NumePrieten.setFont(new Font("Tahoma", Font.PLAIN, 15));
		NumePrieten.setBounds(10, 11, 347, 31);
		ChatFrame.getContentPane().add(NumePrieten);

		// Messages start
		JScrollPane MessagesScrollPane = new JScrollPane();
		MessagesScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		MessagesScrollPane.setBounds(10, 66, 464, 251);
		ChatFrame.getContentPane().add(MessagesScrollPane);

		JPanel MainPanel = new JPanel();
		MessagesScrollPane.setViewportView(MainPanel);
				MainPanel.setLayout(new FormLayout(new ColumnSpec[] {
						ColumnSpec.decode("462px"),},
					new RowSpec[] {
						RowSpec.decode("120px"),
						FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("121px"),}));

//		FormLayout MainPanelLayout = new FormLayout();
//		MessagesScrollPane.setViewportView(MainPanel);
//		MainPanel.setLayout(MainPanelLayout);
//		MainPanelLayout.appendColumn(ColumnSpec.decode("default:grow"));
//
//		MainPanelLayout.appendRow(RowSpec.decode("default:grow"));
//		MainPanelLayout.appendRow(FormSpecs.RELATED_GAP_ROWSPEC);
//		MainPanelLayout.appendRow(RowSpec.decode("default:grow"));

//		for (Map<?, ?> m : Display_messages.get_messages(username_sender, username_reciver)) {
//
//			if (m.get("s").equals(username_reciver)) {
				// reciver
				JPanel Username_ReciverPanel = new JPanel();
				MainPanel.add(Username_ReciverPanel, "1, 1, fill, fill");
				Username_ReciverPanel.setLayout(null);

				JPanel ReciverPanel = new JPanel();
				ReciverPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				ReciverPanel.setBounds(10, 11, 361, 100);
				Username_ReciverPanel.add(ReciverPanel);
				ReciverPanel.setLayout(null);

				JLabel Username_ReciverLabel = new JLabel("New label");
				Username_ReciverLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
				Username_ReciverLabel.setBounds(10, 0, 200, 38);
				ReciverPanel.add(Username_ReciverLabel);

				JSeparator separator_1 = new JSeparator();
				separator_1.setBounds(0, 36, 360, 2);
				ReciverPanel.add(separator_1);

				JLabel Reciver_Message_Sent_TimeLabel = new JLabel("New label");
				Reciver_Message_Sent_TimeLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
				Reciver_Message_Sent_TimeLabel.setHorizontalAlignment(SwingConstants.CENTER);
				Reciver_Message_Sent_TimeLabel.setForeground(Color.LIGHT_GRAY);
				Reciver_Message_Sent_TimeLabel.setBounds(220, 0, 130, 38);
				ReciverPanel.add(Reciver_Message_Sent_TimeLabel);

				JScrollPane ReciverMessageScrollPane = new JScrollPane();
				ReciverMessageScrollPane.setBounds(0, 36, 360, 64);
				ReciverPanel.add(ReciverMessageScrollPane);
				
				JLabel Username_reciverMessageLabel = new JLabel("New label");
				Username_reciverMessageLabel.setHorizontalAlignment(SwingConstants.TRAILING);
				ReciverMessageScrollPane.setViewportView(Username_reciverMessageLabel);
//			}
//			if (m.get("r").equals(username_sender)) {
				// sender
				JPanel Username_SenderPanel = new JPanel();
				MainPanel.add(Username_SenderPanel, "1, 3, fill, fill");
				Username_SenderPanel.setLayout(null);

				JPanel SenderPanel = new JPanel();
				SenderPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				SenderPanel.setBounds(80, 11, 361, 100);
				Username_SenderPanel.add(SenderPanel);
				SenderPanel.setLayout(null);

				JLabel Username_SenderLabel = new JLabel("New label");
				Username_SenderLabel.setHorizontalAlignment(SwingConstants.TRAILING);
				Username_SenderLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
				Username_SenderLabel.setBounds(151, 0, 200, 38);
				SenderPanel.add(Username_SenderLabel);

				JSeparator separator_2 = new JSeparator();
				separator_2.setBounds(0, 36, 360, 2);
				SenderPanel.add(separator_2);

				JLabel Sender_Message_Sent_TimeLabel = new JLabel("New label");
				Sender_Message_Sent_TimeLabel.setBounds(11, 2, 130, 38);
				SenderPanel.add(Sender_Message_Sent_TimeLabel);
				Sender_Message_Sent_TimeLabel.setHorizontalAlignment(SwingConstants.CENTER);
				Sender_Message_Sent_TimeLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
				Sender_Message_Sent_TimeLabel.setForeground(Color.LIGHT_GRAY);

				JScrollPane SenderMessageScrollPane = new JScrollPane();
				SenderMessageScrollPane.setBounds(0, 36, 360, 64);
				SenderPanel.add(SenderMessageScrollPane);
				
				JLabel Username_senderMessageLabel = new JLabel("New label");
				SenderMessageScrollPane.setViewportView(Username_senderMessageLabel);
//			}
//		}
	}
}
