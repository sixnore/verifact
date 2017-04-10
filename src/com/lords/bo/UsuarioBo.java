package com.lords.bo;

import javax.swing.JOptionPane;

import com.lords.model.UsuarioModel;

public class UsuarioBo {

	public String acceder(UsuarioModel usuarioModelo) {
		String mensaje="";
		mensaje=usuarioModelo.getUsername()+" "+usuarioModelo.getPassword();
		
		String username = usuarioModelo.getUsername();
		String password = usuarioModelo.getPassword();
		
		
		if(!(username.length()>=6&&username.length()<=20)){
			mensaje = "No se cumple condiciones de usuario\n";
		}else{
			if(!(password.length()>=8&&password.length()<=20)){
				mensaje = "No se cumple condiciones de contraseña";
			}
		}
		
		return mensaje;
	}

}
