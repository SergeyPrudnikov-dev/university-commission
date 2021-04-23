package com.epam.university.commission.service.api;

import com.epam.university.commission.domain.User;

/**
 * This interface contains the basic methods of the service layer for User entities.
 * <p/>
 * University-commission 2021  epam.com
 * <p/>
 * Date: 04/22/2021
 *
 * @author Siarhei Prudnikau1
 */
public interface IUserService {
    /**
     * Finds and returns an object with the given identifier.
     *
     * @param id of the entity.
     * @return User - entity.
     */
    User findById(Long id);
}
