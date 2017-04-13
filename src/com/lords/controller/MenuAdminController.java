package com.lords.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.lords.views.Captura_facturas;
import com.lords.views.Login;
import com.lords.views.Menu_admin;

public class MenuAdminController implements ActionListener{

	private Menu_admin vistaMenu;
	
	
	Captura_facturas capturaFact = new Captura_facturas();
	Menu_admin menu = new Menu_admin();
	
	public MenuAdminController(Menu_admin menuAd){
		this.vistaMenu = menuAd;
		vistaMenu.btnFacturas.addActionListener(this);
		vistaMenu.btnOrdenesPago.addActionListener(this);
		vistaMenu.btnProveedores.addActionListener(this);
		vistaMenu.btnServicios.addActionListener(this);
		vistaMenu.btnUsuarios.addActionListener(this);
		vistaMenu.btnSalir.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(vistaMenu.btnFacturas)){
			System.out.println("Entro");
			vistaMenu.dispose();
			capturaFact.setLocationRelativeTo(null);
			capturaFact.setVisible(true);
			return;
		}
		if(e.getSource() == vistaMenu.btnOrdenesPago){
			return;
		}
		if(e.getSource() == vistaMenu.btnProveedores){
			return;
		}
		if(e.getSource() == vistaMenu.btnServicios){
			return;
		}
		if(e.getSource() == vistaMenu.btnUsuarios){
			return;
		}
		if(e.getSource() == vistaMenu.btnSalir){
			Login log = new Login();
			vistaMenu.dispose();
			menu.setVisible(false);
			try {
	            log.setLocationRelativeTo(null);
				log.setUndecorated(true);
				log.setVisible(true);
			} catch (Exception ex) {
				ex.printStackTrace();
			}//CATCH
		}
	}
}
