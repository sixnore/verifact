package com.lords.dao;

import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lords.conexion.Conexion;
import com.lords.model.OrdenPagoModel;
import com.lords.model.ProveedorModel;
import com.lords.model.ServicioModel;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class OrdenPagoDao {

	private static Conexion conexion = null;
	
	public OrdenPagoDao() {
		conexion = new Conexion();
	}
	
	public static String registrarOrdenPago(OrdenPagoModel pagoModel, ServicioModel servicioModel,ProveedorModel provModel) {
		String mensaje = "";
		
		Connection accesodb = (Connection) conexion.conectandobd();
		
		try {
			
			String fecha = pagoModel.getFecharOrden();
			String aplicacionContable = pagoModel.getAplicContable();
			float importeNum = pagoModel.getImporteNumero();
			String importeLet = pagoModel.getImporteLetra();
			String tipoPago = pagoModel.getTipoPago();
			
			String servicio = servicioModel.getServicio();
			
			String proveedor = provModel.getProveedor();
			
			PreparedStatement ps = (PreparedStatement) accesodb.prepareStatement("SELECT * FROM orden_pago WHERE tipo_pago=? and importe_numero=? and importe_letra=? and aplic_contable=?");
			ps.setString(1, tipoPago);
			ps.setFloat(2, importeNum);
			ps.setString(3, importeLet);
			ps.setString(4, aplicacionContable);
			
			ResultSet rs = ps.executeQuery();
			if(!rs.next()){
				
				ps = (PreparedStatement) accesodb.prepareStatement("INSERT INTO orden_pago VALUES(NULL,'C.P. Armando Mendoza Delgado',?,'Estadio Azul',?,?,?,?,'Lic. Pedro Ruiz Isunza','C.P. Isaac Velasco Alcantara')");
				ps.setString(1, fecha);
				ps.setString(2, tipoPago);
				ps.setFloat(3, importeNum);
				ps.setString(4, importeLet);
				ps.setString(5, aplicacionContable);
				
				ps.execute();
				
				mensaje = "Registrado en la base de datos";
			}else{
				mensaje = "Ya registrado en la base de datos";
			}
				
		}catch(SQLException ex){
			mensaje = String.valueOf(ex);
		}
		return mensaje;
	}

}