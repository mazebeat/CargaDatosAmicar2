package cl.intelidata.amicar.bd;

import java.util.List;

/**
 * Interface for ClientealgoritmoDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IClientealgoritmoDAO {
	/**
	 * Perform an initial save of a previously unsaved Clientealgoritmo entity.
	 * All subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IClientealgoritmoDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Clientealgoritmo entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Clientealgoritmo entity);

	/**
	 * Delete a persistent Clientealgoritmo entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IClientealgoritmoDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Clientealgoritmo entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Clientealgoritmo entity);

	/**
	 * Persist a previously saved Clientealgoritmo entity and return it or a
	 * copy of it to the sender. A copy of the Clientealgoritmo entity parameter
	 * is returned when the JPA persistence mechanism has not previously been
	 * tracking the updated entity. This operation must be performed within the
	 * a database transaction context for the entity's data to be permanently
	 * saved to the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IClientealgoritmoDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Clientealgoritmo entity to update
	 * @return Clientealgoritmo the persisted Clientealgoritmo entity instance,
	 *         may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Clientealgoritmo update(Clientealgoritmo entity);

    /**
     *
     * @param id
     * @return
     */
    public Clientealgoritmo findById(Integer id);

	/**
	 * Find all Clientealgoritmo entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Clientealgoritmo property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<Clientealgoritmo> found by query
	 */
	public List<Clientealgoritmo> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

    /**
     *
     * @param idCliente
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientealgoritmo> findByIdCliente(Object idCliente,
			int... rowStartIdxAndCount);

    /**
     *
     * @param idBody
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientealgoritmo> findByIdBody(Object idBody,
			int... rowStartIdxAndCount);

	/**
	 * Find all Clientealgoritmo entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<Clientealgoritmo> all Clientealgoritmo entities
	 */
	public List<Clientealgoritmo> findAll(int... rowStartIdxAndCount);
}