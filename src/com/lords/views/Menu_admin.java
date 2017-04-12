package com.lords.views;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.lords.model.UsuarioModel;
import com.mysql.jdbc.PreparedStatement;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Menu_admin extends JFrame {

	public JPanel contentPane;
	public JButton btnFacturas;
	public JButton btnServicios;
	public JButton btnUsuarios;
	private JLabel label;
	private JButton btnProveedores;
	private JButton btnOrdenesPago;
	private JButton btnSalir;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_admin frame = new Menu_admin();
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
	public Menu_admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 685);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblMenu = new JLabel("MENU");
		lblMenu.setFont(new Font("Futura Md BT", Font.BOLD, 30));
		lblMenu.setBounds(179, 11, 114, 23);
		panel.add(lblMenu);
		
		btnFacturas = new JButton("");
		btnFacturas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirCapturaFact();
			}
		});
		btnFacturas.setBackground(Color.WHITE);
		btnFacturas.setIcon(new ImageIcon(Menu_admin.class.getResource("/com/lords/resources/img/boton-FACTURA.png")));
		btnFacturas.setBounds(39, 45, 166, 193);
		panel.add(btnFacturas);
		
		btnUsuarios = new JButton("");
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirUsuarios();
			}
		});
		btnUsuarios.setBackground(Color.WHITE);
		btnUsuarios.setIcon(new ImageIcon(Menu_admin.class.getResource("/com/lords/resources/img/boton-USUARIOS.png")));
		btnUsuarios.setBounds(239, 45, 175, 193);
		panel.add(btnUsuarios);
		
		btnServicios = new JButton("");
		btnServicios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirServicios();
			}
		});
		btnServicios.setBackground(Color.WHITE);
		btnServicios.setIcon(new ImageIcon(Menu_admin.class.getResource("/com/lords/resources/img/boton-SERVICIOS.png")));
		btnServicios.setBounds(39, 249, 166, 170);
		panel.add(btnServicios);
		
		btnProveedores = new JButton("");
		btnProveedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirProveedores();
			}
		});
		btnProveedores.setBackground(Color.WHITE);
		btnProveedores.setIcon(new ImageIcon(Menu_admin.class.getResource("/com/lords/resources/img/boton-PROVEEDORES.png")));
		btnProveedores.setBounds(239, 248, 166, 171);
		panel.add(btnProveedores);
		
		btnOrdenesPago = new JButton("");
		btnOrdenesPago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				abrirOrdenesPago();
			}
		});
		btnOrdenesPago.setBackground(Color.WHITE);
		btnOrdenesPago.setIcon(new ImageIcon(Menu_admin.class.getResource("/com/lords/resources/img/boton-ORDENES_PAGO.png")));
		btnOrdenesPago.setBounds(39, 430, 166, 170);
		panel.add(btnOrdenesPago);
		
		btnSalir = new JButton("");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salir();
			}
		});
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setIcon(new ImageIcon(Menu_admin.class.getResource("/com/lords/resources/img/boton-SALIR.png")));
		btnSalir.setBounds(239, 430, 166, 170);
		panel.add(btnSalir);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(Menu_admin.class.getResource("/com/lords/resources/img/blue_and_white-wallpaper-1920x1080.jpg")));
		label.setBounds(0, 0, 447, 636);
		panel.add(label);
	}
	
	private void salir(){
		UsuarioModel usuarioModel = new UsuarioModel();
		usuarioModel.setUsername(null);
		usuarioModel.setPassword(null);
		Login log = new Login();
		log.setLocationRelativeTo(null);
		log.setVisible(true);
		this.dispose();
	}
	
	private void abrirCapturaFact(){
		Captura_facturas capturaFac = new Captura_facturas();
		capturaFac.setVisible(true);
		capturaFac.setLocationRelativeTo(null);
		this.dispose();
	}

	private void abrirUsuarios(){
		
	}
	
	private void abrirServicios(){
		
	}
	
	private void abrirProveedores(){
		
	}
	
	private void abrirOrdenesPago(){
		
	}
}
