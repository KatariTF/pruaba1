package minimarketdemo.controller.uniformes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import minimarketdemo.model.core.entities.DetalleProforma;
import minimarketdemo.model.core.entities.Producto;
import minimarketdemo.model.core.entities.Proforma;
import minimarketdemo.model.core.utils.ModelUtil;
import minimarketdemo.model.uniformes.managers.ManagerUniforme;

@Named
@SessionScoped
public class BeanUniCliente implements Serializable {

	@EJB
	private ManagerUniforme mUniforme;
	
	private DetalleProforma detalleProforma;
	private Proforma proforma;
	private Producto producto;
	private int cantidad;
	private int idUniforme;
	private String cedula;
	
	private List<DetalleProforma> listaCarrito;
	private List<Producto> listaProducto;
	private List<Producto> listaSeleccion;
	
	public BeanUniCliente() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void inicializar() {
		proforma = new Proforma();
		detalleProforma = new DetalleProforma();
		listaCarrito = new ArrayList<DetalleProforma>();
		listaProducto = mUniforme.findAllProducto();
	}
	
	public void actionSelecionUniforme() throws Exception {
		proforma.setProfCliCed(cedula);
		detalleProforma.setDetaCant(cantidad);
		detalleProforma.setProducto(mUniforme.findProductoByID(idUniforme));
		detalleProforma.setProforma(proforma);
		listaCarrito.add(detalleProforma);
		proforma = new Proforma();
		detalleProforma = new DetalleProforma();
	}
	
	public void actionEnviarListado() throws Exception {
		proforma = new Proforma();
		proforma.setProfFecha(new Date());
		proforma.setProfFechaFin(ModelUtil.addDays(new Date(), 30));
		proforma.setProfPago(false);
		proforma.setProfCliCed(listaCarrito.get(1).getProforma().getProfCliCed());
		mUniforme.createProforma(proforma);
		for (DetalleProforma d : listaCarrito) {
			detalleProforma = new DetalleProforma();
			detalleProforma.setProforma(proforma);
			detalleProforma.setProducto(d.getProducto());
			detalleProforma.setDetaCant(d.getDetaCant());
			mUniforme.createDetalleProforma(detalleProforma);
		}
	}
	
	public void actionCancelarListado() throws Exception {
		listaCarrito = null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public List<Producto> getListaProducto() {
		return listaProducto;
	}

	public void setListaProducto(List<Producto> listaProducto) {
		this.listaProducto = listaProducto;
	}

	public DetalleProforma getDetalleProforma() {
		return detalleProforma;
	}

	public void setDetalleProforma(DetalleProforma detalleProforma) {
		this.detalleProforma = detalleProforma;
	}

	public Proforma getProforma() {
		return proforma;
	}

	public void setProforma(Proforma proforma) {
		this.proforma = proforma;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public List<DetalleProforma> getListaCarrito() {
		return listaCarrito;
	}

	public void setListaCarrito(List<DetalleProforma> listaCarrito) {
		this.listaCarrito = listaCarrito;
	}

	public List<Producto> getListaSeleccion() {
		return listaSeleccion;
	}

	public void setListaSeleccion(List<Producto> listaSeleccion) {
		this.listaSeleccion = listaSeleccion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getIdUniforme() {
		return idUniforme;
	}

	public void setIdUniforme(int idUniforme) {
		this.idUniforme = idUniforme;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	
	
}
