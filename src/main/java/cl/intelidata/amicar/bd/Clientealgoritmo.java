package cl.intelidata.amicar.bd;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Clientealgoritmo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "clientealgoritmo", catalog = "amicarcotizante")
public class Clientealgoritmo extends AbstractClientealgoritmo implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Clientealgoritmo() {
	}

	/** minimal constructor
     * @param idClienteAlgoritmo */
	public Clientealgoritmo(Integer idClienteAlgoritmo) {
		super(idClienteAlgoritmo);
	}

	/** full constructor
     * @param idClienteAlgoritmo
     * @param idCliente
     * @param idBody */
	public Clientealgoritmo(Integer idClienteAlgoritmo, Integer idCliente,
			Integer idBody) {
		super(idClienteAlgoritmo, idCliente, idBody);
	}

}
