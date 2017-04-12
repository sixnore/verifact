package com.lords.model;

public class OrdenPagoModel {

	public OrdenPagoModel() {

	}
	
	int noOrdenpago;
	String solicitante;
	String fecharOrden;
	String departamento;
	String tipoPago;
	float importeNumero;
	String importeLetra;
	String aplicContable;
	String gerenteArea;
	String direccionArea;
	
	public int getNoOrdenpago() {
		return noOrdenpago;
	}
	public void setNoOrdenpago(int noOrdenpago) {
		this.noOrdenpago = noOrdenpago;
	}
	public String getSolicitante() {
		return solicitante;
	}
	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}
	public String getFecharOrden() {
		return fecharOrden;
	}
	public void setFecharOrden(String fecharOrden) {
		this.fecharOrden = fecharOrden;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getTipoPago() {
		return tipoPago;
	}
	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}
	public float getImporteNumero() {
		return importeNumero;
	}
	public void setImporteNumero(float importeNumero) {
		this.importeNumero = importeNumero;
	}
	public String getImporteLetra() {
		return importeLetra;
	}
	public void setImporteLetra(String importeLetra) {
		this.importeLetra = importeLetra;
	}
	public String getAplicContable() {
		return aplicContable;
	}
	public void setAplicContable(String aplicContable) {
		this.aplicContable = aplicContable;
	}
	public String getGerenteArea() {
		return gerenteArea;
	}
	public void setGerenteArea(String gerenteArea) {
		this.gerenteArea = gerenteArea;
	}
	public String getDireccionArea() {
		return direccionArea;
	}
	public void setDireccionArea(String direccionArea) {
		this.direccionArea = direccionArea;
	}
}
