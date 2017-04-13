package com.lords.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.lords.bo.UsuarioBo;
import com.lords.model.UsuarioModel;
import com.lords.views.Login;
import com.lords.views.Menu_admin;

public class PrincipalController implements ActionListener {

	Login vistaLogin = new Login();
	MenuAdminController menuController;
	UsuarioModel usuarioModel = new UsuarioModel();
	Menu_admin vistaMenu;
	UsuarioBo usuarioBo = new UsuarioBo();

	public PrincipalController(UsuarioModel usuarioModel, Login vistaLogin, UsuarioBo usuarioBo) {

		this.usuarioBo = usuarioBo;
		this.usuarioModel = usuarioModel;
		this.vistaLogin = vistaLogin;
		vistaLogin.btnAcceder.addActionListener(this);
		vistaLogin.btnSalir.addActionListener(this);
		vistaMenu = new Menu_admin();
		menuController = new MenuAdminController(vistaMenu);
	}

	public PrincipalController(UsuarioModel usuarioModel, Login vistaLogin) {
		this.usuarioModel = usuarioModel;
		this.vistaLogin = vistaLogin;
		vistaLogin.btnAcceder.addActionListener(this);
		vistaLogin.btnSalir.addActionListener(this);
		vistaMenu = new Menu_admin();
		menuController = new MenuAdminController(vistaMenu);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(vistaLogin.btnAcceder)) {
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
					} // CATCH
				}
			}
			JOptionPane.showMessageDialog(null, resultado+" "+usuarioModel.getUsername());
		} else if (e.getSource().equals(vistaLogin.btnSalir)) {
			System.out.println("Entro");
			System.exit(0);
		}
	}
}