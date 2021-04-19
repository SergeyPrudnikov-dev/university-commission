package com.epam.university.commission.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test to verify the functionality of the (@link EnrolledPerson).
 * <p/>
 * University-commission 2021  epam.com
 * <p/>
 * Date: 04/18/2021
 *
 * @author Siarhei Prudnikau1
 */
public class EnrolledPersonTest {

    private static final String FULL_NAME_1 = "Test FullName 1";
    private static final String FULL_NAME_2 = "Test FullName 2";

    private static final String EXPECTED_FULL_NAME = "FULL_NAME";
    private static final int EXPECTED_TOTAL_SCORE = 99;
    private static final int EXPECTED_FACULTY_ID = 1;
    private static final long EXPECTED_STATEMENT_ID = 77;
    private static final long EXPECTED_ID = 1000;

    private static final String OTHER_FULL_NAME = "OTHER_FULL_NAME";
    private static final int OTHER_TOTAL_SCORE = 78;
    private static final int OTHER_FACULTY_ID = 2;
    private static final long OTHER_STATEMENT_ID = 155;
    private static final long OTHER_ID = 765;

    private EnrolledPerson expectedPerson;

    @BeforeEach
    public void setUp() {
        expectedPerson = new EnrolledPerson();
        expectedPerson.setFullName(EXPECTED_FULL_NAME);
        expectedPerson.setTotalScore(EXPECTED_TOTAL_SCORE);
        expectedPerson.setFacultyId(EXPECTED_FACULTY_ID);
        expectedPerson.setStatementId(EXPECTED_STATEMENT_ID);
        expectedPerson.setId(EXPECTED_ID);
    }

    @Test
    public void testEqualityOfTheDifferentEnrolledPerson() {
        EnrolledPerson enrolledPerson = new EnrolledPerson();
        enrolledPerson.setFullName(OTHER_FULL_NAME);
        enrolledPerson.setTotalScore(OTHER_TOTAL_SCORE);
        enrolledPerson.setFacultyId(OTHER_FACULTY_ID);
        enrolledPerson.setStatementId(OTHER_STATEMENT_ID);
        enrolledPerson.setId(OTHER_ID);
        assertNotEquals(expectedPerson, enrolledPerson);
    }

    @Test
    public void testEqualityOfTheSameEnrolledPerson() {
        EnrolledPerson enrolledPerson = new EnrolledPerson();
        enrolledPerson.setFullName(EXPECTED_FULL_NAME);
        enrolledPerson.setTotalScore(EXPECTED_TOTAL_SCORE);
        enrolledPerson.setFacultyId(EXPECTED_FACULTY_ID);
        enrolledPerson.setStatementId(EXPECTED_STATEMENT_ID);
        enrolledPerson.setId(EXPECTED_ID);
        assertEquals(expectedPerson, enrolledPerson);
    }

    @Test
    public void testHashCode() {
        EnrolledPerson enrolledPerson1 = new EnrolledPerson();
        enrolledPerson1.setFullName(FULL_NAME_1);
        EnrolledPerson enrolledPerson2 = new EnrolledPerson();
        enrolledPerson2.setFullName(FULL_NAME_2);
        assertNotEquals(enrolledPerson1.hashCode(), enrolledPerson2.hashCode());
    }
}
