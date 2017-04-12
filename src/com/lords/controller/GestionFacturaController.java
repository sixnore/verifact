package com.lords.controller;

import com.lords.model.FacturaModel;
import com.lords.model.OrdenPagoModel;
import com.lords.model.PagoModel;
import com.lords.model.ProveedorModel;
import com.lords.model.ServicioModel;
import com.lords.views.Captura_facturas;

public class GestionFacturaController {

	private Captura_facturas view;
	
	FacturaModel facturaModel = new FacturaModel();
	OrdenPagoModel ordenPago = new OrdenPagoModel();
	ProveedorModel proveedorModel = new ProveedorModel();
	ServicioModel servicioModel = new ServicioModel();
	
	public GestionFacturaController(Captura_facturas capturaFacturas, FacturaModel facturaModel2, PagoModel pagoModel, ProveedorModel proveedorModel2, ServicioModel servicioModel2){
	this.view = capturaFacturas;
	}
}
