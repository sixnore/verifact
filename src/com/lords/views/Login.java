package com.lords.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class Login extends JFrame {

	public JPanel contentPane;
	public JTextField jtfUsuario;
	public JPasswordField jpfPassword;
	public JButton btnAcceder;

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
		setBounds(100, 100, 362, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 140, 0));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		jtfUsuario = new JTextField();
		jtfUsuario.setBounds(115, 236, 117, 20);
		panel.add(jtfUsuario);
		jtfUsuario.setColumns(10);
		
		btnAcceder = new JButton("ACCEDER");
		btnAcceder.setBounds(115, 363, 120, 25);
		panel.add(btnAcceder);
		
		jpfPassword = new JPasswordField();
		jpfPassword.setBounds(115, 297, 117, 20);
		panel.add(jpfPassword);
		
		JLabel lblUsuario = new JLabel("USUARIO");
		lblUsuario.setFont(new Font("Futura Md BT", Font.BOLD, 15));
		lblUsuario.setForeground(Color.BLACK);
		lblUsuario.setBounds(139, 200, 83, 14);
		panel.add(lblUsuario);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(139, 272, 93, 14);
		panel.add(lblPassword);
		
		JLabel lblImagenUser = new JLabel("");
		lblImagenUser.setIcon(new ImageIcon(Login.class.getResource("/com/lords/resources/img/Usuario_1.png")));
		lblImagenUser.setBounds(95, 25, 137, 164);
		panel.add(lblImagenUser);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Login.class.getResource("/com/lords/resources/img/blue_and_white-wallpaper-1920x1080.jpg")));
		label.setBounds(0, 0, 336, 416);
		panel.add(label);
	}
}
