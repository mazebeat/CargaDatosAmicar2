package cl.intelidata.amicar.bd;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * Ejecutivos entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be
 * manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 * 
 * @see cl.intelidata.amicar.bd.Ejecutivos
 * @author MyEclipse Persistence Tools
 */
public class EjecutivosDAO implements IEjecutivosDAO {
	// property constants

    /**
     *
     */
    	public static final String NOMBRE_EJECUTIVO = "nombreEjecutivo";

    /**
     *
     */
    public static final String CORREO_EJECUTIVO = "correoEjecutivo";

    /**
     *
     */
    public static final String FECHA_MODIFICACION = "fechaModificacion";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved Ejecutivos entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * EjecutivosDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Ejecutivos entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Ejecutivos entity) {
		EntityManagerHelper.log("saving Ejecutivos instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent Ejecutivos entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * EjecutivosDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Ejecutivos entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Ejecutivos entity) {
		EntityManagerHelper.log("deleting Ejecutivos instance", Level.INFO,
				null);
		try {
			entity = getEntityManager().getReference(Ejecutivos.class,
					entity.getIdEjecutivo());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved Ejecutivos entity and return it or a copy of
	 * it to the sender. A copy of the Ejecutivos entity parameter is returned
	 * when the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = EjecutivosDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Ejecutivos entity to update
	 * @return Ejecutivos the persisted Ejecutivos entity instance, may not be
	 *         the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Ejecutivos update(Ejecutivos entity) {
		EntityManagerHelper.log("updating Ejecutivos instance", Level.INFO,
				null);
		try {
			Ejecutivos result = getEntityManager().merge(entity);
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
    public Ejecutivos findById(Integer id) {
		EntityManagerHelper.log("finding Ejecutivos instance with id: " + id,
				Level.INFO, null);
		try {
			Ejecutivos instance = getEntityManager().find(Ejecutivos.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all Ejecutivos entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Ejecutivos property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            number of results to return.
	 * @return List<Ejecutivos> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Ejecutivos> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding Ejecutivos instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from Ejecutivos model where model."
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
     * @param nombreEjecutivo
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Ejecutivos> findByNombreEjecutivo(Object nombreEjecutivo,
			int... rowStartIdxAndCount) {
		return findByProperty(NOMBRE_EJECUTIVO, nombreEjecutivo,
				rowStartIdxAndCount);
	}

    /**
     *
     * @param correoEjecutivo
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Ejecutivos> findByCorreoEjecutivo(Object correoEjecutivo,
			int... rowStartIdxAndCount) {
		return findByProperty(CORREO_EJECUTIVO, correoEjecutivo,
				rowStartIdxAndCount);
	}

    /**
     *
     * @param fechaModificacion
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Ejecutivos> findByFechaModificacion(Object fechaModificacion,
			int... rowStartIdxAndCount) {
		return findByProperty(FECHA_MODIFICACION, fechaModificacion,
				rowStartIdxAndCount);
	}

	/**
	 * Find all Ejecutivos entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<Ejecutivos> all Ejecutivos entities
	 */
	@SuppressWarnings("unchecked")
	public List<Ejecutivos> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all Ejecutivos instances", Level.INFO,
				null);
		try {
			final String queryString = "select model from Ejecutivos model";
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