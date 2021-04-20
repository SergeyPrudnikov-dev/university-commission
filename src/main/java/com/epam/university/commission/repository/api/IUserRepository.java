package com.epam.university.commission.repository.api;

import com.epam.university.commission.domain.User;

/**
 * The interface extends ICrudRepository for User entity.
 * <p/>
 * University-commission 2021  epam.com
 * <p/>
 * Date: 04/20/2021
 *
 * @author Siarhei Prudnikau1
 */
public interface IUserRepository extends ICrudRepository<Long, User> {
}
