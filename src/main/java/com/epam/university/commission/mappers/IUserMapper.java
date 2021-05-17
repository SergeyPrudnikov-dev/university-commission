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
     * Inserts User to the database.
     *
     * @param user - {@link User} that is being inserted into the database.
     * @return id user.
     */
    Long insert(User user);

    /**
     * Finds and returns an user with the given identifier.
     *
     * @param id - user id.
     * @return User - {@link User}.
     */
    User findById(Long id);

    /**
     * Updates a given {@link User}.
     *
     * @param user which is updated.
     */
    void update(User user);

    /**
     * Deletes {@link User} with the given id.
     *
     * @param userId - id of User.
     */
    void delete(Long userId);
}
