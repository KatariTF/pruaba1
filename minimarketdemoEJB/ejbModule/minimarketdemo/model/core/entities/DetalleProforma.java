package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detalle_proforma database table.
 * 
 */
@Entity
@Table(name="detalle_proforma")
@NamedQuery(name="DetalleProforma.findAll", query="SELECT d FROM DetalleProforma d")
public class DetalleProforma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="deta_id", unique=true, nullable=false)
	private Integer detaId;

	@Column(name="deta_cant", nullable=false)
	private Integer detaCant;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="pro_id", nullable=false)
	private Producto producto;

	//bi-directional many-to-one association to Proforma
	@ManyToOne
	@JoinColumn(name="prof_id", nullable=false)
	private Proforma proforma;

	public DetalleProforma() {
	}

	public Integer getDetaId() {
		return this.detaId;
	}

	public void setDetaId(Integer detaId) {
		this.detaId = detaId;
	}

	public Integer getDetaCant() {
		return this.detaCant;
	}

	public void setDetaCant(Integer detaCant) {
		this.detaCant = detaCant;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Proforma getProforma() {
		return this.proforma;
	}

	public void setProforma(Proforma proforma) {
		this.proforma = proforma;
	}

}