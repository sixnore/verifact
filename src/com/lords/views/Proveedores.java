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

public class Proveedores extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

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
		
		JLabel lblControlDeProveedores = new JLabel("CONTROL DE PROVEEDORES");
		lblControlDeProveedores.setForeground(Color.BLACK);
		lblControlDeProveedores.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		lblControlDeProveedores.setBounds(72, 11, 337, 14);
		panel.add(lblControlDeProveedores);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(173, 216, 230));
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Proveedores", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 120, 448, 85);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblProveedor = new JLabel("Proveedor:");
		lblProveedor.setBounds(10, 21, 72, 14);
		panel_1.add(lblProveedor);
		
		JButton btnAgregar = new JButton("");
		btnAgregar.setIcon(new ImageIcon(Proveedores.class.getResource("/com/lords/resources/img/boton-AGREGAR.png")));
		btnAgregar.setBounds(96, 54, 105, 20);
		panel_1.add(btnAgregar);
		
		JButton btnConsultar = new JButton("");
		btnConsultar.setIcon(new ImageIcon(Proveedores.class.getResource("/com/lords/resources/img/boton-BUSCAR.png")));
		btnConsultar.setBounds(215, 54, 105, 20);
		panel_1.add(btnConsultar);
		
		JButton btnModificar = new JButton("");
		btnModificar.setIcon(new ImageIcon(Proveedores.class.getResource("/com/lords/resources/img/boton-CAMBIOS.png")));
		btnModificar.setBounds(333, 54, 105, 20);
		panel_1.add(btnModificar);
		
		textField = new JTextField();
		textField.setBackground(new Color(135, 206, 250));
		textField.setBounds(96, 18, 342, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(173, 216, 230));
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Servicios", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(10, 216, 448, 166);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 224));
		table.setBorder(new TitledBorder(null, "Servicios que brinda", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Tipos de servicio"
			}
		));
		table.setBounds(10, 23, 428, 94);
		panel_2.add(table);
		
		JButton btnAgregar_1 = new JButton("");
		btnAgregar_1.setIcon(new ImageIcon(Proveedores.class.getResource("/com/lords/resources/img/boton-AGREGAR.png")));
		btnAgregar_1.setBounds(10, 128, 105, 20);
		panel_2.add(btnAgregar_1);
		
		JButton btnConsultar_1 = new JButton("");
		btnConsultar_1.setIcon(new ImageIcon(Proveedores.class.getResource("/com/lords/resources/img/boton-BUSCAR.png")));
		btnConsultar_1.setBounds(115, 128, 105, 20);
		panel_2.add(btnConsultar_1);
		
		JButton btnModificar_1 = new JButton("");
		btnModificar_1.setIcon(new ImageIcon(Proveedores.class.getResource("/com/lords/resources/img/boton-CAMBIOS.png")));
		btnModificar_1.setBounds(229, 128, 105, 20);
		panel_2.add(btnModificar_1);
		
		JButton btnElimanar = new JButton("");
		btnElimanar.setIcon(new ImageIcon(Proveedores.class.getResource("/com/lords/resources/img/boton-ELIMINAR.png")));
		btnElimanar.setBounds(333, 128, 105, 20);
		panel_2.add(btnElimanar);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Proveedores.class.getResource("/com/lords/resources/img/logo.png")));
		lblLogo.setBounds(43, 48, 55, 55);
		panel.add(lblLogo);
		
		JLabel lblTitulo = new JLabel("");
		lblTitulo.setIcon(new ImageIcon(Proveedores.class.getResource("/com/lords/resources/img/titulo-CRUZAZUL.png")));
		lblTitulo.setBounds(134, 48, 324, 48);
		panel.add(lblTitulo);
		
		JButton btnSalir = new JButton("");
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
