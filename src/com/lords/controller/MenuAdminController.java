package com.lords.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.lords.views.Captura_facturas;
import com.lords.views.Menu_admin;

public class MenuAdminController implements ActionListener{

	Menu_admin menuAd = new Menu_admin();
	
	Captura_facturas capturaFact = new Captura_facturas();
	public MenuAdminController(Menu_admin menuAd){
		this.menuAd = menuAd;
		menuAd.btnFacturas.addActionListener(this);
		menuAd.btnOrdenesPago.addActionListener(this);
		menuAd.btnProveedores.addActionListener(this);
		menuAd.btnProveedores.addActionListener(this);
		menuAd.btnSalir.addActionListener(this);
		menuAd.btnUsuarios.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(menuAd.btnFacturas)){
			JOptionPane.showMessageDialog(null, "Escuchado Facturas");
		}else if(arg0.getSource().equals(menuAd.btnServicios)){
			JOptionPane.showMessageDialog(null, "Escuchado Servicios");
		}else if(arg0.getSource().equals(menuAd.btnUsuarios)){
			JOptionPane.showMessageDialog(null, "Escuchado Usuario");
		}else if(arg0.getSource().equals(menuAd.btnOrdenesPago)){
			JOptionPane.showMessageDialog(null, "Escuchado Ordenes");
		}else if(arg0.getSource().equals(menuAd.btnProveedores)){
			JOptionPane.showMessageDialog(null, "Escuchado Proveedores");
		}else if(arg0.getSource().equals(menuAd.btnSalir)){
			JOptionPane.showMessageDialog(null, "Salida");
		}
		
	}
	
	

}
