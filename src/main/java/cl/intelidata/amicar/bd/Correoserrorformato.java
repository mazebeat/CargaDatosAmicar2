package cl.intelidata.amicar.bd;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Correoserrorformato entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "correoserrorformato", catalog = "amicarcotizante")
public class Correoserrorformato extends AbstractCorreoserrorformato implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Correoserrorformato() {
	}

	/** full constructor
     * @param rutCliente
     * @param idBody
     * @param nombreCliente
     * @param emailCliente
     * @param fonoCelular
     * @param fonoParticular
     * @param fonoComercial
     * @param nombreJrn
     * @param marcaAuto
     * @param modeloAuto
     * @param fecha
     * @param idGrupo
     * @param valorAuto */
	public Correoserrorformato(String rutCliente, String emailCliente,
			String nombreCliente, String fonoCelular, String fonoComercial,
			String fonoParticular, String marcaAuto, String modeloAuto,
			String valorAuto, Integer idGrupo, Integer idBody, Timestamp fecha,
			String nombreJrn) {
		super(rutCliente, emailCliente, nombreCliente, fonoCelular,
				fonoComercial, fonoParticular, marcaAuto, modeloAuto,
				valorAuto, idGrupo, idBody, fecha, nombreJrn);
	}

}
