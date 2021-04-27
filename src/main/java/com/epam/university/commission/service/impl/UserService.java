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
public class UserService implements IUserService {
    private IUserRepository userRepository;

    public IUserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.read(id);
    }

    /**
     * Updates or creates this "user" in the database. Checks the uniqueness of the "login" in the database.
     *
     * @param user is an object that is saved in the database.
     */
    @Override
    public void save(User user) {
        if (user.getId() != null) {
            User storedUser = userRepository.read(user.getId());
            if (storedUser != null) {
                userRepository.update(user);
            }
        } else {
            Long id = userRepository.create(user);
        }
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }
}
