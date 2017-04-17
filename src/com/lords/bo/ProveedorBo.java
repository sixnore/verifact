package com.lords.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lords.dao.ProveedorDao;
import com.lords.model.ProveedorModel;
import com.lords.model.ServicioModel;
import com.lords.model.UsuarioModel;

public class ProveedorBo {
	
	
	public static String registrar(ProveedorModel provModel) {
		String mensaje = "";
		String proveedor = provModel.getProveedor();
		
		if(proveedor.length()>35){
			mensaje = "Proveedor demasiado largo";
			return mensaje;
		}else{
			mensaje = ProveedorDao.registrar(provModel);
			return mensaje;
		}
	}

	public static String eliminar(ProveedorModel provModel) {
		String mensaje = "";
		
		mensaje = ProveedorDao.eliminar(provModel);
		
		return mensaje;
	}

	public static String buscar(ProveedorModel provModel) {
		String mensaje = "";
		
		mensaje = ProveedorDao.buscar(provModel);
		
		return mensaje;
	}

	public static List<ServicioModel> consultaGeneral()throws SQLException {
		List<ServicioModel> listaUsuarios=new ArrayList<ServicioModel>();
		try {
			listaUsuarios = ProveedorDao.consultaGeneral();
		} catch (SQLException t) {
			throw new SQLException(t.getMessage());
		}
		return listaUsuarios;
	}

	public static ServicioModel consultaEditar(String servicio)throws SQLException {
		ServicioModel ServicioModel=new ServicioModel();
		try{
			ServicioModel=ProveedorDao.consultaEditar(servicio);
		}catch(Exception e){
			throw new SQLException(e.getMessage());
		}
		return ServicioModel;
	}

	public static String eliminarServicio(String servicio){
		String resultado="correcto editar";
		try{
			resultado=ProveedorDao.eliminarServicio(servicio);
		}catch(Exception e){
		}		
		return resultado;
	}

}
