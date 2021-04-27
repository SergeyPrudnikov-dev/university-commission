package com.epam.university.commission.service.api;

import com.epam.university.commission.domain.Faculty;

/**
 * This interface contains the basic methods of the service layer for {@link Faculty} entities.
 * <p/>
 * University-commission 2021  epam.com
 * <p/>
 * Date: 04/22/2021
 *
 * @author Siarhei Prudnikau1
 */
public interface IFacultyService {
    /**
     * Finds and returns an object with the given identifier.
     *
     * @param id of the entity.
     * @return Faculty - entity.
     */
    Faculty findById(Long id);

    /**
     * Saves an object with the given identifier.
     *
     * @param faculty of the entity.
     */
    void save(Faculty faculty);

    /**
     * Deletes an object with the given identifier.
     *
     * @param id of the entity.
     */
    void delete(Long id);
}
