package com.lords.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.lords.model.FacturaModel;
import com.lords.model.PagoModel;
import com.lords.model.ProveedorModel;
import com.lords.model.ServicioModel;
import com.lords.views.Captura_facturas;

public class GestionFacturaController implements ActionListener{

	Captura_facturas capturaFac = new Captura_facturas();
	FacturaModel facturaModel = new FacturaModel();
	ProveedorModel proveedorModel = new ProveedorModel();
	ServicioModel servicioModel = new ServicioModel();
	PagoModel pagoModel = new PagoModel();
	
	public GestionFacturaController(Captura_facturas capturaFac){
		this.capturaFac = capturaFac;
		this.capturaFac.btnAgregarProv.addActionListener(this);
		this.capturaFac.btnAgregarServ.addActionListener(this);
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
		String mensaje ="";
		String folioFactura = capturaFac.txtFolioFactura.getText();
		String fechaRecepcion = capturaFac.jdcFecha_Recep.getDateFormatString();
		
		String proveedor = String.valueOf(capturaFac.jcbProveedores.getSelectedIndex());
		String servicio = String.valueOf(capturaFac.jcbProveedores.getSelectedIndex());
		String quincena = String.valueOf(capturaFac.jcbProveedores.getSelectedIndex());
		
		float subtotal = Float.parseFloat(capturaFac.txtSubtotal.getText());
		float iva = Float.parseFloat(capturaFac.txtTotal.getText());
		float total = Float.parseFloat(capturaFac.txtTotal.getText());
		
		if(!folioFactura.equals(null)){
			if(!fechaRecepcion.equals(null)){
				if(!(proveedor.equals(null))){
					if(!(servicio.equals(null))){
						if(!(quincena.equals(null))){
							if(!(subtotal == 0)){
								if(!(iva==0)){
									if(!(total==0)){
										facturaModel.setFolioFact(folioFactura);
										facturaModel.setFecha(fechaRecepcion);
										
										proveedorModel.setProveedor(proveedor);
										
										servicioModel.setServicio(servicio);
										
										pagoModel.setSubtotal(subtotal);
										pagoModel.setIva(iva);
										pagoModel.setTotal(total);
										
									}
								}
							}
						}
					}
				}
			}
		}
		
		
	}

}
