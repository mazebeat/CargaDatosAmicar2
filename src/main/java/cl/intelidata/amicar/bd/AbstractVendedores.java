package cl.intelidata.amicar.bd;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

/**
 * AbstractVendedores entity provides the base persistence definition of the
 * Vendedores entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractVendedores implements java.io.Serializable {

	// Fields

	private Integer idVendedor;
	private Locales locales;
	private String rutVendedor;
	private String nombreVendedor;
	private Set<Proceso> procesos = new HashSet<Proceso>(0);

	// Constructors

	/** default constructor */
	public AbstractVendedores() {
	}

	/** minimal constructor
     * @param locales */
	public AbstractVendedores(Locales locales) {
		this.locales = locales;
	}

	/** full constructor
     * @param locales
     * @param procesos
     * @param rutVendedor
     * @param nombreVendedor */
	public AbstractVendedores(Locales locales, String rutVendedor,
			String nombreVendedor, Set<Proceso> procesos) {
		this.locales = locales;
		this.rutVendedor = rutVendedor;
		this.nombreVendedor = nombreVendedor;
		this.procesos = procesos;
	}

	// Property accessors

    /**
     *
     * @return
     */
    	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idVendedor", unique = true, nullable = false)
	public Integer getIdVendedor() {
		return this.idVendedor;
	}

    /**
     *
     * @param idVendedor
     */
    public void setIdVendedor(Integer idVendedor) {
		this.idVendedor = idVendedor;
	}

    /**
     *
     * @return
     */
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "locales_idLocal", nullable = false)
	public Locales getLocales() {
		return this.locales;
	}

    /**
     *
     * @param locales
     */
    public void setLocales(Locales locales) {
		this.locales = locales;
	}

    /**
     *
     * @return
     */
    @Column(name = "rutVendedor", length = 12)
	public String getRutVendedor() {
		return this.rutVendedor;
	}

    /**
     *
     * @param rutVendedor
     */
    public void setRutVendedor(String rutVendedor) {
		this.rutVendedor = rutVendedor;
	}

    /**
     *
     * @return
     */
    @Column(name = "nombreVendedor", length = 100)
	public String getNombreVendedor() {
		return this.nombreVendedor;
	}

    /**
     *
     * @param nombreVendedor
     */
    public void setNombreVendedor(String nombreVendedor) {
		this.nombreVendedor = nombreVendedor;
	}

    /**
     *
     * @return
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "vendedores")
	public Set<Proceso> getProcesos() {
		return this.procesos;
	}

    /**
     *
     * @param procesos
     */
    public void setProcesos(Set<Proceso> procesos) {
		this.procesos = procesos;
	}

}