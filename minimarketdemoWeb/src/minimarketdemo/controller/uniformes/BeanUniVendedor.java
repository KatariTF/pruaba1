package minimarketdemo.controller.uniformes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import minimarketdemo.model.core.entities.Proforma;
import minimarketdemo.model.uniformes.managers.ManagerUniforme;

@Named
@SessionScoped
public class BeanUniVendedor implements Serializable {

	@EJB
	private ManagerUniforme mUniforme;
	
	private boolean pago;
	
	private List<Proforma> listaProformas;
	
	
	public BeanUniVendedor() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void inicializar() {
		listaProformas = mUniforme.findAllProforma();
	}
	
	
	public void actualizarProforma(Proforma proforma) throws Exception {
		proforma.setProfPago(true);
		mUniforme.updateProforma(proforma);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	public List<Proforma> getListaProformas() {
		return listaProformas;
	}

	public void setListaProformas(List<Proforma> listaProformas) {
		this.listaProformas = listaProformas;
	}

	public boolean isPago() {
		return pago;
	}

	public void setPago(boolean pago) {
		this.pago = pago;
	}


	
	
}
