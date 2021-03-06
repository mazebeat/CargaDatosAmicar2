package cl.intelidata.amicar.bd;

import java.util.List;
import java.util.Set;

/**
 * Interface for VendedoresDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IVendedoresDAO {
	/**
	 * Perform an initial save of a previously unsaved Vendedores entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVendedoresDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Vendedores entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Vendedores entity);

	/**
	 * Delete a persistent Vendedores entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IVendedoresDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Vendedores entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Vendedores entity);

	/**
	 * Persist a previously saved Vendedores entity and return it or a copy of
	 * it to the sender. A copy of the Vendedores entity parameter is returned
	 * when the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IVendedoresDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Vendedores entity to update
	 * @return Vendedores the persisted Vendedores entity instance, may not be
	 *         the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Vendedores update(Vendedores entity);

    /**
     *
     * @param id
     * @return
     */
    public Vendedores findById(Integer id);

	/**
	 * Find all Vendedores entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Vendedores property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<Vendedores> found by query
	 */
	public List<Vendedores> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount);

    /**
     *
     * @param rutVendedor
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Vendedores> findByRutVendedor(Object rutVendedor,
			int... rowStartIdxAndCount);

    /**
     *
     * @param nombreVendedor
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Vendedores> findByNombreVendedor(Object nombreVendedor,
			int... rowStartIdxAndCount);

	/**
	 * Find all Vendedores entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<Vendedores> all Vendedores entities
	 */
	public List<Vendedores> findAll(int... rowStartIdxAndCount);
}