package com.epam.university.commission.mappers;

import com.epam.university.commission.domain.EnrolledPerson;

/**
 * It is mapper interface to deal with {@link EnrolledPerson}.
 * <p/>
 * University-commission 2021  epam.com
 * <p/>
 * Date: 05/15/2021
 *
 * @author Siarhei Prudnikau1
 */
public interface IEnrolledPersonMapper {
    /**
     * Inserts {@link EnrolledPerson} to the database.
     *
     * @param enrolledPerson which is inserted into the database.
     * @return id is the identifier of the {@link EnrolledPerson}.
     */
    Long insert(EnrolledPerson enrolledPerson);

    /**
     * Finds and returns an {@link EnrolledPerson} with the given identifier.
     *
     * @param id is the identifier of the {@link EnrolledPerson}.
     * @return EnrolledPerson.
     */
    EnrolledPerson findById(Long id);

    /**
     * Updates a given {@link EnrolledPerson}.
     *
     * @param enrolledPerson which is updated.
     */
    void update(EnrolledPerson enrolledPerson);

    /**
     * Deletes {@link EnrolledPerson} with the given identifier.
     *
     * @param enrolledPersonId is the identifier of the {@link EnrolledPerson}.
     */
    void delete(Long enrolledPersonId);
}
