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
     * Finds and returns an {@link Faculty} with the given identifier.
     *
     * @param id is the identifier of the {@link Faculty}.
     * @return Faculty - entity.
     */
    Faculty findById(Long id);

    /**
     * Saves a given {@link Faculty}.
     *
     * @param faculty which is saved.
     */
    void save(Faculty faculty);

    /**
     * Deletes an {@link Faculty} with the given identifier.
     *
     * @param id is the identifier of the {@link Faculty}.
     */
    void delete(Long id);
}
