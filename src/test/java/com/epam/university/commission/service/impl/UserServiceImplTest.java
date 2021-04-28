package com.epam.university.commission.service.impl;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.epam.university.commission.domain.User;
import com.epam.university.commission.repository.api.IUserRepository;

import org.easymock.EasyMockExtension;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * Test to verify the functionality of the {@link UserService}.
 * <p/>
 * University-commission 2021  epam.com
 * <p/>
 * Date: 04/23/2021
 *
 * @author Siarhei Prudnikau1
 */
@ExtendWith(EasyMockExtension.class)
class UserServiceImplTest {
    private static final long USER_ID = 123;
    private User testUser;

    @BeforeEach
    void setUp() {
        testUser = new User();
        testUser.setId(USER_ID);
    }

    @TestSubject
    private UserService userService = new UserService();

    @Mock
    private IUserRepository repository = createMock(IUserRepository.class);

    @Test
    void findById() {
        expect(repository.read(USER_ID)).andReturn(testUser);
        replay(repository);

        assertEquals(testUser, userService.findById(USER_ID));
        verify(repository);
    }
}
