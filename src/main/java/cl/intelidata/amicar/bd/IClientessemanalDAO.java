package cl.intelidata.amicar.bd;

import java.sql.Timestamp;
import java.util.List;

/**
 * Interface for ClientessemanalDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IClientessemanalDAO {
	/**
	 * Perform an initial save of a previously unsaved Clientessemanal entity.
	 * All subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IClientessemanalDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Clientessemanal entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Clientessemanal entity);

	/**
	 * Delete a persistent Clientessemanal entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IClientessemanalDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Clientessemanal entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Clientessemanal entity);

	/**
	 * Persist a previously saved Clientessemanal entity and return it or a copy
	 * of it to the sender. A copy of the Clientessemanal entity parameter is
	 * returned when the JPA persistence mechanism has not previously been
	 * tracking the updated entity. This operation must be performed within the
	 * a database transaction context for the entity's data to be permanently
	 * saved to the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IClientessemanalDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Clientessemanal entity to update
	 * @return Clientessemanal the persisted Clientessemanal entity instance,
	 *         may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Clientessemanal update(Clientessemanal entity);

    /**
     *
     * @param id
     * @return
     */
    public Clientessemanal findById(Integer id);

	/**
	 * Find all Clientessemanal entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Clientessemanal property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<Clientessemanal> found by query
	 */
	public List<Clientessemanal> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

    /**
     *
     * @param rutCliente
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientessemanal> findByRutCliente(Object rutCliente,
			int... rowStartIdxAndCount);

    /**
     *
     * @param emailCliente
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientessemanal> findByEmailCliente(Object emailCliente,
			int... rowStartIdxAndCount);

    /**
     *
     * @param nombreCliente
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientessemanal> findByNombreCliente(Object nombreCliente,
			int... rowStartIdxAndCount);

    /**
     *
     * @param fonoCelular
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientessemanal> findByFonoCelular(Object fonoCelular,
			int... rowStartIdxAndCount);

    /**
     *
     * @param fonoComercial
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientessemanal> findByFonoComercial(Object fonoComercial,
			int... rowStartIdxAndCount);

    /**
     *
     * @param fonoParticular
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientessemanal> findByFonoParticular(Object fonoParticular,
			int... rowStartIdxAndCount);

    /**
     *
     * @param marcaAuto
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientessemanal> findByMarcaAuto(Object marcaAuto,
			int... rowStartIdxAndCount);

    /**
     *
     * @param modeloAuto
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientessemanal> findByModeloAuto(Object modeloAuto,
			int... rowStartIdxAndCount);

    /**
     *
     * @param valorAuto
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientessemanal> findByValorAuto(Object valorAuto,
			int... rowStartIdxAndCount);

    /**
     *
     * @param idGrupo
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientessemanal> findByIdGrupo(Object idGrupo,
			int... rowStartIdxAndCount);

    /**
     *
     * @param idBody
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientessemanal> findByIdBody(Object idBody,
			int... rowStartIdxAndCount);

    /**
     *
     * @param nombreJrn
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientessemanal> findByNombreJrn(Object nombreJrn,
			int... rowStartIdxAndCount);

	/**
	 * Find all Clientessemanal entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<Clientessemanal> all Clientessemanal entities
	 */
	public List<Clientessemanal> findAll(int... rowStartIdxAndCount);
}