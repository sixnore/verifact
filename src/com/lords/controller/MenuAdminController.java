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
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == view.btnFacturas){
			view.dispose();
			capturaFact.setLocationRelativeTo(null);
			capturaFact.setVisible(true);
			return;
		}
		if(arg0.getSource() == view.btnOrdenesPago){
			return;
		}
		if(arg0.getSource() == view.btnProveedores){
			return;
		}
		if(arg0.getSource() == view.btnServicios){
			return;
		}
		if(arg0.getSource() == view.btnUsuarios){
			return;
		}
		if(arg0.getSource() == view.btnSalir){
			Login log = new Login();
			view.dispose();
			log.setLocationRelativeTo(null);
			log.setVisible(true);
			return;
		}
	}
}
