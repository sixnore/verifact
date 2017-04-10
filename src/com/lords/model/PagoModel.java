package com.lords.model;

public class PagoModel {

	public PagoModel() {

	}
	
	int id_pago=0;
	String folio_cheque;
	String status_pago;
	int id_servicio;
	
	public int getId_pago() {
		return id_pago;
	}
	public void setId_pago(int id_pago) {
		this.id_pago = id_pago;
	}
	public String getFolio_cheque() {
		return folio_cheque;
	}
	public void setFolio_cheque(String folio_cheque) {
		this.folio_cheque = folio_cheque;
	}
	public String getStatus_pago() {
		return status_pago;
	}
	public void setStatus_pago(String status_pago) {
		this.status_pago = status_pago;
	}
	public int getId_servicio() {
		return id_servicio;
	}
	public void setId_servicio(int id_servicio) {
		this.id_servicio = id_servicio;
	}

}
