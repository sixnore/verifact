package com.lords.bo;

import com.lords.dao.OrdenPagoDao;
import com.lords.model.OrdenPagoModel;
import com.lords.model.ProveedorModel;
import com.lords.model.ServicioModel;

public class OrdenPagoBo {

	OrdenPagoDao pagoDao = new OrdenPagoDao();
	
	public String registrarOrdenPago(OrdenPagoModel pagoModel, ServicioModel servicioModel, ProveedorModel provModel) {
		String mensaje = "";
		
		String aplicacionContable = pagoModel.getAplicContable();
		float importeNumero = pagoModel.getImporteNumero();
		String importeLetra = pagoModel.getImporteLetra();		
		String tipoPago = pagoModel.getTipoPago();
		String fechaO = pagoModel.getFecharOrden();
		
		String proveedor = provModel.getProveedor();
		
		String servicio = servicioModel.getServicio();
		
		
		
		mensaje = OrdenPagoDao.registrarOrdenPago(pagoModel, servicioModel, provModel);
		return mensaje;
	}

}
