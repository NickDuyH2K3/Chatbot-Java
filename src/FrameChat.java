import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.LocalDateTime;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.SwingConstants;

public class FrameChat extends JFrame {

	public static JPanel contentPane;
	private JTextField textField;
	
	/**
	 * Create the frame.
	 * @throws NotBoundException 
	 * @throws RemoteException 
	 * @throws MalformedURLException 
	 */
	public FrameChat(Hello s, String name) throws MalformedURLException, RemoteException, NotBoundException {
		
		setUndecorated(true);
		setFocusTraversalKeysEnabled(false);
		setFocusTraversalPolicyProvider(true);
		setBounds(100, 100, 1057, 619);
		contentPane = new JPanel();
		contentPane.setForeground(Color.ORANGE);
		contentPane.setBackground(new Color(51,51,51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel.setIcon(new ImageIcon("E:\\java-2021-09\\ChatBot\\icons8-close-50.png"));
		lblNewLabel.setBounds(1007, 11, 40, 30);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setBounds(598, 547, 401, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(333, 111, 724, 411);
		contentPane.add(scrollPane);
		
		JTextPane textPane = new JTextPane();
		textPane.setVerifyInputWhenFocusTarget(false);
		textPane.setEnabled(false);
		textPane.setEditable(false);
		textPane.setBackground(Color.GRAY);
		textPane.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		textPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		scrollPane.setViewportView(textPane);
		textPane.setContentType("text/html");
		appendToPane(textPane, "<div class='clear' style='background-color:white'></div>");
		
		JLabel sendBtn = new JLabel("");
		sendBtn.setIcon(new ImageIcon("E:\\java-2021-09\\ChatBot\\icons8-send-32.png"));
		sendBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean check = textField.getText().equals("");
					if (check==false)
					{
						appendToPane(textPane,
								"<table class='bang' style='color: white; clear:both; width: 100%;'>" + "<tr align='right'>"
										+ "<td style='width: 59%; border-radius:10px;'></td>" + "<td style='width: 40%; background-color: #0084ff; border-radius:10px;'>"
										+ LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute() + "<br>" + textField.getText()
										+ "</td> </tr>" + "</table>");
						try {
							
							appendToPane(textPane, "<div class='left' style='width: 40%; background-color: #555555; color: white; border-radius:10px;'>" + "    "
									+ s.Chat(textField.getText()) + "<br>" + LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute() + "</div>");
							if (s.Chat(textField.getText()).equals("Có cc bố m trả lời được :)))"))
							{
								int c = JOptionPane.showConfirmDialog(null, "Bạn muốn thêm câu trả lời cho chúng tôi?");
								if (c==0)
								{
									AddFrame add = new AddFrame(s);
									add.setVisible(true);
									add.setLocationRelativeTo(null);
								}
							}
							s.updateChat(name, textField.getText());
						
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						textField.setText("");
					}
				}
		});
		
		sendBtn.setForeground(Color.ORANGE);
		sendBtn.setBackground(Color.ORANGE);
		sendBtn.setBounds(1007, 547, 40, 30);
		contentPane.add(sendBtn);
		appendToPane(textPane, "<div class='left' style='width: 40%; background-color: #555555; color: white; border-radius:10px;'>" + "    "
				+"Chào bạn, cảm ơn bạn đã sử dụng ứng dụng của chúng tôi!" + "<br>" + LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute() + "</div>");
		
		JLabel lblNewLabel_1 = new JLabel("MeoSimmi");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 95));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 11, 329, 95);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("About US");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(951, 58, 106, 48);
		contentPane.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 105, 1057, 10);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(598, 546, 449, 31);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
	}
	private void appendToPane(JTextPane tp, String msg) {
		HTMLDocument doc = (HTMLDocument) tp.getDocument();
		HTMLEditorKit editorKit = (HTMLEditorKit) tp.getEditorKit();
		try {

			editorKit.insertHTML(doc, doc.getLength(), msg, 0, 0, null);
			tp.setCaretPosition(doc.getLength());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
