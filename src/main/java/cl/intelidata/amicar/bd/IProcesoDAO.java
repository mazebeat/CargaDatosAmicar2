package cl.intelidata.amicar.bd;

import java.sql.Timestamp;
import java.util.List;

/**
 * Interface for ProcesoDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IProcesoDAO {
		/**
	 Perform an initial save of a previously unsaved Proceso entity. 
	 All subsequent persist actions of this entity should use the #update() method.
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 	 
	 * <pre> 
	 *   EntityManagerHelper.beginTransaction();
	 *   IProcesoDAO.save(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity Proceso entity to persist
	  @throws RuntimeException when the operation fails
	 */
    public void save(Proceso entity);
    /**
	 Delete a persistent Proceso entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IProcesoDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity Proceso entity to delete
	 @throws RuntimeException when the operation fails
	 */
    public void delete(Proceso entity);
   /**
	 Persist a previously saved Proceso entity and return it or a copy of it to the sender. 
	 A copy of the Proceso entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IProcesoDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity Proceso entity to update
	 @return Proceso the persisted Proceso entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public Proceso update(Proceso entity);
	public Proceso findById( Integer id);
	 /**
	 * Find all Proceso entities with a specific property value.  
	 
	  @param propertyName the name of the Proceso property to query
	  @param value the property value to match
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<Proceso> found by query
	 */
	public List<Proceso> findByProperty(String propertyName, Object value
			, int...rowStartIdxAndCount
		);
	/**
	 * Find all Proceso entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<Proceso> all Proceso entities
	 */
	public List<Proceso> findAll(
			int...rowStartIdxAndCount
		);	
}