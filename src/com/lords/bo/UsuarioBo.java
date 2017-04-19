package com.lords.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.lords.dao.UsuarioDao;
import com.lords.model.UsuarioModel;

public class UsuarioBo {
	UsuarioDao usuarioDao=new UsuarioDao();
	
	public String acceder(UsuarioModel usuarioModelo) {
		String mensaje="";
		mensaje=usuarioModelo.getUsername()+" "+usuarioModelo.getPassword();
		
		String username = usuarioModelo.getUsername();
		String password = usuarioModelo.getPassword();
		
		
		if(!(username.length()>=6&&username.length()<=20)){
			mensaje = "No se cumple condiciones de usuario";
		}else if(!(password.length()>=8&&password.length()<=20)){
				mensaje = "No se cumple condiciones de password";
		}else{
			mensaje=usuarioDao.acceder(usuarioModelo);
		}
		return mensaje;
	}

	public String verificarUsuario(UsuarioModel usuarioModel) {
		String resultado="";
		try{
			resultado=usuarioDao.verificarUsuario(usuarioModel);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return resultado;
	}

	public String ingresarUsuario(UsuarioModel usuarioModel) {
		String resultado="";
		try{
			resultado=usuarioDao.ingresarUsuario(usuarioModel);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return resultado;
	}

	public String recuperarIdUsuario(UsuarioModel usuarioModel) {
		String resultado="";
		try{
			resultado=usuarioDao.recuperarIdUsuario(usuarioModel);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return resultado;
	}
	
	public String ingresarRolUsuario(UsuarioModel usuarioModel) {
		String resultado="";
		try{
			resultado=usuarioDao.ingresarRolUsuario(usuarioModel);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return resultado;
	}

	public List<UsuarioModel> consultaGeneral()throws SQLException {
		List<UsuarioModel> listaUsuarios=new ArrayList<UsuarioModel>();
		try {
			listaUsuarios = usuarioDao.consultaGeneral();
		} catch (SQLException t) {
			throw new SQLException(t.getMessage());
		}
		return listaUsuarios;
	}

	public UsuarioModel consultaEditar(String username)throws SQLException {
		UsuarioModel usuarioModel=new UsuarioModel();
		try{
			usuarioModel=usuarioDao.consultaEditar(username);
		}catch(Exception e){
			throw new SQLException(e.getMessage());
		}
		return usuarioModel;
	}

	public String eliminarUsuario(String username){
		String resultado="correcto editar";
		try{
			resultado=usuarioDao.eliminarUsuario(username);
		}catch(Exception e){
		}		
		return resultado;
	}

	public String modificarUsuario(UsuarioModel usuarioModel) {
		String resultado="";
		try{
			resultado=usuarioDao.modificarUsuario(usuarioModel);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return resultado;
	}

	public String modificarRolUsuario(UsuarioModel usuarioModel) {
		String resultado="";
		try{
			resultado=usuarioDao.modificarRolUsuario(usuarioModel);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return resultado;
	}

	

}