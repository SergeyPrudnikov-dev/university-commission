package com.epam.university.commission.service.api;

import com.epam.university.commission.domain.EnrolledPerson;

/**
 * This interface contains the basic methods of the service layer for {@link EnrolledPerson} entities.
 * <p/>
 * University-commission 2021  epam.com
 * <p/>
 * Date: 04/22/2021
 *
 * @author Siarhei Prudnikau1
 */
public interface IEnrolledPersonService {

    /**
     * Finds and returns an {@link EnrolledPerson} with the given identifier.
     *
     * @param id is the identifier of the {@link EnrolledPerson}.
     * @return EnrolledPerson - entity.
     */
    EnrolledPerson findById(Long id);

    /**
     * Saves a given {@link EnrolledPerson}.
     *
     * @param enrolledPerson which is saved.
     */
    void save(EnrolledPerson enrolledPerson);

    /**
     * Deletes an {@link EnrolledPerson} with the given identifier.
     *
     * @param id is the identifier of the {@link EnrolledPerson}.
     */
    void delete(Long id);
}

