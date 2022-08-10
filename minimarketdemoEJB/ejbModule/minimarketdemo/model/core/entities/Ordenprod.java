package minimarketdemo.model.core.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ordenprod database table.
 * 
 */
@Entity
@Table(name="ordenprod")
@NamedQuery(name="Ordenprod.findAll", query="SELECT o FROM Ordenprod o")
public class Ordenprod implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ord_id", unique=true, nullable=false)
	private Integer ordId;

	@Temporal(TemporalType.DATE)
	@Column(name="ord_fec_fin")
	private Date ordFecFin;

	@Temporal(TemporalType.DATE)
	@Column(name="ord_fec_ini")
	private Date ordFecIni;

	@Column(name="ord_state")
	private Boolean ordState;

	//bi-directional many-to-one association to Proforma
	@ManyToOne
	@JoinColumn(name="prof_id")
	private Proforma proforma;

	public Ordenprod() {
	}

	public Integer getOrdId() {
		return this.ordId;
	}

	public void setOrdId(Integer ordId) {
		this.ordId = ordId;
	}

	public Date getOrdFecFin() {
		return this.ordFecFin;
	}

	public void setOrdFecFin(Date ordFecFin) {
		this.ordFecFin = ordFecFin;
	}

	public Date getOrdFecIni() {
		return this.ordFecIni;
	}

	public void setOrdFecIni(Date ordFecIni) {
		this.ordFecIni = ordFecIni;
	}

	public Boolean getOrdState() {
		return this.ordState;
	}

	public void setOrdState(Boolean ordState) {
		this.ordState = ordState;
	}

	public Proforma getProforma() {
		return this.proforma;
	}

	public void setProforma(Proforma proforma) {
		this.proforma = proforma;
	}

}