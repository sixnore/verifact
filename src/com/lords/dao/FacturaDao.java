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
			PreparedStatement ps = (PreparedStatement) accesodb.prepareStatement("SELECT * FROM factura WHERE folio_factura=?");
			ps.setString(1, facturaModel.getFolioFactura());
			ResultSet rs = ps.executeQuery();
			if (!(rs==null)) {
				String folioBase = rs.getString(1);
				String fechaB = rs.getString(2);
				String quincenaB = rs.getString(3);
				String estadoB = rs.getString(4);
				float subtotalB = rs.getFloat(6);
				float ivaB = rs.getFloat(7);
				float totalB = rs.getFloat(8);
				
				String folio = facturaModel.getFolioFactura();
				String fecha = facturaModel.getFechaRecep();
				String quincena = facturaModel.getQuicena();
				String estado = facturaModel.getEstadoFactura();
				
				float subtotal = facturaModel.getSubtotal();
				float iva = facturaModel.getIva();
				float total = facturaModel.getTotal();
				
				if(folioBase.equals(folio) && fechaB.equals(fecha) && quincenaB.equals(quincena) && subtotalB == subtotal && ivaB == ivaB && totalB == total){
					return mensaje ="Ya registrado o datos incorrectos";
				}else{
					ps = (PreparedStatement) accesodb.prepareStatement("INSERT INTO factura VALUES(?,?,?,?,?,?,?,?)");
					ps.setString(1, folio);
					ps.setString(2, fecha);
					ps.setString(3, quincena);
					ps.setString(4, estado);
					ps.setString(5, null);
					ps.setFloat(6, subtotal);
					ps.setFloat(7, iva);
					ps.setFloat(8, total);
					ps.execute();
					
					ps.close();
					return mensaje = "Ok "+ subtotal + iva  + total;
				}
			}else{
				mensaje="Ya registrado o datos incorrectos";
			}
		} catch (Exception e) {
			mensaje="Error con la base "+e;
		}
		return mensaje;
	}
}
