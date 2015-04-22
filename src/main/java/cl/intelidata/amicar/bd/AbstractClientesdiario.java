package cl.intelidata.amicar.bd;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * AbstractClientesdiario entity provides the base persistence definition of the
 * Clientesdiario entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractClientesdiario implements java.io.Serializable {

	// Fields

	private Integer idCliente;
	private String rutCliente;
	private String emailCliente;
	private String nombreCliente;
	private String fonoCelular;
	private String fonoComercial;
	private String fonoParticular;
	private String marcaAuto;
	private String modeloAuto;
	private String valorAuto;
	private Integer idGrupo;
	private Integer idBody;
	private Timestamp fecha;
	private String nombreJrn;
	private Set<Proceso> procesos = new HashSet<Proceso>(0);

	// Constructors

	/** default constructor */
	public AbstractClientesdiario() {
	}

	/** full constructor
     * @param rutCliente
     * @param emailCliente
     * @param nombreCliente
     * @param fecha
     * @param fonoCelular
     * @param fonoParticular
     * @param fonoComercial
     * @param nombreJrn
     * @param idBody
     * @param modeloAuto
     * @param marcaAuto
     * @param valorAuto
     * @param procesos
     * @param idGrupo */
	public AbstractClientesdiario(String rutCliente, String emailCliente,
			String nombreCliente, String fonoCelular, String fonoComercial,
			String fonoParticular, String marcaAuto, String modeloAuto,
			String valorAuto, Integer idGrupo, Integer idBody, Timestamp fecha,
			String nombreJrn, Set<Proceso> procesos) {
		this.rutCliente = rutCliente;
		this.emailCliente = emailCliente;
		this.nombreCliente = nombreCliente;
		this.fonoCelular = fonoCelular;
		this.fonoComercial = fonoComercial;
		this.fonoParticular = fonoParticular;
		this.marcaAuto = marcaAuto;
		this.modeloAuto = modeloAuto;
		this.valorAuto = valorAuto;
		this.idGrupo = idGrupo;
		this.idBody = idBody;
		this.fecha = fecha;
		this.nombreJrn = nombreJrn;
		this.procesos = procesos;
	}

	// Property accessors

    /**
     *
     * @return
     */
    	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idCliente", unique = true, nullable = false)
	public Integer getIdCliente() {
		return this.idCliente;
	}

    /**
     *
     * @param idCliente
     */
    public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

    /**
     *
     * @return
     */
    @Column(name = "rutCliente", length = 12)
	public String getRutCliente() {
		return this.rutCliente;
	}

    /**
     *
     * @param rutCliente
     */
    public void setRutCliente(String rutCliente) {
		this.rutCliente = rutCliente;
	}

    /**
     *
     * @return
     */
    @Column(name = "emailCliente", length = 45)
	public String getEmailCliente() {
		return this.emailCliente;
	}

    /**
     *
     * @param emailCliente
     */
    public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

    /**
     *
     * @return
     */
    @Column(name = "nombreCliente", length = 45)
	public String getNombreCliente() {
		return this.nombreCliente;
	}

    /**
     *
     * @param nombreCliente
     */
    public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

    /**
     *
     * @return
     */
    @Column(name = "fonoCelular", length = 15)
	public String getFonoCelular() {
		return this.fonoCelular;
	}

    /**
     *
     * @param fonoCelular
     */
    public void setFonoCelular(String fonoCelular) {
		this.fonoCelular = fonoCelular;
	}

    /**
     *
     * @return
     */
    @Column(name = "fonoComercial", length = 15)
	public String getFonoComercial() {
		return this.fonoComercial;
	}

    /**
     *
     * @param fonoComercial
     */
    public void setFonoComercial(String fonoComercial) {
		this.fonoComercial = fonoComercial;
	}

    /**
     *
     * @return
     */
    @Column(name = "fonoParticular", length = 15)
	public String getFonoParticular() {
		return this.fonoParticular;
	}

    /**
     *
     * @param fonoParticular
     */
    public void setFonoParticular(String fonoParticular) {
		this.fonoParticular = fonoParticular;
	}

    /**
     *
     * @return
     */
    @Column(name = "marcaAuto", length = 45)
	public String getMarcaAuto() {
		return this.marcaAuto;
	}

    /**
     *
     * @param marcaAuto
     */
    public void setMarcaAuto(String marcaAuto) {
		this.marcaAuto = marcaAuto;
	}

    /**
     *
     * @return
     */
    @Column(name = "modeloAuto", length = 45)
	public String getModeloAuto() {
		return this.modeloAuto;
	}

    /**
     *
     * @param modeloAuto
     */
    public void setModeloAuto(String modeloAuto) {
		this.modeloAuto = modeloAuto;
	}

    /**
     *
     * @return
     */
    @Column(name = "valorAuto", length = 45)
	public String getValorAuto() {
		return this.valorAuto;
	}

    /**
     *
     * @param valorAuto
     */
    public void setValorAuto(String valorAuto) {
		this.valorAuto = valorAuto;
	}

    /**
     *
     * @return
     */
    @Column(name = "idGrupo")
	public Integer getIdGrupo() {
		return this.idGrupo;
	}

    /**
     *
     * @param idGrupo
     */
    public void setIdGrupo(Integer idGrupo) {
		this.idGrupo = idGrupo;
	}

    /**
     *
     * @return
     */
    @Column(name = "idBody")
	public Integer getIdBody() {
		return this.idBody;
	}

    /**
     *
     * @param idBody
     */
    public void setIdBody(Integer idBody) {
		this.idBody = idBody;
	}

    /**
     *
     * @return
     */
    @Column(name = "fecha", length = 19)
	public Timestamp getFecha() {
		return this.fecha;
	}

    /**
     *
     * @param fecha
     */
    public void setFecha(Timestamp fecha) {
		Date date = new Date();
		this.fecha = new Timestamp(date.getTime());
	}

    /**
     *
     * @return
     */
    @Column(name = "nombreJrn", length = 100)
	public String getNombreJrn() {
		return this.nombreJrn;
	}

    /**
     *
     * @param nombreJrn
     */
    public void setNombreJrn(String nombreJrn) {
		this.nombreJrn = nombreJrn;
	}

    /**
     *
     * @return
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "clientesdiario")
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