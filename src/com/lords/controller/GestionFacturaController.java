package com.lords.controller;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import com.lords.conexion.Conexion;
import com.lords.dao.FacturaDao;
import com.lords.model.FacturaModel;
import com.lords.model.OrdenPagoModel;
import com.lords.model.PagoModel;
import com.lords.model.ProveedorModel;
import com.lords.model.ServicioModel;
import com.lords.views.CapturaFacturas;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class GestionFacturaController implements ActionListener, KeyListener, WindowListener{

	private CapturaFacturas view;
	
	FacturaModel facturaModel = new FacturaModel();
	OrdenPagoModel ordenPago = new OrdenPagoModel();
	ProveedorModel proveedorModel = new ProveedorModel();
	ServicioModel servicioModel = new ServicioModel();
	
	
	FacturaDao facturaDao = new FacturaDao();

	private Conexion conexion = null;
	
	public GestionFacturaController(CapturaFacturas capturaFacturas, FacturaModel facturaModel, OrdenPagoModel pagoModel, ProveedorModel proveedorModel, ServicioModel servicioModel){
	this.view = capturaFacturas;
	
	this.facturaModel = facturaModel;
	this.ordenPago = pagoModel;
	this.proveedorModel = proveedorModel;
	
	view.txtSubtotal.addKeyListener(this);
	view.txtIva.addKeyListener(this);
	view.txtTotal.addKeyListener(this);
	view.addWindowListener(this);
	
	capturaFacturas.btnGuardar.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(view.btnGuardar)){
			String folioFact =  view.txtFolioFactura.getText();
			String fecha =  view.jdcFecha_Recep.getDateFormatString();
			String quincena = (String)  view.jcbQuincena.getSelectedItem();
			String estado = (String)  view.jcbEstado.getSelectedItem();
			
			String proveedor = (String)  view.jcbProveedores.getSelectedItem();
			String servicio = (String)  view.jcbServicios.getSelectedItem();
			
			String pago = (String)  view.jcbMetodoPago.getSelectedItem();
			
			if(folioFact.isEmpty() || fecha.isEmpty() || quincena.isEmpty() ||  view.txtSubtotal.getText().isEmpty() ||  view.txtIva.getText().isEmpty() ||  view.txtTotal.getText().isEmpty() || estado.equals("Estado...") || proveedor.equals("Proveedores...") || servicio.equals("Servicios...") || pago.equals("Pago...")){
				JOptionPane.showMessageDialog(null, "Algun campo se encuentra vacio o no selecciona algo");
			}else{
				String fechaS = null;
				try { 
					Date date = view.jdcFecha_Recep.getDate(); 
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
					fechaS = String.valueOf(sdf.format(date));
					
					Date actual = new Date();
					
					
					if(date.after(actual)){
						throw new NullPointerException();
					}
					
					} catch(NullPointerException ex) { 
						JOptionPane.showMessageDialog(null, "Fecha no valida", "Error", JOptionPane.INFORMATION_MESSAGE); 
					}
				float subtotal = Float.parseFloat(view.txtSubtotal.getText() );
				float iva = Float.parseFloat(view.txtIva.getText());
				float total = Float.parseFloat(view.txtTotal.getText());
				facturaModel.setFolioFactura(folioFact);
				facturaModel.setFechaRecep(fechaS);
				facturaModel.setQuicena(quincena);
				facturaModel.setEstadoFactura(estado);
				facturaModel.setSubtotal(subtotal);
				facturaModel.setIva(iva);
				facturaModel.setTotal(total);
				
				proveedorModel.setProveedor(proveedor);
				servicioModel.setServicio(servicio);
				
				ordenPago.setTipoPago(pago);
				
				String mensaje = facturaDao.registrarFact(ordenPago, facturaModel, proveedorModel, servicioModel);
				JOptionPane.showMessageDialog(null, mensaje);
			}
		}else if(arg0.getSource().equals(view.btnAgregarProv)){
			System.out.println("ok");
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
		char key = e.getKeyChar();
		   if(Character.isLetter(key)) {          
              e.consume();
          } 
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		conexion = new Conexion();
		Connection accesodb = (Connection) conexion.conectandobd();
		DefaultComboBoxModel modelo = (DefaultComboBoxModel) view.jcbProveedores.getModel();
		try {
			PreparedStatement ps = (PreparedStatement) accesodb.prepareStatement("select proveedor from proveedor");
			ResultSet rs = ps.executeQuery();
			view.jcbProveedores.setModel(modelo);
			while(rs.next()){
				modelo.addElement(rs.getObject(1));
				view.jcbProveedores.setModel(modelo);
			}
			ps.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error cargando datos");
		}
	}


	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
