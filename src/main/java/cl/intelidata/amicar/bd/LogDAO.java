package cl.intelidata.amicar.bd;

import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for Log
 * entities. Transaction control of the save(), update() and delete() operations
 * must be handled externally by senders of these methods or must be manually
 * added to each of these methods for data to be persisted to the JPA datastore.
 * 
 * @see cl.intelidata.amicar.bd.Log
 * @author MyEclipse Persistence Tools
 */
public class LogDAO implements ILogDAO {
	// property constants

    /**
     *
     */
    	public static final String ID_VENDEDOR = "idVendedor";

    /**
     *
     */
    public static final String ID_CLIENTE = "idCliente";

    /**
     *
     */
    public static final String ID_EJECUTIVO = "idEjecutivo";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

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
	 * LogDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Log entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Log entity) {
		EntityManagerHelper.log("saving Log instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent Log entity. This operation must be performed within
	 * the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * LogDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Log entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Log entity) {
		EntityManagerHelper.log("deleting Log instance", Level.INFO, null);
		try {
			entity = getEntityManager().getReference(Log.class,
					entity.getIdlog());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

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
	 * entity = LogDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Log entity to update
	 * @return Log the persisted Log entity instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Log update(Log entity) {
		EntityManagerHelper.log("updating Log instance", Level.INFO, null);
		try {
			Log result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

    /**
     *
     * @param id
     * @return
     */
    public Log findById(Integer id) {
		EntityManagerHelper.log("finding Log instance with id: " + id,
				Level.INFO, null);
		try {
			Log instance = getEntityManager().find(Log.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

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
	 *            number of results to return.
	 * @return List<Log> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Log> findByProperty(String propertyName, final Object value,
			final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding Log instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from Log model where model."
					+ propertyName + "= :propertyValue";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue", value);
			if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
				int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
				if (rowStartIdx > 0) {
					query.setFirstResult(rowStartIdx);
				}

				if (rowStartIdxAndCount.length > 1) {
					int rowCount = Math.max(0, rowStartIdxAndCount[1]);
					if (rowCount > 0) {
						query.setMaxResults(rowCount);
					}
				}
			}
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			throw re;
		}
	}

    /**
     *
     * @param idVendedor
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Log> findByIdVendedor(Object idVendedor,
			int... rowStartIdxAndCount) {
		return findByProperty(ID_VENDEDOR, idVendedor, rowStartIdxAndCount);
	}

    /**
     *
     * @param idCliente
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Log> findByIdCliente(Object idCliente,
			int... rowStartIdxAndCount) {
		return findByProperty(ID_CLIENTE, idCliente, rowStartIdxAndCount);
	}

    /**
     *
     * @param idEjecutivo
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Log> findByIdEjecutivo(Object idEjecutivo,
			int... rowStartIdxAndCount) {
		return findByProperty(ID_EJECUTIVO, idEjecutivo, rowStartIdxAndCount);
	}

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
	@SuppressWarnings("unchecked")
	public List<Log> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all Log instances", Level.INFO, null);
		try {
			final String queryString = "select model from Log model";
			Query query = getEntityManager().createQuery(queryString);
			if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
				int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
				if (rowStartIdx > 0) {
					query.setFirstResult(rowStartIdx);
				}

				if (rowStartIdxAndCount.length > 1) {
					int rowCount = Math.max(0, rowStartIdxAndCount[1]);
					if (rowCount > 0) {
						query.setMaxResults(rowCount);
					}
				}
			}
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}