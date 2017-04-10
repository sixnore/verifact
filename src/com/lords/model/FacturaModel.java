package com.lords.model;

import java.awt.Image;

public class FacturaModel {

	public FacturaModel() {

	}
	
	String folioFact;
	String fecha;
	String quicena;
	String estado;
	Image factura;
	
	
	public String getFolioFact() {
		return folioFact;
	}
	public void setFolioFact(String folioFact) {
		this.folioFact = folioFact;
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
	public Image getFactura() {
		return factura;
	}
	public void setFactura(Image factura) {
		this.factura = factura;
	}
	
	
}
