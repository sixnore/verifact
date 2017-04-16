package com.lords.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.lords.verifact.AbstractJasperReports;
import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JRadioButton;

import java.sql.Connection;

public class OrdenPago extends JFrame {

	public OrdenPago(Connection conn){
		AbstractJasperReports.createReport(conn,"C:\\Users\\Samuel\\JaspersoftWorkspace\\Verifact\\OrdenPago.jasper");
	}
	
	public JPanel contentPane;
	public JTextField txtImporte;
	public JTextField txtImporteLetra;
	public JPanel jpSolicitudCheque;
	public JButton btnSalir;
	public JButton btnGuardar;
	public JComboBox jcbServicios;
	public JComboBox jcbProveedores;
	public JDateChooser jdcFechaOrden;
	public JRadioButton rdbtnCheque;
	public JRadioButton rdbtnTransferenciaBancaria;
	public JComboBox jcbAplicacion;
	public ButtonGroup grupoPago;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrdenPago frame = new OrdenPago();
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
	public OrdenPago() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image icono = Toolkit.getDefaultToolkit().getImage("src/com/lords/resources/img/icono-VERIFACT.png");
        this.setIconImage(icono); 
		setBounds(100, 100, 569, 569);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		jdcFechaOrden = new JDateChooser();
		jdcFechaOrden.setEnabled(false);
		Date now = new Date();
		jdcFechaOrden.setDate(now);
		jdcFechaOrden.setBackground(new Color(135, 206, 250));
		jdcFechaOrden.setBounds(444, 82, 105, 20);
		panel.add(jdcFechaOrden);
		
		JLabel lblOrdenDePago = new JLabel("ORDEN DE PAGO");
		lblOrdenDePago.setForeground(Color.BLACK);
		lblOrdenDePago.setFont(new Font("Futura Md BT", Font.BOLD, 20));
		lblOrdenDePago.setBounds(187, 11, 189, 25);
		panel.add(lblOrdenDePago);
		
		jpSolicitudCheque = new JPanel();
		jpSolicitudCheque.setBackground(new Color(173, 216, 230));
		jpSolicitudCheque.setBorder(new TitledBorder(null, "SOLICITUD DE CHEQUE", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		jpSolicitudCheque.setBounds(10, 113, 539, 219);
		panel.add(jpSolicitudCheque);
		jpSolicitudCheque.setLayout(null);
		
		JLabel lblSolicitante = new JLabel("SOLICITANTE:");
		lblSolicitante.setBounds(10, 35, 101, 14);
		jpSolicitudCheque.add(lblSolicitante);
		
		JLabel lblDepartamento = new JLabel("DEPARTAMENTO:");
		lblDepartamento.setBounds(10, 64, 110, 14);
		jpSolicitudCheque.add(lblDepartamento);
		
		JLabel lblTipoDeSalida = new JLabel("TIPO DE SALIDA DE EFECTIVO:");
		lblTipoDeSalida.setBounds(10, 96, 172, 14);
		jpSolicitudCheque.add(lblTipoDeSalida);
		
		JLabel lblChequeANombrede = new JLabel("CHEQUE A NOMBRE DE:");
		lblChequeANombrede.setBounds(10, 129, 142, 14);
		jpSolicitudCheque.add(lblChequeANombrede);
		
		jcbProveedores = new JComboBox();
		jcbProveedores.setBackground(new Color(135, 206, 250));
		jcbProveedores.setModel(new DefaultComboBoxModel(new String[] {"Proveedores..."}));
		jcbProveedores.setBounds(162, 126, 367, 20);
		jpSolicitudCheque.add(jcbProveedores);
		
		JLabel lblPorConceptoDe = new JLabel("POR CONCEPTO DE:");
		lblPorConceptoDe.setBounds(10, 190, 122, 14);
		jpSolicitudCheque.add(lblPorConceptoDe);
		
		jcbServicios = new JComboBox();
		jcbServicios.setEnabled(false);
		jcbServicios.setBackground(new Color(135, 206, 250));
		jcbServicios.setModel(new DefaultComboBoxModel(new String[] {"Servicios..."}));
		jcbServicios.setBounds(162, 187, 367, 20);
		jpSolicitudCheque.add(jcbServicios);
		
		JLabel lblPorElImporte = new JLabel("POR EL IMPORTE DE:");
		lblPorElImporte.setBounds(10, 159, 122, 14);
		jpSolicitudCheque.add(lblPorElImporte);
		
		txtImporte = new JTextField();
		txtImporte.setBackground(new Color(135, 206, 250));
		txtImporte.setBounds(161, 156, 44, 20);
		jpSolicitudCheque.add(txtImporte);
		txtImporte.setColumns(10);
		
		JLabel lblImporteletra = new JLabel("IMPORTE (LETRA):");
		lblImporteletra.setBounds(215, 162, 114, 14);
		jpSolicitudCheque.add(lblImporteletra);
		
		txtImporteLetra = new JTextField();
		txtImporteLetra.setBackground(new Color(135, 206, 250));
		txtImporteLetra.setBounds(339, 156, 190, 20);
		jpSolicitudCheque.add(txtImporteLetra);
		txtImporteLetra.setColumns(10);
		
		JLabel lblConstante1 = new JLabel("C.P. Armando Mendoza Delgado");
		lblConstante1.setBounds(121, 35, 174, 14);
		jpSolicitudCheque.add(lblConstante1);
		
		JLabel lblConstante2 = new JLabel("Estadio Azul");
		lblConstante2.setBounds(121, 64, 157, 14);
		jpSolicitudCheque.add(lblConstante2);
		
		rdbtnCheque = new JRadioButton("Cheque");
		rdbtnCheque.setBackground(new Color(173, 216, 230));
		rdbtnCheque.setBounds(186, 92, 109, 23);
		jpSolicitudCheque.add(rdbtnCheque);
		rdbtnCheque.setSelected(true);
		
		rdbtnTransferenciaBancaria = new JRadioButton("Transferencia Bancaria");
		rdbtnTransferenciaBancaria.setBackground(new Color(173, 216, 230));
		rdbtnTransferenciaBancaria.setBounds(322, 92, 157, 23);
		jpSolicitudCheque.add(rdbtnTransferenciaBancaria);
		
		grupoPago = new ButtonGroup();
		grupoPago.add(rdbtnCheque);
		grupoPago.add(rdbtnTransferenciaBancaria);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(173, 216, 230));
		panel_1.setBorder(new TitledBorder(null, "PARA USO DE CONTABILIDAD", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 343, 539, 63);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblAplicacinContable = new JLabel("APLICACI\u00D3N CONTABLE:");
		lblAplicacinContable.setBounds(10, 27, 144, 14);
		panel_1.add(lblAplicacinContable);
		
		jcbAplicacion = new JComboBox();
		jcbAplicacion.setBackground(new Color(135, 206, 250));
		jcbAplicacion.setModel(new DefaultComboBoxModel(new String[] {"...", "FAVOR DE PAGAR ANTES DEL D\u00CDA X", "SE ANEXA EL ESTADO BANCARIO DE LA CUENTA PARA SU PAGO"}));
		jcbAplicacion.setBounds(164, 24, 365, 20);
		panel_1.add(jcbAplicacion);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(173, 216, 230));
		panel_2.setBorder(new TitledBorder(null, "SOLICIT\u00D3", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 417, 245, 47);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblSolicito = new JLabel("Lic. Pedro Ruiz Isunza");
		lblSolicito.setHorizontalAlignment(SwingConstants.CENTER);
		lblSolicito.setBounds(10, 11, 225, 14);
		panel_2.add(lblSolicito);
		
		JLabel lblGerenteDerea = new JLabel("GERENTE DE \u00C1REA");
		lblGerenteDerea.setHorizontalAlignment(SwingConstants.CENTER);
		lblGerenteDerea.setBounds(61, 22, 122, 14);
		panel_2.add(lblGerenteDerea);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(173, 216, 230));
		panel_3.setBorder(new TitledBorder(null, "AUTORIZ\u00D3", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_3.setBounds(287, 417, 262, 47);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblAutorizo = new JLabel("C.P. Isaac Velasco Alcantara");
		lblAutorizo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutorizo.setBounds(10, 11, 242, 14);
		panel_3.add(lblAutorizo);
		
		JLabel lblDireccinDerea = new JLabel("DIRECCI\u00D3N DE \u00C1REA");
		lblDireccinDerea.setHorizontalAlignment(SwingConstants.CENTER);
		lblDireccinDerea.setBounds(76, 22, 115, 14);
		panel_3.add(lblDireccinDerea);
		
		JLabel lblNotaEnCaso = new JLabel("NOTA: EN CASO DE NO EFECTUAR LA COMPROBACI\u00D3N DENTRO DE LOS 15 D\u00CDAS POSTERIORES SE PROCEDER\u00C1 ");
		lblNotaEnCaso.setForeground(Color.BLACK);
		lblNotaEnCaso.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNotaEnCaso.setHorizontalAlignment(SwingConstants.LEFT);
		lblNotaEnCaso.setBounds(10, 463, 539, 20);
		panel.add(lblNotaEnCaso);
		
		JLabel lblSeProcederA = new JLabel("A APLICAR EN LA QUINCENA INMEDIATA EL DESCUENTO CONRRESPONDIENTE POR VIA N\u00D3MINA.");
		lblSeProcederA.setForeground(Color.BLACK);
		lblSeProcederA.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblSeProcederA.setBounds(10, 484, 529, 14);
		panel.add(lblSeProcederA);
		
		JLabel lblTitulo = new JLabel("");
		lblTitulo.setIcon(new ImageIcon(OrdenPago.class.getResource("/com/lords/resources/img/titulo-CRUZAZUL.png")));
		lblTitulo.setBounds(110, 47, 324, 55);
		panel.add(lblTitulo);
		
		JLabel lblFechaDeElaboracin = new JLabel("FECHA DE ");
		lblFechaDeElaboracin.setForeground(Color.BLACK);
		lblFechaDeElaboracin.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblFechaDeElaboracin.setBounds(444, 47, 105, 14);
		panel.add(lblFechaDeElaboracin);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(OrdenPago.class.getResource("/com/lords/resources/img/logo.png")));
		lblLogo.setBounds(23, 47, 55, 55);
		panel.add(lblLogo);
		
		JLabel lblElaboracin = new JLabel("ELABORACI\u00D3N");
		lblElaboracin.setForeground(Color.BLACK);
		lblElaboracin.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblElaboracin.setBounds(444, 60, 95, 14);
		panel.add(lblElaboracin);
		
		btnSalir = new JButton("");
		btnSalir.setIcon(new ImageIcon(OrdenPago.class.getResource("/com/lords/resources/img/boton-REGRESAR.png")));
		btnSalir.setBounds(62, 509, 117, 36);
		panel.add(btnSalir);
		
		btnGuardar = new JButton("");
		btnGuardar.setIcon(new ImageIcon(OrdenPago.class.getResource("/com/lords/resources/img/boton-GUARDAR.png")));
		btnGuardar.setBounds(365, 509, 117, 36);
		panel.add(btnGuardar);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFondo.setIcon(new ImageIcon(OrdenPago.class.getResource("/com/lords/resources/img/fondo2.jpg")));
		lblFondo.setBounds(0, 0, 569, 569);
		panel.add(lblFondo);
	}
}
