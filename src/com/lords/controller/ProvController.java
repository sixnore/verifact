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

import com.lords.bo.ProveedorBo;
import com.lords.conexion.Conexion;
import com.lords.model.ProveedorModel;
import com.lords.views.Login;
import com.lords.views.MenuAdmin;
import com.lords.views.Proveedores;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ProvController  implements ActionListener, ItemListener, WindowListener{
	
	Proveedores proveedorView = new Proveedores();
	
	MenuAdmin vistaMenu;
	MenuAdminController controllerMenu;
	
	ProveedorModel provModel;
	
	Proveedores proveedor;
	
	private Conexion conexion = null;
	
	public ProvController(Proveedores proveedorView, ProveedorModel provModel){
		
		this.proveedorView = proveedorView;
		
		this.provModel = provModel;
		
		proveedorView.btnAgregar.addActionListener(this);
		proveedorView.btnConsultar.addActionListener(this);
		proveedorView.btnModificar.addActionListener(this);
		proveedorView.btnSalir.addActionListener(this);
		proveedorView.btnEliminar.addActionListener(this);
		
		proveedorView.jcbProveedores.addItemListener(this);
		
		proveedorView.addWindowListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(proveedorView.btnEliminar)){
			String mensaje = "";
			if(proveedorView.jcbProveedores.getSelectedItem().toString().equals("Proveedores")){
				mensaje = "Elije un proveedor antes";
			}else{
				provModel = new ProveedorModel();
				provModel.setProveedor(proveedorView.jcbProveedores.getSelectedItem().toString());
				mensaje = ProveedorBo.eliminar(provModel);
			}
			JOptionPane.showMessageDialog(null, mensaje);
		}
		if(arg0.getSource().equals(proveedorView.btnAgregar)){
			String mensaje = "";
			String proveedor = JOptionPane.showInputDialog(null, "Ingresar nuevo proveedor", "Registro nuevo proveedor", JOptionPane.INFORMATION_MESSAGE);
			
			
			if(proveedor.equals(null) || proveedor.isEmpty() || proveedor.equals("")){
				mensaje = "Datos vacios";
			}else{
				provModel = new ProveedorModel();
				provModel.setProveedor(proveedor);
				mensaje = ProveedorBo.registrar(provModel);
			}
			fillComboBox();
			JOptionPane.showMessageDialog(null, mensaje);
		}else if(arg0.getSource().equals(proveedorView.btnConsultar)){
			String mensaje = "";
			
			String proveedorSearch = JOptionPane.showInputDialog(null, "Ingresas nombre de proveedor", "Busqueda de proveedores", JOptionPane.INFORMATION_MESSAGE);
			
			if(proveedorSearch.equals(null)||proveedorSearch.equals("")||proveedorSearch.isEmpty()){
				mensaje = "No ingreso proveedor";
			}else{
				provModel = new ProveedorModel();
				provModel.setProveedor(proveedorSearch);
				mensaje = ProveedorBo.buscar(provModel);
			}
			
		}else if(arg0.getSource().equals(proveedorView.btnModificar)){
			System.out.println("ok");
		}else if(arg0.getSource().equals(proveedorView.btnSalir)){
			proveedorView.dispose();
			proveedorView.setVisible(false);
			try{
				vistaMenu = new MenuAdmin();
				vistaMenu.setLocationRelativeTo(null);
				vistaMenu.setUndecorated(true);
				vistaMenu.setVisible(true);
				controllerMenu = new MenuAdminController(vistaMenu);
			}catch(Exception ex){
				
			}
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
		fillComboBox();
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		if(arg0.getSource().equals(proveedorView.jcbProveedores)){
			removeElementsTable();
			fillTable();
		}
	}
	
	private void fillTable(){
		DefaultTableModel modelo = (DefaultTableModel) proveedorView.jtServicios.getModel();
		String item = proveedorView.jcbProveedores.getSelectedItem().toString();
		
		if(!item.equals("Proveedores...")){
			
			try {
				
	            int filas = proveedorView.jtServicios.getRowCount();
	            for (int i = 0;filas>i; i++) {
	                modelo.removeRow(0);
	            }
	            
			} catch (Exception e) {
	            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
	        }
			
			Connection accesodb = (Connection) conexion.conectandobd();
			
			try {
				PreparedStatement ps = (PreparedStatement) accesodb.prepareStatement("SELECT servicio from servicio inner join proveedor on servicio.id_proveedor=proveedor.id_proveedor where proveedor=?"); 
				ps.setString(1, item);
				ResultSet rs = ps.executeQuery();
				Object sqlInfo[] = new Object[1];
				
				while(rs.next()){
					for(int x = 0; x < proveedorView.jtServicios.getColumnCount() ; x++){
						sqlInfo[x] = rs.getString(x+1);
					}
				}
				modelo.addRow(sqlInfo);
				proveedorView.jtServicios.setModel(modelo);
			} catch (Exception e) {
				
			}
		}else{
			removeElementsTable();
		}
		
	}
	
	private void removeElementsTable(){
		DefaultTableModel modelo = (DefaultTableModel) proveedorView.jtServicios.getModel();
		int total = modelo.getRowCount();
		for(int x = total; x == 0 ; x -- ){
			modelo.removeRow(x-1);
		}
		proveedor.jtServicios.setModel(modelo);
	}
	
	private void fillComboBox(){
		conexion = new Conexion();
		Connection accesodb = (Connection) conexion.conectandobd();
		DefaultComboBoxModel modelo = (DefaultComboBoxModel) proveedorView.jcbProveedores.getModel();
		try {
			PreparedStatement ps = (PreparedStatement) accesodb.prepareStatement("select proveedor from proveedor");
			ResultSet rs = ps.executeQuery();
			proveedorView.jcbProveedores.setModel(modelo);
			while(rs.next()){
				modelo.addElement(rs.getObject(1));
				proveedorView.jcbProveedores.setModel(modelo);
			}
			ps.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error cargando datos");
		}
	}

}
