package com.lords.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
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
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import java.awt.Font;

public class ControlUsuarios extends JFrame {

	public JPanel contentPane;
	public JTextField txtNombre;
	public JTextField txtUsername;
	public JButton btnBuscar;
	public JButton btnAgregar;
	public JButton btnSalir;
	public JTable table;

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
		setBounds(100, 100, 613, 488);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel jpPrincipal = new JPanel();
		jpPrincipal.setBounds(0, 0, 634, 523);
		contentPane.add(jpPrincipal);
		jpPrincipal.setLayout(null);
		
		JPanel jpInformacionPersonal = new JPanel();
		jpInformacionPersonal.setBackground(new Color(173, 216, 230));
		jpInformacionPersonal.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Parametros de busqueda", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		jpInformacionPersonal.setBounds(21, 28, 421, 158);
		jpPrincipal.add(jpInformacionPersonal);
		jpInformacionPersonal.setLayout(null);
		JLabel lblNombre = new JLabel("Nombre y/o apellidos:");
		lblNombre.setBounds(10, 65, 147, 17);
		jpInformacionPersonal.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(156, 63, 246, 20);
		jpInformacionPersonal.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(10, 111, 73, 14);
		jpInformacionPersonal.add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(95, 108, 113, 20);
		jpInformacionPersonal.add(txtUsername);
		txtUsername.setColumns(10);
		
		JComboBox jcbRoll = new JComboBox();
		jcbRoll.setModel(new DefaultComboBoxModel(new String[] {"--Seleccione un rol--", "Administrador", "Capturista", "Secretaria"}));
		jcbRoll.setBounds(220, 109, 195, 20);
		jpInformacionPersonal.add(jcbRoll);
		
		JLabel lblNewLabel = new JLabel("Los parametros de busqueda funcionan en conjunto o de manera independiente.");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.ITALIC, 10));
		lblNewLabel.setBounds(10, 29, 405, 16);
		jpInformacionPersonal.add(lblNewLabel);
		
		JPanel jpOpciones = new JPanel();
		jpOpciones.setBackground(new Color(173, 216, 230));
		jpOpciones.setBorder(new TitledBorder(null, "Opciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		jpOpciones.setBounds(454, 28, 139, 158);
		jpPrincipal.add(jpOpciones);
		jpOpciones.setLayout(null);
		
		btnBuscar = new JButton("");
		btnBuscar.setIcon(new ImageIcon(ControlUsuarios.class.getResource("/com/lords/resources/img/boton-BUSCAR.png")));
		btnBuscar.setBounds(20, 23, 105, 20);
		jpOpciones.add(btnBuscar);
		
		btnAgregar = new JButton("");
		btnAgregar.setIcon(new ImageIcon(ControlUsuarios.class.getResource("/com/lords/resources/img/boton-AGREGAR.png")));
		btnAgregar.setBounds(20, 69, 105, 20);
		jpOpciones.add(btnAgregar);
		
		btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(ControlUsuarios.class.getResource("/com/lords/resources/img/boton-SALIR3.png")));
		btnSalir.setBounds(20, 116, 105, 20);
		jpOpciones.add(btnSalir);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(21, 213, 577, 218);
		jpPrincipal.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 565, 203);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Nombre completo", "Username", "Estatus", "Modificar", "Eliminar"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFondo.setIcon(new ImageIcon(ControlUsuarios.class.getResource("/com/lords/resources/img/fondo1.jpg")));
		lblFondo.setBounds(0, 0, 615, 468);
		jpPrincipal.add(lblFondo);
	}
}
