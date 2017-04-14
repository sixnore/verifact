package com.lords.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.lords.views.ControlUsuarios;
import com.lords.views.MenuAdmin;
import com.lords.views.RegistroUsuarios;

public class UsuariosController implements ActionListener{

	RegistroUsuarios usuariosView = new RegistroUsuarios();
	RegistroUsuarios usuarios;
	
	ControlUsuarios usuariosControlView = new ControlUsuarios();
	ControlUsuarios usuariosControl;
	
	MenuAdmin vistaMenu;
	MenuAdminController controllerMenu;
	
	public UsuariosController(RegistroUsuarios vistaUsuarios, ControlUsuarios vistaControlUsuarios){
		this.usuariosView = vistaUsuarios;
		this.usuariosControlView = vistaControlUsuarios;
		
		vistaUsuarios.btnRegistrar.addActionListener(this);
		vistaUsuarios.btnSalir.addActionListener(this);
		
		vistaControlUsuarios.btnAgregar.addActionListener(this);
		vistaControlUsuarios.btnBuscar.addActionListener(this);
		vistaControlUsuarios.btnSalir.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(usuariosView.btnRegistrar)){
			System.out.println("ok");
		}else if(e.getSource().equals(usuariosView.btnSalir)){
			System.out.println("ok");
		}else if(e.getSource().equals(usuariosControlView.btnAgregar)){
			System.out.println("ok");
		}else if(e.getSource().equals(usuariosControlView.btnBuscar)){
			System.out.println("ok");
		}else if(e.getSource().equals(usuariosControlView.btnSalir)){
			System.out.println("ok");
		}
		
	}
}
