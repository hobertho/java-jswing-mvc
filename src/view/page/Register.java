package view.page;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;

import static controller.RegisterController.*;
import javax.swing.JPasswordField;
import java.awt.BorderLayout;

public class Register extends JPanel {
	private JTextField username;
	private JPasswordField password;
	private JPasswordField passwordConfirm;

	/**
	 * Create the panel.
	 */
	public Register() {
		setLayout(null);
		
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setBounds(185, 31, 70, 15);
		add(lblRegister);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(55, 68, 86, 15);
		add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(55, 105, 70, 15);
		add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setBounds(55, 145, 128, 15);
		add(lblConfirmPassword);
		
		username = new JTextField();
		username.setBounds(233, 66, 114, 19);
		add(username);
		username.setColumns(10);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HashMap<String, String> params = new HashMap<String, String>();
				params.put("username", username.getText());
				params.put("password", new String(password.getPassword()));
				params.put("passwordConfirm", new String(passwordConfirm.getPassword()));
				System.out.println(params);
				register(params);
				
			}
		});
		btnRegister.setBounds(164, 205, 117, 25);
		add(btnRegister);
		
		password = new JPasswordField();
		password.setBounds(233, 103, 114, 17);
		add(password);
		
		passwordConfirm = new JPasswordField();
		passwordConfirm.setBounds(232, 144, 114, 19);
		add(passwordConfirm);

	}
}
