package com.lords.dao;

import java.sql.ResultSet;

import com.lords.conexion.Conexion;
import com.lords.model.ProveedorModel;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ProveedorDao {
	static Conexion conexion;

	public ProveedorDao() {
		
	}
	
	public static String registrar(ProveedorModel provModel) {
		String mensaje = "";
		
		conexion = new Conexion();
		
		Connection accesodb = (Connection) conexion.conectandobd();
		try {
			PreparedStatement ps = (PreparedStatement) accesodb.prepareStatement("SELECT id_proveedor FROM proveedor WHERE proveedor.proveedor=?");
			ps.setString(1, provModel.getProveedor());

			ResultSet rs = ps.executeQuery();
			if (!rs.next()) {
				ps = (PreparedStatement) accesodb.prepareStatement("INSERT INTO proveedor VALUES(null,?)");
				ps.setString(1, provModel.getProveedor());
				
				ps.execute();
				ps.close();
				
				return mensaje = "Registrado en la base de datos";
			}else{
				mensaje="Ya se encuentra el proveedor ingresado";
				provModel.setProveedor(null);
			}
		} catch (Exception e) {
			mensaje="Error con la base "+e;
		}
		return mensaje;
	}

	public static String eliminar(ProveedorModel provModel) {
		String mensaje = "";
		String proveedor = provModel.getProveedor();
		
		conexion = new Conexion();
		
		Connection accesodb = (Connection) conexion.conectandobd();
		
		try {

			PreparedStatement ps = (PreparedStatement) accesodb.prepareStatement("SELECT id_proveedor FROM proveedor WHERE proveedor.proveedor=?");
			ps.setString(1, provModel.getProveedor());

			ResultSet rs = ps.executeQuery();
			if (!rs.next()) {
				return mensaje = "No se encuentra en la base de datos";
			}else{
				
				ps = (PreparedStatement) accesodb.prepareStatement("DELETE FROM proveedor WHERE proveedor.proveedor=?");
				
				ps.setString(1, provModel.getProveedor());
				
				ps.execute();
				
				ps.close();
				
				mensaje="Eliminado de la base de datos";
				provModel.setProveedor(null);
			}
		} catch (Exception e) {
			mensaje="Error con la base "+e;
		}
		
		return mensaje;
	}

	public static String buscar(ProveedorModel provModel) {
		String mensaje = "";
		String proveedor = provModel.getProveedor();
		
		conexion = new Conexion();
		
		Connection accesodb = (Connection) conexion.conectandobd();
		
		try {

			PreparedStatement ps = (PreparedStatement) accesodb.prepareStatement("SELECT servicio.servicio FROM servicio WHERE proveedor.proveedor=?");
			ps.setString(1, provModel.getProveedor());

			ResultSet rs = ps.executeQuery();
			
			
			
		} catch (Exception e) {
			mensaje="Error con la base "+e;
		}
		
		
		
		return mensaje;
	}

}
