package com.lords.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class OrdenPago extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrdenPago frame = new OrdenPago();
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
	public OrdenPago() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(415, 11, 134, 20);
		panel.add(dateChooser);
		
		JLabel lblOrdenDePago = new JLabel("ORDEN DE PAGO");
		lblOrdenDePago.setFont(new Font("Futura Md BT", Font.BOLD, 20));
		lblOrdenDePago.setBounds(187, 11, 189, 25);
		panel.add(lblOrdenDePago);
		
		JPanel jpSolicitudCheque = new JPanel();
		jpSolicitudCheque.setBorder(new TitledBorder(null, "SOLICITUD DE CHEQUE", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		jpSolicitudCheque.setBounds(10, 54, 539, 219);
		panel.add(jpSolicitudCheque);
		jpSolicitudCheque.setLayout(null);
		
		JLabel lblSolicitante = new JLabel("SOLICITANTE:");
		lblSolicitante.setBounds(10, 35, 76, 14);
		jpSolicitudCheque.add(lblSolicitante);
		
		textField = new JTextField();
		textField.setBounds(100, 32, 129, 20);
		jpSolicitudCheque.add(textField);
		textField.setColumns(10);
		
		JLabel lblDepartamento = new JLabel("DEPARTAMENTO:");
		lblDepartamento.setBounds(10, 64, 92, 14);
		jpSolicitudCheque.add(lblDepartamento);
		
		textField_1 = new JTextField();
		textField_1.setBounds(100, 61, 129, 20);
		jpSolicitudCheque.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblTipoDeSalida = new JLabel("TIPO DE SALIDA DE EFECTIVO:");
		lblTipoDeSalida.setBounds(10, 96, 157, 14);
		jpSolicitudCheque.add(lblTipoDeSalida);
		
		JCheckBox chckbxCheque = new JCheckBox("CHEQUE");
		chckbxCheque.setBounds(188, 92, 97, 23);
		jpSolicitudCheque.add(chckbxCheque);
		
		JCheckBox chckbxTransferencia = new JCheckBox("TRANSFERENCIA");
		chckbxTransferencia.setBounds(293, 92, 122, 23);
		jpSolicitudCheque.add(chckbxTransferencia);
		
		JLabel lblChequeANombrede = new JLabel("CHEQUE A NOMBRE DE:");
		lblChequeANombrede.setBounds(10, 129, 122, 14);
		jpSolicitudCheque.add(lblChequeANombrede);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Proveedores.."}));
		comboBox.setBounds(142, 126, 273, 20);
		jpSolicitudCheque.add(comboBox);
		
		JLabel lblPorConceptoDe = new JLabel("POR CONCEPTO DE:");
		lblPorConceptoDe.setBounds(10, 190, 110, 14);
		jpSolicitudCheque.add(lblPorConceptoDe);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Servicios..."}));
		comboBox_1.setBounds(142, 187, 273, 20);
		jpSolicitudCheque.add(comboBox_1);
		
		JLabel lblPorElImporte = new JLabel("POR EL IMPORTE DE:");
		lblPorElImporte.setBounds(10, 159, 122, 14);
		jpSolicitudCheque.add(lblPorElImporte);
		
		textField_2 = new JTextField();
		textField_2.setBounds(143, 156, 62, 20);
		jpSolicitudCheque.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblImporteletra = new JLabel("IMPORTE (LETRA):");
		lblImporteletra.setBounds(215, 162, 92, 14);
		jpSolicitudCheque.add(lblImporteletra);
		
		textField_3 = new JTextField();
		textField_3.setBounds(317, 156, 212, 20);
		jpSolicitudCheque.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.setBounds(440, 125, 89, 23);
		jpSolicitudCheque.add(btnAgregar);
		
		JButton btnAgregar_1 = new JButton("AGREGAR");
		btnAgregar_1.setBounds(440, 186, 89, 23);
		jpSolicitudCheque.add(btnAgregar_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "PARA USO DE CONTABILIDAD", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 284, 539, 63);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblAplicacinContable = new JLabel("APLICACI\u00D3N CONTABLE:");
		lblAplicacinContable.setBounds(10, 27, 130, 14);
		panel_1.add(lblAplicacinContable);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"...", "FAVOR DE PAGAR ANTES DEL D\u00CDA X", "SE ANEXA EL ESTADO BANCARIO DE LA CUENTA PARA SU PAGO"}));
		comboBox_2.setBounds(150, 24, 379, 20);
		panel_1.add(comboBox_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "SOLICIT\u00D3", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 358, 245, 36);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblLicPedroRuiz = new JLabel("Lic. Pedro Ruiz Isunza");
		lblLicPedroRuiz.setHorizontalAlignment(SwingConstants.CENTER);
		lblLicPedroRuiz.setBounds(10, 11, 225, 14);
		panel_2.add(lblLicPedroRuiz);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "AUTORIZ\u00D3", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_3.setBounds(287, 358, 262, 36);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblCpIsaacVelasco = new JLabel("C.P. Isaac Velasco Alcantara");
		lblCpIsaacVelasco.setHorizontalAlignment(SwingConstants.CENTER);
		lblCpIsaacVelasco.setBounds(10, 11, 242, 14);
		panel_3.add(lblCpIsaacVelasco);
		
		JLabel lblNotaEnCaso = new JLabel("NOTA: EN CASO DE NO EFECTUAR LA COMPROBACI\u00D3N DENTRO DE LOS 15 D\u00CDAS POSTERIORES SE PROCEDER\u00C1 ");
		lblNotaEnCaso.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNotaEnCaso.setHorizontalAlignment(SwingConstants.LEFT);
		lblNotaEnCaso.setBounds(10, 398, 539, 20);
		panel.add(lblNotaEnCaso);
		
		JLabel lblSeProcederA = new JLabel("A APLICAR EN LA QUINCENA INMEDIATA EL DESCUENTO CONRRESPONDIENTE POR VIA N\u00D3MINA.");
		lblSeProcederA.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblSeProcederA.setBounds(10, 419, 529, 14);
		panel.add(lblSeProcederA);
	}
}
