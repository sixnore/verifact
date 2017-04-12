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
		setBounds(100, 100, 471, 485);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblControlDeProveedores = new JLabel("CONTROL DE PROVEEDORES");
		lblControlDeProveedores.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		lblControlDeProveedores.setBounds(65, 11, 337, 14);
		panel.add(lblControlDeProveedores);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(null, "Proveedores", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 120, 425, 85);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblProveedor = new JLabel("Proveedor:");
		lblProveedor.setBounds(10, 21, 72, 14);
		panel_1.add(lblProveedor);
		
		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.setBounds(97, 51, 81, 23);
		panel_1.add(btnAgregar);
		
		JButton btnConsultar = new JButton("CONSULTAR");
		btnConsultar.setBounds(188, 51, 105, 23);
		panel_1.add(btnConsultar);
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.setBounds(303, 51, 112, 23);
		panel_1.add(btnModificar);
		
		textField = new JTextField();
		textField.setBounds(96, 18, 319, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new TitledBorder(null, "Servicios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 216, 425, 166);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		table = new JTable();
		table.setBorder(new TitledBorder(null, "Servicios que brinda", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Tipos de servicio"
			}
		));
		table.setBounds(10, 23, 405, 94);
		panel_2.add(table);
		
		JButton btnAgregar_1 = new JButton("AGREGAR");
		btnAgregar_1.setBounds(10, 128, 81, 23);
		panel_2.add(btnAgregar_1);
		
		JButton btnConsultar_1 = new JButton("CONSULTAR");
		btnConsultar_1.setBounds(101, 128, 100, 23);
		panel_2.add(btnConsultar_1);
		
		JButton btnModificar_1 = new JButton("MODIFICAR");
		btnModificar_1.setBounds(211, 128, 105, 23);
		panel_2.add(btnModificar_1);
		
		JButton btnElimanar = new JButton("ELIMINAR");
		btnElimanar.setBounds(326, 128, 89, 23);
		panel_2.add(btnElimanar);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Proveedores.class.getResource("/com/lords/resources/img/logo.png")));
		lblLogo.setBounds(22, 38, 55, 55);
		panel.add(lblLogo);
		
		JLabel lblTitulo = new JLabel("");
		lblTitulo.setIcon(new ImageIcon(Proveedores.class.getResource("/com/lords/resources/img/titulo-CRUZAZUL.png")));
		lblTitulo.setBounds(111, 45, 324, 48);
		panel.add(lblTitulo);
		
		JButton btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(Proveedores.class.getResource("/com/lords/resources/img/boton-SALIR2.png")));
		btnSalir.setBounds(10, 393, 117, 36);
		panel.add(btnSalir);
	}
}
