package com.lords.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.lords.views.Login;
import com.lords.views.MenuAdmin;
import com.lords.views.Proveedores;

public class ProvController  implements ActionListener{
	
	Proveedores proveedorView = new Proveedores();
	
	MenuAdmin vistaMenu;
	MenuAdminController controllerMenu;
	
	Proveedores proveedor;
	
	public ProvController(Proveedores proveedorView){
		this.proveedorView = proveedorView;
		proveedorView.btnAgregar.addActionListener(this);
		proveedorView.btnConsultar.addActionListener(this);
		proveedorView.btnModificar.addActionListener(this);
		proveedorView.btnSalir.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(proveedorView.btnAgregar)){
			System.out.println("ok");
		}else if(arg0.getSource().equals(proveedorView.btnConsultar)){
			System.out.println("ok");
		}else if(arg0.getSource().equals(proveedorView.btnModificar)){
			System.out.println("ok");
		}else if(arg0.getSource().equals(proveedorView.btnSalir)){
			proveedorView.dispose();
			proveedorView.setVisible(false);
			try{
				vistaMenu = new MenuAdmin();
				vistaMenu.setLocationRelativeTo(null);
				vistaMenu.setUndecorated(true);
				vistaMenu.setVisible(true);
				controllerMenu = new MenuAdminController(vistaMenu);
			}catch(Exception ex){
				
			}
		}
	}

}
