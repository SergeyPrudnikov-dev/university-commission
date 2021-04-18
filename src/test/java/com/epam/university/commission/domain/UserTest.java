package com.epam.university.commission.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Test to verify the functionality of the User.
 * <p/>
 * University-commission 2021  epam.com
 * <p/>
 * Date: 04/18/2021
 *
 * @author Siarhei Prudnikau1
 */
public class UserTest {

    private static final String LOGIN_1 = "Test Login 1";
    private static final String LOGIN_2 = "Test Login 2";

    private static final String EXPECTED_LOGIN = "LOGIN";
    private static final String EXPECTED_PASSWORD = "PASSWORD";
    private static final Role EXPECTED_ROLE = Role.ADMIN;
    private static final String EXPECTED_EMAIL = "EXAMPLE@EMAIL.ORG";
    private static final long EXPECTED_ID = 1789;

    private static final String OTHER_LOGIN = "OTHER_LOGIN";
    private static final String OTHER_PASSWORD = "OTHER_PASSWORD";
    private static final Role OTHER_ROLE = Role.ENTRANT;
    private static final String OTHER_EMAIL = "OTHER_EXAMPLE@EMAIL.ORG";
    private static final long OTHER_ID = 4573;

    private User expectedUser;

    @BeforeEach
    public void setUp() {
        expectedUser = new User();
        expectedUser.setLogin(EXPECTED_LOGIN);
        expectedUser.setPassword(EXPECTED_PASSWORD);
        expectedUser.setRole(EXPECTED_ROLE);
        expectedUser.setEmail(EXPECTED_EMAIL);
        expectedUser.setId(EXPECTED_ID);
    }

    @Test
    public void testEqualityOfTheDifferentUser() {
        User user = new User();
        user.setLogin(OTHER_LOGIN);
        user.setPassword(OTHER_PASSWORD);
        user.setRole(OTHER_ROLE);
        user.setEmail(OTHER_EMAIL);
        user.setId(OTHER_ID);
        assertNotEquals(expectedUser, user);
    }

    @Test
    public void testEqualityOfTheSameUser() {
        User user = new User();
        user.setLogin(EXPECTED_LOGIN);
        user.setPassword(EXPECTED_PASSWORD);
        user.setRole(EXPECTED_ROLE);
        user.setEmail(EXPECTED_EMAIL);
        user.setId(EXPECTED_ID);
        assertEquals(expectedUser, user);
    }

    @Test
    public void testHashCode() {
        User user1 = new User();
        user1.setLogin(LOGIN_1);
        User user2 = new User();
        user2.setLogin(LOGIN_2);
        assertNotEquals(user1.hashCode(), user2.hashCode());
    }
}
