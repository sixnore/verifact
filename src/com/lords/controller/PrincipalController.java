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
		log.getBtnAcceder().addActionListener(this);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(log.getBtnAcceder())){
			acceder();
		}
		
	}

	
	
	private void acceder() {
		JOptionPane.showMessageDialog(null, "Llego");
	}
	
}
