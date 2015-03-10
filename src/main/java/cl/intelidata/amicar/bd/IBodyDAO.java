package cl.intelidata.amicar.bd;

import java.util.List;

/**
 * Interface for BodyDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IBodyDAO {
		/**
	 Perform an initial save of a previously unsaved Body entity. 
	 All subsequent persist actions of this entity should use the #update() method.
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 	 
	 * <pre> 
	 *   EntityManagerHelper.beginTransaction();
	 *   IBodyDAO.save(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity Body entity to persist
	  @throws RuntimeException when the operation fails
	 */
    public void save(Body entity);
    /**
	 Delete a persistent Body entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	  
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   IBodyDAO.delete(entity);
	 *   EntityManagerHelper.commit();
	 *   entity = null;
	 * </pre>
	   @param entity Body entity to delete
	 @throws RuntimeException when the operation fails
	 */
    public void delete(Body entity);
   /**
	 Persist a previously saved Body entity and return it or a copy of it to the sender. 
	 A copy of the Body entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 
	 * <pre>
	 *   EntityManagerHelper.beginTransaction();
	 *   entity = IBodyDAO.update(entity);
	 *   EntityManagerHelper.commit();
	 * </pre>
	   @param entity Body entity to update
	 @return Body the persisted Body entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public Body update(Body entity);
	public Body findById( Integer id);
	 /**
	 * Find all Body entities with a specific property value.  
	 
	  @param propertyName the name of the Body property to query
	  @param value the property value to match
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<Body> found by query
	 */
	public List<Body> findByProperty(String propertyName, Object value
			, int...rowStartIdxAndCount
		);
	public List<Body> findByBodyNombre(Object bodyNombre
			, int...rowStartIdxAndCount
		);
	/**
	 * Find all Body entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<Body> all Body entities
	 */
	public List<Body> findAll(
			int...rowStartIdxAndCount
		);	
}