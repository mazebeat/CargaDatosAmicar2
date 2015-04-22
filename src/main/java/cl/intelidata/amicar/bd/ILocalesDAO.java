package cl.intelidata.amicar.bd;

import java.util.List;
import java.util.Set;

/**
 * Interface for LocalesDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface ILocalesDAO {
	/**
	 * Perform an initial save of a previously unsaved Locales entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ILocalesDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Locales entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Locales entity);

	/**
	 * Delete a persistent Locales entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ILocalesDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Locales entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Locales entity);

	/**
	 * Persist a previously saved Locales entity and return it or a copy of it
	 * to the sender. A copy of the Locales entity parameter is returned when
	 * the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = ILocalesDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Locales entity to update
	 * @return Locales the persisted Locales entity instance, may not be the
	 *         same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Locales update(Locales entity);

    /**
     *
     * @param id
     * @return
     */
    public Locales findById(Integer id);

	/**
	 * Find all Locales entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Locales property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<Locales> found by query
	 */
	public List<Locales> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount);

    /**
     *
     * @param nombreLocal
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Locales> findByNombreLocal(Object nombreLocal,
			int... rowStartIdxAndCount);

	/**
	 * Find all Locales entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<Locales> all Locales entities
	 */
	public List<Locales> findAll(int... rowStartIdxAndCount);
}