package com.lords.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.lords.model.UsuarioModel;
import com.lords.views.ControlUsuarios;
import com.lords.views.MenuAdmin;
import com.lords.views.RegistroUsuarios;

public class UsuariosController implements ActionListener{

	RegistroUsuarios usuariosView = new RegistroUsuarios();
	RegistroUsuarios usuarios;
	
	UsuarioModel usuarioModel=new UsuarioModel();
	
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
			usuariosControlView.setVisible(false);
			usuariosControlView.dispose();
			try{
				vistaMenu = new MenuAdmin();
				vistaMenu.setLocationRelativeTo(null);
				vistaMenu.setUndecorated(true);
				vistaMenu.setVisible(true);
				controllerMenu = new MenuAdminController(vistaMenu);
			}catch(Exception ex){
				ex.printStackTrace();
			}	
		}
		
	}

	private void agregarUsuario() {
		String contrasena1,contrasena2;
		int estatus=0;
		contrasena1=usuariosView.txtPassword.getText();
		contrasena2=usuariosView.txtPassword2.getText();
		if(usuariosView.rdbtnSi.isSelected()==true){
			estatus=1;
		}else if(usuariosView.rdbtnNo.isSelected()==true){
			estatus=0;
		}
		if(usuariosView.txtNombre.getText().isEmpty()
				|| usuariosView.txtApPaterno.getText().isEmpty()
				|| usuariosView.txtApMaterno.getText().isEmpty()
				|| usuariosView.txtPassword.getText().isEmpty()
				|| usuariosView.txtUsername.getText().isEmpty()
				|| usuariosView.txtPassword.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Campos vacios");
		}else if (!contrasena1.equals(contrasena2)){
			JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
		}else if(usuariosView.jcbRoll.getSelectedItem().equals("--Seleccione un rol--")){
			JOptionPane.showMessageDialog(null, "Seleccione un rol por favor");
		}else{
			usuarioModel.setNombreUsuario(usuariosView.txtNombre.getText());
			usuarioModel.setApatUsuario(usuariosView.txtApPaterno.getText());
			usuarioModel.setAmatUsuario(usuariosView.txtApMaterno.getText());
			usuarioModel.setNombreUsuario(usuariosView.txtUsername.getText());
			usuarioModel.setPassword(usuariosView.txtPassword.getText());
			usuarioModel.setRol(usuariosView.jcbRoll.getSelectedItem().toString());
			usuarioModel.setEnabled(estatus);
			
			JOptionPane.showMessageDialog(null, usuarioModel.getNombreUsuario()
					+""+usuarioModel.getApatUsuario()
					+""+usuarioModel.getAmatUsuario()
					+""+usuarioModel.getNombreUsuario()
					+""+usuarioModel.getPassword()
					+""+usuarioModel.getRol()
					+""+usuarioModel.getEnabled());
		}
	}
}
