package com.epam.university.commission.mappers;

import com.epam.university.commission.domain.Faculty;

/**
 * It is mapper interface to deal with {@link Faculty}.
 * <p/>
 * University-commission 2021  epam.com
 * <p/>
 * Date: 05/18/2021
 *
 * @author Siarhei Prudnikau1
 */
public interface IFacultyMapper {
    /**
     * Inserts {@link Faculty} to the database.
     *
     * @param faculty which is inserted into the database.
     * @return id is the identifier of the {@link Faculty}.
     */
    Long insert(Faculty faculty);

    /**
     * Finds and returns an {@link Faculty} with the given identifier.
     *
     * @param id is the identifier of the {@link Faculty}.
     * @return Faculty.
     */
    Faculty findById(Long id);

    /**
     * Updates a given {@link Faculty}.
     *
     * @param faculty which is updated.
     */
    void update(Faculty faculty);

    /**
     * Deletes {@link Faculty} with the given identifier.
     *
     * @param facultyId is the identifier of the {@link Faculty}.
     */
    void delete(Long facultyId);
}
