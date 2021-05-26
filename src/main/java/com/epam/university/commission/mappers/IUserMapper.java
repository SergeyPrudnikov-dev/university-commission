package com.epam.university.commission.mappers;

import com.epam.university.commission.domain.User;

/**
 * It is mapper interface to deal with {@link User}.
 * <p/>
 * University-commission 2021  epam.com
 * <p/>
 * Date: 05/15/2021
 *
 * @author Siarhei Prudnikau1
 */
public interface IUserMapper {
    /**
     * Inserts {@link User} to the database.
     *
     * @param user which is inserted into the database.
     * @return id is the identifier of the {@link User}.
     */
    Long insert(User user);

    /**
     * Finds and returns an {@link User} with the given identifier.
     *
     * @param id is the identifier of the {@link User}.
     * @return User.
     */
    User findById(Long id);

    /**
     * Updates a given {@link User}.
     *
     * @param user which is updated.
     */
    void update(User user);

    /**
     * Deletes {@link User} with the given identifier.
     *
     * @param userId is the identifier of the {@link User}.
     */
    void delete(Long userId);
}
