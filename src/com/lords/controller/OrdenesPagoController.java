package com.lords.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import com.lords.conexion.Conexion;
import com.lords.views.MenuAdmin;
import com.lords.views.OrdenPago;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class OrdenesPagoController implements ActionListener, WindowListener, ItemListener, KeyListener{

	OrdenPago pagoView = new OrdenPago();
	
	MenuAdmin menuView;
	MenuAdminController controllerMenu;
	
	OrdenPago pago;
	
	private Conexion conexion = null;
	
	public OrdenesPagoController(OrdenPago vistaPago){
		this.pagoView = vistaPago;
		
		vistaPago.btnGuardar.addActionListener(this);
		vistaPago.btnSalir.addActionListener(this);
		vistaPago.addWindowListener(this);
		vistaPago.jcbProveedores.addItemListener(this);
		vistaPago.txtImporte.addKeyListener(this);
		vistaPago.txtImporteLetra.addKeyListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(pagoView.btnSalir)){
			pagoView.dispose();
			pagoView.setVisible(false);
			try{
				menuView = new MenuAdmin();
				menuView.setLocationRelativeTo(null);
				menuView.setUndecorated(true);
				menuView.setVisible(true);
				controllerMenu= new MenuAdminController(menuView);
			}catch (Exception ex){
				
			}
		}else if(e.getSource().equals(pagoView.btnGuardar)){
			
		}
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		conexion = new Conexion();
		Connection accesodb = (Connection) conexion.conectandobd();
		DefaultComboBoxModel modelo = (DefaultComboBoxModel) pagoView.jcbProveedores.getModel();
		try {
			PreparedStatement ps = (PreparedStatement) accesodb.prepareStatement("select proveedor from proveedor");
			ResultSet rs = ps.executeQuery();
			pagoView.jcbProveedores.setModel(modelo);
			while(rs.next()){
				modelo.addElement(rs.getObject(1));
				pagoView.jcbProveedores.setModel(modelo);
			}
			ps.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error cargando datos");
		}
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		DefaultComboBoxModel modelo = (DefaultComboBoxModel) pagoView.jcbServicios.getModel();
		System.out.println(pagoView.jcbProveedores.getSelectedItem());
		if(pagoView.jcbProveedores.equals("Proveedores...")){
			pagoView.jcbServicios.setEnabled(false);
		}else{
			pagoView.jcbServicios.setEnabled(true);
			modelo.removeAllElements();
			modelo.addElement("Servicios...");
			Connection accesodb = (Connection) conexion.conectandobd();
			
			String proveedor = (String) pagoView.jcbProveedores.getSelectedItem();
			
			try {
				PreparedStatement ps = (PreparedStatement) accesodb.prepareStatement(" select servicio from servicio inner join proveedor on servicio.id_proveedor=proveedor.id_proveedor where proveedor=?"); 
				ps.setString(1, proveedor);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					modelo.addElement(rs.getObject(1));
				}
				pagoView.jcbServicios.setModel(modelo);
			} catch (Exception e) {
				
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		if(arg0.getSource().equals(pagoView.txtImporte)){
			char key = arg0.getKeyChar();
		    if(Character.isLetter(key)) {
		    	arg0.consume();
	        }	
		}else if(arg0.getSource().equals(pagoView.txtImporteLetra)){
			char key = arg0.getKeyChar();
			 if(Character.isDigit(key)) {  
	              arg0.consume();
			 }
		}
	}
}
