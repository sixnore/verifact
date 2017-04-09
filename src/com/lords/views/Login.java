package com.lords.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField jtfUsuario;
	private JPasswordField jpfPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		jtfUsuario = new JTextField();
		jtfUsuario.setBounds(144, 150, 117, 20);
		panel.add(jtfUsuario);
		jtfUsuario.setColumns(10);
		
		JButton btnAcceder = new JButton("ACCEDER");
		btnAcceder.setBounds(159, 277, 89, 23);
		panel.add(btnAcceder);
		
		jpfPassword = new JPasswordField();
		jpfPassword.setBounds(144, 205, 117, 20);
		panel.add(jpfPassword);
	}
}
