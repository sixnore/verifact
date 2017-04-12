package com.lords.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.lords.bo.UsuarioBo;
import com.lords.model.UsuarioModel;
import com.lords.views.Login;
import com.lords.views.Menu_admin;

public class PrincipalController implements ActionListener{

	UsuarioModel usuarioModel=new UsuarioModel();
	Login vistaLogin=new Login();
	Menu_admin vistaMenu=new Menu_admin();
	UsuarioBo usuarioBo=new UsuarioBo();
	
	public PrincipalController(UsuarioModel usuarioModel,Login vistaLogin,UsuarioBo usuarioBo) {
		this.usuarioBo=usuarioBo;
		this.usuarioModel=usuarioModel;
		this.vistaLogin=vistaLogin;
		vistaLogin.btnAcceder.addActionListener(this);
		vistaLogin.btnSalir.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(vistaLogin.btnAcceder)) {
			String resultado="";
			char[] getPass = vistaLogin.jpfPassword.getPassword();
			String password = String.valueOf(getPass);
			if(vistaLogin.jtfUsuario.getText().isEmpty()|| password.isEmpty()){
				resultado="Completa los campos";
			}else{
				usuarioModel.setUsername(vistaLogin.jtfUsuario.getText());
				usuarioModel.setPassword(password);
				
				resultado=usuarioBo.acceder(usuarioModel);
				
				JOptionPane.showMessageDialog(null, resultado);
				if(!(resultado=="No existe usuario")){
					vistaLogin.setVisible(false);
					vistaMenu.setVisible(true);
					vistaMenu.setLocationRelativeTo(null);
				}
			}
		}else if(e.getSource().equals(vistaLogin.btnSalir)){
			System.exit(0);
		}
	}
}