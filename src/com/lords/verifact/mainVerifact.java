package com.lords.verifact;

import com.lords.controller.GestionFacturaController;
import com.lords.controller.MenuAdminController;
import com.lords.controller.PrincipalController;
import com.lords.model.UsuarioModel;
import com.lords.views.Captura_facturas;
import com.lords.views.Login;
import com.lords.views.Menu_admin;

public class mainVerifact {

	public static void main(String[] args) {
		Login log = new Login();
		UsuarioModel usuarioModelo=new UsuarioModel();
		
		Menu_admin mA = new Menu_admin();
		Captura_facturas capturaFac = new Captura_facturas();
		
		GestionFacturaController gestionFac = new GestionFacturaController(capturaFac);
		
		
		MenuAdminController menuAdmin = new MenuAdminController(mA);
		
		PrincipalController controller=new PrincipalController(log, usuarioModelo);
		
		log.setVisible(true);
		log.setLocationRelativeTo(null);
		
		
	}

}
