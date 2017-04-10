package com.lords.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.lords.views.Menu_admin;

public class MenuAdminController implements ActionListener{

	Menu_admin menuAd = new Menu_admin();
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(menuAd.btnAcceder)){
			acceder();
		}
	}

}
