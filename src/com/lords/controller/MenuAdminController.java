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
	
	public MenuAdminController(Menu_admin menuAd) {
		super();
		
		menuAd.btnFacturas.addActionListener(this);;
		menuAd.btnOrdenesDePago.addActionListener(this);
		menuAd.btnProveedores.addActionListener(this);
		menuAd.btnUsuarios.addActionListener(this);
		this.menuAd = menuAd;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JOptionPane.showMessageDialog(null, "Escuchado");
	}
	
	

}
