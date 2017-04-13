package com.lords.dao;

import java.sql.ResultSet;
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
	
	FacturaModel facturaModel = new FacturaModel();
	OrdenPagoModel ordenPago = new OrdenPagoModel();
	ProveedorModel proveedorModel = new ProveedorModel();
	ServicioModel servicioModel = new ServicioModel();
	
	Conexion conexion;

	public FacturaDao() {
		conexion = new Conexion();
	}
	
	public String registrarFact(OrdenPagoModel ordenPago, FacturaModel facturaModel, ProveedorModel proveedorModel, ServicioModel servicioModel) {
		Connection accesodb = (Connection) conexion.conectandobd();
		String mensaje = "";
		
		try {
			PreparedStatement ps = (PreparedStatement) accesodb.prepareStatement("SELECT * FROM factura WHERE folio=?");
			ps.setString(1, facturaModel.getFolioFactura());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String folioBase = rs.getString(1);
				String fecha = rs.getString(2);
				String quincena = rs.getString(3);
				String 
				
				return mensaje = "Ok";
			}else{
				mensaje="Ya registrado";
			}
		} catch (Exception e) {
			mensaje="Error con la base "+e;
		}
		return mensaje;
	}
}
