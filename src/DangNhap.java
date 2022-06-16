import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DangNhap extends JFrame {

	public static JPanel contentPane;


	private JTextField tk;
	private JTextField mk;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 * @throws NotBoundException 
	 * @throws RemoteException 
	 * @throws MalformedURLException 
	 */
	public DangNhap(Hello s) throws MalformedURLException, RemoteException, NotBoundException {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 316);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tk = new JTextField();
		tk.setBounds(200, 63, 224, 48);
		contentPane.add(tk);
		tk.setColumns(10);
		
		mk = new JTextField();
		mk.setBounds(200, 147, 224, 48);
		contentPane.add(mk);
		mk.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Tài khoản:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(27, 63, 137, 48);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mật khẩu:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(27, 147, 137, 48);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Đăng nhập");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (s.login(tk.getText(), mk.getText())!=null)
					{
						try {
							FrameChat fr = new FrameChat(s,s.login(tk.getText(), mk.getText()));
							fr.setVisible(true);
							fr.setLocationRelativeTo(null);
							s.updateUser(s.login(tk.getText(), mk.getText()));
							dispose();
						} catch (MalformedURLException | NotBoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(260, 220, 120, 46);
		contentPane.add(btnNewButton);
	}

}
