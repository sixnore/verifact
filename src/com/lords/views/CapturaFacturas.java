package com.lords.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import com.lords.conexion.Conexion;
import com.lords.dao.FacturaDao;
import com.lords.model.FacturaModel;
import com.lords.model.OrdenPagoModel;
import com.lords.model.ProveedorModel;
import com.lords.model.ServicioModel;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.toedter.calendar.JDateChooser;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;

public class CapturaFacturas extends JFrame {

	public JPanel contentPane;
	public JTextField txtFolioFactura;
	public JTextField txtSubtotal;
	public JTextField txtIva;
	public JTextField txtTotal;
	public JButton btnGuardar;
	public JButton btnAgregarServ;
	public JButton btnExaminar;
	public JComboBox jcbProveedores;
	public JComboBox jcbServicios;
	public JComboBox jcbMetodoPago;
	public JPanel jpImg_factura;
	public JDateChooser jdcFecha_Recep;
	private JLabel lblEstado;
	public JComboBox jcbQuincena;
	public JComboBox jcbEstado;
	public JButton btnAgregarProv;
	public JButton btnSalir;

	static Conexion conexion;
	FacturaModel facturaModel = new FacturaModel();
	OrdenPagoModel ordenPago = new OrdenPagoModel();
	ProveedorModel proveedorModel = new ProveedorModel();
	ServicioModel servicioModel = new ServicioModel();
	
	FacturaDao facturaDao = new FacturaDao();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CapturaFacturas frame = new CapturaFacturas();
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
	public CapturaFacturas() {
		
		conexion = new Conexion();
		
		setTitle("Gestion de facturas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image icono = Toolkit.getDefaultToolkit().getImage("src/com/lords/resources/img/icono-VERIFACT.png");
        this.setIconImage(icono); 
		setBounds(100, 100, 454, 481);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblCampturaDeFacturas = new JLabel("CAPTURA DE FACTURAS");
		lblCampturaDeFacturas.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 20));
		lblCampturaDeFacturas.setBounds(88, 11, 305, 20);
		panel.add(lblCampturaDeFacturas);
		
		JLabel lblFolioDeFactura = new JLabel("Folio de factura");
		lblFolioDeFactura.setBounds(10, 132, 82, 14);
		panel.add(lblFolioDeFactura);
		
		txtFolioFactura = new JTextField();
		txtFolioFactura.setBackground(new Color(173, 216, 230));
		txtFolioFactura.setBounds(102, 129, 86, 20);
		panel.add(txtFolioFactura);
		txtFolioFactura.setColumns(10);
		
		JLabel lblFechaDeRecepcin = new JLabel("Fecha de recepci\u00F3n");
		lblFechaDeRecepcin.setBounds(210, 132, 120, 14);
		panel.add(lblFechaDeRecepcin);
		
		
		jdcFecha_Recep = new JDateChooser();
		jdcFecha_Recep.setBackground(new Color(173, 216, 230));
		jdcFecha_Recep.setBounds(340, 126, 105, 20);
		panel.add(jdcFecha_Recep);
		
		JLabel lblProveedor = new JLabel("Proveedor");
		lblProveedor.setBounds(10, 178, 66, 14);
		panel.add(lblProveedor);
		
		jcbProveedores = new JComboBox();
		jcbProveedores.setBackground(new Color(173, 216, 230));
		jcbProveedores.setModel(new DefaultComboBoxModel(new String[] {"Proveedores..."}));
		jcbProveedores.setBounds(102, 175, 228, 20);
		panel.add(jcbProveedores);
		
		JLabel lblServicio = new JLabel("Servicio");
		lblServicio.setBounds(10, 224, 46, 14);
		panel.add(lblServicio);
		
		jcbServicios = new JComboBox();
		jcbServicios.setBackground(new Color(173, 216, 230));
		jcbServicios.setModel(new DefaultComboBoxModel(new String[] {"Servicios..."}));
		jcbServicios.setBounds(102, 221, 228, 20);
		panel.add(jcbServicios);
		
		btnAgregarServ = new JButton("");
		btnAgregarServ.setIcon(new ImageIcon(CapturaFacturas.class.getResource("/com/lords/resources/img/boton-AGREGAR.png")));
		btnAgregarServ.setBounds(340, 220, 105, 20);
		panel.add(btnAgregarServ);
		
		JLabel lblSubtotal = new JLabel("Subtotal");
		lblSubtotal.setBounds(10, 269, 66, 14);
		panel.add(lblSubtotal);
		
		txtSubtotal = new JTextField();
		txtSubtotal.setBackground(new Color(173, 216, 230));
		txtSubtotal.setBounds(102, 266, 75, 20);
		panel.add(txtSubtotal);
		txtSubtotal.setColumns(10);
		
		JLabel lblIva = new JLabel("Iva");
		lblIva.setBounds(187, 269, 33, 14);
		panel.add(lblIva);
		
		txtIva = new JTextField();
		txtIva.setBackground(new Color(173, 216, 230));
		txtIva.setBounds(226, 266, 75, 20);
		panel.add(txtIva);
		txtIva.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(311, 269, 33, 14);
		panel.add(lblTotal);
		
		txtTotal = new JTextField();
		txtTotal.setBackground(new Color(173, 216, 230));
		txtTotal.setBounds(354, 266, 91, 20);
		panel.add(txtTotal);
		txtTotal.setColumns(10);
		
		JLabel lblMtodoDePago = new JLabel("M\u00E9todo de pago");
		lblMtodoDePago.setBounds(10, 351, 82, 14);
		panel.add(lblMtodoDePago);
		
		jcbMetodoPago = new JComboBox();
		jcbMetodoPago.setBackground(new Color(173, 216, 230));
		jcbMetodoPago.setModel(new DefaultComboBoxModel(new String[] {"Pago...", "TRANSFERENCIA BANCARIA", "V\u00CDA CHEQUE", "EN EFECTIVO"}));
		jcbMetodoPago.setBounds(102, 348, 166, 20);
		panel.add(jcbMetodoPago);
		
		JLabel lblAgregarDocumentoEscaneado = new JLabel("Agregar documento escaneado");
		lblAgregarDocumentoEscaneado.setBounds(10, 390, 163, 14);
		panel.add(lblAgregarDocumentoEscaneado);
		
		btnExaminar = new JButton("");
		btnExaminar.setIcon(new ImageIcon(CapturaFacturas.class.getResource("/com/lords/resources/img/boton-EXAMINAR.png")));
		btnExaminar.setBounds(167, 386, 105, 20);
		panel.add(btnExaminar);
		
		btnGuardar = new JButton("");
		btnGuardar.setIcon(new ImageIcon(CapturaFacturas.class.getResource("/com/lords/resources/img/boton-GUARDAR.png")));
		btnGuardar.setBounds(150, 431, 117, 36);
		panel.add(btnGuardar);
		
		jpImg_factura = new JPanel();
		jpImg_factura.setBorder(new TitledBorder(null, "Imagen de la factura", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		jpImg_factura.setBounds(289, 336, 156, 133);
		panel.add(jpImg_factura);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(10, 310, 46, 14);
		panel.add(lblEstado);
		
		jcbEstado = new JComboBox();
		jcbEstado.setBackground(new Color(173, 216, 230));
		jcbEstado.setModel(new DefaultComboBoxModel(new String[] {"Estado...", "EN ESPERA", "ENTREGADA", "FALLO"}));
		jcbEstado.setBounds(102, 307, 71, 20);
		panel.add(jcbEstado);
		
		JLabel lblQuincena = new JLabel("Quincena");
		lblQuincena.setBounds(242, 310, 46, 14);
		panel.add(lblQuincena);
		
		jcbQuincena = new JComboBox();
		jcbQuincena.setBackground(new Color(173, 216, 230));
		jcbQuincena.setModel(new DefaultComboBoxModel(new String[] {"1ERA", "2DA"}));
		jcbQuincena.setBounds(316, 305, 129, 20);
		panel.add(jcbQuincena);
		
		btnAgregarProv = new JButton("");
		btnAgregarProv.setIcon(new ImageIcon(CapturaFacturas.class.getResource("/com/lords/resources/img/boton-AGREGAR.png")));
		btnAgregarProv.setBounds(340, 174, 105, 20);
		panel.add(btnAgregarProv);
		
		btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(CapturaFacturas.class.getResource("/com/lords/resources/img/boton-SALIR2.png")));
		btnSalir.setBounds(10, 431, 117, 36);
		panel.add(btnSalir);
		
		JLabel lblTitulo = new JLabel("");
		lblTitulo.setIcon(new ImageIcon(CapturaFacturas.class.getResource("/com/lords/resources/img/titulo-CRUZAZUL.png")));
		lblTitulo.setBounds(88, 42, 324, 51);
		panel.add(lblTitulo);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(CapturaFacturas.class.getResource("/com/lords/resources/img/logo.png")));
		lblLogo.setBounds(10, 38, 55, 55);
		panel.add(lblLogo);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFondo.setIcon(new ImageIcon(CapturaFacturas.class.getResource("/com/lords/resources/img/fondo1.jpg")));
		lblFondo.setBounds(0, 0, 454, 481);
		panel.add(lblFondo);
	}
	
}
