package com.lords.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import java.awt.Font;

public class Captura_facturas extends JFrame {

	public JPanel contentPane;
	public JTextField txtFolioFactura;
	public JTextField txtSubtotal;
	public JTextField txtIva;
	public JTextField txtTotal;
	public JButton btnGuardar;
	public JButton btnAgregar;
	public JButton btnExaminar;
	public JComboBox jcbProveedores;
	public JComboBox jcbServicios;
	public JComboBox jcbMetodo_pago;
	public JPanel jpImg_factura;
	public JDateChooser jdcFecha_Recep;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Captura_facturas frame = new Captura_facturas();
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
	public Captura_facturas() {
		setTitle("Gestion de facturas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblCampturaDeFacturas = new JLabel("Camptura de facturas");
		lblCampturaDeFacturas.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCampturaDeFacturas.setBounds(156, 11, 143, 14);
		panel.add(lblCampturaDeFacturas);
		
		JLabel lblFolioDeFactura = new JLabel("Folio de factura");
		lblFolioDeFactura.setBounds(21, 56, 82, 14);
		panel.add(lblFolioDeFactura);
		
		txtFolioFactura = new JTextField();
		txtFolioFactura.setBounds(113, 53, 86, 20);
		panel.add(txtFolioFactura);
		txtFolioFactura.setColumns(10);
		
		JLabel lblFechaDeRecepcin = new JLabel("Fecha de recepci\u00F3n");
		lblFechaDeRecepcin.setBounds(221, 56, 101, 14);
		panel.add(lblFechaDeRecepcin);
		
		jdcFecha_Recep = new JDateChooser();
		jdcFecha_Recep.setBounds(327, 50, 113, 20);
		panel.add(jdcFecha_Recep);
		
		JLabel lblProveedor = new JLabel("Proveedor");
		lblProveedor.setBounds(21, 102, 66, 14);
		panel.add(lblProveedor);
		
		jcbProveedores = new JComboBox();
		jcbProveedores.setModel(new DefaultComboBoxModel(new String[] {"Proveedores..."}));
		jcbProveedores.setBounds(113, 99, 327, 20);
		panel.add(jcbProveedores);
		
		JLabel lblServicio = new JLabel("Servicio");
		lblServicio.setBounds(21, 148, 46, 14);
		panel.add(lblServicio);
		
		jcbServicios = new JComboBox();
		jcbServicios.setModel(new DefaultComboBoxModel(new String[] {"Servicios..."}));
		jcbServicios.setBounds(113, 145, 228, 20);
		panel.add(jcbServicios);
		
		btnAgregar = new JButton("AGREGAR");
		btnAgregar.setBounds(351, 144, 89, 23);
		panel.add(btnAgregar);
		
		JLabel lblSubtotal = new JLabel("Subtotal");
		lblSubtotal.setBounds(21, 193, 46, 14);
		panel.add(lblSubtotal);
		
		txtSubtotal = new JTextField();
		txtSubtotal.setBounds(113, 190, 75, 20);
		panel.add(txtSubtotal);
		txtSubtotal.setColumns(10);
		
		JLabel lblIva = new JLabel("Iva");
		lblIva.setBounds(198, 193, 33, 14);
		panel.add(lblIva);
		
		txtIva = new JTextField();
		txtIva.setBounds(237, 190, 75, 20);
		panel.add(txtIva);
		txtIva.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(322, 193, 33, 14);
		panel.add(lblTotal);
		
		txtTotal = new JTextField();
		txtTotal.setBounds(365, 190, 75, 20);
		panel.add(txtTotal);
		txtTotal.setColumns(10);
		
		JLabel lblMtodoDePago = new JLabel("M\u00E9todo de pago");
		lblMtodoDePago.setBounds(21, 236, 82, 14);
		panel.add(lblMtodoDePago);
		
		jcbMetodo_pago = new JComboBox();
		jcbMetodo_pago.setModel(new DefaultComboBoxModel(new String[] {"Pago...", "TRANSFERENCIA BANCARIA", "V\u00CDA CHEQUE", "EN EFECTIVO"}));
		jcbMetodo_pago.setBounds(113, 233, 166, 20);
		panel.add(jcbMetodo_pago);
		
		JLabel lblAgregarDocumentoEscaneado = new JLabel("Agregar documento escaneado");
		lblAgregarDocumentoEscaneado.setBounds(21, 275, 163, 14);
		panel.add(lblAgregarDocumentoEscaneado);
		
		btnExaminar = new JButton("EXAMINAR...");
		btnExaminar.setBounds(178, 271, 101, 23);
		panel.add(btnExaminar);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBounds(21, 313, 89, 23);
		panel.add(btnGuardar);
		
		jpImg_factura = new JPanel();
		jpImg_factura.setBorder(new TitledBorder(null, "Imagen de la factura", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		jpImg_factura.setBounds(300, 221, 140, 133);
		panel.add(jpImg_factura);
	}
}
