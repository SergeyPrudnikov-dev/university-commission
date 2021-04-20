package com.epam.university.commission.repository.api;

import com.epam.university.commission.domain.Entity;

/**
 * Base repository that represent CRUD operations for common repository.
 * <p/>
 * University-commission 2021  epam.com
 * <p/>
 * Date: 04/20/2021
 *
 * @param <T>  The type of objects managed by repository.
 * @param <ID> The type of object's identifier.
 * @author Siarhei Prudnikau1
 */
public interface ICrudRepository<ID, T extends Entity> {
    /**
     * Creates a given entity.
     *
     * @param entity which is created.
     * @return id of the entity.
     */
    ID create(T entity);

    /**
     * Finds and returns an object with the given identifier.
     *
     * @param id of the entity.
     * @return T - entity.
     */
    T read(ID id);

    /**
     * Updates a given entity.
     *
     * @param entity which is updated.
     */
    void update(T entity);

    /**
     * Deletes the entity with the given id.
     *
     * @param id of the entity.
     */
    void delete(ID id);
}
