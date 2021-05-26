package com.epam.university.commission.repository.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.epam.university.commission.domain.Faculty;
import com.epam.university.commission.domain.Role;
import com.epam.university.commission.domain.StatementByEntrant;
import com.epam.university.commission.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

/**
 * Test to verify the functionality of the {@link StatementByEntrantRepository}.
 * <p/>
 * University-commission 2021  epam.com
 * <p/>
 * Date: 05/20/2021
 *
 * @author Siarhei Prudnikau1
 */
class StatementByEntrantRepositoryIntegrationTest {
    private static final LocalDate STATEMENT_DATE = LocalDate.now();
    private static final int STATEMENT_CERTIFICATE_SCORE = 43;
    private static final int STATEMENT_SUBJECT_SCORE_1 = 20;
    private static final int STATEMENT_SUBJECT_SCORE_2 = 50;
    private static final int STATEMENT_SUBJECT_SCORE_3 = 12;
    private static final String STATEMENT_FIRST_NAME = "test_firstName";
    private static final String STATEMENT_LAST_NAME = "test_lastName";
    private static final String STATEMENT_PASSPORT_ID = "test_passportId";
    private static final String STATEMENT_PATRONYMIC = "test_patronymic";
    private static final int STATEMENT_UPDATED_CERTIFICATE_SCORE = 36;
    private static final int STATEMENT_UPDATED_SUBJECT_SCORE_1 = 55;
    private static final int STATEMENT_UPDATED_SUBJECT_SCORE_2 = 44;
    private static final int STATEMENT_UPDATED_SUBJECT_SCORE_3 = 28;
    private static final String STATEMENT_UPDATED_FIRST_NAME = "test_updated_firstName";
    private static final String STATEMENT_UPDATED_LAST_NAME = "test_updated_lastName";
    private static final String STATEMENT_UPDATED_PATRONYMIC = "test_updated_patronymic";
    private static final String STATEMENT_UPDATED_PASSPORT_ID = "test_updated_passportId";
    private long userId;
    private StatementByEntrant statement;
    private StatementByEntrantRepository statementRepository;
    private static final int FACULTY_RECRUITMENT_PLAN = 30;
    private static final String FACULTY_CERTIFICATE = "test_certificate";
    private static final String FACULTY_NAME = "test_name";
    private static final String FACULTY_SUBJECT_1 = "test_subject1";
    private static final String FACULTY_SUBJECT_2 = "test_subject2";
    private static final String FACULTY_SUBJECT_3 = "test_subject3";
    private Faculty faculty;
    private static FacultyRepository sFacultyRepository = new FacultyRepository();
    private static final String USER_EMAIL = "test_email@gmail.com";
    private static final String USER_LOGIN = "test_login";
    private static final String USER_PASSWORD = "test_password";
    private User user;
    private UserRepository userRepository;

    @BeforeEach
    void setup() {
        user = buildUser();
        userRepository = new UserRepository();
        userRepository.create(user);
        userId = user.getId();
        faculty = buildFaculty(FACULTY_RECRUITMENT_PLAN, FACULTY_CERTIFICATE, FACULTY_NAME, FACULTY_SUBJECT_1,
                FACULTY_SUBJECT_2, FACULTY_SUBJECT_3);
        sFacultyRepository.create(faculty);
        statement = buildStatementByEntrant();
        statementRepository = new StatementByEntrantRepository();
        statementRepository.create(statement);
    }

    @AfterEach
    void teardown() {
        statementRepository.delete(statement.getId());
        userRepository.delete(user.getId());
        sFacultyRepository.delete(faculty.getId());
    }

    @Test
    void testCreateStatementByEntrant() {
        StatementByEntrant expectedStatement = buildStatementByEntrant();
        statementRepository.create(expectedStatement);
        StatementByEntrant actualStatement = statementRepository.read(expectedStatement.getId());
        assertNotNull(actualStatement);
        assertEquals(expectedStatement, actualStatement);
        statementRepository.delete(expectedStatement.getId());
    }

    @Test
    void testReadStatementByEntrantById() {
        StatementByEntrant actualStatement = statementRepository.read(statement.getId());
        assertNotNull(actualStatement);
        assertEquals(faculty, actualStatement.getFaculty());
        assertEquals(STATEMENT_DATE, actualStatement.getDate());
        assertEquals(STATEMENT_LAST_NAME, actualStatement.getLastName());
        assertEquals(STATEMENT_FIRST_NAME, actualStatement.getFirstName());
        assertEquals(STATEMENT_PATRONYMIC, actualStatement.getPatronymic());
        assertEquals(STATEMENT_PASSPORT_ID, actualStatement.getPassportId());
        assertEquals(STATEMENT_CERTIFICATE_SCORE, actualStatement.getCertificateScore());
        assertEquals(STATEMENT_SUBJECT_SCORE_1, actualStatement.getSubjectScore1());
        assertEquals(STATEMENT_SUBJECT_SCORE_2, actualStatement.getSubjectScore2());
        assertEquals(STATEMENT_SUBJECT_SCORE_3, actualStatement.getSubjectScore3());
        assertEquals(userId, actualStatement.getUserId());
    }

    @Test
    void testUpdateStatementByEntrant() {
        Faculty newFaculty = buildFaculty(77, "test_new_certificate", "test_new_name",
                "test_new_subject1", "test_new_subject3", "test_new_subject3");
        sFacultyRepository.create(newFaculty);
        statement.setFaculty(newFaculty);
        statement.setDate(LocalDate.now());
        statement.setCertificateScore(STATEMENT_UPDATED_CERTIFICATE_SCORE);
        statement.setSubjectScore1(STATEMENT_UPDATED_SUBJECT_SCORE_1);
        statement.setSubjectScore2(STATEMENT_UPDATED_SUBJECT_SCORE_2);
        statement.setSubjectScore3(STATEMENT_UPDATED_SUBJECT_SCORE_3);
        statement.setFirstName(STATEMENT_UPDATED_FIRST_NAME);
        statement.setLastName(STATEMENT_UPDATED_LAST_NAME);
        statement.setPassportId(STATEMENT_UPDATED_PASSPORT_ID);
        statement.setPatronymic(STATEMENT_UPDATED_PATRONYMIC);
        statementRepository.update(statement);
        StatementByEntrant actualStatement = statementRepository.read(statement.getId());
        assertEquals(statement, actualStatement);
        sFacultyRepository.delete(faculty.getId());
        faculty = newFaculty;   // to remove this faculty in @AfterEach
    }

    @Test
    void testDeleteStatementByEntrant() {
        statementRepository.delete(statement.getId());
        StatementByEntrant actualStatement = statementRepository.read(statement.getId());
        assertNull(actualStatement);
    }

    private StatementByEntrant buildStatementByEntrant() {
        StatementByEntrant newStatement = new StatementByEntrant();
        newStatement.setDate(STATEMENT_DATE);
        newStatement.setFaculty(faculty);
        newStatement.setCertificateScore(STATEMENT_CERTIFICATE_SCORE);
        newStatement.setSubjectScore1(STATEMENT_SUBJECT_SCORE_1);
        newStatement.setSubjectScore2(STATEMENT_SUBJECT_SCORE_2);
        newStatement.setSubjectScore3(STATEMENT_SUBJECT_SCORE_3);
        newStatement.setFirstName(STATEMENT_FIRST_NAME);
        newStatement.setLastName(STATEMENT_LAST_NAME);
        newStatement.setPassportId(STATEMENT_PASSPORT_ID);
        newStatement.setPatronymic(STATEMENT_PATRONYMIC);
        newStatement.setUserId(userId);
        return newStatement;
    }

    private User buildUser() {
        User newUser = new User();
        newUser.setLogin(USER_LOGIN);
        newUser.setPassword(USER_PASSWORD);
        newUser.setEmail(USER_EMAIL);
        newUser.setRole(Role.ENTRANT);
        return newUser;
    }

    private Faculty buildFaculty(int recruitmentPlan, String certificate, String name, String subject1, String subject2,
                                 String subject3) {
        Faculty newFaculty = new Faculty();
        newFaculty.setRecruitmentPlan(recruitmentPlan);
        newFaculty.setName(name);
        newFaculty.setCertificate(certificate);
        newFaculty.setSubject1(subject1);
        newFaculty.setSubject2(subject2);
        newFaculty.setSubject3(subject3);
        return newFaculty;
    }
}
