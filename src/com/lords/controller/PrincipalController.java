package com.lords.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import com.lords.bo.UsuarioBo;
import com.lords.model.UsuarioModel;
import com.lords.views.Login;
import com.lords.views.MenuAdmin;

public class PrincipalController implements ActionListener, KeyListener {

	Login vistaLogin = new Login();
	Login log;
	
	MenuAdmin vistaMenu;
	MenuAdminController menuController;
	
	UsuarioModel usuarioModel = new UsuarioModel();
	UsuarioBo usuarioBo = new UsuarioBo();

	public PrincipalController(UsuarioModel usuarioModel, Login vistaLogin, UsuarioBo usuarioBo) {

		this.usuarioBo = usuarioBo;
		this.usuarioModel = usuarioModel;
		
		this.vistaLogin = vistaLogin;
		
		vistaLogin.btnAcceder.addActionListener(this);
		vistaLogin.btnSalir.addActionListener(this);
		
		vistaLogin.jpfPassword.addKeyListener(this);
		vistaLogin.jtfUsuario.addKeyListener(this);
	}

	public PrincipalController(UsuarioModel usuarioModel, Login vistaLogin) {
		this.usuarioModel = usuarioModel;
		this.vistaLogin = vistaLogin;
		
		vistaLogin.btnAcceder.addActionListener(this);
		vistaLogin.btnSalir.addActionListener(this);
		
		vistaLogin.jpfPassword.addKeyListener(this);
		vistaLogin.jtfUsuario.addKeyListener(this);
		
		//vistaMenu = new MenuAdmin();
		//menuController = new MenuAdminController(vistaMenu);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(vistaLogin.btnAcceder)) {
			accederSistema();
		} else if (e.getSource().equals(vistaLogin.btnSalir)) {
			System.exit(0);
		}
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_ENTER){
			accederSistema();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
	
	public void accederSistema(){
		String resultado="";
		String usuario=vistaLogin.jtfUsuario.getText();
		String password=vistaLogin.jpfPassword.getText();
		if(usuario.isEmpty()|| password.isEmpty()){
			JOptionPane.showMessageDialog(null, "Completa los campos por favor");
		}else{
			usuarioModel.setUsername(usuario);
			usuarioModel.setPassword(password);
			resultado = usuarioBo.acceder(usuarioModel);
			JOptionPane.showMessageDialog(null, resultado, "Inicio sistema", JOptionPane.INFORMATION_MESSAGE);
			if(resultado=="No se cumple condiciones de usuario"||resultado=="No se cumple condiciones de password"|| resultado=="Cuenta desactivada"){
				clean();
			}else{
				if (!usuarioModel.getUsername().equals("")) {
					if(usuarioModel.getRol().equals("Administrador")){
						vistaLogin.setVisible(false);
						vistaLogin.dispose();
						try {
							vistaMenu = new MenuAdmin();
							vistaMenu.setLocationRelativeTo(null);
							vistaMenu.setUndecorated(true);
							vistaMenu.setVisible(true);
							menuController = new MenuAdminController(vistaMenu);
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}else if(usuarioModel.getRol().equals("Capturista")){
						vistaLogin.setVisible(false);
						vistaLogin.dispose();
						try {
							vistaMenu = new MenuAdmin();
							vistaMenu.setLocationRelativeTo(null);
							vistaMenu.setUndecorated(true);
							vistaMenu.setVisible(true);
							vistaMenu.btnFacturas.setEnabled(false);
							vistaMenu.btnOrdenesPago.setEnabled(false);
							vistaMenu.btnPagos.setEnabled(false);
							vistaMenu.btnUsuarios.setEnabled(false);
							menuController = new MenuAdminController(vistaMenu);
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}else if(usuarioModel.getRol().equals("Secretaria")){
						vistaLogin.setVisible(false);
						vistaLogin.dispose();
						try {
							vistaMenu = new MenuAdmin();
							vistaMenu.setLocationRelativeTo(null);
							vistaMenu.setUndecorated(true);
							vistaMenu.setVisible(true);
							vistaMenu.btnProveedores.setEnabled(false);
							vistaMenu.btnUsuarios.setEnabled(false);
							menuController = new MenuAdminController(vistaMenu);
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				}
			}
			
		}
	}
	
	public void clean(){
		vistaLogin.jpfPassword.setText("");
		vistaLogin.jtfUsuario.setText("");
	}

}