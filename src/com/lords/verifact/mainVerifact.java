package com.lords.verifact;

import com.lords.controller.PrincipalController;
import com.lords.model.UsuarioModel;
import com.lords.views.Login;

public class mainVerifact {

	public static void main(String[] args) {
		Login log = new Login();
		UsuarioModel usuarioModelo=new UsuarioModel();
		PrincipalController controller=new PrincipalController(log, usuarioModelo);
		log.setVisible(true);
		log.setLocationRelativeTo(null);
	}

}
