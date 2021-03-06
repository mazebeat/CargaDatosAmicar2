package cl.intelidata.amicar.bd;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

/**
 * Interface for ClientesDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IClientesDAO {
	/**
	 * Perform an initial save of a previously unsaved Clientes entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IClientesDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Clientes entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Clientes entity);

	/**
	 * Delete a persistent Clientes entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IClientesDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Clientes entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Clientes entity);

	/**
	 * Persist a previously saved Clientes entity and return it or a copy of it
	 * to the sender. A copy of the Clientes entity parameter is returned when
	 * the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IClientesDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Clientes entity to update
	 * @return Clientes the persisted Clientes entity instance, may not be the
	 *         same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Clientes update(Clientes entity);

    /**
     *
     * @param id
     * @return
     */
    public Clientes findById(Integer id);

	/**
	 * Find all Clientes entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Clientes property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<Clientes> found by query
	 */
	public List<Clientes> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount);

    /**
     *
     * @param rutCliente
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientes> findByRutCliente(Object rutCliente,
			int... rowStartIdxAndCount);

    /**
     *
     * @param emailCliente
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientes> findByEmailCliente(Object emailCliente,
			int... rowStartIdxAndCount);

    /**
     *
     * @param nombreCliente
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientes> findByNombreCliente(Object nombreCliente,
			int... rowStartIdxAndCount);

    /**
     *
     * @param fonoCelular
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientes> findByFonoCelular(Object fonoCelular,
			int... rowStartIdxAndCount);

    /**
     *
     * @param fonoComercial
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientes> findByFonoComercial(Object fonoComercial,
			int... rowStartIdxAndCount);

    /**
     *
     * @param fonoParticular
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientes> findByFonoParticular(Object fonoParticular,
			int... rowStartIdxAndCount);

    /**
     *
     * @param marcaAuto
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientes> findByMarcaAuto(Object marcaAuto,
			int... rowStartIdxAndCount);

    /**
     *
     * @param modeloAuto
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientes> findByModeloAuto(Object modeloAuto,
			int... rowStartIdxAndCount);

    /**
     *
     * @param valorAuto
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientes> findByValorAuto(Object valorAuto,
			int... rowStartIdxAndCount);

    /**
     *
     * @param idGrupo
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientes> findByIdGrupo(Object idGrupo,
			int... rowStartIdxAndCount);

    /**
     *
     * @param idBody
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientes> findByIdBody(Object idBody,
			int... rowStartIdxAndCount);

    /**
     *
     * @param nombreJrn
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientes> findByNombreJrn(Object nombreJrn,
			int... rowStartIdxAndCount);

    /**
     *
     * @param desinscrito
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientes> findByDesinscrito(Object desinscrito,
			int... rowStartIdxAndCount);

	/**
	 * Find all Clientes entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<Clientes> all Clientes entities
	 */
	public List<Clientes> findAll(int... rowStartIdxAndCount);
}