package com.lords.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;

public class ControlUsuarios extends JFrame {

	public JPanel contentPane;
	public JTextField txtNombre;
	public JTextField txtApPaterno;
	public JTextField txtApMaterno;
	public JTextField txtUsername;
	public JTable jtUsuarios;
	public JButton btnBuscar;
	public JButton btnAgregar;
	public JButton btnSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControlUsuarios frame = new ControlUsuarios();
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
	public ControlUsuarios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image icono = Toolkit.getDefaultToolkit().getImage("src/com/lords/resources/img/icono-VERIFACT.png");
        this.setIconImage(icono); 
		setBounds(100, 100, 577, 395);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel jpPrincipal = new JPanel();
		jpPrincipal.setBounds(0, 0, 634, 523);
		contentPane.add(jpPrincipal);
		jpPrincipal.setLayout(null);
		
		JPanel jpInformacionPersonal = new JPanel();
		jpInformacionPersonal.setBackground(new Color(173, 216, 230));
		jpInformacionPersonal.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n personal", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		jpInformacionPersonal.setBounds(21, 11, 392, 187);
		jpPrincipal.add(jpInformacionPersonal);
		jpInformacionPersonal.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 41, 73, 14);
		jpInformacionPersonal.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(128, 38, 100, 20);
		jpInformacionPersonal.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellidoPaterno = new JLabel("Apellido paterno:");
		lblApellidoPaterno.setBounds(10, 71, 108, 14);
		jpInformacionPersonal.add(lblApellidoPaterno);
		
		txtApPaterno = new JTextField();
		txtApPaterno.setBounds(128, 69, 100, 20);
		jpInformacionPersonal.add(txtApPaterno);
		txtApPaterno.setColumns(10);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido materno:");
		lblApellidoMaterno.setBounds(10, 108, 108, 14);
		jpInformacionPersonal.add(lblApellidoMaterno);
		
		txtApMaterno = new JTextField();
		txtApMaterno.setBounds(128, 105, 100, 20);
		jpInformacionPersonal.add(txtApMaterno);
		txtApMaterno.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(10, 143, 73, 14);
		jpInformacionPersonal.add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(128, 140, 100, 20);
		jpInformacionPersonal.add(txtUsername);
		txtUsername.setColumns(10);
		
		JComboBox jcbRoll = new JComboBox();
		jcbRoll.setModel(new DefaultComboBoxModel(new String[] {"Roll...."}));
		jcbRoll.setBounds(255, 38, 120, 20);
		jpInformacionPersonal.add(jcbRoll);
		
		JPanel jpOpciones = new JPanel();
		jpOpciones.setBackground(new Color(173, 216, 230));
		jpOpciones.setBorder(new TitledBorder(null, "Opciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		jpOpciones.setBounds(423, 11, 139, 187);
		jpPrincipal.add(jpOpciones);
		jpOpciones.setLayout(null);
		
		btnBuscar = new JButton("");
		btnBuscar.setIcon(new ImageIcon(ControlUsuarios.class.getResource("/com/lords/resources/img/boton-BUSCAR.png")));
		btnBuscar.setBounds(20, 23, 105, 20);
		jpOpciones.add(btnBuscar);
		
		btnAgregar = new JButton("");
		btnAgregar.setIcon(new ImageIcon(ControlUsuarios.class.getResource("/com/lords/resources/img/boton-AGREGAR.png")));
		btnAgregar.setBounds(20, 81, 105, 20);
		jpOpciones.add(btnAgregar);
		
		btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(ControlUsuarios.class.getResource("/com/lords/resources/img/boton-SALIR3.png")));
		btnSalir.setBounds(20, 143, 105, 20);
		jpOpciones.add(btnSalir);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(547, 210, 17, 160);
		jpPrincipal.add(scrollBar);
		
		jtUsuarios = new JTable();
		jtUsuarios.setColumnSelectionAllowed(true);
		jtUsuarios.setBounds(21, 212, 542, 158);
		jpPrincipal.add(jtUsuarios);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFondo.setIcon(new ImageIcon(ControlUsuarios.class.getResource("/com/lords/resources/img/fondo1.jpg")));
		lblFondo.setBounds(0, 0, 577, 395);
		jpPrincipal.add(lblFondo);
	}
}
