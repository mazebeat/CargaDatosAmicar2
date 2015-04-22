package cl.intelidata.amicar.bd;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Vendedores entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "vendedores", catalog = "amicarcotizante")
public class Vendedores extends AbstractVendedores implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Vendedores() {
	}

	/** minimal constructor
     * @param locales */
	public Vendedores(Locales locales) {
		super(locales);
	}

	/** full constructor
     * @param locales
     * @param nombreVendedor
     * @param rutVendedor
     * @param procesos */
	public Vendedores(Locales locales, String rutVendedor,
			String nombreVendedor, Set<Proceso> procesos) {
		super(locales, rutVendedor, nombreVendedor, procesos);
	}

}
