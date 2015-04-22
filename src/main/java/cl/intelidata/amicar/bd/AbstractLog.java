package cl.intelidata.amicar.bd;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * AbstractLog entity provides the base persistence definition of the Log
 * entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractLog implements java.io.Serializable {

	// Fields

	private Integer idlog;
	private Integer idVendedor;
	private Integer idCliente;
	private Integer idEjecutivo;
	private Timestamp fechaLog;

	// Constructors

	/** default constructor */
	public AbstractLog() {
	}

	/** minimal constructor
     * @param idlog */
	public AbstractLog(Integer idlog) {
		this.idlog = idlog;
	}

	/** full constructor
     * @param idlog
     * @param idCliente
     * @param idVendedor
     * @param idEjecutivo
     * @param fechaLog */
	public AbstractLog(Integer idlog, Integer idVendedor, Integer idCliente,
			Integer idEjecutivo, Timestamp fechaLog) {
		this.idlog = idlog;
		this.idVendedor = idVendedor;
		this.idCliente = idCliente;
		this.idEjecutivo = idEjecutivo;
		this.fechaLog = fechaLog;
	}

	// Property accessors

    /**
     *
     * @return
     */
    	@Id
	@Column(name = "idlog", unique = true, nullable = false)
	public Integer getIdlog() {
		return this.idlog;
	}

    /**
     *
     * @param idlog
     */
    public void setIdlog(Integer idlog) {
		this.idlog = idlog;
	}

    /**
     *
     * @return
     */
    @Column(name = "idVendedor")
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
    @Column(name = "idCliente")
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
    @Column(name = "idEjecutivo")
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
    @Column(name = "fechaLog", length = 19)
	public Timestamp getFechaLog() {
		return this.fechaLog;
	}

    /**
     *
     * @param fechaLog
     */
    public void setFechaLog(Timestamp fechaLog) {
		this.fechaLog = fechaLog;
	}

}