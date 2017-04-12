package com.lords.model;

public class PagoModel {

	public PagoModel() {

	}
	
	int id_pago;
	int noOrdenPago;
	String estadoPago;
	int idServicio;
	String folioFactura;
	
	public int getId_pago() {
		return id_pago;
	}
	public void setId_pago(int id_pago) {
		this.id_pago = id_pago;
	}
	public int getNoOrdenPago() {
		return noOrdenPago;
	}
	public void setNoOrdenPago(int noOrdenPago) {
		this.noOrdenPago = noOrdenPago;
	}
	public String getEstadoPago() {
		return estadoPago;
	}
	public void setEstadoPago(String estadoPago) {
		this.estadoPago = estadoPago;
	}
	public int getIdServicio() {
		return idServicio;
	}
	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}
	public String getFolioFactura() {
		return folioFactura;
	}
	public void setFolioFactura(String folioFactura) {
		this.folioFactura = folioFactura;
	}
}
