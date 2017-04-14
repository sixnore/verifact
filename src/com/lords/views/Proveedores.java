package com.lords.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollBar;

public class Proveedores extends JFrame {

	public JPanel contentPane;
	public JTable jtServicios;
	public JButton btnAgregar;
	public JButton btnConsultar;
	public JButton btnModificar;
	public JButton btnElimanar;
	public JButton btnSalir;
	private JComboBox jcbProveedores;
	private JScrollBar jsbTabla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				Proveedores frame = new Proveedores();
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
	public Proveedores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image icono = Toolkit.getDefaultToolkit().getImage("src/com/lords/resources/img/icono-VERIFACT.png");
        this.setIconImage(icono); 
		setBounds(100, 100, 468, 446);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel jlbTitulo = new JLabel("CONTROL DE PROVEEDORES");
		jlbTitulo.setForeground(Color.BLACK);
		jlbTitulo.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		jlbTitulo.setBounds(72, 11, 337, 14);
		panel.add(jlbTitulo);
		
		JPanel jpProveedores = new JPanel();
		jpProveedores.setBackground(new Color(173, 216, 230));
		jpProveedores.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Proveedores", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		jpProveedores.setBounds(10, 120, 448, 85);
		panel.add(jpProveedores);
		jpProveedores.setLayout(null);
		
		JLabel lblProveedor = new JLabel("Proveedor:");
		lblProveedor.setBounds(10, 21, 72, 14);
		jpProveedores.add(lblProveedor);
		
		btnAgregar = new JButton("");
		btnAgregar.setIcon(new ImageIcon(Proveedores.class.getResource("/com/lords/resources/img/boton-AGREGAR.png")));
		btnAgregar.setBounds(116, 54, 105, 20);
		jpProveedores.add(btnAgregar);
		
		btnConsultar = new JButton("");
		btnConsultar.setIcon(new ImageIcon(Proveedores.class.getResource("/com/lords/resources/img/boton-BUSCAR.png")));
		btnConsultar.setBounds(231, 54, 105, 20);
		jpProveedores.add(btnConsultar);
		
		btnModificar = new JButton("");
		btnModificar.setIcon(new ImageIcon(Proveedores.class.getResource("/com/lords/resources/img/boton-CAMBIOS.png")));
		btnModificar.setBounds(333, 54, 105, 20);
		jpProveedores.add(btnModificar);
		
		btnElimanar = new JButton("");
		btnElimanar.setBounds(10, 54, 105, 20);
		jpProveedores.add(btnElimanar);
		btnElimanar.setIcon(new ImageIcon(Proveedores.class.getResource("/com/lords/resources/img/boton-ELIMINAR.png")));
		
		jcbProveedores = new JComboBox();
		jcbProveedores.setModel(new DefaultComboBoxModel(new String[] {"Proveedores...."}));
		jcbProveedores.setBounds(125, 18, 313, 20);
		jpProveedores.add(jcbProveedores);
		
		JPanel jpServicios = new JPanel();
		jpServicios.setBackground(new Color(173, 216, 230));
		jpServicios.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Servicios", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		jpServicios.setBounds(10, 216, 448, 166);
		panel.add(jpServicios);
		jpServicios.setLayout(null);
		
		jsbTabla = new JScrollBar();
		jsbTabla.setBounds(421, 23, 17, 132);
		jpServicios.add(jsbTabla);
		
		jtServicios = new JTable();
		jtServicios.setBackground(new Color(255, 255, 224));
		jtServicios.setBorder(new TitledBorder(null, "Servicios que brinda", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		jtServicios.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Tipos de servicio"
			}
		));
		jtServicios.setBounds(10, 23, 428, 132);
		jpServicios.add(jtServicios);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Proveedores.class.getResource("/com/lords/resources/img/logo.png")));
		lblLogo.setBounds(43, 48, 55, 55);
		panel.add(lblLogo);
		
		JLabel lblTitulo = new JLabel("");
		lblTitulo.setIcon(new ImageIcon(Proveedores.class.getResource("/com/lords/resources/img/titulo-CRUZAZUL.png")));
		lblTitulo.setBounds(134, 48, 324, 48);
		panel.add(lblTitulo);
		
		btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(Proveedores.class.getResource("/com/lords/resources/img/boton-SALIR2.png")));
		btnSalir.setBounds(10, 393, 117, 36);
		panel.add(btnSalir);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondo.setIcon(new ImageIcon(Proveedores.class.getResource("/com/lords/resources/img/fondo2.jpg")));
		lblFondo.setBounds(0, 0, 468, 446);
		panel.add(lblFondo);
	}
}
