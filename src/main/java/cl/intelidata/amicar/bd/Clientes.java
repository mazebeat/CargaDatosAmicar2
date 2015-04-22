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

	/** minimal constructor
     * @param desinscrito */
	public Clientes(Boolean desinscrito) {
		super(desinscrito);
	}

	/** full constructor
     * @param rutCliente
     * @param fonoComercial
     * @param nombreCliente
     * @param emailCliente
     * @param fonoCelular
     * @param valorAuto
     * @param idGrupo
     * @param fonoParticular
     * @param marcaAuto
     * @param desinscrito
     * @param modeloAuto
     * @param nombreJrn
     * @param idBody
     * @param fecha */
	public Clientes(String rutCliente, String emailCliente,
			String nombreCliente, String fonoCelular, String fonoComercial,
			String fonoParticular, String marcaAuto, String modeloAuto,
			String valorAuto, Integer idGrupo, Integer idBody, Timestamp fecha,
			String nombreJrn, Boolean desinscrito) {
		super(rutCliente, emailCliente, nombreCliente, fonoCelular,
				fonoComercial, fonoParticular, marcaAuto, modeloAuto,
				valorAuto, idGrupo, idBody, fecha, nombreJrn, desinscrito);
	}

}
