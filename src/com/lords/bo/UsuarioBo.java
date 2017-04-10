package com.lords.bo;

import com.lords.model.UsuarioModel;

public class UsuarioBo {

	public String acceder(UsuarioModel usuarioModelo) {
		String mensaje="";
		mensaje=usuarioModelo.getUsername()+" "+usuarioModelo.getPassword();
		return mensaje;
	}

}
