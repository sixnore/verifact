package com.lords.model;

public class Servicio {

	public Servicio() {

	}
	
	int id_servicio=0;
	String proveedor=null;
	String concepto=null;
	float importe_num=0;
	String importe_letra=null;
	
	public int getId_servicio() {
		return id_servicio;
	}
	public void setId_servicio(int id_servicio) {
		this.id_servicio = id_servicio;
	}
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public float getImporte_num() {
		return importe_num;
	}
	public void setImporte_num(float importe_num) {
		this.importe_num = importe_num;
	}
	public String getImporte_letra() {
		return importe_letra;
	}
	public void setImporte_letra(String importe_letra) {
		this.importe_letra = importe_letra;
	}



}
