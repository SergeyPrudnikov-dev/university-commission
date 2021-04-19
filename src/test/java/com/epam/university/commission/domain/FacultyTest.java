package com.epam.university.commission.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Test to verify the functionality of the Faculty.
 * <p/>
 * University-commission 2021  epam.com
 * <p/>
 * Date: 04/18/2021
 *
 * @author Siarhei Prudnikau1
 */
public class FacultyTest {

    private static final String NAME_1 = "Test Name 1";
    private static final String NAME_2 = "Test Name 2";

    private static final String EXPECTED_NAME = "NAME";
    private static final int EXPECTED_RECRUITMENT_PLAN = 50;
    private static final String EXPECTED_CERTIFICATE = "CERTIFICATE";
    private static final String EXPECTED_SUBJECT_1 = "SUBJECT_1";
    private static final String EXPECTED_SUBJECT_2 = "SUBJECT_2";
    private static final String EXPECTED_SUBJECT_3 = "SUBJECT_3";
    private static final long EXPECTED_ID = 789;

    private static final String OTHER_NAME = "OTHER_NAME";
    private static final int OTHER_RECRUITMENT_PLAN = 70;
    private static final String OTHER_CERTIFICATE = "OTHER_CERTIFICATE";
    private static final String OTHER_SUBJECT_1 = "OTHER_SUBJECT_1";
    private static final String OTHER_SUBJECT_2 = "OTHER_SUBJECT_2";
    private static final String OTHER_SUBJECT_3 = "OTHER_SUBJECT_3";
    private static final long OTHER_ID = 564;

    private Faculty expectedFaculty;

    @BeforeEach
    public void setUp() {
        expectedFaculty = new Faculty();
        expectedFaculty.setName(EXPECTED_NAME);
        expectedFaculty.setRecruitmentPlan(EXPECTED_RECRUITMENT_PLAN);
        expectedFaculty.setCertificate(EXPECTED_CERTIFICATE);
        expectedFaculty.setSubject1(EXPECTED_SUBJECT_1);
        expectedFaculty.setSubject2(EXPECTED_SUBJECT_2);
        expectedFaculty.setSubject3(EXPECTED_SUBJECT_3);
        expectedFaculty.setId(EXPECTED_ID);
    }

    @Test
    public void testEqualityOfTheDifferentFaculty() {
        Faculty faculty = new Faculty();
        faculty.setName(OTHER_NAME);
        faculty.setRecruitmentPlan(OTHER_RECRUITMENT_PLAN);
        faculty.setCertificate(OTHER_CERTIFICATE);
        faculty.setSubject1(OTHER_SUBJECT_1);
        faculty.setSubject2(OTHER_SUBJECT_2);
        faculty.setSubject3(OTHER_SUBJECT_3);
        faculty.setId(OTHER_ID);
        assertNotEquals(expectedFaculty, faculty);
    }

    @Test
    public void testEqualityOfTheSameFaculty() {
        Faculty faculty = new Faculty();
        faculty.setName(EXPECTED_NAME);
        faculty.setRecruitmentPlan(EXPECTED_RECRUITMENT_PLAN);
        faculty.setCertificate(EXPECTED_CERTIFICATE);
        faculty.setSubject1(EXPECTED_SUBJECT_1);
        faculty.setSubject2(EXPECTED_SUBJECT_2);
        faculty.setSubject3(EXPECTED_SUBJECT_3);
        faculty.setId(EXPECTED_ID);
        assertEquals(expectedFaculty, faculty);
    }

    @Test
    public void testHashCode() {
        Faculty faculty1 = new Faculty();
        faculty1.setName(NAME_1);
        Faculty faculty2 = new Faculty();
        faculty1.setName(NAME_2);
        assertNotEquals(faculty1.hashCode(), faculty2.hashCode());
    }
}
