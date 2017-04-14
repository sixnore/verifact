package com.lords.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.lords.model.*;
import com.lords.views.*;

public class MenuAdminController implements ActionListener{

	MenuAdmin menu = new MenuAdmin();
	
	//Inicializacion de objetos
	MenuAdmin vistaMenu;
	
	ControlUsuarios vistaControlUsuarios;
	CapturaFacturas vistaFacturas;
	RegistroUsuarios vistaUsuarios;
	Proveedores vistaProveedores;
	OrdenPago vistaPago;
	Login log;
	
	FacturaModel facturaModel;
	UsuarioModel usuarioModel;
	OrdenPagoModel pagoModel;
	ProveedorModel proveedorModel;
	ServicioModel servicioModel;
	
	PrincipalController controllerLogin;
	GestionFacturaController controllerFactura;
	ProvController controllerProveedor;
	OrdenesPagoController controllerPago;
	UsuariosController controllerUsuario;

	public MenuAdminController(MenuAdmin vistaMenu){
		this.vistaMenu = vistaMenu;
		vistaMenu.btnFacturas.addActionListener(this);
		vistaMenu.btnOrdenesPago.addActionListener(this);
		vistaMenu.btnProveedores.addActionListener(this);
		vistaMenu.btnServicios.addActionListener(this);
		vistaMenu.btnUsuarios.addActionListener(this);
		vistaMenu.btnSalir.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(vistaMenu.btnFacturas)){
			vistaMenu.dispose();
			menu.setVisible(false);
			try{
				vistaFacturas = new CapturaFacturas();
				vistaFacturas.setLocationRelativeTo(null);
				vistaFacturas.setUndecorated(true);
				vistaFacturas.setVisible(true);
				controllerFactura = new GestionFacturaController(vistaFacturas, facturaModel, pagoModel, proveedorModel, servicioModel);
			}catch(Exception ex){
				
			}
		}
		
		if(e.getSource().equals(vistaMenu.btnOrdenesPago)){
			vistaMenu.dispose();
			menu.setVisible(false);
			try{
				vistaPago = new OrdenPago();
				vistaPago.setLocationRelativeTo(null);
				vistaPago.setUndecorated(true);
				vistaPago.setVisible(true);
				controllerPago = new OrdenesPagoController(vistaPago);
			}catch(Exception ex){
				
			}
		}
		
		if(e.getSource().equals(vistaMenu.btnProveedores)){
			vistaMenu.dispose();
			menu.setVisible(false);
			try{
				vistaProveedores = new Proveedores();
				vistaProveedores.setLocationRelativeTo(null);
				vistaProveedores.setUndecorated(true);
				vistaProveedores.setVisible(true);
				controllerProveedor = new ProvController(vistaProveedores);
			}catch(Exception ex){
				
			}
		}
		
		if(e.getSource().equals(vistaMenu.btnUsuarios)){
			vistaMenu.dispose();
			menu.setVisible(false);
			try{
				vistaUsuarios = new RegistroUsuarios();
				vistaControlUsuarios = new ControlUsuarios();
				vistaControlUsuarios.setLocationRelativeTo(null);
				vistaControlUsuarios.setUndecorated(true);
				vistaControlUsuarios.setVisible(true);
				controllerUsuario = new UsuariosController(vistaUsuarios, vistaControlUsuarios);
			}catch(Exception ex){
				
			}
		}
		
		if(e.getSource().equals(vistaMenu.btnSalir)){
			vistaMenu.dispose();
			menu.setVisible(false);
			try {
				log=new Login();
				usuarioModel=new UsuarioModel();
	            log.setLocationRelativeTo(null);
				log.setUndecorated(true);
				log.setVisible(true);
				controllerLogin =new PrincipalController(usuarioModel, log);
			} catch (Exception ex) {
				ex.printStackTrace();
			}//CATCH
		}
	}
}
