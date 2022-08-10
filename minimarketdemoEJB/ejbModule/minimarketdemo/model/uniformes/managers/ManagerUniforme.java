package minimarketdemo.model.uniformes.managers;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import minimarketdemo.model.core.entities.DetalleProforma;
import minimarketdemo.model.core.entities.Ordenprod;
import minimarketdemo.model.core.entities.Producto;
import minimarketdemo.model.core.entities.Proforma;
import minimarketdemo.model.core.managers.ManagerDAO;

/**
 * Session Bean implementation class ManagerUniforme
 */
@Stateless
@LocalBean
public class ManagerUniforme {

	@EJB
	private ManagerDAO mDAO;
    /**
     * Default constructor. 
     */
    public ManagerUniforme() {
        // TODO Auto-generated constructor stub
    }
    
    public List<Producto> findAllProducto(){
    	return mDAO.findAll(Producto.class);
    }
    
    public List<Producto> inicializarProyecto() {
    	return findAllProducto();
    }
    
    public Producto findProductoByID(int idProducto) throws Exception {
    	return (Producto) mDAO.findById(Producto.class, idProducto);
    }
    
    public void createProforma(Proforma proforma) throws Exception {
    	mDAO.insertar(proforma);
    }
    
    public void createDetalleProforma(DetalleProforma detalleProforma) throws Exception {
    	mDAO.insertar(detalleProforma);
    }
    
    public List<Proforma> findAllProforma() {
    	return mDAO.findAll(Proforma.class);
    }
    
    public void updateProforma(Proforma proforma) throws Exception {
    	mDAO.actualizar(proforma);
    }
    
    public List<Ordenprod> findAllOrdenProduccion() {
    	return mDAO.findAll(Ordenprod.class);
    }
    
    public void createOrdenProforma(Ordenprod ordenProduccion) throws Exception {
    	mDAO.insertar(ordenProduccion);
    }
    
    public void updateOrdenProduccion(Ordenprod ordenProduccion) throws Exception {
    	mDAO.actualizar(ordenProduccion);
    }
}
