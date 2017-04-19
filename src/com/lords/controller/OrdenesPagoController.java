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
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import com.lords.bo.OrdenPagoBo;
import com.lords.conexion.Conexion;
import com.lords.model.OrdenPagoModel;
import com.lords.model.ProveedorModel;
import com.lords.model.ServicioModel;
import com.lords.views.MenuAdmin;
import com.lords.views.OrdenPago;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import com.lords.verifact.AbstractJasperReports;

public class OrdenesPagoController implements ActionListener, WindowListener, ItemListener, KeyListener{

	OrdenPago pagoView = new OrdenPago();
	
	MenuAdmin menuView;
	MenuAdminController controllerMenu;
	
	OrdenPago pago;
	
	OrdenPagoModel pagoModel;
	ProveedorModel provModel;
	ServicioModel servicioModel;
	
	OrdenPagoBo ordenPagoBo = new OrdenPagoBo();
	private Conexion conexion = new Conexion();
	
	public OrdenesPagoController(OrdenPago vistaPago, OrdenPagoModel pagoModel, ProveedorModel provModel, ServicioModel servicioModel, OrdenPagoBo ordenPagoBo){
		this.pagoView = vistaPago;
		this.pagoModel = pagoModel;
		this.provModel = provModel;
		this.servicioModel = servicioModel;
		this.ordenPagoBo = ordenPagoBo;
		//this.conexion = new Conexion();
		
		//AbstractJasperReports.createReport(conexion,"C:\\Verifact\\OrdenPago.jasper");
		
		vistaPago.btnGuardar.addActionListener(this);
		vistaPago.btnSalir.addActionListener(this);
		vistaPago.btnGenerar.addActionListener(this);
		vistaPago.btnExportar.addActionListener(this);
		vistaPago.addWindowListener(this);
		vistaPago.jcbProveedores.addItemListener(this);
		vistaPago.txtImporte.addKeyListener(this);
		vistaPago.txtImporteLetra.addKeyListener(this);
	}
	
	public OrdenesPagoController(OrdenPago vistaPago, OrdenPagoModel pagoModel, ProveedorModel provModel, ServicioModel servicioModel
			//, Connection con
			){
		this.pagoView = vistaPago;
		this.pagoModel = pagoModel;
		this.provModel = provModel;
		this.servicioModel = servicioModel;
		
		vistaPago.btnGuardar.addActionListener(this);
		vistaPago.btnSalir.addActionListener(this);
		vistaPago.btnGenerar.addActionListener(this);
		vistaPago.btnExportar.addActionListener(this);
		vistaPago.addWindowListener(this);
		vistaPago.jcbProveedores.addItemListener(this);
		vistaPago.txtImporte.addKeyListener(this);
		vistaPago.txtImporteLetra.addKeyListener(this);
		
		AbstractJasperReports.createReport(conexion,"C:\\Verifact\\OrdenPago.jasper");
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
			String mensaje = "";
			if(pagoView.jcbProveedores.getSelectedItem().toString().equals("Proveedores...") || pagoView.txtImporte.getText().isEmpty() || pagoView.txtImporteLetra.getText().isEmpty() || pagoView.jcbAplicacion.getSelectedItem().toString().equals("...")){
				mensaje = "Campos sin llenar";
			}else{
				
				if(pagoView.rdbtnCheque.isSelected()){
					pagoModel.setTipoPago("CHEQUE");
				}else if(pagoView.rdbtnTransferenciaBancaria.isSelected()){
					pagoModel.setTipoPago("TRANSFERENCIA");
				}
				
				Date date = pagoView.jdcFechaOrden.getDate();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
				String fechaO = String.valueOf(sdf.format(date));
				
				pagoModel.setFecharOrden(fechaO);
				pagoModel.setAplicContable(pagoView.jcbAplicacion.getSelectedItem().toString());
				pagoModel.setImporteNumero(Float.parseFloat(pagoView.txtImporte.getText()));
				pagoModel.setImporteLetra(pagoView.txtImporteLetra.getText().toUpperCase()+" PESOS MEXICANOS");
				
				
				servicioModel.setServicio(pagoView.jcbServicios.getSelectedItem().toString());
				
				provModel.setProveedor(pagoView.jcbProveedores.getSelectedItem().toString());
				
				mensaje = ordenPagoBo.registrarOrdenPago(pagoModel, servicioModel, provModel);
			}
			JOptionPane.showMessageDialog(null, mensaje);
		}else if(e.getSource().equals(pagoView.btnGenerar)){
			AbstractJasperReports.showViewer();
		}else if(e.getSource().equals(pagoView.btnExportar)){
			AbstractJasperReports.exportToPDF("C:\\Reportes\\Reporte.pdf");
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
		conexion = new Conexion();
		DefaultComboBoxModel modelo = (DefaultComboBoxModel) pagoView.jcbServicios.getModel();
		if(pagoView.jcbProveedores.equals("Proveedores...")){
			modelo.removeAllElements();
			modelo.addElement("Servicios...");
			pagoView.jcbServicios.setModel(modelo);
			pagoView.setEnabled(false);
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
				ps.close();
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