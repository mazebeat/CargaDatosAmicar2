package cl.intelidata.amicar.bd;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Body entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "body", catalog = "amicarcotizante")
public class Body extends AbstractBody implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Body() {
	}

	/** minimal constructor
     * @param idBody */
	public Body(Integer idBody) {
		super(idBody);
	}

	/** full constructor
     * @param idBody
     * @param bodyNombre */
	public Body(Integer idBody, String bodyNombre) {
		super(idBody, bodyNombre);
	}

}
