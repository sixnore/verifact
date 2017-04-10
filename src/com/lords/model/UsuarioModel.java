package com.lords.model;

public class UsuarioModel {
	
	private int idUsuario;
	private String nombreUsuario;
	private String apatUsuario;
	private String amatUsuario;
	private String username;
	private String password;
	private int enabled;
	
	private int idRol;
	private String rol;
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getApatUsuario() {
		return apatUsuario;
	}
	public void setApatUsuario(String apatUsuario) {
		this.apatUsuario = apatUsuario;
	}
	public String getAmatUsuario() {
		return amatUsuario;
	}
	public void setAmatUsuario(String amatUsuario) {
		this.amatUsuario = amatUsuario;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	public int getIdRol() {
		return idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	

}
