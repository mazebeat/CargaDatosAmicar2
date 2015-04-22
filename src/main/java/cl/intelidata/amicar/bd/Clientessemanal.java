package cl.intelidata.amicar.bd;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Clientessemanal entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "clientessemanal", catalog = "amicarcotizante")
public class Clientessemanal extends AbstractClientessemanal implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Clientessemanal() {
	}

	/** full constructor
     * @param rutCliente
     * @param emailCliente
     * @param nombreCliente
     * @param fonoCelular
     * @param fonoComercial
     * @param fonoParticular
     * @param fecha
     * @param modeloAuto
     * @param valorAuto
     * @param marcaAuto
     * @param idGrupo
     * @param idBody
     * @param nombreJrn */
	public Clientessemanal(String rutCliente, String emailCliente,
			String nombreCliente, String fonoCelular, String fonoComercial,
			String fonoParticular, String marcaAuto, String modeloAuto,
			String valorAuto, Integer idGrupo, Integer idBody, Timestamp fecha,
			String nombreJrn) {
		super(rutCliente, emailCliente, nombreCliente, fonoCelular,
				fonoComercial, fonoParticular, marcaAuto, modeloAuto,
				valorAuto, idGrupo, idBody, fecha, nombreJrn);
	}

}
