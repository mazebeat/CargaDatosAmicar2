package cl.intelidata.amicar.bd;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Clientesdiario entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "clientesdiario", catalog = "amicarcotizante")
public class Clientesdiario extends AbstractClientesdiario implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Clientesdiario() {
	}

	/** full constructor */
	public Clientesdiario(String rutCliente, String emailCliente,
			String nombreCliente, String sexoCliente, String fonoCliente,
			String automovilCliente, Integer idGrupo, Integer idBody,
			Timestamp fecha, String nombreJrn, Set<Proceso> procesos) {
		super(rutCliente, emailCliente, nombreCliente, sexoCliente,
				fonoCliente, automovilCliente, idGrupo, idBody, fecha,
				nombreJrn, procesos);
	}

}
