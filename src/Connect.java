import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class Connect extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField id;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connect frame = new Connect();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 
	 * Create the frame.
	 * @throws RemoteException 
	 * @throws NotBoundException 
	 * @throws MalformedURLException 
	 */
	public Connect() throws RemoteException, MalformedURLException, NotBoundException {
		setBounds(100, 100, 482, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter port:");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(34, 134, 189, 41);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		textField.setBounds(77, 176, 322, 57);
		contentPane.add(textField);
		textField.setColumns(10);
		id = new JTextField();
		id.setHorizontalAlignment(SwingConstants.CENTER);
		id.setFont(new Font("Tahoma", Font.PLAIN, 30));
		id.setColumns(10);
		id.setBounds(77, 76, 322, 57);
		contentPane.add(id);
		
		JButton btnNewButton = new JButton("Connect");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Hello s = (Hello) Naming.lookup("//"+id.getText()+":"+Integer.parseInt(textField.getText())+"/Hello");
					DangNhap dn = new DangNhap(s);
					dn.setVisible(true);
					
				} catch (MalformedURLException | RemoteException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(150, 244, 172, 37);
		contentPane.add(btnNewButton);
		
		JLabel lblEnterId = new JLabel("Enter ID:");
		lblEnterId.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD | Font.ITALIC, 25));
		lblEnterId.setBounds(34, 24, 189, 41);
		contentPane.add(lblEnterId);
		
		
	}
}
