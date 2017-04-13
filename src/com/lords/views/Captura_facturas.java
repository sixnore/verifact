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

public class Captura_facturas extends JFrame {

	public JPanel contentPane;
	public JTextField txtFolioFactura;
	public JTextField txtSubtotal;
	public JTextField txtIva;
	public JTextField txtTotal;
	public JButton btnGuardar;
	public JButton btnAgregarServ;
	public JButton btnExaminar;
	public static JComboBox jcbProveedores;
	public static JComboBox jcbServicios;
	public JComboBox jcbMetodoPago;
	public JPanel jpImg_factura;
	public JDateChooser jdcFecha_Recep;
	private JLabel lblEstado;
	public JComboBox jcbQuincena;
	public JComboBox jcbEstado;
	public JButton btnAgregarProv;

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
					Captura_facturas frame = new Captura_facturas();
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
	public Captura_facturas() {
		
		conexion = new Conexion();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
			//llenarServicios();
			llenarProveedores();
			}
		});
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
		jcbProveedores.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				seleccionServicios();
			}
		});
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
		btnAgregarServ.setIcon(new ImageIcon(Captura_facturas.class.getResource("/com/lords/resources/img/boton-AGREGAR.png")));
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
		btnExaminar.setIcon(new ImageIcon(Captura_facturas.class.getResource("/com/lords/resources/img/boton-EXAMINAR.png")));
		btnExaminar.setBounds(167, 386, 105, 20);
		panel.add(btnExaminar);
		
		btnGuardar = new JButton("");
		btnGuardar.setIcon(new ImageIcon(Captura_facturas.class.getResource("/com/lords/resources/img/boton-GUARDAR.png")));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				validacionCampos();
			}
		});
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
		btnAgregarProv.setIcon(new ImageIcon(Captura_facturas.class.getResource("/com/lords/resources/img/boton-AGREGAR.png")));
		btnAgregarProv.setBounds(340, 174, 105, 20);
		panel.add(btnAgregarProv);
		
		JButton btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(Captura_facturas.class.getResource("/com/lords/resources/img/boton-SALIR2.png")));
		btnSalir.setBounds(10, 431, 117, 36);
		panel.add(btnSalir);
		
		JLabel lblTitulo = new JLabel("");
		lblTitulo.setIcon(new ImageIcon(Captura_facturas.class.getResource("/com/lords/resources/img/titulo-CRUZAZUL.png")));
		lblTitulo.setBounds(88, 42, 324, 51);
		panel.add(lblTitulo);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Captura_facturas.class.getResource("/com/lords/resources/img/logo.png")));
		lblLogo.setBounds(10, 38, 55, 55);
		panel.add(lblLogo);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFondo.setIcon(new ImageIcon(Captura_facturas.class.getResource("/com/lords/resources/img/fondo1.jpg")));
		lblFondo.setBounds(0, 0, 454, 481);
		panel.add(lblFondo);
	}
	
	private void validacionCampos(){
		String folioFact =  txtFolioFactura.getText();
		String fecha =  jdcFecha_Recep.getDateFormatString();
		String quincena = (String)  jcbQuincena.getSelectedItem();
		String estado = (String)  jcbEstado.getSelectedItem();
		
		String proveedor = (String)  jcbProveedores.getSelectedItem();
		String servicio = (String)  jcbServicios.getSelectedItem();
		
		String pago = (String)  jcbMetodoPago.getSelectedItem();
		
		if(folioFact.isEmpty() || fecha.isEmpty() || quincena.isEmpty() ||  txtSubtotal.getText().isEmpty() ||  txtIva.getText().isEmpty() ||  txtTotal.getText().isEmpty() || estado.equals("Estado...") || proveedor.equals("Proveedores...") || servicio.equals("Servicios...") || pago.equals("Pago...")){
			JOptionPane.showMessageDialog(null, "Algun campo se encuentra vacio o no selecciona algo");
		}else{
			String fechaS = null;
			try { 
				Date date = jdcFecha_Recep.getDate(); 
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
				fechaS = String.valueOf(sdf.format(date));
				
				Date actual = new Date();
				
				
				if(date.after(actual)){
					throw new NullPointerException();
				}
				
				} catch(NullPointerException ex) { 
					JOptionPane.showMessageDialog(this, "Fecha no valida", "Error", JOptionPane.INFORMATION_MESSAGE); 
				}
			float subtotal = Float.parseFloat(txtSubtotal.getText() );
			float iva = Float.parseFloat(txtIva.getText());
			float total = Float.parseFloat(txtTotal.getText());
			facturaModel.setFolioFactura(folioFact);
			facturaModel.setFechaRecep(fechaS);
			facturaModel.setQuicena(quincena);
			facturaModel.setEstadoFactura(estado);
			facturaModel.setSubtotal(subtotal);
			facturaModel.setIva(iva);
			facturaModel.setTotal(total);
			
			proveedorModel.setProveedor(proveedor);
			servicioModel.setServicio(servicio);
			
			ordenPago.setTipoPago(pago);
			
			String mensaje = facturaDao.registrarFact(ordenPago, facturaModel, proveedorModel, servicioModel);
			JOptionPane.showMessageDialog(null, mensaje);
		}
	}
		
	
	
	private void seleccionServicios(){
		DefaultComboBoxModel modelo = (DefaultComboBoxModel) jcbServicios.getModel();
		if(!(jcbProveedores.equals("Proveedores..."))){
			modelo.removeAllElements();
			modelo.addElement("Servicios...");
			Connection accesodb = (Connection) conexion.conectandobd();
			
			String proveedor = (String) jcbProveedores.getSelectedItem();
			
			try {
				PreparedStatement ps = (PreparedStatement) accesodb.prepareStatement(" select servicio from servicio inner join proveedor on servicio.id_proveedor=proveedor.id_proveedor where proveedor=?"); 
				ps.setString(1, proveedor);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					modelo.addElement(rs.getObject(1));
				}
				jcbServicios.setModel(modelo);
			} catch (Exception e) {
				
			}
		}else{
			
		}
		
	}
	
	/*
	private static void llenarServicios(){
		Connection accesodb = (Connection) conexion.conectandobd();
		DefaultComboBoxModel modelo = (DefaultComboBoxModel) jcbServicios.getModel();
		try {
			PreparedStatement ps = (PreparedStatement) accesodb.prepareStatement("select servicio from servicio");
			ResultSet rs = ps.executeQuery();
			jcbServicios.setModel(modelo);
			while(rs.next()){
				modelo.addElement(rs.getObject(1));
				jcbServicios.setModel(modelo);
			}
			ps.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error cargando datos");
		}
	}
	*/
	
	
	private static void llenarProveedores(){
		Connection accesodb = (Connection) conexion.conectandobd();
		DefaultComboBoxModel modelo = (DefaultComboBoxModel) jcbProveedores.getModel();
		try {
			PreparedStatement ps = (PreparedStatement) accesodb.prepareStatement("select proveedor from proveedor");
			ResultSet rs = ps.executeQuery();
			jcbProveedores.setModel(modelo);
			while(rs.next()){
				modelo.addElement(rs.getObject(1));
				jcbProveedores.setModel(modelo);
			}
			ps.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error cargando datos");
		}
	}
}
