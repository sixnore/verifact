package com.lords.model;

import java.awt.Image;

public class FacturaModel {

	public FacturaModel() {

	}
	
	String folioFactura;
	String fechaRecep;
	String quicena;
	String estadoFactura;
	Image facturaImg;
	float subtotal;
	float iva;
	float total;
	
	public String getFolioFactura() {
		return folioFactura;
	}
	public void setFolioFactura(String folioFactura) {
		this.folioFactura = folioFactura;
	}
	public String getFechaRecep() {
		return fechaRecep;
	}
	public void setFechaRecep(String fechaRecep) {
		this.fechaRecep = fechaRecep;
	}
	public String getQuicena() {
		return quicena;
	}
	public void setQuicena(String quicena) {
		this.quicena = quicena;
	}
	public String getEstadoFactura() {
		return estadoFactura;
	}
	public void setEstadoFactura(String estadoFactura) {
		this.estadoFactura = estadoFactura;
	}
	public Image getFacturaImg() {
		return facturaImg;
	}
	public void setFacturaImg(Image facturaImg) {
		this.facturaImg = facturaImg;
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
}
