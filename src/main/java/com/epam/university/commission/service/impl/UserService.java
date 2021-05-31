package com.epam.university.commission.service.impl;

import com.epam.university.commission.domain.User;
import com.epam.university.commission.repository.api.IUserRepository;
import com.epam.university.commission.service.api.IUserService;

/**
 * This service contains the basic methods of the service layer for {@link User} entities.
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

    /**
     * Finds and returns an {@link User} with the given identifier.
     *
     * @param id is the identifier of the {@link User}.
     * @return User - entity.
     */
    @Override
    public User findById(Long id) {
        return userRepository.read(id);
    }

    /**
     * Saves a given {@link User}.
     *
     * @param user which is saved.
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

    /**
     * Deletes an {@link User} with the given identifier.
     *
     * @param id is the identifier of the {@link User}.
     */
    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }
}
