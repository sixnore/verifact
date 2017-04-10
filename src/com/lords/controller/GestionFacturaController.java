package com.lords.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.lords.views.Captura_facturas;

public class GestionFacturaController implements ActionListener{

	Captura_facturas capturaFac = new Captura_facturas();
	
	public GestionFacturaController(Captura_facturas capturaFac){
		this.capturaFac = capturaFac;
		this.capturaFac.btnAgregar.addActionListener(this);
		this.capturaFac.btnExaminar.addActionListener(this);
		this.capturaFac.btnGuardar.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(capturaFac.btnGuardar)){
			guardar();
		}
	}
	
	private void guardar(){
		String folioFactura = capturaFac.txtFolioFactura.getText();
		String fechaRecepcion = capturaFac.jdcFecha_Recep.getDateFormatString();
		int proveedor = capturaFac.jcbProveedores.getSelectedIndex();
		int servicio = capturaFac.jcbServicios.getSelectedIndex();
		float subtotal = Float.parseFloat(capturaFac.txtSubtotal.getText());
		float iva = Float.parseFloat(capturaFac.txtTotal.getText());
		float total = Float.parseFloat(capturaFac.txtTotal.getText());
		
		
	}

}
