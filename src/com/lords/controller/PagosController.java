package com.lords.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.lords.conexion.Conexion;
import com.lords.views.Pagos;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class PagosController implements ActionListener, ItemListener, WindowListener{
	
	Pagos pagosVerView = new Pagos();
	
	private Conexion conexion = null;
	
	public PagosController(Pagos pagosVerView){
		this.pagosVerView = pagosVerView;
		
		pagosVerView.btnBuscar.addActionListener(this);
		pagosVerView.btnSalir.addActionListener(this);
		
		pagosVerView.jcbFolioFactura.addItemListener(this);
		
		pagosVerView.addWindowListener(this);
		
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		
		
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		conexion = new Conexion();
		Connection accesodb = (Connection) conexion.conectandobd();
		DefaultComboBoxModel modelo = (DefaultComboBoxModel) pagosVerView.jcbFolioFactura.getModel();
		try {
			PreparedStatement ps = (PreparedStatement) accesodb.prepareStatement("SELECT folio_factua FROM pago");
			ResultSet rs = ps.executeQuery();
			pagosVerView.jcbFolioFactura.setModel(modelo);
			while(rs.next()){
				modelo.addElement(rs.getObject(1));
				pagosVerView.jcbFolioFactura.setModel(modelo);
			}
			ps.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error cargando datos");
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(pagosVerView.btnSalir)){
			
		}else if(arg0.getSource().equals(pagosVerView.btnBuscar)){
			
		}
		
	}

	
}
