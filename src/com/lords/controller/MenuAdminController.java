package com.lords.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.lords.views.Captura_facturas;
import com.lords.views.Login;
import com.lords.views.Menu_admin;

public class MenuAdminController implements ActionListener{

	private Menu_admin view;
	
	Captura_facturas capturaFact = new Captura_facturas();
	Menu_admin menu = new Menu_admin();
	
	public MenuAdminController(Menu_admin menuAd){
		this.view = menuAd;
		addListener();
	}
	
	private void addListener(){
		view.btnFacturas.addActionListener(this);
		view.btnOrdenesPago.addActionListener(this);
		view.btnProveedores.addActionListener(this);
		view.btnServicios.addActionListener(this);
		view.btnUsuarios.addActionListener(this);
		view.btnSalir.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.btnFacturas){
			view.dispose();
			capturaFact.setLocationRelativeTo(null);
			capturaFact.setVisible(true);
			return;
		}
		if(e.getSource() == view.btnOrdenesPago){
			return;
		}
		if(e.getSource() == view.btnProveedores){
			return;
		}
		if(e.getSource() == view.btnServicios){
			return;
		}
		if(e.getSource() == view.btnUsuarios){
			return;
		}
		if(e.getSource() == view.btnSalir){
			Login log = new Login();
			view.dispose();
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
