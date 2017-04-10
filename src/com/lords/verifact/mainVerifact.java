package com.lords.verifact;

import com.lords.controller.MenuAdminController;
import com.lords.controller.PrincipalController;
import com.lords.model.UsuarioModel;
import com.lords.views.Login;
import com.lords.views.Menu_admin;

public class mainVerifact {

	public static void main(String[] args) {
		Login log = new Login();
		UsuarioModel usuarioModelo=new UsuarioModel();
		
		Menu_admin menuAd = new Menu_admin();
		MenuAdminController adminController = new MenuAdminController(menuAd);
		
		PrincipalController controller=new PrincipalController(log, usuarioModelo);
		
		
		log.setVisible(true);
		log.setLocationRelativeTo(null);
		
		
	}

}
