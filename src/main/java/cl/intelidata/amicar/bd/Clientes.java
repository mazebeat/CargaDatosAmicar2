package cl.intelidata.amicar.bd;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Clientes entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "clientes", catalog = "amicarcotizante")
public class Clientes extends AbstractClientes implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Clientes() {
	}

	/** full constructor */
	public Clientes(String rutCliente, String emailCliente,
			String nombreCliente, String sexoCliente, String fonoCliente,
			String automovilCliente, Integer idGrupo, Integer idBody,
			Timestamp fecha, String nombreJrn) {
		super(rutCliente, emailCliente, nombreCliente, sexoCliente,
				fonoCliente, automovilCliente, idGrupo, idBody, fecha,
				nombreJrn);
	}

}
