package view.page;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static controller.HomeController.*;

public class Home extends JPanel {
	private JTextField textFieldUsername;
	private JTextField textFieldPassword;

	/**
	 * Create the panel.
	 */
	public Home() {
		setLayout(null);
		
		JLabel lblSelamatDatang = new JLabel("Selamat Datang");
		lblSelamatDatang.setBounds(152, 28, 150, 15);
		add(lblSelamatDatang);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(224, 98, 114, 19);
		add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(114, 100, 92, 15);
		add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(114, 138, 70, 15);
		add(lblPassword);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(224, 136, 114, 19);
		add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(163, 176, 117, 25);
		add(btnLogin);
		
		JLabel lblRegister = new JLabel("or Register");
		lblRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				redirectToRegister();
			}
		});
		lblRegister.setFont(new Font("Dialog", Font.BOLD, 10));
		lblRegister.setForeground(Color.BLUE);
		lblRegister.setBounds(192, 213, 88, 15);
		add(lblRegister);

	}
}
