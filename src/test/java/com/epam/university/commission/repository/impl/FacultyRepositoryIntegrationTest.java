package com.epam.university.commission.repository.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.epam.university.commission.domain.Faculty;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

/**
 * Test to verify the functionality of the {@link FacultyRepository}.
 * <p/>
 * University-commission 2021  epam.com
 * <p/>
 * Date: 05/18/2021
 *
 * @author Siarhei Prudnikau1
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FacultyRepositoryIntegrationTest {
    private static final int FACULTY_RECRUITMENT_PLAN = 30;
    private static final String FACULTY_CERTIFICATE = "test_certificate";
    private static final String FACULTY_NAME = "test_name";
    private static final String FACULTY_SUBJECT_1 = "test_subject1";
    private static final String FACULTY_SUBJECT_2 = "test_subject2";
    private static final String FACULTY_SUBJECT_3 = "test_subject3";
    private static final int FACULTY_UPDATED_RECRUITMENT_PLAN = 20;
    private static final String FACULTY_UPDATED_CERTIFICATE = "test_updated_certificate";
    private static final String FACULTY_UPDATED_NAME = "test_updated_name";
    private static final String FACULTY_UPDATED_SUBJECT_1 = "test_updated_subject1";
    private static final String FACULTY_UPDATED_SUBJECT_2 = "test_updated_subject2";
    private static final String FACULTY_UPDATED_SUBJECT_3 = "test_updated_subject3";
    private Faculty faculty;
    private FacultyRepository facultyRepository;

    @BeforeEach
    void setup() {
        faculty = buildFaculty();
        facultyRepository = new FacultyRepository();
        facultyRepository.create(faculty);
    }

    @AfterEach
    void teardown() {
        facultyRepository.delete(faculty.getId());
    }

    @Test
    void testCreateFaculty() {
        Faculty expectedFaculty = buildFaculty();
        facultyRepository.create(expectedFaculty);
        Faculty actualFaculty = facultyRepository.read(expectedFaculty.getId());
        assertNotNull(actualFaculty);
        assertEquals(expectedFaculty, actualFaculty);
        facultyRepository.delete(expectedFaculty.getId());
    }

    @Test
    void testReadFacultyById() {
        Faculty actualFaculty = facultyRepository.read(faculty.getId());
        assertNotNull(actualFaculty);
        assertEquals(FACULTY_RECRUITMENT_PLAN, actualFaculty.getRecruitmentPlan());
        assertEquals(FACULTY_NAME, actualFaculty.getName());
        assertEquals(FACULTY_CERTIFICATE, actualFaculty.getCertificate());
        assertEquals(FACULTY_SUBJECT_1, actualFaculty.getSubject1());
        assertEquals(FACULTY_SUBJECT_2, actualFaculty.getSubject2());
        assertEquals(FACULTY_SUBJECT_3, actualFaculty.getSubject3());
    }

    @Test
    void testUpdateFaculty() {
        faculty.setRecruitmentPlan(FACULTY_UPDATED_RECRUITMENT_PLAN);
        faculty.setName(FACULTY_UPDATED_NAME);
        faculty.setCertificate(FACULTY_UPDATED_CERTIFICATE);
        faculty.setSubject1(FACULTY_UPDATED_SUBJECT_1);
        faculty.setSubject2(FACULTY_UPDATED_SUBJECT_2);
        faculty.setSubject3(FACULTY_UPDATED_SUBJECT_3);
        facultyRepository.update(faculty);
        Faculty actualFaculty = facultyRepository.read(faculty.getId());
        assertEquals(faculty, actualFaculty);
    }

    @Test
    void testDeleteFaculty() {
        facultyRepository.delete(faculty.getId());
        Faculty actualFaculty = facultyRepository.read(faculty.getId());
        assertNull(actualFaculty);
    }

    private Faculty buildFaculty() {
        Faculty newFaculty = new Faculty();
        newFaculty.setRecruitmentPlan(FACULTY_RECRUITMENT_PLAN);
        newFaculty.setName(FACULTY_NAME);
        newFaculty.setCertificate(FACULTY_CERTIFICATE);
        newFaculty.setSubject1(FACULTY_SUBJECT_1);
        newFaculty.setSubject2(FACULTY_SUBJECT_2);
        newFaculty.setSubject3(FACULTY_SUBJECT_3);
        return newFaculty;
    }
}

