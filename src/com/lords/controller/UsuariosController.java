package com.lords.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.lords.views.MenuAdmin;
import com.lords.views.RegistroUsuarios;

public class UsuariosController implements ActionListener{

	RegistroUsuarios usuariosView = new RegistroUsuarios();
	RegistroUsuarios usuarios;
	
	MenuAdmin vistaMenu;
	MenuAdminController controllerMenu;
	
	public UsuariosController(RegistroUsuarios vistaUsuarios){
		this.usuariosView = vistaUsuarios;
		vistaUsuarios.btnRegistrar.addActionListener(this);
		vistaUsuarios.btnSalir.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(usuariosView.btnRegistrar)){
			
		}else if(e.getSource().equals(usuariosView.btnSalir)){
			
		}
		
	}
}
