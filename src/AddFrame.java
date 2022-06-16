

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class AddFrame extends JFrame {

	private JPanel contentPane;
	private JTextField key;
	private JTextField ans;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public AddFrame(Hello s) {
		setLocationRelativeTo(null);
		setUndecorated(true);
		setBackground(new Color(144,175,197));
		setBounds(100, 100, 622, 325);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51,51,51));
		contentPane.setOpaque(false);
		contentPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLocation(0,0);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Keyword:");
		lblNewLabel.setBounds(10, 37, 122, 38);
		lblNewLabel.setForeground(new Color(42,49,50));
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 24));
		contentPane.add(lblNewLabel);
		
		key = new JTextField();
		key.setBounds(33, 86, 536, 29);
		key.setForeground(new Color(118,54,38));
		contentPane.add(key);
		key.setColumns(10);
		
		JLabel lblAnswer = new JLabel("Answer:");
		lblAnswer.setBounds(10, 136, 122, 38);
		lblAnswer.setForeground(new Color(42,49,50));
		lblAnswer.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 24));
		contentPane.add(lblAnswer);
		
		
		ans = new JTextField();
		ans.setBounds(33, 180, 536, 29);
		ans.setForeground(new Color(118,54,38));
		ans.setColumns(10);
		contentPane.add(ans);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(147, 238, 111, 37);
		btnNewButton.setBackground(new Color(51,107,135));
		btnNewButton.setRequestFocusEnabled(false);
		btnNewButton.setFocusable(false);
		btnNewButton.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					s.add(key.getText(), ans.getText());
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(btnNewButton,"Đã thêm thành công!");
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(322, 238, 111, 37);
		btnCancel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(btnCancel);
	}
}
