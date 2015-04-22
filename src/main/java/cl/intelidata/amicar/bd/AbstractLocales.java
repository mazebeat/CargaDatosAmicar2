package cl.intelidata.amicar.bd;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

/**
 * AbstractLocales entity provides the base persistence definition of the
 * Locales entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractLocales implements java.io.Serializable {

	// Fields

	private Integer idLocal;
	private String nombreLocal;
	private Set<Vendedores> vendedoreses = new HashSet<Vendedores>(0);
	private Set<Ejecutivos> ejecutivoses = new HashSet<Ejecutivos>(0);

	// Constructors

	/** default constructor */
	public AbstractLocales() {
	}

	/** full constructor
     * @param nombreLocal
     * @param vendedoreses
     * @param ejecutivoses */
	public AbstractLocales(String nombreLocal, Set<Vendedores> vendedoreses,
			Set<Ejecutivos> ejecutivoses) {
		this.nombreLocal = nombreLocal;
		this.vendedoreses = vendedoreses;
		this.ejecutivoses = ejecutivoses;
	}

	// Property accessors

    /**
     *
     * @return
     */
    	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idLocal", unique = true, nullable = false)
	public Integer getIdLocal() {
		return this.idLocal;
	}

    /**
     *
     * @param idLocal
     */
    public void setIdLocal(Integer idLocal) {
		this.idLocal = idLocal;
	}

    /**
     *
     * @return
     */
    @Column(name = "nombreLocal")
	public String getNombreLocal() {
		return this.nombreLocal;
	}

    /**
     *
     * @param nombreLocal
     */
    public void setNombreLocal(String nombreLocal) {
		this.nombreLocal = nombreLocal;
	}

    /**
     *
     * @return
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "locales")
	public Set<Vendedores> getVendedoreses() {
		return this.vendedoreses;
	}

    /**
     *
     * @param vendedoreses
     */
    public void setVendedoreses(Set<Vendedores> vendedoreses) {
		this.vendedoreses = vendedoreses;
	}

    /**
     *
     * @return
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "locales")
	public Set<Ejecutivos> getEjecutivoses() {
		return this.ejecutivoses;
	}

    /**
     *
     * @param ejecutivoses
     */
    public void setEjecutivoses(Set<Ejecutivos> ejecutivoses) {
		this.ejecutivoses = ejecutivoses;
	}

}