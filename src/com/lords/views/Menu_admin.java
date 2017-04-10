package com.lords.views;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu_admin extends JFrame {

	private JPanel contentPane;

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
		setBounds(100, 100, 450, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblMenu = new JLabel("MENU");
		lblMenu.setBounds(191, 24, 46, 14);
		panel.add(lblMenu);
		
		JButton btnFacturas = new JButton("FACTURAS");
		btnFacturas.setBounds(66, 113, 113, 23);
		panel.add(btnFacturas);
		
		JButton btnUsuarios = new JButton("USUARIOS");
		btnUsuarios.setBounds(249, 113, 113, 23);
		panel.add(btnUsuarios);
		
		JButton btnProveedores = new JButton("PROVEEDORES");
		btnProveedores.setBounds(249, 196, 113, 23);
		panel.add(btnProveedores);
		
		JButton btnServicios = new JButton("SERVICIOS");
		btnServicios.setBounds(66, 196, 113, 23);
		panel.add(btnServicios);
		
		JButton btnOrdenesDePago = new JButton("ORDENES DE PAGO");
		btnOrdenesDePago.setBounds(147, 267, 140, 23);
		panel.add(btnOrdenesDePago);
	}

}
