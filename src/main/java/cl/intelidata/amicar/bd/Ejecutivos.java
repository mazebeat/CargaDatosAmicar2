package cl.intelidata.amicar.bd;

import java.sql.Timestamp;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Ejecutivos entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ejecutivos", catalog = "amicarcotizante")
public class Ejecutivos extends AbstractEjecutivos implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Ejecutivos() {
	}

	/** minimal constructor
     * @param locales */
	public Ejecutivos(Locales locales) {
		super(locales);
	}

	/** full constructor
     * @param locales
     * @param nombreEjecutivo
     * @param correoEjecutivo
     * @param fechaIngreso
     * @param fechaModificacion
     * @param procesos */
	public Ejecutivos(Locales locales, String nombreEjecutivo,
			String correoEjecutivo, Timestamp fechaIngreso,
			String fechaModificacion, Set<Proceso> procesos) {
		super(locales, nombreEjecutivo, correoEjecutivo, fechaIngreso,
				fechaModificacion, procesos);
	}

}
