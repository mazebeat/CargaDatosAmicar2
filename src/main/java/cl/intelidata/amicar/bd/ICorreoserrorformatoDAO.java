package cl.intelidata.amicar.bd;

import java.sql.Timestamp;
import java.util.List;

/**
 * Interface for CorreoserrorformatoDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface ICorreoserrorformatoDAO {
	/**
	 * Perform an initial save of a previously unsaved Correoserrorformato
	 * entity. All subsequent persist actions of this entity should use the
	 * #update() method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ICorreoserrorformatoDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Correoserrorformato entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Correoserrorformato entity);

	/**
	 * Delete a persistent Correoserrorformato entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ICorreoserrorformatoDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Correoserrorformato entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Correoserrorformato entity);

	/**
	 * Persist a previously saved Correoserrorformato entity and return it or a
	 * copy of it to the sender. A copy of the Correoserrorformato entity
	 * parameter is returned when the JPA persistence mechanism has not
	 * previously been tracking the updated entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently saved to the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#merge(Object)
	 * EntityManager#merge} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = ICorreoserrorformatoDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Correoserrorformato entity to update
	 * @return Correoserrorformato the persisted Correoserrorformato entity
	 *         instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Correoserrorformato update(Correoserrorformato entity);

    /**
     *
     * @param id
     * @return
     */
    public Correoserrorformato findById(Integer id);

	/**
	 * Find all Correoserrorformato entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Correoserrorformato property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<Correoserrorformato> found by query
	 */
	public List<Correoserrorformato> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

    /**
     *
     * @param rutCliente
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Correoserrorformato> findByRutCliente(Object rutCliente,
			int... rowStartIdxAndCount);

    /**
     *
     * @param emailCliente
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Correoserrorformato> findByEmailCliente(Object emailCliente,
			int... rowStartIdxAndCount);

    /**
     *
     * @param nombreCliente
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Correoserrorformato> findByNombreCliente(Object nombreCliente,
			int... rowStartIdxAndCount);

    /**
     *
     * @param fonoCelular
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Correoserrorformato> findByFonoCelular(Object fonoCelular,
			int... rowStartIdxAndCount);

    /**
     *
     * @param fonoComercial
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Correoserrorformato> findByFonoComercial(Object fonoComercial,
			int... rowStartIdxAndCount);

    /**
     *
     * @param fonoParticular
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Correoserrorformato> findByFonoParticular(
			Object fonoParticular, int... rowStartIdxAndCount);

    /**
     *
     * @param marcaAuto
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Correoserrorformato> findByMarcaAuto(Object marcaAuto,
			int... rowStartIdxAndCount);

    /**
     *
     * @param modeloAuto
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Correoserrorformato> findByModeloAuto(Object modeloAuto,
			int... rowStartIdxAndCount);

    /**
     *
     * @param valorAuto
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Correoserrorformato> findByValorAuto(Object valorAuto,
			int... rowStartIdxAndCount);

    /**
     *
     * @param idGrupo
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Correoserrorformato> findByIdGrupo(Object idGrupo,
			int... rowStartIdxAndCount);

    /**
     *
     * @param idBody
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Correoserrorformato> findByIdBody(Object idBody,
			int... rowStartIdxAndCount);

    /**
     *
     * @param nombreJrn
     * @param rowStartIdxAndCount
     * @return
     */
    public List<Correoserrorformato> findByNombreJrn(Object nombreJrn,
			int... rowStartIdxAndCount);

	/**
	 * Find all Correoserrorformato entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<Correoserrorformato> all Correoserrorformato entities
	 */
	public List<Correoserrorformato> findAll(int... rowStartIdxAndCount);
}