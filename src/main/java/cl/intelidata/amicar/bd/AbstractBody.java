package cl.intelidata.amicar.bd;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * AbstractBody entity provides the base persistence definition of the Body
 * entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractBody implements java.io.Serializable {

	// Fields

	private Integer idBody;
	private String bodyNombre;

	// Constructors

	/** default constructor */
	public AbstractBody() {
	}

	/** minimal constructor
     * @param idBody */
	public AbstractBody(Integer idBody) {
		this.idBody = idBody;
	}

	/** full constructor
     * @param idBody
     * @param bodyNombre */
	public AbstractBody(Integer idBody, String bodyNombre) {
		this.idBody = idBody;
		this.bodyNombre = bodyNombre;
	}

	// Property accessors

    /**
     *
     * @return
     */
    	@Id
	@Column(name = "idBody", unique = true, nullable = false)
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

    /**
     *
     * @return
     */
    @Column(name = "bodyNombre", length = 45)
	public String getBodyNombre() {
		return this.bodyNombre;
	}

    /**
     *
     * @param bodyNombre
     */
    public void setBodyNombre(String bodyNombre) {
		this.bodyNombre = bodyNombre;
	}

}