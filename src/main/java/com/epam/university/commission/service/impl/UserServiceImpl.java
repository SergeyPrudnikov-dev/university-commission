package com.epam.university.commission.service.impl;

import com.epam.university.commission.domain.User;
import com.epam.university.commission.repository.api.IUserRepository;
import com.epam.university.commission.service.api.IUserService;

/**
 * This is a method for finding an entity {@link User} in a database by id.
 * <p/>
 * University-commission 2021  epam.com
 * <p/>
 * Date: 04/22/2021
 *
 * @author Siarhei Prudnikau1
 */
public class UserServiceImpl implements IUserService {
    private IUserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.read(id);
    }
}
