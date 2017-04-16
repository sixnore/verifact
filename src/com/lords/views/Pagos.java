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

public class Pagos extends JFrame {

	private JPanel contentPane;
	private JTable jtRegistros;
	private JTextField txtFolioFactura;

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
		setBounds(100, 100, 490, 415);
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
		lblPagos.setBounds(176, 11, 107, 24);
		jpPrincipal.add(lblPagos);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Pagos.class.getResource("/com/lords/resources/img/logo.png")));
		lblLogo.setBounds(30, 37, 55, 55);
		jpPrincipal.add(lblLogo);
		
		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setIcon(new ImageIcon(Pagos.class.getResource("/com/lords/resources/img/titulo-CRUZAZUL.png")));
		lblTitulo.setBounds(94, 37, 324, 51);
		jpPrincipal.add(lblTitulo);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(435, 149, 17, 161);
		jpPrincipal.add(scrollBar);
		
		jtRegistros = new JTable();
		jtRegistros.setBounds(10, 149, 444, 161);
		jpPrincipal.add(jtRegistros);
		
		JLabel lblPorIndice = new JLabel("Por indice");
		lblPorIndice.setBounds(10, 115, 75, 14);
		jpPrincipal.add(lblPorIndice);
		
		JComboBox jcbFolioFactura = new JComboBox();
		jcbFolioFactura.setBackground(new Color(173, 216, 230));
		jcbFolioFactura.setModel(new DefaultComboBoxModel(new String[] {"Folio de la factura...."}));
		jcbFolioFactura.setBounds(91, 112, 166, 20);
		jpPrincipal.add(jcbFolioFactura);
		
		JLabel lblEscribaFolio = new JLabel("Escriba el folio");
		lblEscribaFolio.setBounds(261, 115, 91, 14);
		jpPrincipal.add(lblEscribaFolio);
		
		txtFolioFactura = new JTextField();
		txtFolioFactura.setBackground(new Color(173, 216, 230));
		txtFolioFactura.setBounds(354, 110, 98, 20);
		jpPrincipal.add(txtFolioFactura);
		txtFolioFactura.setColumns(10);
		
		JButton btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(Pagos.class.getResource("/com/lords/resources/img/boton-SALIR3.png")));
		btnSalir.setBounds(10, 322, 100, 20);
		jpPrincipal.add(btnSalir);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.setIcon(new ImageIcon(Pagos.class.getResource("/com/lords/resources/img/boton-BUSCAR.png")));
		btnBuscar.setBounds(356, 322, 100, 20);
		jpPrincipal.add(btnBuscar);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(Pagos.class.getResource("/com/lords/resources/img/fondo2.jpg")));
		lblFondo.setBounds(0, 0, 464, 366);
		jpPrincipal.add(lblFondo);
	}
}
