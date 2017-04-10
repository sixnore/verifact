package com.lords.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.lords.model.UsuarioModel;
import com.lords.views.Login;

public class PrincipalController implements ActionListener{

	Login log = new Login();
	UsuarioModel usuarioModelo = new UsuarioModel();
	
	public PrincipalController(Login log, UsuarioModel usuarioModelo) {
		super();
		this.log = log;
		this.usuarioModelo = usuarioModelo;
		this.log.btnAcceder.addActionListener(this);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(log.btnAcceder)){
			acceder();
		}
		
	}

	
	
	private void acceder() {
		String username = log.jtfUsuario.getText();
		char[] getPass = log.jpfPassword.getPassword();
		String password = new String(getPass);
		if(username.equals(null)|| password.equals(null)|| password.equals("")|| username.equals("")){
			JOptionPane.showMessageDialog(null, "Usuario/Contraseña vacíos");
		}else{
			
		}
	}
	
	
}
