package cl.intelidata.amicar.bd;

import java.sql.Timestamp;
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
 * AbstractEjecutivos entity provides the base persistence definition of the
 * Ejecutivos entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractEjecutivos implements java.io.Serializable {

	// Fields

	private Integer idEjecutivo;
	private Locales locales;
	private String nombreEjecutivo;
	private String correoEjecutivo;
	private Timestamp fechaIngreso;
	private String fechaModificacion;
	private Set<Proceso> procesos = new HashSet<Proceso>(0);

	// Constructors

	/** default constructor */
	public AbstractEjecutivos() {
	}

	/** minimal constructor
     * @param locales */
	public AbstractEjecutivos(Locales locales) {
		this.locales = locales;
	}

	/** full constructor
     * @param locales
     * @param nombreEjecutivo
     * @param correoEjecutivo
     * @param fechaIngreso
     * @param fechaModificacion
     * @param procesos */
	public AbstractEjecutivos(Locales locales, String nombreEjecutivo,
			String correoEjecutivo, Timestamp fechaIngreso,
			String fechaModificacion, Set<Proceso> procesos) {
		this.locales = locales;
		this.nombreEjecutivo = nombreEjecutivo;
		this.correoEjecutivo = correoEjecutivo;
		this.fechaIngreso = fechaIngreso;
		this.fechaModificacion = fechaModificacion;
		this.procesos = procesos;
	}

	// Property accessors

    /**
     *
     * @return
     */
    	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idEjecutivo", unique = true, nullable = false)
	public Integer getIdEjecutivo() {
		return this.idEjecutivo;
	}

    /**
     *
     * @param idEjecutivo
     */
    public void setIdEjecutivo(Integer idEjecutivo) {
		this.idEjecutivo = idEjecutivo;
	}

    /**
     *
     * @return
     */
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "locales_idLocal1", nullable = false)
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
    @Column(name = "nombreEjecutivo", length = 100)
	public String getNombreEjecutivo() {
		return this.nombreEjecutivo;
	}

    /**
     *
     * @param nombreEjecutivo
     */
    public void setNombreEjecutivo(String nombreEjecutivo) {
		this.nombreEjecutivo = nombreEjecutivo;
	}

    /**
     *
     * @return
     */
    @Column(name = "correoEjecutivo", length = 45)
	public String getCorreoEjecutivo() {
		return this.correoEjecutivo;
	}

    /**
     *
     * @param correoEjecutivo
     */
    public void setCorreoEjecutivo(String correoEjecutivo) {
		this.correoEjecutivo = correoEjecutivo;
	}

    /**
     *
     * @return
     */
    @Column(name = "fechaIngreso", length = 19)
	public Timestamp getFechaIngreso() {
		return this.fechaIngreso;
	}

    /**
     *
     * @param fechaIngreso
     */
    public void setFechaIngreso(Timestamp fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

    /**
     *
     * @return
     */
    @Column(name = "fechaModificacion", length = 45)
	public String getFechaModificacion() {
		return this.fechaModificacion;
	}

    /**
     *
     * @param fechaModificacion
     */
    public void setFechaModificacion(String fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

    /**
     *
     * @return
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ejecutivos")
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