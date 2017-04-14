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
		
		
		vistaMenu = new MenuAdmin();
		menuController = new MenuAdminController(vistaMenu);
	}

	public PrincipalController(UsuarioModel usuarioModel, Login vistaLogin) {
		this.usuarioModel = usuarioModel;
		this.vistaLogin = vistaLogin;
		
		vistaLogin.btnAcceder.addActionListener(this);
		vistaLogin.btnSalir.addActionListener(this);
		
		
		vistaMenu = new MenuAdmin();
		menuController = new MenuAdminController(vistaMenu);
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
			return;
		}else{
			usuarioModel.setUsername(usuario);
			usuarioModel.setPassword(password);
			resultado = usuarioBo.acceder(usuarioModel);
			if (!usuarioModel.getUsername().equals("")) {
				vistaLogin.setVisible(false);
				try {
					vistaMenu.setLocationRelativeTo(null);
					vistaMenu.setUndecorated(true);
					vistaMenu.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

}