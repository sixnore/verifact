package com.lords.verifact;

import com.lords.bo.UsuarioBo;
import com.lords.controller.GestionFacturaController;
import com.lords.controller.MenuAdminController;
import com.lords.controller.PrincipalController;
import com.lords.controller.ProvController;
import com.lords.model.FacturaModel;
import com.lords.model.OrdenPagoModel;
import com.lords.model.PagoModel;
import com.lords.model.ProveedorModel;
import com.lords.model.RollUsuarioModel;
import com.lords.model.ServicioModel;
import com.lords.model.UsuarioModel;
import com.lords.views.CapturaFacturas;
import com.lords.views.Login;
import com.lords.views.MenuAdmin;
import com.lords.views.OrdenPago;
import com.lords.views.Proveedores;

public class mainVerifact {

	UsuarioModel usuarioModel = new UsuarioModel();
	
	public static void main(String[] args) {
		//Vistas 
		Login vistaLogin = new Login();
		
		
		//BoS
		UsuarioBo usuarioBo=new UsuarioBo();

		//Modelos
		UsuarioModel usuarioModel=new UsuarioModel();
		
		//Controladores
		PrincipalController principalController=new PrincipalController(usuarioModel, vistaLogin, usuarioBo);
				
		try {
            vistaLogin.setLocationRelativeTo(null);
			vistaLogin.setUndecorated(true);
			vistaLogin.setVisible(true);
			usuarioModel.setRol(null);
			usuarioModel.setUsername(null);
			usuarioModel.setPassword(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
