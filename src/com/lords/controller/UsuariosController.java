package com.lords.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

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
			agregarUsuario();
		}else if(e.getSource().equals(usuariosView.btnSalir)){
			usuariosControlView.setVisible(true);
			usuariosView.dispose();
		}else if(e.getSource().equals(usuariosControlView.btnAgregar)){
			usuariosControlView.setVisible(false);
			usuariosControlView.dispose();
			usuariosView.setLocationRelativeTo(null);
			usuariosView.setUndecorated(true);
			usuariosView.setVisible(true);
		}else if(e.getSource().equals(usuariosControlView.btnBuscar)){
			System.out.println("ok");
		}else if(e.getSource().equals(usuariosControlView.btnSalir)){
			
		}
		
	}

	private void agregarUsuario() {
		if(usuariosView.txtNombre.getText().isEmpty()
				|| usuariosView.txtApPaterno.getText().isEmpty()
				|| usuariosView.txtApMaterno.getText().isEmpty()
				|| usuariosView.txtPassword.getText().isEmpty()
				|| usuariosView.txtUsername.getText().isEmpty()
				|| usuariosView.txtPassword.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Campos vacios");
		}else if (usuariosView.txtPassword.getText()!=usuariosView.txtPassword2.getText()){
			JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
		}
	}
}
