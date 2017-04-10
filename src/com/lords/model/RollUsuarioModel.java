package com.lords.model;

public class RollUsuarioModel {

	public RollUsuarioModel() {

	}
	
	int id_roll;
	int id_usuario;
	String user_name;
	String roll;
	
	public int getId_roll() {
		return id_roll;
	}
	public void setId_roll(int id_roll) {
		this.id_roll = id_roll;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
}
