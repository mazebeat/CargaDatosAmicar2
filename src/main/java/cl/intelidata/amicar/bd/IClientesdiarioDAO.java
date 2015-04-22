package cl.intelidata.amicar.bd;

import java.sql.Timestamp;
import java.util.List;

/**
 * Interface for ClientesdiarioDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IClientesdiarioDAO {
	/**
	 * Perform an initial save of a previously unsaved Clientesdiario entity.
	 * All subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IClientesdiarioDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Clientesdiario entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Clientesdiario entity);

	/**
	 * Delete a persistent Clientesdiario entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IClientesdiarioDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Clientesdiario entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Clientesdiario entity);

	/**
	 * Persist a previously saved Clientesdiario entity and return it or a copy
	 * of it to the sender. A copy of the Clientesdiario entity parameter is
	 * returned when the JPA persistence mechanism has not previously been
	 * tracking the updated entity. This operation must be performed within the
	 * a database transaction context for the entity's data to be permanently
	 * saved to the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IClientesdiarioDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Clientesdiario entity to update
	 * @return Clientesdiario the persisted Clientesdiario entity instance, may
	 *         not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Clientesdiario update(Clientesdiario entity);

    /**
     *
     * @param id
     * @return
     */
    public Clientesdiario findById(Integer id);

	/**
	 * Find all Clientesdiario entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Clientesdiario property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<Clientesdiario> found by query
	 */
	public List<Clientesdiario> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

    /**
     *
     * @param rutCliente
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientesdiario> findByRutCliente(Object rutCliente,
			int... rowStartIdxAndCount);

    /**
     *
     * @param emailCliente
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientesdiario> findByEmailCliente(Object emailCliente,
			int... rowStartIdxAndCount);

    /**
     *
     * @param nombreCliente
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientesdiario> findByNombreCliente(Object nombreCliente,
			int... rowStartIdxAndCount);

    /**
     *
     * @param fonoCelular
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientesdiario> findByFonoCelular(Object fonoCelular,
			int... rowStartIdxAndCount);

    /**
     *
     * @param fonoComercial
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientesdiario> findByFonoComercial(Object fonoComercial,
			int... rowStartIdxAndCount);

    /**
     *
     * @param fonoParticular
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientesdiario> findByFonoParticular(Object fonoParticular,
			int... rowStartIdxAndCount);

    /**
     *
     * @param marcaAuto
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientesdiario> findByMarcaAuto(Object marcaAuto,
			int... rowStartIdxAndCount);

    /**
     *
     * @param modeloAuto
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientesdiario> findByModeloAuto(Object modeloAuto,
			int... rowStartIdxAndCount);

    /**
     *
     * @param valorAuto
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientesdiario> findByValorAuto(Object valorAuto,
			int... rowStartIdxAndCount);

    /**
     *
     * @param idGrupo
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientesdiario> findByIdGrupo(Object idGrupo,
			int... rowStartIdxAndCount);

    /**
     *
     * @param idBody
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientesdiario> findByIdBody(Object idBody,
			int... rowStartIdxAndCount);

    /**
     *
     * @param nombreJrn
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Clientesdiario> findByNombreJrn(Object nombreJrn,
			int... rowStartIdxAndCount);

	/**
	 * Find all Clientesdiario entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<Clientesdiario> all Clientesdiario entities
	 */
	public List<Clientesdiario> findAll(int... rowStartIdxAndCount);
}