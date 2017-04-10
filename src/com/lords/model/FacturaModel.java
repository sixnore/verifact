package com.lords.model;

public class FacturaModel {

	public FacturaModel() {

	}
	
	String no_factura;
	String fecha;
	String quicena;
	String estado;
	int id_pago;
	
	public String getNo_factura() {
		return no_factura;
	}
	public void setNo_factura(String no_factura) {
		this.no_factura = no_factura;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getQuicena() {
		return quicena;
	}
	public void setQuicena(String quicena) {
		this.quicena = quicena;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getId_pago() {
		return id_pago;
	}
	public void setId_pago(int id_pago) {
		this.id_pago = id_pago;
	}
}
