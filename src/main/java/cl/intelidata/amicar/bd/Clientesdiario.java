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

	/** full constructor
     * @param rutCliente
     * @param emailCliente
     * @param idGrupo
     * @param nombreCliente
     * @param fonoCelular
     * @param fonoComercial
     * @param valorAuto
     * @param marcaAuto
     * @param fonoParticular
     * @param modeloAuto
     * @param idBody
     * @param fecha
     * @param nombreJrn
     * @param procesos */
	public Clientesdiario(String rutCliente, String emailCliente,
			String nombreCliente, String fonoCelular, String fonoComercial,
			String fonoParticular, String marcaAuto, String modeloAuto,
			String valorAuto, Integer idGrupo, Integer idBody, Timestamp fecha,
			String nombreJrn, Set<Proceso> procesos) {
		super(rutCliente, emailCliente, nombreCliente, fonoCelular,
				fonoComercial, fonoParticular, marcaAuto, modeloAuto,
				valorAuto, idGrupo, idBody, fecha, nombreJrn,
				procesos);
	}

}
