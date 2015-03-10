package cl.intelidata.amicar.bd;

import java.sql.Timestamp;
import java.util.List;

/**
 * Interface for LogDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface ILogDAO {
	/**
	 * Perform an initial save of a previously unsaved Log entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ILogDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Log entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Log entity);

	/**
	 * Delete a persistent Log entity. This operation must be performed within
	 * the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ILogDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Log entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Log entity);

	/**
	 * Persist a previously saved Log entity and return it or a copy of it to
	 * the sender. A copy of the Log entity parameter is returned when the JPA
	 * persistence mechanism has not previously been tracking the updated
	 * entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = ILogDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Log entity to update
	 * @return Log the persisted Log entity instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Log update(Log entity);

	public Log findById(Integer id);

	/**
	 * Find all Log entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Log property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<Log> found by query
	 */
	public List<Log> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount);

	public List<Log> findByIdVendedor(Object idVendedor,
			int... rowStartIdxAndCount);

	public List<Log> findByIdCliente(Object idCliente,
			int... rowStartIdxAndCount);

	public List<Log> findByIdEjecutivo(Object idEjecutivo,
			int... rowStartIdxAndCount);

	/**
	 * Find all Log entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<Log> all Log entities
	 */
	public List<Log> findAll(int... rowStartIdxAndCount);
}