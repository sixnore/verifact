package com.lords.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.lords.bo.UsuarioBo;
import com.lords.model.UsuarioModel;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import java.awt.Image;
import java.awt.Toolkit;


public class Login extends JFrame {

	public JPanel contentPane;
	public JTextField jtfUsuario;
	public JPasswordField jpfPassword;
	public JButton btnAcceder;
	public JButton btnSalir;
	
	UsuarioModel usuarioModelo = new UsuarioModel();
	UsuarioBo usuarioBo = new UsuarioBo();
	MenuAdmin menu_admin = new MenuAdmin();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
                    frame.setLocationRelativeTo(null);
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}//catch
			}
		});
	}

	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image icono = Toolkit.getDefaultToolkit().getImage("src/com/lords/resources/img/icono-VERIFACT.png");
        this.setIconImage(icono); 
		setBounds(100, 100, 370, 476);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 140, 0));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		jtfUsuario = new JTextField();
		jtfUsuario.setBounds(134, 211, 117, 20);
		panel.add(jtfUsuario);
		jtfUsuario.setColumns(10);
		
		btnAcceder = new JButton("");
		btnAcceder.setIcon(new ImageIcon(Login.class.getResource("/com/lords/resources/img/boton-LOGIN.png")));
		btnAcceder.setBounds(134, 303, 117, 39);
		panel.add(btnAcceder);
		
		jpfPassword = new JPasswordField();
		jpfPassword.setBounds(134, 272, 117, 20);
		panel.add(jpfPassword);
		
		JLabel lblUsuario = new JLabel("USUARIO");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		lblUsuario.setForeground(Color.BLACK);
		lblUsuario.setBounds(134, 186, 117, 14);
		panel.add(lblUsuario);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		lblPassword.setBounds(134, 247, 117, 14);
		panel.add(lblPassword);
		
		JLabel lblImagenUser = new JLabel("");
		lblImagenUser.setIcon(new ImageIcon(Login.class.getResource("/com/lords/resources/img/Usuario_1.png")));
		lblImagenUser.setBounds(114, 11, 137, 164);
		panel.add(lblImagenUser);
		
		btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(Login.class.getResource("/com/lords/resources/img/boton-SALIR2.png")));
		btnSalir.setBounds(132, 357, 119, 34);
		panel.add(btnSalir);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Login.class.getResource("/com/lords/resources/img/blue_and_white-wallpaper-1920x1080.jpg")));
		label.setBounds(0, 0, 376, 476);
		panel.add(label);
	}
}
