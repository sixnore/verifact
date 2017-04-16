package com.lords.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class Pagos extends JFrame {

	public JPanel contentPane;
	public JTable jtRegistros;
	public JComboBox jcbFolioFactura;
	public JTextField txtFolioFactura;
	public JButton btnSalir;
	public JButton btnBuscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pagos frame = new Pagos();
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
	public Pagos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 824, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel jpPrincipal = new JPanel();
		contentPane.add(jpPrincipal, BorderLayout.CENTER);
		jpPrincipal.setLayout(null);
		
		JLabel lblPagos = new JLabel("PAGOS");
		lblPagos.setForeground(new Color(0, 0, 0));
		lblPagos.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		lblPagos.setHorizontalAlignment(SwingConstants.CENTER);
		lblPagos.setBounds(379, 11, 107, 24);
		jpPrincipal.add(lblPagos);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Pagos.class.getResource("/com/lords/resources/img/logo.png")));
		lblLogo.setBounds(227, 33, 55, 55);
		jpPrincipal.add(lblLogo);
		
		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setIcon(new ImageIcon(Pagos.class.getResource("/com/lords/resources/img/titulo-CRUZAZUL.png")));
		lblTitulo.setBounds(291, 33, 324, 51);
		jpPrincipal.add(lblTitulo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 149, 804, 161);
		jpPrincipal.add(scrollPane);
		
		jtRegistros = new JTable();
		jtRegistros.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"#", "M\u00E9todo de pago", "Folio de Factura", "Servicio"
			}
		));
		jtRegistros.getColumnModel().getColumn(0).setPreferredWidth(60);
		jtRegistros.getColumnModel().getColumn(1).setPreferredWidth(145);
		jtRegistros.getColumnModel().getColumn(2).setPreferredWidth(150);
		scrollPane.setViewportView(jtRegistros);
		
		JLabel lblPorIndice = new JLabel("Por indice");
		lblPorIndice.setBounds(151, 115, 75, 14);
		jpPrincipal.add(lblPorIndice);
		
		jcbFolioFactura = new JComboBox();
		jcbFolioFactura.setBackground(new Color(173, 216, 230));
		jcbFolioFactura.setModel(new DefaultComboBoxModel(new String[] {"Folio de la factura...."}));
		jcbFolioFactura.setBounds(227, 112, 189, 20);
		jpPrincipal.add(jcbFolioFactura);
		
		JLabel lblEscribaFolio = new JLabel("Escriba el folio");
		lblEscribaFolio.setBounds(440, 115, 91, 14);
		jpPrincipal.add(lblEscribaFolio);
		
		txtFolioFactura = new JTextField();
		txtFolioFactura.setBackground(new Color(173, 216, 230));
		txtFolioFactura.setBounds(541, 112, 200, 20);
		jpPrincipal.add(txtFolioFactura);
		txtFolioFactura.setColumns(10);
		
		btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(Pagos.class.getResource("/com/lords/resources/img/boton-SALIR3.png")));
		btnSalir.setBounds(268, 321, 100, 20);
		jpPrincipal.add(btnSalir);
		
		btnBuscar = new JButton("");
		btnBuscar.setIcon(new ImageIcon(Pagos.class.getResource("/com/lords/resources/img/boton-BUSCAR.png")));
		btnBuscar.setBounds(507, 321, 100, 20);
		jpPrincipal.add(btnBuscar);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(Pagos.class.getResource("/com/lords/resources/img/fondo2.jpg")));
		lblFondo.setBounds(0, 0, 824, 366);
		jpPrincipal.add(lblFondo);
	}
}
