package cl.intelidata.amicar.bd;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * AbstractProceso entity provides the base persistence definition of the
 * Proceso entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractProceso implements java.io.Serializable {

	// Fields

	private Integer idProceso;
	private Ejecutivos ejecutivos;
	private Clientesdiario clientesdiario;
	private Vendedores vendedores;
	private Timestamp fechaEnvio;
	private Timestamp fechaAperturaMail;
	private Timestamp fechaClickLink;

	// Constructors

	/** default constructor */
	public AbstractProceso() {
	}

	/** minimal constructor
     * @param ejecutivos
     * @param clientesdiario
     * @param vendedores */
	public AbstractProceso(Ejecutivos ejecutivos, Clientesdiario clientesdiario,
			Vendedores vendedores) {
		this.ejecutivos = ejecutivos;
		this.clientesdiario = clientesdiario;
		this.vendedores = vendedores;
	}

	/** full constructor
     * @param ejecutivos
     * @param fechaClickLink
     * @param vendedores
     * @param fechaEnvio
     * @param clientesdiario
     * @param fechaAperturaMail */
	public AbstractProceso(Ejecutivos ejecutivos,  Clientesdiario clientesdiario,
			Vendedores vendedores, Timestamp fechaEnvio,
			Timestamp fechaAperturaMail, Timestamp fechaClickLink) {
		this.ejecutivos = ejecutivos;
		this.clientesdiario = clientesdiario;
		this.vendedores = vendedores;
		this.fechaEnvio = fechaEnvio;
		this.fechaAperturaMail = fechaAperturaMail;
		this.fechaClickLink = fechaClickLink;
	}

	// Property accessors

    /**
     *
     * @return
     */
    	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idProceso", unique = true, nullable = false)
	public Integer getIdProceso() {
		return this.idProceso;
	}

    /**
     *
     * @param idProceso
     */
    public void setIdProceso(Integer idProceso) {
		this.idProceso = idProceso;
	}

    /**
     *
     * @return
     */
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ejecutivos_idEjecutivo", nullable = false)
	public Ejecutivos getEjecutivos() {
		return this.ejecutivos;
	}

    /**
     *
     * @param ejecutivos
     */
    public void setEjecutivos(Ejecutivos ejecutivos) {
		this.ejecutivos = ejecutivos;
	}

    /**
     *
     * @return
     */
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clientes_idCliente", nullable = false)
	public Clientesdiario getClientesdiario() {
		return this.clientesdiario;
	}

    /**
     *
     * @param clientesdiario
     */
    public void setClientesdiario(Clientesdiario clientesdiario) {
		this.clientesdiario = clientesdiario;
	}

    /**
     *
     * @return
     */
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vendedores_idVendedor", nullable = false)
	public Vendedores getVendedores() {
		return this.vendedores;
	}

    /**
     *
     * @param vendedores
     */
    public void setVendedores(Vendedores vendedores) {
		this.vendedores = vendedores;
	}

    /**
     *
     * @return
     */
    @Column(name = "fechaEnvio", length = 19)
	public Timestamp getFechaEnvio() {
		return this.fechaEnvio;
	}

    /**
     *
     * @param fechaEnvio
     */
    public void setFechaEnvio(Timestamp fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

    /**
     *
     * @return
     */
    @Column(name = "fechaAperturaMail", length = 19)
	public Timestamp getFechaAperturaMail() {
		return this.fechaAperturaMail;
	}

    /**
     *
     * @param fechaAperturaMail
     */
    public void setFechaAperturaMail(Timestamp fechaAperturaMail) {
		this.fechaAperturaMail = fechaAperturaMail;
	}

    /**
     *
     * @return
     */
    @Column(name = "fechaClickLink", length = 19)
	public Timestamp getFechaClickLink() {
		return this.fechaClickLink;
	}

    /**
     *
     * @param fechaClickLink
     */
    public void setFechaClickLink(Timestamp fechaClickLink) {
		this.fechaClickLink = fechaClickLink;
	}

}