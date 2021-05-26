package com.epam.university.commission.service.api;

import com.epam.university.commission.domain.User;

/**
 * This interface contains the basic methods of the service layer for {@link User} entities.
 * <p/>
 * University-commission 2021  epam.com
 * <p/>
 * Date: 04/22/2021
 *
 * @author Siarhei Prudnikau1
 */
public interface IUserService {
    /**
     * Finds and returns an {@link User} with the given identifier.
     *
     * @param id is the identifier of the {@link User}.
     * @return User - entity.
     */
    User findById(Long id);

    /**
     * Saves a given {@link User}.
     *
     * @param user which is saved.
     */
    void save(User user);

    /**
     * Deletes an {@link User} with the given identifier.
     *
     * @param id is the identifier of the {@link User}.
     */
    void delete(Long id);
}
