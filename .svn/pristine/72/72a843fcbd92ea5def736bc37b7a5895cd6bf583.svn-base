package cl.intelidata.amicar.bd;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

/**
 * Interface for EjecutivosDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IEjecutivosDAO {
		/**
	 Perform an initial save of a previously unsaved Ejecutivos entity. 
	 All subsequent persist actions of this entity should use the #update() method.
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 	 
	 * <pre> 
	 *   EntityManagerHelper.beginTransaction();
	 *   IEjecutivosDAO.save(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity Ejecutivos entity to persist
	  @throws RuntimeException when the operation fails
	 */
    public void save(Ejecutivos entity);
    /**
	 Delete a persistent Ejecutivos entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IEjecutivosDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity Ejecutivos entity to delete
	 @throws RuntimeException when the operation fails
	 */
    public void delete(Ejecutivos entity);
   /**
	 Persist a previously saved Ejecutivos entity and return it or a copy of it to the sender. 
	 A copy of the Ejecutivos entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IEjecutivosDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity Ejecutivos entity to update
	 @return Ejecutivos the persisted Ejecutivos entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public Ejecutivos update(Ejecutivos entity);
	public Ejecutivos findById( Integer id);
	 /**
	 * Find all Ejecutivos entities with a specific property value.  
	 
	  @param propertyName the name of the Ejecutivos property to query
	  @param value the property value to match
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<Ejecutivos> found by query
	 */
	public List<Ejecutivos> findByProperty(String propertyName, Object value
			, int...rowStartIdxAndCount
		);
	public List<Ejecutivos> findByNombreEjecutivo(Object nombreEjecutivo
			, int...rowStartIdxAndCount
		);
	public List<Ejecutivos> findByCorreoEjecutivo(Object correoEjecutivo
			, int...rowStartIdxAndCount
		);
	public List<Ejecutivos> findByFechaModificacion(Object fechaModificacion
			, int...rowStartIdxAndCount
		);
	/**
	 * Find all Ejecutivos entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<Ejecutivos> all Ejecutivos entities
	 */
	public List<Ejecutivos> findAll(
			int...rowStartIdxAndCount
		);	
}