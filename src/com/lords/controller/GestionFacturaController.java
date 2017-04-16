package com.lords.controller;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.lords.bo.FacturaBo;
import com.lords.conexion.Conexion;
import com.lords.dao.FacturaDao;
import com.lords.model.FacturaModel;
import com.lords.model.OrdenPagoModel;
import com.lords.model.PagoModel;
import com.lords.model.ProveedorModel;
import com.lords.model.ServicioModel;
import com.lords.views.CapturaFacturas;
import com.lords.views.MenuAdmin;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class GestionFacturaController implements ActionListener, KeyListener, WindowListener, ItemListener{
	
	FacturaModel facturaModel = new FacturaModel();
	OrdenPagoModel ordenPago = new OrdenPagoModel();
	ProveedorModel proveedorModel = new ProveedorModel();
	ServicioModel servicioModel = new ServicioModel();
	
	MenuAdmin vistaMenu;
	MenuAdminController controllerMenu;
	
	CapturaFacturas capturaView = new CapturaFacturas();
	
	FacturaBo facturaBo = new FacturaBo();

	private Conexion conexion = null;
	private String url;
	
	public GestionFacturaController(CapturaFacturas capturaFacturas, FacturaModel facturaModel, OrdenPagoModel pagoModel, ProveedorModel proveedorModel, ServicioModel servicioModel){
	this.capturaView = capturaFacturas;
	
	this.facturaModel = facturaModel;
	this.ordenPago = pagoModel;
	this.proveedorModel = proveedorModel;
	
	
	capturaView.txtSubtotal.addKeyListener(this);
	capturaView.txtIva.addKeyListener(this);
	capturaView.txtTotal.addKeyListener(this);
	capturaView.addWindowListener(this);
	capturaView.jcbProveedores.addItemListener(this);
	
	capturaFacturas.btnSalir.addActionListener(this);
	capturaFacturas.btnGuardar.addActionListener(this);
	capturaFacturas.btnExaminar.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(capturaView.btnGuardar)){
			String folioFact =  capturaView.txtFolioFactura.getText();
			String fecha =  capturaView.jdcFecha_Recep.getDateFormatString();
			String quincena = (String)  capturaView.jcbQuincena.getSelectedItem();
			String estado = (String)  capturaView.jcbEstado.getSelectedItem();
			
			String proveedor = (String)  capturaView.jcbProveedores.getSelectedItem();
			String servicio = (String)  capturaView.jcbServicios.getSelectedItem();
			
			String pago = (String)  capturaView.jcbMetodoPago.getSelectedItem();
			
			if(folioFact.isEmpty() || fecha.isEmpty() || quincena.isEmpty() ||  capturaView.txtSubtotal.getText().isEmpty() ||  capturaView.txtIva.getText().isEmpty() ||  capturaView.txtTotal.getText().isEmpty() || estado.equals("Estado...") || proveedor.equals("Proveedores...") || servicio.equals("Servicios...") || pago.equals("Pago...")){
				JOptionPane.showMessageDialog(null, "Algun campo se encuentra vacio o no selecciona algo");
			}else{
				
				String fechaS = null;
				try { 
					Date date = capturaView.jdcFecha_Recep.getDate(); 
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
					fechaS = String.valueOf(sdf.format(date));
					
					Date actual = new Date();
					
					
					if(date.after(actual)){
						throw new NullPointerException();
					}
					
					} catch(NullPointerException ex) { 
						JOptionPane.showMessageDialog(null, "Fecha no valida", "Error", JOptionPane.INFORMATION_MESSAGE); 
					}
				float subtotal = Float.parseFloat(capturaView.txtSubtotal.getText() );
				float iva = Float.parseFloat(capturaView.txtIva.getText());
				float total = Float.parseFloat(capturaView.txtTotal.getText());
				
				facturaModel = new FacturaModel();
				facturaModel.setFolioFactura(folioFact);
				facturaModel.setFechaRecep(fechaS);
				facturaModel.setQuicena(quincena);
				facturaModel.setEstadoFactura(estado);
				facturaModel.setSubtotal(subtotal);
				facturaModel.setIva(iva);
				facturaModel.setTotal(total);
				facturaModel.setUrlImg(this.url);
				
				proveedorModel = new ProveedorModel();
				proveedorModel.setProveedor(proveedor);
				
				servicioModel = new ServicioModel();
				servicioModel.setServicio(servicio);
				
				ordenPago = new  OrdenPagoModel(); 
				ordenPago.setTipoPago(pago);
				
				String mensaje = facturaBo.registrarFact(ordenPago, facturaModel, proveedorModel, servicioModel);
				
				JOptionPane.showMessageDialog(null, "Estado : "+mensaje);
				
				limpiezaView();
				
				/*
				try {
					Date date  = capturaView.jdcFecha_Recep.getDate();;
					Date actual  = new Date();
					if(date.after(actual)){
						throw new NullPointerException();
					}else{
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
						String fechaS  = String.valueOf(sdf.format(date));
						 
						float subtotal = Float.parseFloat(capturaView.txtSubtotal.getText() );
						float iva = Float.parseFloat(capturaView.txtIva.getText());
						float total = Float.parseFloat(capturaView.txtTotal.getText());
						//facturaModel = new FacturaModel();
						facturaModel.setFolioFactura(folioFact);
						facturaModel.setFechaRecep(fechaS);
						facturaModel.setQuicena(quincena);
						facturaModel.setEstadoFactura(estado);
						facturaModel.setSubtotal(subtotal);
						facturaModel.setIva(iva);
						facturaModel.setTotal(total);
						
						//proveedorModel = new ProveedorModel();
						proveedorModel.setProveedor(proveedor);
						
						servicioModel = new ServicioModel();
						servicioModel.setServicio(servicio);
						
						//ordenPago = new  OrdenPagoModel(); 
						ordenPago.setTipoPago(pago);
						
						String mensaje = facturaBo.registrarFact(ordenPago, facturaModel, proveedorModel, servicioModel);
						
						JOptionPane.showMessageDialog(null, "Estado: "+mensaje);
					}
				}catch(NullPointerException ex) { 
					JOptionPane.showMessageDialog(null, "Fecha no valida \n"+ex, "Error", JOptionPane.INFORMATION_MESSAGE); 
				}*/				
			}
		}else if(arg0.getSource().equals(capturaView.btnSalir)){
			capturaView.dispose();
			capturaView.setVisible(false);
			try{
				vistaMenu = new MenuAdmin();
				vistaMenu.setLocationRelativeTo(null);
				vistaMenu.setUndecorated(true);
				vistaMenu.setVisible(true);
				controllerMenu = new MenuAdminController(vistaMenu);
			}catch (Exception ex){
				
			}
		}else if(arg0.getSource().equals(capturaView.btnExaminar)){
			
			FileNameExtensionFilter filtro = new FileNameExtensionFilter("Formato de archivos tipo imagen JPEG(*.JPG, *.JPEG)", "jpg", "jpeg");
			JFileChooser imagen = new JFileChooser();
			imagen.addChoosableFileFilter(filtro);
			imagen.setDialogTitle("Elegir imagen de factura");
			File url = new File("C:/");
			imagen.setCurrentDirectory(url);
			
			int window = imagen.showOpenDialog(null);
			if(window == JFileChooser.APPROVE_OPTION){
				File factura = imagen.getSelectedFile();
				String urlFact = String.valueOf(factura);
				
				Image facturaPan = Toolkit.getDefaultToolkit().getImage(urlFact);
				facturaPan = facturaPan.getScaledInstance(155, 135, Image.SCALE_DEFAULT);
				
				capturaView.jlblImagen.setIcon(new ImageIcon(facturaPan));
				
				try{
					this.url = urlFact;
				}catch(Exception ex){
					
				}
				
			}
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
		DefaultComboBoxModel modelo = (DefaultComboBoxModel) capturaView.jcbProveedores.getModel();
		try {
			PreparedStatement ps = (PreparedStatement) accesodb.prepareStatement("select proveedor from proveedor");
			ResultSet rs = ps.executeQuery();
			capturaView.jcbProveedores.setModel(modelo);
			while(rs.next()){
				modelo.addElement(rs.getObject(1));
				capturaView.jcbProveedores.setModel(modelo);
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

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		DefaultComboBoxModel modelo = (DefaultComboBoxModel) capturaView.jcbServicios.getModel();
		if(!(capturaView.jcbProveedores.equals("Proveedores..."))){
			modelo.removeAllElements();
			modelo.addElement("Servicios...");
			Connection accesodb = (Connection) conexion.conectandobd();
			
			String proveedor = (String) capturaView.jcbProveedores.getSelectedItem();
			
			try {
				PreparedStatement ps = (PreparedStatement) accesodb.prepareStatement("SELECT servicio from servicio inner join proveedor on servicio.id_proveedor=proveedor.id_proveedor where proveedor=?"); 
				ps.setString(1, proveedor);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					modelo.addElement(rs.getObject(1));
				}
				capturaView.jcbServicios.setModel(modelo);
			} catch (Exception e) {
				
			}
		}else{
			
		}
	}
	
	private void limpiezaView(){
		capturaView.jdcFecha_Recep.setDate(null);
		capturaView.txtFolioFactura.setText(null);
		capturaView.txtSubtotal.setText(null);
		capturaView.txtIva.setText(null);
		capturaView.txtTotal.setText(null);
		capturaView.jlblImagen.setIcon(null);
		capturaView.jcbProveedores.setSelectedIndex(0);
		capturaView.jcbServicios.setSelectedIndex(0);
		capturaView.jcbEstado.setSelectedIndex(0);
		capturaView.jcbQuincena.setSelectedIndex(0);
		capturaView.jcbMetodoPago.setSelectedIndex(0);
	}
}
