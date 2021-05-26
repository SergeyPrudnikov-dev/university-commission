package com.epam.university.commission.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

/**
 * Test to verify the functionality of the StatementByEntrant.
 * <p/>
 * University-commission 2021  epam.com
 * <p/>
 * Date: 04/18/2021
 *
 * @author Siarhei Prudnikau1
 */
public class StatementByEntrantTest {

    private static final String LAST_NAME_1 = "Test LastName 1";
    private static final String LAST_NAME_2 = "Test LastName 2";

    private static final String EXPECTED_LAST_NAME = "LAST_NAME";
    private static final String EXPECTED_FIRST_NAME = "FIRST_NAME";
    private static final String EXPECTED_PATRONYMIC = "PATRONYMIC";
    private static final String EXPECTED_PASSPORT_ID = "3636346ID";
    private static final Faculty EXPECTED_FACULTY = new Faculty();
    private static final int EXPECTED_CERTIFICATE_SCORE = 87;
    private static final int EXPECTED_SUBJECT_SCORE_1 = 65;
    private static final int EXPECTED_SUBJECT_SCORE_2 = 99;
    private static final int EXPECTED_SUBJECT_SCORE_3 = 56;
    private static final LocalDate EXPECTED_DATE = LocalDate.now();
    private static final long EXPECTED_USER_ID = 2352;
    private static final long EXPECTED_ID = 13298;

    private static final String OTHER_LAST_NAME = "OTHER_LAST_NAME";
    private static final String OTHER_FIRST_NAME = "OTHER_FIRST_NAME";
    private static final String OTHER_PATRONYMIC = "OTHER_PATRONYMIC";
    private static final String OTHER_PASSPORT_ID = "379453ID";
    private static final Faculty OTHER_FACULTY = new Faculty();
    private static final int OTHER_CERTIFICATE_SCORE = 34;
    private static final int OTHER_SUBJECT_SCORE_1 = 77;
    private static final int OTHER_SUBJECT_SCORE_2 = 32;
    private static final int OTHER_SUBJECT_SCORE_3 = 78;
    private static final LocalDate OTHER_DATE = LocalDate.now();
    private static final long OTHER_USER_ID = 12455;
    private static final long OTHER_ID = 5432;

    private StatementByEntrant expectedStatementByEntrant;

    @BeforeEach
    public void setUp() {
        expectedStatementByEntrant = new StatementByEntrant();
        expectedStatementByEntrant.setLastName(EXPECTED_LAST_NAME);
        expectedStatementByEntrant.setFirstName(EXPECTED_FIRST_NAME);
        expectedStatementByEntrant.setPatronymic(EXPECTED_PATRONYMIC);
        expectedStatementByEntrant.setPassportId(EXPECTED_PASSPORT_ID);
        expectedStatementByEntrant.setFaculty(EXPECTED_FACULTY);
        expectedStatementByEntrant.setCertificateScore(EXPECTED_CERTIFICATE_SCORE);
        expectedStatementByEntrant.setSubjectScore1(EXPECTED_SUBJECT_SCORE_1);
        expectedStatementByEntrant.setSubjectScore2(EXPECTED_SUBJECT_SCORE_2);
        expectedStatementByEntrant.setSubjectScore3(EXPECTED_SUBJECT_SCORE_3);
        expectedStatementByEntrant.setDate(EXPECTED_DATE);
        expectedStatementByEntrant.setUserId(EXPECTED_USER_ID);
        expectedStatementByEntrant.setId(EXPECTED_ID);
    }

    @Test
    public void testEqualityOfTheDifferentStatementByEntrant() {
        StatementByEntrant statementByEntrant = new StatementByEntrant();
        statementByEntrant.setLastName(OTHER_LAST_NAME);
        statementByEntrant.setFirstName(OTHER_FIRST_NAME);
        statementByEntrant.setPatronymic(OTHER_PATRONYMIC);
        statementByEntrant.setPassportId(OTHER_PASSPORT_ID);
        statementByEntrant.setFaculty(OTHER_FACULTY);
        statementByEntrant.setCertificateScore(OTHER_CERTIFICATE_SCORE);
        statementByEntrant.setSubjectScore1(OTHER_SUBJECT_SCORE_1);
        statementByEntrant.setSubjectScore2(OTHER_SUBJECT_SCORE_2);
        statementByEntrant.setSubjectScore3(OTHER_SUBJECT_SCORE_3);
        statementByEntrant.setDate(OTHER_DATE);
        statementByEntrant.setUserId(OTHER_USER_ID);
        statementByEntrant.setId(OTHER_ID);
        assertNotEquals(expectedStatementByEntrant, statementByEntrant);
    }

    @Test
    public void testEqualityOfTheSameStatementByEntrant() {
        StatementByEntrant statementByEntrant = new StatementByEntrant();
        statementByEntrant.setLastName(EXPECTED_LAST_NAME);
        statementByEntrant.setFirstName(EXPECTED_FIRST_NAME);
        statementByEntrant.setPatronymic(EXPECTED_PATRONYMIC);
        statementByEntrant.setPassportId(EXPECTED_PASSPORT_ID);
        statementByEntrant.setFaculty(EXPECTED_FACULTY);
        statementByEntrant.setCertificateScore(EXPECTED_CERTIFICATE_SCORE);
        statementByEntrant.setSubjectScore1(EXPECTED_SUBJECT_SCORE_1);
        statementByEntrant.setSubjectScore2(EXPECTED_SUBJECT_SCORE_2);
        statementByEntrant.setSubjectScore3(EXPECTED_SUBJECT_SCORE_3);
        statementByEntrant.setDate(EXPECTED_DATE);
        statementByEntrant.setUserId(EXPECTED_USER_ID);
        statementByEntrant.setId(EXPECTED_ID);
        assertEquals(expectedStatementByEntrant, statementByEntrant);
    }

    @Test
    public void testHashCode() {
        StatementByEntrant statementByEntrant1 = new StatementByEntrant();
        statementByEntrant1.setLastName(LAST_NAME_1);
        StatementByEntrant statementByEntrant2 = new StatementByEntrant();
        statementByEntrant2.setLastName(LAST_NAME_2);
        assertNotEquals(statementByEntrant1.hashCode(), statementByEntrant2.hashCode());
    }
}
