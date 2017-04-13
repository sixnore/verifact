package com.lords.controller;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import com.lords.dao.FacturaDao;
import com.lords.model.FacturaModel;
import com.lords.model.OrdenPagoModel;
import com.lords.model.PagoModel;
import com.lords.model.ProveedorModel;
import com.lords.model.ServicioModel;
import com.lords.views.Captura_facturas;

public class GestionFacturaController implements ActionListener, KeyListener{

	private Captura_facturas view;
	
	FacturaModel facturaModel = new FacturaModel();
	OrdenPagoModel ordenPago = new OrdenPagoModel();
	ProveedorModel proveedorModel = new ProveedorModel();
	ServicioModel servicioModel = new ServicioModel();
	
	
	FacturaDao facturaDao = new FacturaDao();
	
	public GestionFacturaController(Captura_facturas capturaFacturas, FacturaModel facturaModel, OrdenPagoModel pagoModel, ProveedorModel proveedorModel, ServicioModel servicioModel){
	this.view = capturaFacturas;
	this.facturaModel = facturaModel;
	this.ordenPago = pagoModel;
	this.ordenPago = pagoModel;
	this.proveedorModel = proveedorModel;
	
	ActionListener();
	}

	
	private void ActionListener() {
		view.btnAgregarProv.addActionListener(this);
		view.btnGuardar.addActionListener(null);
	}
	
	private void KeyTyped(){
		view.txtSubtotal.addKeyListener(this);
		view.txtIva.addKeyListener(this);
		view.txtTotal.addKeyListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(view.btnGuardar)){
			
				
				String mensaje = facturaDao.registrarFact(ordenPago, facturaModel, proveedorModel, servicioModel );
			}
	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getSource().equals(KeyEvent.CHAR_UNDEFINED)){
		            Toolkit.getDefaultToolkit().beep();
		            e.consume();
		            JOptionPane.showMessageDialog(null, "Solo numeros");
		}
	}
	
	
	
	
}
