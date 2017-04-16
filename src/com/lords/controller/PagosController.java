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
import com.lords.views.MenuAdmin;
import com.lords.views.Pagos;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class PagosController implements ActionListener, ItemListener, WindowListener{
	
	Pagos pagosVerView = new Pagos();
	
	
	MenuAdmin menuAdmin;
	MenuAdminController menuController;
	
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
		DefaultTableModel modelo = (DefaultTableModel) pagosVerView.jtRegistros.getModel();
		if(arg0.getSource().equals(pagosVerView.jcbFolioFactura)){
			String item = pagosVerView.jcbFolioFactura.getSelectedItem().toString();
				try {
		            int filas = pagosVerView.jtRegistros.getRowCount();
		            for (int i = 0;filas>i; i++) {
		                modelo.removeRow(0);
		            }
				} catch (Exception e) {
		            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
		        }
				Connection accesodb = (Connection) conexion.conectandobd();
				try {
					PreparedStatement ps = (PreparedStatement) accesodb.prepareStatement("SELECT id_pago,(SELECT  tipo_pago FROM orden_pago op WHERE op.no_orden_pago=p.no_orden_pago) as tipo, folio_factura, (SELECT servicio FROM servicio s WHERE s.id_servicio=p.id_servicio) as servicio from pago p WHERE folio_factura=?"); 
					ps.setString(1, item);
					ResultSet rs = ps.executeQuery();
					Object sqlInfo[] = new Object[4];
					while(rs.next()){
						for(int x = 0; x < 4; x++){
							sqlInfo[x] = rs.getObject(x+1);
						}
						modelo.addRow(sqlInfo);
					}
					pagosVerView.jtRegistros.setModel(modelo);
				} catch (Exception e) {
					
				}
		}
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
			PreparedStatement ps = (PreparedStatement) accesodb.prepareStatement("SELECT folio_factura FROM pago");
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
			pagosVerView.dispose();
			pagosVerView.setVisible(false);
			try{
				menuAdmin = new MenuAdmin();
				menuAdmin.setLocationRelativeTo(null);
				menuAdmin.setUndecorated(true);
				menuAdmin.setVisible(true);
				menuController = new MenuAdminController(menuAdmin);
			}catch(Exception ex){
				
			}
		}else if(arg0.getSource().equals(pagosVerView.btnBuscar)){
			pagosVerView.txtFolioFactura.getText();
		}		
	}
}
