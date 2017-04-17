package com.lords.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lords.conexion.Conexion;
import com.lords.model.ProveedorModel;
import com.lords.model.ServicioModel;
import com.lords.model.UsuarioModel;
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

	public static List<ServicioModel> consultaGeneral() throws SQLException {
		List<ServicioModel> listaUsuarios = new ArrayList<ServicioModel>();
		conexion = new Conexion();
		Connection accesodb = (Connection) conexion.conectandobd();

		try {
			PreparedStatement ps = (PreparedStatement) accesodb.prepareStatement(
					"SELECT servicio FROM servicio");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ServicioModel ServicioModel = new ServicioModel();
				ServicioModel.setServicio(rs.getString(1));
				listaUsuarios.add(ServicioModel);
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return listaUsuarios;
	}

	public static ServicioModel consultaEditar(String username) throws SQLException {
		ServicioModel servicioModel=new ServicioModel();
		Connection accesodb = (Connection) conexion.conectandobd();
		try {
			PreparedStatement ps = (PreparedStatement) accesodb
					.prepareStatement("select id_servicio, servicio from servicio");
			ps.setString(1, username);
			ps.setString(2, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				servicioModel.setId_servicio(rs.getInt(1));
				servicioModel.setServicio(rs.getString(2));
			} 
		} catch (Exception e) {
			System.out.println("Existe un error en la base de datos "+ e);
			throw new SQLException("Existe un problema con la base de datos\n" + "No se pudo realizar la consulta!");
		}
		return servicioModel;
		}

	public static String eliminarServicio(String servicio)throws SQLException{
		String resultado="";
		try {
			Connection accesodb = (Connection) conexion.conectandobd();
			String insertServ = "UPDATE usuario SET servicio.servicio WHERE servicio=?";
			PreparedStatement ps = (PreparedStatement) accesodb.prepareStatement(insertServ);
			ps.setString(1, servicio);

			int correcto = ps.executeUpdate();
			if (correcto > 0) {
				resultado = "El usuario fue dado de baja correctamente";
			}

		} catch (Exception e) {
			resultado = "Existio un error en la transaccion " + e;
			throw new SQLException("Existe un problema con la base de datos\n" + "No se pudo realizar la consulta!");
		}
		return resultado;
	}

}
