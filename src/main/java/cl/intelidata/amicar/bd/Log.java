package cl.intelidata.amicar.bd;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Log entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "log", catalog = "amicarcotizante")
public class Log extends AbstractLog implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Log() {
	}

	/** minimal constructor
     * @param idlog */
	public Log(Integer idlog) {
		super(idlog);
	}

	/** full constructor
     * @param idlog
     * @param fechaLog
     * @param idCliente
     * @param idVendedor
     * @param idEjecutivo */
	public Log(Integer idlog, Integer idVendedor, Integer idCliente,
			Integer idEjecutivo, Timestamp fechaLog) {
		super(idlog, idVendedor, idCliente, idEjecutivo, fechaLog);
	}

}
