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
		JOptionPane.showMessageDialog(null, "Escuchado");
	}

}
