package cl.intelidata.amicar.bd;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * Vendedores entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be
 * manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 * 
 * @see cl.intelidata.amicar.bd.Vendedores
 * @author MyEclipse Persistence Tools
 */
public class VendedoresDAO implements IVendedoresDAO {
	// property constants

    /**
     *
     */
    	public static final String RUT_VENDEDOR = "rutVendedor";

    /**
     *
     */
    public static final String NOMBRE_VENDEDOR = "nombreVendedor";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

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
	 * VendedoresDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Vendedores entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Vendedores entity) {
		EntityManagerHelper.log("saving Vendedores instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent Vendedores entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * VendedoresDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Vendedores entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Vendedores entity) {
		EntityManagerHelper.log("deleting Vendedores instance", Level.INFO,
				null);
		try {
			entity = getEntityManager().getReference(Vendedores.class,
					entity.getIdVendedor());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

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
	 * entity = VendedoresDAO.update(entity);
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
	public Vendedores update(Vendedores entity) {
		EntityManagerHelper.log("updating Vendedores instance", Level.INFO,
				null);
		try {
			Vendedores result = getEntityManager().merge(entity);
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
    public Vendedores findById(Integer id) {
		EntityManagerHelper.log("finding Vendedores instance with id: " + id,
				Level.INFO, null);
		try {
			Vendedores instance = getEntityManager().find(Vendedores.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

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
	 *            number of results to return.
	 * @return List<Vendedores> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Vendedores> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding Vendedores instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from Vendedores model where model."
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
     * @param rutVendedor
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Vendedores> findByRutVendedor(Object rutVendedor,
			int... rowStartIdxAndCount) {
		return findByProperty(RUT_VENDEDOR, rutVendedor, rowStartIdxAndCount);
	}

    /**
     *
     * @param nombreVendedor
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Vendedores> findByNombreVendedor(Object nombreVendedor,
			int... rowStartIdxAndCount) {
		return findByProperty(NOMBRE_VENDEDOR, nombreVendedor,
				rowStartIdxAndCount);
	}

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
	@SuppressWarnings("unchecked")
	public List<Vendedores> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all Vendedores instances", Level.INFO,
				null);
		try {
			final String queryString = "select model from Vendedores model";
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