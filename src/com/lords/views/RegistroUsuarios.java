package com.lords.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Registro_Usuarios extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApPaterno;
	private JTextField txtApMaterno;
	private JTextField txtUsername;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro_Usuarios frame = new Registro_Usuarios();
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
	public Registro_Usuarios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 357, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblRegistro = new JLabel("REGISTRO");
		lblRegistro.setBounds(101, 12, 142, 31);
		lblRegistro.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		lblRegistro.setForeground(new Color(0, 0, 0));
		panel.add(lblRegistro);
		
		JPanel jpDatos = new JPanel();
		jpDatos.setBackground(new Color(173, 216, 230));
		jpDatos.setBounds(12, 55, 306, 200);
		jpDatos.setBorder(new TitledBorder(null, "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(jpDatos);
		jpDatos.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(12, 32, 62, 16);
		jpDatos.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(147, 30, 135, 20);
		jpDatos.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellidoPaterno = new JLabel("Apellido paterno: ");
		lblApellidoPaterno.setBounds(12, 63, 111, 16);
		jpDatos.add(lblApellidoPaterno);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido materno: ");
		lblApellidoMaterno.setBounds(12, 91, 111, 16);
		jpDatos.add(lblApellidoMaterno);
		
		txtApPaterno = new JTextField();
		txtApPaterno.setBounds(147, 62, 135, 20);
		jpDatos.add(txtApPaterno);
		txtApPaterno.setColumns(10);
		
		txtApMaterno = new JTextField();
		txtApMaterno.setBounds(147, 89, 135, 20);
		jpDatos.add(txtApMaterno);
		txtApMaterno.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username: ");
		lblUsername.setBounds(12, 119, 111, 16);
		jpDatos.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setBounds(12, 147, 75, 16);
		jpDatos.add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(147, 117, 135, 20);
		jpDatos.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(147, 145, 135, 20);
		jpDatos.add(txtPassword);
		txtPassword.setColumns(10);
		
		JLabel lblActivo = new JLabel("Activo: ");
		lblActivo.setBounds(12, 175, 55, 16);
		jpDatos.add(lblActivo);
		
		JRadioButton rdbtnSi = new JRadioButton("Si");
		rdbtnSi.setBackground(new Color(173, 216, 230));
		rdbtnSi.setBounds(147, 171, 55, 24);
		jpDatos.add(rdbtnSi);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBackground(new Color(173, 216, 230));
		rdbtnNo.setBounds(219, 171, 62, 24);
		jpDatos.add(rdbtnNo);
		
		JComboBox jcbRoll = new JComboBox();
		jcbRoll.setModel(new DefaultComboBoxModel(new String[] {"Roll...."}));
		jcbRoll.setBounds(12, 267, 306, 25);
		panel.add(jcbRoll);
		
		JButton btnRegistrar = new JButton("");
		btnRegistrar.setIcon(new ImageIcon(Registro_Usuarios.class.getResource("/com/lords/resources/img/boton-AGREGAR.png")));
		btnRegistrar.setBounds(119, 304, 105, 20);
		panel.add(btnRegistrar);
		
		JButton btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(Registro_Usuarios.class.getResource("/com/lords/resources/img/boton-SALIR3.png")));
		btnSalir.setBounds(119, 336, 105, 20);
		panel.add(btnSalir);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setHorizontalAlignment(SwingConstants.LEFT);
		lblFondo.setIcon(new ImageIcon(Registro_Usuarios.class.getResource("/com/lords/resources/img/fondo2.jpg")));
		lblFondo.setBounds(0, 0, 331, 370);
		panel.add(lblFondo);
	}
}
