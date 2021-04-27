package com.epam.university.commission.service.impl;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.epam.university.commission.domain.EnrolledPerson;
import com.epam.university.commission.repository.api.IEnrolledPersonRepository;

import org.easymock.EasyMockExtension;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * Test to verify the functionality of the {@link EnrolledPersonService}.
 * <p/>
 * University-commission 2021  epam.com
 * <p/>
 * Date: 04/26/2021
 *
 * @author Siarhei Prudnikau1
 */
@ExtendWith(EasyMockExtension.class)
class EnrolledPersonServiceImplTest {
    private static final long ENROLLED_PERSON_ID = 123;
    private EnrolledPerson testEnrolledPerson;

    @BeforeEach
    void setUp() {
        testEnrolledPerson = new EnrolledPerson();
        testEnrolledPerson.setId(ENROLLED_PERSON_ID);
    }

    @TestSubject
    private EnrolledPersonService enrolledPersonService = new EnrolledPersonService();

    @Mock
    private IEnrolledPersonRepository repository = createMock(IEnrolledPersonRepository.class);

    @Test
    void findById() {
        expect(repository.read(ENROLLED_PERSON_ID)).andReturn(testEnrolledPerson);
        replay(repository);

        assertEquals(testEnrolledPerson, enrolledPersonService.findById(ENROLLED_PERSON_ID));
        verify(repository);
    }
}
