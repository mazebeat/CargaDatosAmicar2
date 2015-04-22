package cl.intelidata.amicar.bd;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Locales entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "locales", catalog = "amicarcotizante")
public class Locales extends AbstractLocales implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Locales() {
	}

	/** full constructor
     * @param nombreLocal
     * @param vendedoreses
     * @param ejecutivoses */
	public Locales(String nombreLocal, Set<Vendedores> vendedoreses,
			Set<Ejecutivos> ejecutivoses) {
		super(nombreLocal, vendedoreses, ejecutivoses);
	}

}
