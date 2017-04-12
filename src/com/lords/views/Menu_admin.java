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

public class Menu_admin extends JFrame {

	public JPanel contentPane;
	public JButton btnFacturas;
	public JButton btnServicios;
	public JButton btnUsuarios;
	private JLabel label;
	public JButton btnProveedores;
	public JButton btnOrdenesPago;
	public JButton btnSalir;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_admin frame = new Menu_admin();
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
	public Menu_admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image icono = Toolkit.getDefaultToolkit().getImage("src/com/lords/resources/img/icono-VERIFACT.png");
        this.setIconImage(icono); 
		setBounds(100, 100, 460, 650);
		contentPane = new JPanel();
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
		btnFacturas.setBackground(Color.WHITE);
		btnFacturas.setIcon(new ImageIcon(Menu_admin.class.getResource("/com/lords/resources/img/boton-FACTURA.png")));
		btnFacturas.setBounds(39, 45, 166, 193);
		panel.add(btnFacturas);
		
		btnUsuarios = new JButton("");
		btnUsuarios.setBackground(Color.WHITE);
		btnUsuarios.setIcon(new ImageIcon(Menu_admin.class.getResource("/com/lords/resources/img/boton-USUARIOS.png")));
		btnUsuarios.setBounds(239, 45, 175, 193);
		panel.add(btnUsuarios);
		
		btnServicios = new JButton("");
		btnServicios.setBackground(Color.WHITE);
		btnServicios.setIcon(new ImageIcon(Menu_admin.class.getResource("/com/lords/resources/img/boton-SERVICIOS.png")));
		btnServicios.setBounds(39, 249, 166, 170);
		panel.add(btnServicios);
		
		btnProveedores = new JButton("");
		btnProveedores.setBackground(Color.WHITE);
		btnProveedores.setIcon(new ImageIcon(Menu_admin.class.getResource("/com/lords/resources/img/boton-PROVEEDORES.png")));
		btnProveedores.setBounds(239, 248, 166, 171);
		panel.add(btnProveedores);
		
		btnOrdenesPago = new JButton("");
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
		label.setBounds(0, 0, 460, 650);
		panel.add(label);
	}
	
	private void salir(){
		Login vistaLogin = new Login();
		this.setVisible(false);
		try {
            vistaLogin.setLocationRelativeTo(null);
			vistaLogin.setUndecorated(true);
			vistaLogin.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}//CATCH
	}
}
