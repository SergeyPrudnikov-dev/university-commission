package com.epam.university.commission.service.impl;

import com.epam.university.commission.domain.User;
import com.epam.university.commission.exception.DataChangesException;
import com.epam.university.commission.repository.api.IUserRepository;
import com.epam.university.commission.service.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * This service contains the basic methods of the service layer for {@link User} entities.
 * <p/>
 * University-commission 2021  epam.com
 * <p/>
 * Date: 04/22/2021
 *
 * @author Siarhei Prudnikau1
 */
@Service
public class UserService implements IUserService {
    private IUserRepository userRepository;

    public IUserRepository getUserRepository() {
        return userRepository;
    }

    @Autowired
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
        return Optional.ofNullable(userRepository.read(id))
                .orElseThrow(() -> new NoSuchElementException(String.format("User with Id %d not found.", id)));
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
                if (!userRepository.read(user.getId()).equals(user)) {
                    new DataChangesException("The user was not updated.");
                }
            }
        } else {
            Long id = userRepository.create(user);
            if (id == null) {
                throw new DataChangesException("The user was not created.");
            }
        }
    }

    /**
     * Deletes an {@link User} with the given identifier.
     *
     * @param id is the identifier of the {@link User}.
     */
    @Override
    public void delete(Long id) {
        Optional.ofNullable(userRepository.read(id))
                .orElseThrow(() -> new NoSuchElementException(String.format("User with Id %d not found.", id)));
        userRepository.delete(id);
    }
}
