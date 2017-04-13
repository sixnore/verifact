package com.lords.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.lords.views.Login;
import com.lords.views.MenuAdmin;
import com.lords.views.Proveedores;

public class ProvController  implements ActionListener{
	
	Proveedores proveedor = new Proveedores();
	
	
	MenuAdminController principal;
	
	Proveedores proveedorView;
	MenuAdmin vistaMenu;
	
	
	public ProvController(Proveedores proveedorView){
		this.proveedor = proveedorView;
		proveedorView.btnAgregar.addActionListener(this);
		proveedorView.btnConsultar.addActionListener(this);
		proveedorView.btnModificar.addActionListener(this);
		proveedorView.btnSalir.addActionListener(this);
		principal = new MenuAdminController(vistaMenu);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(proveedor.btnAgregar)){
			System.out.println("ok");
		}else if(arg0.getSource().equals(proveedor.btnConsultar)){
			System.out.println("ok");
		}else if(arg0.getSource().equals(proveedor.btnModificar)){
			System.out.println("ok");
		}else if(arg0.getSource().equals(proveedor.btnSalir)){
			proveedor.dispose();
			proveedor.setVisible(false);
			try{
				vistaMenu = new MenuAdmin();
				vistaMenu.setVisible(true);
				vistaMenu.setUndecorated(false);
				vistaMenu.setLocationRelativeTo(null);
				principal = new MenuAdminController(vistaMenu);
			}catch(Exception ex){
				
			}
		}
	}

}
