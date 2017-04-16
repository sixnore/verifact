package com.lords.dao;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.lords.conexion.Conexion;
import com.lords.model.FacturaModel;
import com.lords.model.OrdenPagoModel;
import com.lords.model.ProveedorModel;
import com.lords.model.ServicioModel;
import com.lords.model.UsuarioModel;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class FacturaDao {
	
	Conexion conexion;

	public FacturaDao() {
		conexion = new Conexion();
	}
	
	public String registrarFact(OrdenPagoModel ordenPago, FacturaModel facturaModel, ProveedorModel proveedorModel, ServicioModel servicioModel) {
		
		Connection accesodb = (Connection) conexion.conectandobd();
		
		String mensaje = "";
		String url = facturaModel.getUrlImg();
		InputStream archivo = null;
		
		System.out.println(url);
		try {
			
			PreparedStatement ps = (PreparedStatement) accesodb.prepareStatement("SELECT * FROM factura WHERE folio_factura=?");
			ps.setString(1, facturaModel.getFolioFactura());
			ResultSet rs = ps.executeQuery();
			if(rs!=null){
				
				//url = facturaModel.getUrlImg();
				archivo = new FileInputStream(new File(url));
				
				String folio = facturaModel.getFolioFactura();
				String fecha = facturaModel.getFechaRecep();
				String quincena = facturaModel.getQuicena();
				String estado = facturaModel.getEstadoFactura();
				
				
				float subtotal = facturaModel.getSubtotal();
				float iva = facturaModel.getIva();
				float total = facturaModel.getTotal();
				
				ps = (PreparedStatement) accesodb.prepareStatement("INSERT INTO factura VALUES(?,?,?,?,?,?,?,?)");
				ps.setString(1, folio);
				ps.setString(2, fecha);
				ps.setString(3, quincena);
				ps.setString(4, estado);
				ps.setBinaryStream(5, archivo);
				ps.setFloat(6, subtotal);
				ps.setFloat(7, iva);
				ps.setFloat(8, total);
				
				ps.execute();
				
				ps.close();
				
				mensaje = "Registrado";
				
			}else{
				mensaje = "Ya registrado en la base de datos";
			}
		}catch(NullPointerException ex){
			String folio = facturaModel.getFolioFactura();
			String fecha = facturaModel.getFechaRecep();
			String quincena = facturaModel.getQuicena();
			String estado = facturaModel.getEstadoFactura();
			
			
			float subtotal = facturaModel.getSubtotal();
			float iva = facturaModel.getIva();
			float total = facturaModel.getTotal();
			
			PreparedStatement ps;
			try {
				ps = (PreparedStatement) accesodb.prepareStatement("INSERT INTO factura VALUES(?,?,?,?,?,?,?,?)");
				ps.setString(1, folio);
				ps.setString(2, fecha);
				ps.setString(3, quincena);
				ps.setString(4, estado);
				ps.setBinaryStream(5, null);
				ps.setFloat(6, subtotal);
				ps.setFloat(7, iva);
				ps.setFloat(8, total);
				
				ps.execute();
				
				ps.close();
			} catch (SQLException e) {
				mensaje = "Error cargando datos "+ e;
			}
			
			
			mensaje = "Registrado";
		}catch (FileNotFoundException | SQLException ex) {
			mensaje = "Ya registrado en la base de datos o error en la carga de datos";
		}
			
		
		return mensaje;
	}
}
