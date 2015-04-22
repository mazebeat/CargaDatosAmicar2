package cl.intelidata.amicar.bd;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * Clientes entities. Transaction control of the save(), update() and delete()
 * operations must be handled externally by senders of these methods or must be
 * manually added to each of these methods for data to be persisted to the JPA
 * datastore.
 * 
 * @see cl.intelidata.amicar.bd.Clientes
 * @author MyEclipse Persistence Tools
 */
public class ClientesDAO implements IClientesDAO {
	// property constants

    /**
     *
     */
    	public static final String RUT_CLIENTE = "rutCliente";

    /**
     *
     */
    public static final String EMAIL_CLIENTE = "emailCliente";

    /**
     *
     */
    public static final String NOMBRE_CLIENTE = "nombreCliente";

    /**
     *
     */
    public static final String FONO_CELULAR = "fonoCelular";

    /**
     *
     */
    public static final String FONO_COMERCIAL = "fonoComercial";

    /**
     *
     */
    public static final String FONO_PARTICULAR = "fonoParticular";

    /**
     *
     */
    public static final String MARCA_AUTO = "marcaAuto";

    /**
     *
     */
    public static final String MODELO_AUTO = "modeloAuto";

    /**
     *
     */
    public static final String VALOR_AUTO = "valorAuto";

    /**
     *
     */
    public static final String ID_GRUPO = "idGrupo";

    /**
     *
     */
    public static final String ID_BODY = "idBody";

    /**
     *
     */
    public static final String NOMBRE_JRN = "nombreJrn";

    /**
     *
     */
    public static final String DESINSCRITO = "desinscrito";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

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
	 * ClientesDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Clientes entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Clientes entity) {
		EntityManagerHelper.log("saving Clientes instance", Level.INFO, null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent Clientes entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ClientesDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Clientes entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Clientes entity) {
		EntityManagerHelper.log("deleting Clientes instance", Level.INFO, null);
		try {
			entity = getEntityManager().getReference(Clientes.class,
					entity.getIdCliente());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

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
	 * entity = ClientesDAO.update(entity);
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
	public Clientes update(Clientes entity) {
		EntityManagerHelper.log("updating Clientes instance", Level.INFO, null);
		try {
			Clientes result = getEntityManager().merge(entity);
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
    public Clientes findById(Integer id) {
		EntityManagerHelper.log("finding Clientes instance with id: " + id,
				Level.INFO, null);
		try {
			Clientes instance = getEntityManager().find(Clientes.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

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
	 *            number of results to return.
	 * @return List<Clientes> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Clientes> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding Clientes instance with property: "
				+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from Clientes model where model."
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
     * @param rutCliente
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientes> findByRutCliente(Object rutCliente,
			int... rowStartIdxAndCount) {
		return findByProperty(RUT_CLIENTE, rutCliente, rowStartIdxAndCount);
	}

    /**
     *
     * @param emailCliente
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientes> findByEmailCliente(Object emailCliente,
			int... rowStartIdxAndCount) {
		return findByProperty(EMAIL_CLIENTE, emailCliente, rowStartIdxAndCount);
	}

    /**
     *
     * @param nombreCliente
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientes> findByNombreCliente(Object nombreCliente,
			int... rowStartIdxAndCount) {
		return findByProperty(NOMBRE_CLIENTE, nombreCliente,
				rowStartIdxAndCount);
	}

    /**
     *
     * @param fonoCelular
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientes> findByFonoCelular(Object fonoCelular,
			int... rowStartIdxAndCount) {
		return findByProperty(FONO_CELULAR, fonoCelular, rowStartIdxAndCount);
	}

    /**
     *
     * @param fonoComercial
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientes> findByFonoComercial(Object fonoComercial,
			int... rowStartIdxAndCount) {
		return findByProperty(FONO_COMERCIAL, fonoComercial,
				rowStartIdxAndCount);
	}

    /**
     *
     * @param fonoParticular
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientes> findByFonoParticular(Object fonoParticular,
			int... rowStartIdxAndCount) {
		return findByProperty(FONO_PARTICULAR, fonoParticular,
				rowStartIdxAndCount);
	}

    /**
     *
     * @param marcaAuto
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientes> findByMarcaAuto(Object marcaAuto,
			int... rowStartIdxAndCount) {
		return findByProperty(MARCA_AUTO, marcaAuto, rowStartIdxAndCount);
	}

    /**
     *
     * @param modeloAuto
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientes> findByModeloAuto(Object modeloAuto,
			int... rowStartIdxAndCount) {
		return findByProperty(MODELO_AUTO, modeloAuto, rowStartIdxAndCount);
	}

    /**
     *
     * @param valorAuto
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientes> findByValorAuto(Object valorAuto,
			int... rowStartIdxAndCount) {
		return findByProperty(VALOR_AUTO, valorAuto, rowStartIdxAndCount);
	}

    /**
     *
     * @param idGrupo
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientes> findByIdGrupo(Object idGrupo,
			int... rowStartIdxAndCount) {
		return findByProperty(ID_GRUPO, idGrupo, rowStartIdxAndCount);
	}

    /**
     *
     * @param idBody
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientes> findByIdBody(Object idBody,
			int... rowStartIdxAndCount) {
		return findByProperty(ID_BODY, idBody, rowStartIdxAndCount);
	}

    /**
     *
     * @param nombreJrn
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientes> findByNombreJrn(Object nombreJrn,
			int... rowStartIdxAndCount) {
		return findByProperty(NOMBRE_JRN, nombreJrn, rowStartIdxAndCount);
	}

    /**
     *
     * @param desinscrito
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientes> findByDesinscrito(Object desinscrito,
			int... rowStartIdxAndCount) {
		return findByProperty(DESINSCRITO, desinscrito, rowStartIdxAndCount);
	}

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
	@SuppressWarnings("unchecked")
	public List<Clientes> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all Clientes instances", Level.INFO,
				null);
		try {
			final String queryString = "select model from Clientes model";
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