package com.lords.model;

public class Cheque {

	int no_cheque=0;
	String solicitud_cheque=null;
	String poliza=null;
	int id_pago=0;
	
	public Cheque() {

	}
	
	public int getNo_cheque() {
		return no_cheque;
	}
	public void setNo_cheque(int no_cheque) {
		this.no_cheque = no_cheque;
	}
	public String getSolicitud_cheque() {
		return solicitud_cheque;
	}
	public void setSolicitud_cheque(String solicitud_cheque) {
		this.solicitud_cheque = solicitud_cheque;
	}
	public String getPoliza() {
		return poliza;
	}
	public void setPoliza(String poliza) {
		this.poliza = poliza;
	}
	public int getId_pago() {
		return id_pago;
	}
	public void setId_pago(int id_pago) {
		this.id_pago = id_pago;
	}	

}
