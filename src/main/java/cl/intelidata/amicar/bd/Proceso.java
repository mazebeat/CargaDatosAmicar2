package cl.intelidata.amicar.bd;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Proceso entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "proceso", catalog = "amicarcotizante")
public class Proceso extends AbstractProceso implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Proceso() {
	}

	/** minimal constructor
     * @param ejecutivos
     * @param clientesdiario
     * @param vendedores */
	public Proceso(Ejecutivos ejecutivos, Clientesdiario clientesdiario,
			Vendedores vendedores) {
		super(ejecutivos, clientesdiario, vendedores);
	}

	/** full constructor
     * @param ejecutivos
     * @param clientesdiario
     * @param vendedores
     * @param fechaEnvio
     * @param fechaAperturaMail
     * @param fechaClickLink */
	public Proceso(Ejecutivos ejecutivos, Clientesdiario clientesdiario,
			Vendedores vendedores, Timestamp fechaEnvio,
			Timestamp fechaAperturaMail, Timestamp fechaClickLink) {
		super(ejecutivos, clientesdiario, vendedores, fechaEnvio, fechaAperturaMail,
				fechaClickLink);
	}

}
