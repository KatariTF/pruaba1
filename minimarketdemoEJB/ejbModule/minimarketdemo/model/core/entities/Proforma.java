package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the proforma database table.
 * 
 */
@Entity
@Table(name="proforma")
@NamedQuery(name="Proforma.findAll", query="SELECT p FROM Proforma p")
public class Proforma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="prof_id", unique=true, nullable=false)
	private Integer profId;

	@Column(name="prof_cli_ced", nullable=false, length=10)
	private String profCliCed;

	@Temporal(TemporalType.DATE)
	@Column(name="prof_fecha", nullable=false)
	private Date profFecha;

	@Temporal(TemporalType.DATE)
	@Column(name="prof_fecha_fin", nullable=false)
	private Date profFechaFin;

	@Column(name="prof_pago", nullable=false)
	private Boolean profPago;

	//bi-directional many-to-one association to DetalleProforma
	@OneToMany(mappedBy="proforma")
	private List<DetalleProforma> detalleProformas;

	//bi-directional many-to-one association to Ordenprod
	@OneToMany(mappedBy="proforma")
	private List<Ordenprod> ordenprods;

	public Proforma() {
	}

	public Integer getProfId() {
		return this.profId;
	}

	public void setProfId(Integer profId) {
		this.profId = profId;
	}

	public String getProfCliCed() {
		return this.profCliCed;
	}

	public void setProfCliCed(String profCliCed) {
		this.profCliCed = profCliCed;
	}

	public Date getProfFecha() {
		return this.profFecha;
	}

	public void setProfFecha(Date profFecha) {
		this.profFecha = profFecha;
	}

	public Date getProfFechaFin() {
		return this.profFechaFin;
	}

	public void setProfFechaFin(Date profFechaFin) {
		this.profFechaFin = profFechaFin;
	}

	public Boolean getProfPago() {
		return this.profPago;
	}

	public void setProfPago(Boolean profPago) {
		this.profPago = profPago;
	}

	public List<DetalleProforma> getDetalleProformas() {
		return this.detalleProformas;
	}

	public void setDetalleProformas(List<DetalleProforma> detalleProformas) {
		this.detalleProformas = detalleProformas;
	}

	public DetalleProforma addDetalleProforma(DetalleProforma detalleProforma) {
		getDetalleProformas().add(detalleProforma);
		detalleProforma.setProforma(this);

		return detalleProforma;
	}

	public DetalleProforma removeDetalleProforma(DetalleProforma detalleProforma) {
		getDetalleProformas().remove(detalleProforma);
		detalleProforma.setProforma(null);

		return detalleProforma;
	}

	public List<Ordenprod> getOrdenprods() {
		return this.ordenprods;
	}

	public void setOrdenprods(List<Ordenprod> ordenprods) {
		this.ordenprods = ordenprods;
	}

	public Ordenprod addOrdenprod(Ordenprod ordenprod) {
		getOrdenprods().add(ordenprod);
		ordenprod.setProforma(this);

		return ordenprod;
	}

	public Ordenprod removeOrdenprod(Ordenprod ordenprod) {
		getOrdenprods().remove(ordenprod);
		ordenprod.setProforma(null);

		return ordenprod;
	}

}