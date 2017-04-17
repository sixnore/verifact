package com.lords.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.lords.bo.ProveedorBo;
import com.lords.conexion.Conexion;
import com.lords.model.ProveedorModel;
import com.lords.model.ServicioModel;
import com.lords.model.UsuarioModel;
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
	
	ServicioModel servicioModel = new ServicioModel();
	
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
		consultaGeneral();
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
				Object sqlInfo[] = new Object[3];
				
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
		for(int x = total; x < total ; x -- ){
			modelo.removeRow(x);
			proveedor.jtServicios.setModel(modelo);
		}
		
	}


	private void consultaGeneral() {
		List<ServicioModel> listaServicios = new ArrayList<ServicioModel>();
		try {
			listaServicios = ProveedorBo.consultaGeneral();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		Iterator<ServicioModel> itrUsuarios = listaServicios.iterator();
		String[] columnNames = {"Servicio", "Modificar", "Eliminar" };

		final Class[] tiposColumnas = new Class[] { java.lang.String.class, java.lang.String.class,java.lang.Integer.class, JButton.class,
				JButton.class };

		proveedorView.jtServicios.setModel(new javax.swing.table.DefaultTableModel() {
			Class[] tipos = tiposColumnas;

			@SuppressWarnings("unchecked")
			public Class getColumnClass(int columnIndex) {
				return tipos[columnIndex];
			}

			public boolean isCellEdijtServicios(int row, int column) {
				return false;
			}
		});

		proveedorView.jtServicios.setDefaultRenderer(JButton.class, new TableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable jjtServicios, Object objeto, boolean estaSeleccionado,boolean tieneElFoco, int fila, int columna){
				return (Component) objeto;
			}
		});
		if (proveedorView.jtServicios.getMouseListeners().length == 2) {

			proveedorView.jtServicios.addMouseListener(new MouseAdapter() {
				String servicio;
				Object boton;
				private String delete;

				public void mouseClicked(MouseEvent e) {
					int fila = proveedorView.jtServicios.rowAtPoint(e.getPoint());
					int columna = proveedorView.jtServicios.columnAtPoint(e.getPoint());

					if (proveedorView.jtServicios.getModel().getColumnClass(columna).equals(JButton.class)) {
						boton = proveedorView.jtServicios.getModel().getValueAt(fila, columna);
						StringBuilder sb = new StringBuilder();
						for (int i = 0; i < proveedorView.jtServicios.getModel().getColumnCount(); i++) {
							if (!proveedorView.jtServicios.getModel().getColumnClass(i).equals(JButton.class)) {
								sb.append("\n").append(proveedorView.jtServicios.getModel().getColumnName(i)).append(": ")
										.append(proveedorView.jtServicios.getModel().getValueAt(fila, i));
								if (proveedorView.jtServicios.getModel().getColumnName(i) == "Servicio") {
									servicio = proveedorView.jtServicios.getModel().getValueAt(fila, i).toString();
								}
							}
						}
						// Boton Editar--------
						if (boton.toString().contains("Modificar") == true) {

							try {
								servicioModel = ProveedorBo.consultaEditar(servicio);
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							return;
							
							// Boton Eliminar------
						} else if (boton.toString().contains("Eliminar") == true) {
							if (JOptionPane.showConfirmDialog(null, "Seguro de Eliminar el Usuario :" + servicio) == 0) {
								delete = ProveedorBo.eliminarServicio(servicio);
								if (delete.equals("El usuario fue eliminado correctamente!")) {
									JOptionPane.showMessageDialog(null, delete, "Eliminar usuario",
											JOptionPane.INFORMATION_MESSAGE);
								} else {
									JOptionPane.showMessageDialog(null, delete, "Eliminar usuario",
											JOptionPane.WARNING_MESSAGE);
								}
								consultaGeneral();
							}
							return;
						}
					}
				}
			});
		}

		DefaultTableModel modelo = (DefaultTableModel) proveedorView.jtServicios.getModel();
		modelo.setColumnIdentifiers(columnNames);
		Object[] fila = new Object[modelo.getColumnCount()];
//		String status="";
		while (itrUsuarios.hasNext()) {
			ServicioModel ServicioModeloitr = itrUsuarios.next();
//			status= Integer.toString(ServicioModeloitr.getEnabled());
			JButton btn = new JButton("Modificar");
			JButton btn2 = new JButton("Eliminar");
			fila[0] = ServicioModeloitr.getServicio();
			fila[1] = btn;
			fila[2] = btn2;
			modelo.addRow(fila);
		}
		proveedorView.jtServicios.getColumnModel().getColumn(0).setPreferredWidth(300);
		proveedorView.jtServicios.getColumnModel().getColumn(1).setPreferredWidth(100);
		proveedorView.jtServicios.getColumnModel().getColumn(2).setPreferredWidth(100);
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
