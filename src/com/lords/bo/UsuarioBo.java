package com.lords.bo;

import javax.swing.JOptionPane;

import com.lords.model.UsuarioModel;

public class UsuarioBo {

	public String acceder(UsuarioModel usuarioModelo) {
		String mensaje="";
		mensaje=usuarioModelo.getUsername()+" "+usuarioModelo.getPassword();
		
		String username = usuarioModelo.getUsername();
		String password = usuarioModelo.getPassword();
		
		
		if(!(username.length()>6&&username.length()<20||password.length()>8&&password.length()<20)){
			JOptionPane.showMessageDialog(null, "No cumple con los requisitos");
			
		}
		
		return mensaje;
	}

}
