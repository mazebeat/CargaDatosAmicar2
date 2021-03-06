package cl.intelidata.amicar.bd;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * Clientealgoritmo entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see cl.intelidata.amicar.bd.Clientealgoritmo
 * @author MyEclipse Persistence Tools
 */
public class ClientealgoritmoDAO implements IClientealgoritmoDAO {
	// property constants

    /**
     *
     */
    	public static final String ID_CLIENTE = "idCliente";

    /**
     *
     */
    public static final String ID_BODY = "idBody";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

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
	 * ClientealgoritmoDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Clientealgoritmo entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Clientealgoritmo entity) {
		EntityManagerHelper.log("saving Clientealgoritmo instance", Level.INFO,
				null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

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
	 * ClientealgoritmoDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Clientealgoritmo entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Clientealgoritmo entity) {
		EntityManagerHelper.log("deleting Clientealgoritmo instance",
				Level.INFO, null);
		try {
			entity = getEntityManager().getReference(Clientealgoritmo.class,
					entity.getIdClienteAlgoritmo());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

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
	 * entity = ClientealgoritmoDAO.update(entity);
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
	public Clientealgoritmo update(Clientealgoritmo entity) {
		EntityManagerHelper.log("updating Clientealgoritmo instance",
				Level.INFO, null);
		try {
			Clientealgoritmo result = getEntityManager().merge(entity);
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
    public Clientealgoritmo findById(Integer id) {
		EntityManagerHelper.log("finding Clientealgoritmo instance with id: "
				+ id, Level.INFO, null);
		try {
			Clientealgoritmo instance = getEntityManager().find(
					Clientealgoritmo.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

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
	 *            number of results to return.
	 * @return List<Clientealgoritmo> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Clientealgoritmo> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log(
				"finding Clientealgoritmo instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from Clientealgoritmo model where model."
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
     * @param idCliente
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientealgoritmo> findByIdCliente(Object idCliente,
			int... rowStartIdxAndCount) {
		return findByProperty(ID_CLIENTE, idCliente, rowStartIdxAndCount);
	}

    /**
     *
     * @param idBody
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientealgoritmo> findByIdBody(Object idBody,
			int... rowStartIdxAndCount) {
		return findByProperty(ID_BODY, idBody, rowStartIdxAndCount);
	}

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
	@SuppressWarnings("unchecked")
	public List<Clientealgoritmo> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all Clientealgoritmo instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from Clientealgoritmo model";
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