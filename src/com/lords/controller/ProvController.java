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
import com.lords.views.Login;
import com.lords.views.MenuAdmin;
import com.lords.views.Proveedores;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ProvController  implements ActionListener, ItemListener, WindowListener{
	
	Proveedores proveedorView = new Proveedores();
	
	MenuAdmin vistaMenu;
	MenuAdminController controllerMenu;
	
	Proveedores proveedor;
	
	private Conexion conexion = null;
	
	public ProvController(Proveedores proveedorView){
		
		this.proveedorView = proveedorView;
		
		proveedorView.btnAgregar.addActionListener(this);
		proveedorView.btnConsultar.addActionListener(this);
		proveedorView.btnModificar.addActionListener(this);
		proveedorView.btnSalir.addActionListener(this);
		
		proveedorView.jcbProveedores.addItemListener(this);
		
		proveedorView.addWindowListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(proveedorView.btnAgregar)){
			System.out.println("ok");
		}else if(arg0.getSource().equals(proveedorView.btnConsultar)){
			System.out.println("ok");
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

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		
		DefaultTableModel modelo = (DefaultTableModel) proveedorView.jtServicios.getModel();
		
		if(arg0.getSource().equals(proveedorView.jcbProveedores)){
			
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
				int total = modelo.getRowCount();
				for(int x = total; x == 0 ; x -- ){
					modelo.removeRow(x-1);
				}
				proveedor.jtServicios.setModel(modelo);
			}
		}
	}

}
