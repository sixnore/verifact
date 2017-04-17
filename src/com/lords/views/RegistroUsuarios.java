package com.lords.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class RegistroUsuarios extends JFrame {

	public JPanel contentPane;
	public JTextField txtNombre;
	public JTextField txtApPaterno;
	public JTextField txtApMaterno;
	public JTextField txtUsername;
	public JButton btnSalir;
	public JButton btnRegistrar;
	public JRadioButton rdbtnSi,rdbtnNo;
	public JComboBox jcbRoll;
	public ButtonGroup grupo1;
	public JPasswordField txtPassword;
	public JPasswordField txtPassword2;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroUsuarios frame = new RegistroUsuarios();
					frame.setLocationRelativeTo(null);
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}//catch
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegistroUsuarios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image icono = Toolkit.getDefaultToolkit().getImage("src/com/lords/resources/img/icono-VERIFACT.png");
        this.setIconImage(icono); 
		setBounds(100, 100, 331, 357);
		contentPane = new JPanel();
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
		jpDatos.setBounds(12, 41, 306, 231);
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
		
		JLabel lblActivo = new JLabel("Activo: ");
		lblActivo.setBounds(13, 204, 55, 16);
		jpDatos.add(lblActivo);
		
		rdbtnSi = new JRadioButton("Si",true);
		rdbtnSi.setBackground(new Color(173, 216, 230));
		rdbtnSi.setBounds(148, 200, 55, 24);
		jpDatos.add(rdbtnSi);
		
		rdbtnNo = new JRadioButton("No",false);
		rdbtnNo.setBackground(new Color(173, 216, 230));
		rdbtnNo.setBounds(220, 200, 62, 24);
		jpDatos.add(rdbtnNo);
		
		grupo1 = new ButtonGroup();
		grupo1.add(rdbtnSi);
		grupo1.add(rdbtnNo);

		JLabel lblRepetirPassword = new JLabel("Repetir password:");
		lblRepetirPassword.setBounds(12, 179, 111, 14);
		jpDatos.add(lblRepetirPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(147, 142, 135, 26);
		jpDatos.add(txtPassword);
		
		txtPassword2 = new JPasswordField();
		txtPassword2.setBounds(147, 173, 135, 26);
		jpDatos.add(txtPassword2);
		
		jcbRoll = new JComboBox();
		jcbRoll.setModel(new DefaultComboBoxModel(new String[] {"--Seleccione un rol--", "Administrador", "Capturista", "Secretaria"}));
		jcbRoll.setBounds(12, 283, 306, 25);
		panel.add(jcbRoll);
		
		btnRegistrar = new JButton("");
		btnRegistrar.setIcon(new ImageIcon(RegistroUsuarios.class.getResource("/com/lords/resources/img/boton-AGREGAR.png")));
		btnRegistrar.setBounds(12, 319, 105, 20);
		panel.add(btnRegistrar);
		
		btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(RegistroUsuarios.class.getResource("/com/lords/resources/img/boton-SALIR3.png")));
		btnSalir.setBounds(200, 319, 105, 20);
		panel.add(btnSalir);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setHorizontalAlignment(SwingConstants.LEFT);
		lblFondo.setIcon(new ImageIcon(RegistroUsuarios.class.getResource("/com/lords/resources/img/fondo2.jpg")));
		lblFondo.setBounds(0, 0, 331, 357);
		panel.add(lblFondo);
		
	}
}
