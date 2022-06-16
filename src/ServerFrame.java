
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NoSuchObjectException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class ServerFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	static JTextArea textArea;
	static JTextArea Chat;
	Imple obj = new Imple();
	static int k=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerFrame frame = new ServerFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ServerFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 493, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PORT:");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(54, 53, 93, 39);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(156, 53, 285, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int port = Integer.parseInt(textField.getText());
				try {
					LocateRegistry.createRegistry(port);
					UnicastRemoteObject.exportObject(obj, 10);
					Naming.rebind("//localhost:"+port+"/Hello", obj);
					JOptionPane.showMessageDialog(btnNewButton, "Server đã sẵn sàng!");
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showInternalMessageDialog(btnNewButton, "ID đã tồn tại!");
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		btnNewButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 20));
		btnNewButton.setBounds(156, 120, 93, 39);
		contentPane.add(btnNewButton);
		
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
					UnicastRemoteObject.unexportObject(obj, true);
					JOptionPane.showMessageDialog(btnStop, "Server đã đóng!");
				} catch (NoSuchObjectException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnStop.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 20));
		btnStop.setBounds(331, 116, 93, 39);
		contentPane.add(btnStop);
		 
		 JScrollPane scrollPane_1 = new JScrollPane();
		 scrollPane_1.setBounds(356, 215, 111, 229);
		 contentPane.add(scrollPane_1);
		
		 textArea = new JTextArea();
		 scrollPane_1.setViewportView(textArea);
		 textArea.setFont(new Font("Montserrat Medium", Font.PLAIN, 26));
		
		JLabel lblNewLabel_1 = new JLabel("User");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(341, 171, 77, 33);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 215, 334, 229);
		contentPane.add(scrollPane);
		
		Chat = new JTextArea();
		scrollPane.setViewportView(Chat);
		
		JLabel lblNewLabel_2 = new JLabel("Chat");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(10, 173, 77, 31);
		contentPane.add(lblNewLabel_2);
	}


	public static void updateUser(String name) {
		// TODO Auto-generated method stub
		textArea.append(name+"\n");
	}
	public static void updateChat(String name, String chat)
	{
		Chat.append("["+name+"]: "+chat+"\n");
	}
}
