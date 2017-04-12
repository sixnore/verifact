package com.lords.model;

public class ServicioModel {

	public ServicioModel() {

	}
	
	int id_servicio;
	String servicio;
	float importe_num;
	
	public int getId_servicio() {
		return id_servicio;
	}
	public void setId_servicio(int id_servicio) {
		this.id_servicio = id_servicio;
	}
	public String getServicio() {
		return servicio;
	}
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	public float getImporte_num() {
		return importe_num;
	}
	public void setImporte_num(float importe_num) {
		this.importe_num = importe_num;
	}
}
