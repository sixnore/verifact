package com.lords.verifact;

import com.lords.bo.UsuarioBo;
import com.lords.controller.GestionFacturaController;
import com.lords.controller.MenuAdminController;
import com.lords.controller.PrincipalController;
import com.lords.model.FacturaModel;
import com.lords.model.PagoModel;
import com.lords.model.ProveedorModel;
import com.lords.model.RollUsuarioModel;
import com.lords.model.ServicioModel;
import com.lords.model.UsuarioModel;
import com.lords.views.Captura_facturas;
import com.lords.views.Login;
import com.lords.views.Menu_admin;
import com.lords.views.OrdenPago;
import com.lords.views.Proveedores;

public class mainVerifact {

	public static void main(String[] args) {
		//Vistas 
		Login vistaLogin = new Login();
		Menu_admin vistaMenuAdmin = new Menu_admin();
		Captura_facturas vistaCapFac = new Captura_facturas();
		OrdenPago vistaOrdenPago=new OrdenPago();
		Proveedores vistaProv=new Proveedores();

		//BoS
		UsuarioBo usuarioBo=new UsuarioBo();

		
		//Modelos
		UsuarioModel usuarioModelo=new UsuarioModel();
		FacturaModel facturaModel=new FacturaModel();
		PagoModel pagoModel=new PagoModel();
		ProveedorModel proveedorModel=new ProveedorModel();
		RollUsuarioModel rollUsuarioModel=new RollUsuarioModel();
		ServicioModel servicioModel=new ServicioModel();
		UsuarioModel usuarioModel=new UsuarioModel();
		
		//Controladores
		GestionFacturaController gestionFacturaController=new GestionFacturaController();
		MenuAdminController menuAdminController=new MenuAdminController();
		
		vistaLogin.setVisible(true);
		PrincipalController principalController=new PrincipalController(usuarioModel, vistaLogin, usuarioBo);
//		vistaCapFac.setVisible(true);
//		vistaMenuAdmin.setVisible(true);
//		vistaOrdenPago.setVisible(true);
//		vistaProv.setVisible(true);
		vistaLogin.setLocationRelativeTo(null);
	}

}
