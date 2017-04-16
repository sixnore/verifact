package com.lords.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.lords.model.*;
import com.lords.views.*;

public class MenuAdminController implements ActionListener{

	MenuAdmin menuView = new MenuAdmin();
	MenuAdmin menu;
	
	//Inicializacion de objetos
	
	ControlUsuarios vistaControlUsuarios;
	CapturaFacturas vistaFacturas;
	RegistroUsuarios vistaUsuarios;
	Proveedores vistaProveedores;
	OrdenPago vistaPago;
	Pagos vistaPagos;
	Login login;
	
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
	PagosController pagosController;

	public MenuAdminController(MenuAdmin menuView){
		this.menuView = menuView;
		menuView.btnFacturas.addActionListener(this);
		menuView.btnOrdenesPago.addActionListener(this);
		menuView.btnProveedores.addActionListener(this);
		menuView.btnUsuarios.addActionListener(this);
		menuView.btnSalir.addActionListener(this);
		menuView.btnPagos.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(menuView.btnFacturas)){
			menuView.dispose();
			menuView.setVisible(false);
			try{
				vistaFacturas = new CapturaFacturas();
				vistaFacturas.setLocationRelativeTo(null);
				vistaFacturas.setUndecorated(true);
				vistaFacturas.setVisible(true);
				controllerFactura = new GestionFacturaController(vistaFacturas, facturaModel, pagoModel, proveedorModel, servicioModel);
			}catch(Exception ex){
				
			}
		}
		
		if(e.getSource().equals(menuView.btnOrdenesPago)){
			menuView.dispose();
			menuView.setVisible(false);
			try{
				pagoModel = new OrdenPagoModel();
				servicioModel = new ServicioModel();
				proveedorModel = new ProveedorModel();
				
				vistaPago = new OrdenPago();
				vistaPago.setLocationRelativeTo(null);
				vistaPago.setUndecorated(true);
				vistaPago.setVisible(true);
				controllerPago = new OrdenesPagoController(vistaPago, pagoModel, proveedorModel, servicioModel);
			}catch(Exception ex){
				
			}
		}
		
		if(e.getSource().equals(menuView.btnProveedores)){
			menuView.dispose();
			menuView.setVisible(false);
			try{
				vistaProveedores = new Proveedores();
				vistaProveedores.setLocationRelativeTo(null);
				vistaProveedores.setUndecorated(true);
				vistaProveedores.setVisible(true);
				controllerProveedor = new ProvController(vistaProveedores);
			}catch(Exception ex){
				
			}
		}
		
		if(e.getSource().equals(menuView.btnUsuarios)){
			menuView.dispose();
			menuView.setVisible(false);
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
		
		if(e.getSource().equals(menuView.btnSalir)){
			menuView.dispose();
			menuView.setVisible(false);
			try {
				usuarioModel = new UsuarioModel();
				login = new Login();
	            login.setLocationRelativeTo(null);
				login.setUndecorated(true);
				login.setVisible(true);
				controllerLogin =new PrincipalController(usuarioModel, login);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		if(e.getSource().equals(menuView.btnPagos)){
			menuView.dispose();
			menuView.setVisible(false);
			try{
				vistaPagos = new Pagos();
				vistaPagos.setLocationRelativeTo(null);
				vistaPagos.setUndecorated(true);
				vistaPagos.setVisible(true);
				pagosController = new PagosController(vistaPagos);
			}catch(Exception ex){
				
			}
		}
	}
}
