package com.lords.bo;

import com.lords.dao.ProveedorDao;
import com.lords.model.ProveedorModel;

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

}
