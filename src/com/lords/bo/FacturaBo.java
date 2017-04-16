package com.lords.bo;

import com.lords.dao.FacturaDao;
import com.lords.model.FacturaModel;
import com.lords.model.OrdenPagoModel;
import com.lords.model.ProveedorModel;
import com.lords.model.ServicioModel;

public class FacturaBo {

	FacturaDao facturaDao = new FacturaDao();
	
	public String registrarFact(OrdenPagoModel ordenPago, FacturaModel facturaModel, ProveedorModel proveedorModel, ServicioModel servicioModel) {
		String mensaje = "";
		
		String folio = facturaModel.getFolioFactura();
		
		if(folio.length()>50){
			mensaje = "Formato de factura demasiado largo";
		}else{
			mensaje = facturaDao.registrarFact(ordenPago, facturaModel, proveedorModel, servicioModel);
		}
		return mensaje;
	}	
}
