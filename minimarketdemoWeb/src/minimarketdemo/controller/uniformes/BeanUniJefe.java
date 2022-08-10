package minimarketdemo.controller.uniformes;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import minimarketdemo.model.core.entities.Ordenprod;
import minimarketdemo.model.core.entities.Proforma;
import minimarketdemo.model.uniformes.managers.ManagerUniforme;

@Named
@SessionScoped
public class BeanUniJefe implements Serializable {

	@EJB
	private ManagerUniforme mUniforme;
	
	private Ordenprod ordenProduccion;
	private List<Proforma> listaProformas;
	private List<Ordenprod> listaOrdenProduccion;
	
	public BeanUniJefe() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void inicializar() {
		ordenProduccion = new Ordenprod();
		listaProformas = mUniforme.findAllProforma();
		listaOrdenProduccion = mUniforme.findAllOrdenProduccion();
	}

	public void createOrdenProduccion(Proforma proforma) throws Exception {
		ordenProduccion.setProforma(proforma);
		ordenProduccion.setOrdFecFin(proforma.getProfFecha());
		ordenProduccion.setOrdFecFin(proforma.getProfFechaFin());
		ordenProduccion.setOrdState(true);
		mUniforme.createOrdenProforma(ordenProduccion);
		listaOrdenProduccion = mUniforme.findAllOrdenProduccion();
	}
	
	public void actualizarOrdenProduccion(Ordenprod ordenProduccion) throws Exception {
		ordenProduccion.setOrdState(false);
		mUniforme.updateOrdenProduccion(ordenProduccion);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<Proforma> getListaProformas() {
		return listaProformas;
	}

	public void setListaProformas(List<Proforma> listaProformas) {
		this.listaProformas = listaProformas;
	}

	public List<Ordenprod> getListaOrdenProduccion() {
		return listaOrdenProduccion;
	}

	public void setListaOrdenProduccion(List<Ordenprod> listaOrdenProduccion) {
		this.listaOrdenProduccion = listaOrdenProduccion;
	}

	public Ordenprod getOrdenProduccion() {
		return ordenProduccion;
	}

	public void setOrdenProduccion(Ordenprod ordenProduccion) {
		this.ordenProduccion = ordenProduccion;
	}
	
	
	
	
	
	
	
	
}
