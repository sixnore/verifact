package com.lords.model;

public class ProveedorModel {

	public ProveedorModel() {
		
	}
	
	int id_proveedor;
	String proveedor;
	int id_servicio;

	public int getId_proveedor() {
		return id_proveedor;
	}
	public void setId_proveedor(int id_proveedor) {
		this.id_proveedor = id_proveedor;
	}
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	public int getId_servicio() {
		return id_servicio;
	}
	public void setId_servicio(int id_servicio) {
		this.id_servicio = id_servicio;
	}
}
