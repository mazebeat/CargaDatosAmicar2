package cl.intelidata.amicar.bd;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * AbstractClientealgoritmo entity provides the base persistence definition of
 * the Clientealgoritmo entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractClientealgoritmo implements java.io.Serializable {

	// Fields

	private Integer idClienteAlgoritmo;
	private Integer idCliente;
	private Integer idBody;

	// Constructors

	/** default constructor */
	public AbstractClientealgoritmo() {
	}

	/** minimal constructor
     * @param idClienteAlgoritmo */
	public AbstractClientealgoritmo(Integer idClienteAlgoritmo) {
		this.idClienteAlgoritmo = idClienteAlgoritmo;
	}

	/** full constructor
     * @param idClienteAlgoritmo
     * @param idBody
     * @param idCliente */
	public AbstractClientealgoritmo(Integer idClienteAlgoritmo,
			Integer idCliente, Integer idBody) {
		this.idClienteAlgoritmo = idClienteAlgoritmo;
		this.idCliente = idCliente;
		this.idBody = idBody;
	}

	// Property accessors

    /**
     *
     * @return
     */
    	@Id
	@Column(name = "idClienteAlgoritmo", unique = true, nullable = false)
	public Integer getIdClienteAlgoritmo() {
		return this.idClienteAlgoritmo;
	}

    /**
     *
     * @param idClienteAlgoritmo
     */
    public void setIdClienteAlgoritmo(Integer idClienteAlgoritmo) {
		this.idClienteAlgoritmo = idClienteAlgoritmo;
	}

    /**
     *
     * @return
     */
    @Column(name = "idCliente")
	public Integer getIdCliente() {
		return this.idCliente;
	}

    /**
     *
     * @param idCliente
     */
    public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

    /**
     *
     * @return
     */
    @Column(name = "idBody")
	public Integer getIdBody() {
		return this.idBody;
	}

    /**
     *
     * @param idBody
     */
    public void setIdBody(Integer idBody) {
		this.idBody = idBody;
	}

}