package com.lords.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;

import javax.swing.JOptionPane;

import com.lords.model.UsuarioModel;
import com.lords.views.Login;
import com.lords.views.Menu_admin;

public class MenuAdminController implements ActionListener{

	Menu_admin menuAd = new Menu_admin();
	
	public MenuAdminController() {
		super();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(menuAd.btnFacturas)){
			JOptionPane.showMessageDialog(null, "Escuchado Facturas");
		}else if(arg0.getSource().equals(menuAd.btnOrdenesDePago)){
			JOptionPane.showMessageDialog(null, "Escuchado Ordenes");
		}else if(arg0.getSource().equals(menuAd.btnProveedores)){
			JOptionPane.showMessageDialog(null, "Escuchado Proveedores");
		}else if(arg0.getSource().equals(menuAd.btnUsuarios)){
			JOptionPane.showMessageDialog(null, "Escuchado Usuario");
		}
	}
	
	

}
