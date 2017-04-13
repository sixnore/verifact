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
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;

public class MenuAdmin extends JFrame {

	public JLabel label;
	public JPanel contentPane;
	public JButton btnFacturas;
	public JButton btnServicios;
	public JButton btnUsuarios;
	public JButton btnProveedores;
	public JButton btnOrdenesPago;
	public JButton btnSalir;
	
	
	public JButton getBtnFacturas() {
		return btnFacturas;
	}

	public JButton getBtnServicios() {
		return btnServicios;
	}

	public JButton getBtnUsuarios() {
		return btnUsuarios;
	}

	public JButton getBtnProveedores() {
		return btnProveedores;
	}

	public JButton getBtnOrdenesPago() {
		return btnOrdenesPago;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuAdmin frame = new MenuAdmin();
                    frame.setLocationRelativeTo(null);
					frame.setUndecorated(true);
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
	public MenuAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image icono = Toolkit.getDefaultToolkit().getImage("src/com/lords/resources/img/icono-VERIFACT.png");
        this.setIconImage(icono); 
		setBounds(100, 100, 444, 239);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblMenu = new JLabel("MENU");
		lblMenu.setBackground(new Color(0, 0, 0));
		lblMenu.setForeground(new Color(0, 0, 0));
		lblMenu.setFont(new Font("Futura Md BT", Font.BOLD, 30));
		lblMenu.setBounds(179, 11, 114, 23);
		panel.add(lblMenu);
		
		btnFacturas = new JButton("");
		btnFacturas.setBackground(Color.WHITE);
		btnFacturas.setIcon(new ImageIcon(MenuAdmin.class.getResource("/com/lords/resources/img/boton-FACTURA.png")));
		btnFacturas.setBounds(10, 45, 194, 38);
		panel.add(btnFacturas);
		
		btnUsuarios = new JButton("");
		btnUsuarios.setBackground(Color.WHITE);
		btnUsuarios.setIcon(new ImageIcon(MenuAdmin.class.getResource("/com/lords/resources/img/boton-USUARIOS.png")));
		btnUsuarios.setBounds(239, 45, 194, 38);
		panel.add(btnUsuarios);
		
		btnServicios = new JButton("");
		btnServicios.setBackground(Color.WHITE);
		btnServicios.setIcon(new ImageIcon(MenuAdmin.class.getResource("/com/lords/resources/img/boton-SERVICIOS.png")));
		btnServicios.setBounds(10, 103, 194, 38);
		panel.add(btnServicios);
		
		btnProveedores = new JButton("");
		btnProveedores.setBackground(Color.WHITE);
		btnProveedores.setIcon(new ImageIcon(MenuAdmin.class.getResource("/com/lords/resources/img/boton-PROVEEDORES.png")));
		btnProveedores.setBounds(239, 103, 194, 38);
		panel.add(btnProveedores);
		
		btnOrdenesPago = new JButton("");
		btnOrdenesPago.setBackground(Color.WHITE);
		btnOrdenesPago.setIcon(new ImageIcon(MenuAdmin.class.getResource("/com/lords/resources/img/boton-ORDENES_PAGO.png")));
		btnOrdenesPago.setBounds(10, 161, 194, 38);
		panel.add(btnOrdenesPago);
		
		btnSalir = new JButton("");
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setIcon(new ImageIcon(MenuAdmin.class.getResource("/com/lords/resources/img/boton-SALIR.png")));
		btnSalir.setBounds(239, 162, 194, 38);
		panel.add(btnSalir);
		
		label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setIcon(new ImageIcon(MenuAdmin.class.getResource("/com/lords/resources/img/fondo1.jpg")));
		label.setBounds(0, 0, 444, 239);
		panel.add(label);
	}
}
