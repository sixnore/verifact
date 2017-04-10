package com.lords.model;

public class PagoModel {

	public PagoModel() {

	}
	
	int id_pago;
	String folio_cheque;
	String status_pago;
	float subtotal;
	float iva;
	float total;
	String metodo_pago;
	int id_servicio;
	String folio_factura;
	
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
	public float getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}
	public float getIva() {
		return iva;
	}
	public void setIva(float iva) {
		this.iva = iva;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public String getMetodo_pago() {
		return metodo_pago;
	}
	public void setMetodo_pago(String metodo_pago) {
		this.metodo_pago = metodo_pago;
	}
	public int getId_servicio() {
		return id_servicio;
	}
	public void setId_servicio(int id_servicio) {
		this.id_servicio = id_servicio;
	}
	public String getFolio_factura() {
		return folio_factura;
	}
	public void setFolio_factura(String folio_factura) {
		this.folio_factura = folio_factura;
	}
}
