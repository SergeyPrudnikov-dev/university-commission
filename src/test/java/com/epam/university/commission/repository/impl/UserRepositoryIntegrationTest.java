package com.epam.university.commission.repository.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.epam.university.commission.domain.Role;
import com.epam.university.commission.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test to verify the functionality of the {@link UserRepository}.
 * <p/>
 * University-commission 2021  epam.com
 * <p/>
 * Date: 05/17/2021
 *
 * @author Siarhei Prudnikau1
 */
class UserRepositoryIntegrationTest {
    private static final String USER_EMAIL = "test_email@gmail.com";
    private static final String USER_LOGIN = "test_login";
    private static final String USER_PASSWORD = "test_password";
    private static final String USER_UPDATED_EMAIL = "test_updated@gmail.com";
    private static final String USER_UPDATED_LOGIN = "test_updated_login";
    private static final String USER_UPDATED_PASSWORD = "test_updated_password";
    private User user;
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        user = buildUser();
        userRepository = new UserRepository();
        userRepository.create(user);
    }

    @AfterEach
    public void teardown() {
        userRepository.delete(user.getId());
    }

    @Test
    void testCreateUser() {
        User expectedUser = buildUser();
        userRepository.create(expectedUser);
        User actualUser = userRepository.read(expectedUser.getId());
        assertNotNull(actualUser);
        assertEquals(expectedUser, actualUser);
        userRepository.delete(expectedUser.getId());
    }

    @Test
    void testReadUserById() {
        User actualUser = userRepository.read(user.getId());
        assertNotNull(actualUser);
        assertEquals(USER_LOGIN, actualUser.getLogin());
        assertEquals(USER_EMAIL, actualUser.getEmail());
        assertEquals(USER_PASSWORD, actualUser.getPassword());
        assertEquals(user.getRole(),actualUser.getRole());
    }

    @Test
    void testUpdateUser() {
        user.setLogin(USER_UPDATED_LOGIN);
        user.setEmail(USER_UPDATED_EMAIL);
        user.setPassword(USER_UPDATED_PASSWORD);
        user.setRole(Role.ADMIN);
        userRepository.update(user);
        User actualUser = userRepository.read(user.getId());
        assertEquals(user, actualUser);
    }

    @Test
    void testDeleteUser() {
        userRepository.delete(user.getId());
        User actualUser = userRepository.read(user.getId());
        assertNull(actualUser);
    }

    private User buildUser() {
        User newUser = new User();
        newUser.setLogin(USER_LOGIN);
        newUser.setPassword(USER_PASSWORD);
        newUser.setEmail(USER_EMAIL);
        newUser.setRole(Role.ENTRANT);
        return newUser;
    }
}
