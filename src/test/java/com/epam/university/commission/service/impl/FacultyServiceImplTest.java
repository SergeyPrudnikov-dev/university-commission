package com.epam.university.commission.service.impl;

import static org.easymock.EasyMock.createStrictControl;
import static org.easymock.EasyMock.expect;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.epam.university.commission.domain.Faculty;
import com.epam.university.commission.repository.api.IFacultyRepository;

import org.easymock.EasyMockExtension;
import org.easymock.IMocksControl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * Test to verify the functionality of the {@link FacultyService}.
 * <p/>
 * University-commission 2021  epam.com
 * <p/>
 * Date: 04/26/2021
 *
 * @author Siarhei Prudnikau1
 */
@ExtendWith(EasyMockExtension.class)
class FacultyServiceImplTest {
    private static final long FACULTY_ID = 123;
    private Faculty testFaculty;
    private IMocksControl control;
    private IFacultyRepository repository;
    private FacultyService facultyService;

    @BeforeEach
    void setUp() {
        testFaculty = new Faculty();
        testFaculty.setId(FACULTY_ID);
        control = createStrictControl();
        repository = control.createMock(IFacultyRepository.class);
        facultyService = new FacultyService();
        facultyService.setFacultyRepository(repository);
    }

    @Test
    void findById() {
        expect(repository.read(FACULTY_ID)).andReturn(testFaculty);
        control.replay();

        assertEquals(testFaculty, facultyService.findById(FACULTY_ID));
        control.verify();
    }
}
