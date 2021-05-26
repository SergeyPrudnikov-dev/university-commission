package com.epam.university.commission.repository.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.epam.university.commission.domain.EnrolledPerson;
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
 * Date: 05/24/2021
 *
 * @author Siarhei Prudnikau1
 */
class EnrolledPersonRepositoryIntegrationTest {
    private static final int ENROLLED_PERSON_TOTAL_SCORE = 200;
    private static final int ENROLLED_PERSON_UPDATE_TOTAL_SCORE = 367;
    private static final String ENROLLED_PERSON_FULL_NAME = "test_full_name";
    private static final String ENROLLED_PERSON_UPDATE_FULL_NAME = "test_update_full_name";
    private EnrolledPersonRepository enrolledPersonRepository;
    private EnrolledPerson enrolledPerson;
    private static final LocalDate STATEMENT_DATE = LocalDate.now();
    private static final int STATEMENT_CERTIFICATE_SCORE = 43;
    private static final int STATEMENT_SUBJECT_SCORE_1 = 20;
    private static final int STATEMENT_SUBJECT_SCORE_2 = 50;
    private static final int STATEMENT_SUBJECT_SCORE_3 = 12;
    private static final String STATEMENT_FIRST_NAME = "test_firstName";
    private static final String STATEMENT_LAST_NAME = "test_lastName";
    private static final String STATEMENT_PASSPORT_ID = "test_passportId";
    private static final String STATEMENT_PATRONYMIC = "test_patronymic";
    private static StatementByEntrantRepository sStatementRepository = new StatementByEntrantRepository();
    private StatementByEntrant statement;
    private static final int FACULTY_RECRUITMENT_PLAN = 30;
    private static final String FACULTY_CERTIFICATE = "test_certificate";
    private static final String FACULTY_NAME = "test_name";
    private static final String FACULTY_SUBJECT_1 = "test_subject1";
    private static final String FACULTY_SUBJECT_2 = "test_subject2";
    private static final String FACULTY_SUBJECT_3 = "test_subject3";
    private static FacultyRepository sFacultyRepository = new FacultyRepository();
    private Faculty faculty;
    private static final String USER_LOGIN = "test_login";
    private static final String USER_EMAIL = "test_email@gmail.com";
    private static final String USER_PASSWORD = "test_password";
    private static UserRepository sUserRepository = new UserRepository();
    private User user;

    @BeforeEach
    void setup() {
        user = buildUser();
        sUserRepository.create(user);
        faculty = buildFaculty(FACULTY_RECRUITMENT_PLAN, FACULTY_CERTIFICATE, FACULTY_NAME, FACULTY_SUBJECT_1,
                FACULTY_SUBJECT_2, FACULTY_SUBJECT_3);
        sFacultyRepository.create(faculty);
        statement = buildStatementByEntrant(STATEMENT_DATE, faculty, STATEMENT_CERTIFICATE_SCORE,
                STATEMENT_SUBJECT_SCORE_1, STATEMENT_SUBJECT_SCORE_2, STATEMENT_SUBJECT_SCORE_3, STATEMENT_FIRST_NAME,
                STATEMENT_LAST_NAME, STATEMENT_PASSPORT_ID, STATEMENT_PATRONYMIC, user.getId());
        sStatementRepository.create(statement);
        enrolledPerson = buildEnrolledPerson();
        enrolledPersonRepository = new EnrolledPersonRepository();
        enrolledPersonRepository.create(enrolledPerson);
    }

    @AfterEach
    void teardown() {
        enrolledPersonRepository.delete(enrolledPerson.getId());
        sStatementRepository.delete(statement.getId());
        sFacultyRepository.delete(faculty.getId());
        sUserRepository.delete(user.getId());
    }

    @Test
    void testCreateEnrolledPerson() {
        EnrolledPerson expectedEnrolledPerson = buildEnrolledPerson();
        enrolledPersonRepository.create(expectedEnrolledPerson);
        EnrolledPerson actualEnrolledPerson = enrolledPersonRepository.read(expectedEnrolledPerson.getId());
        assertNotNull(actualEnrolledPerson);
        assertEquals(expectedEnrolledPerson, actualEnrolledPerson);
        enrolledPersonRepository.delete(expectedEnrolledPerson.getId());
    }

    @Test
    void testReadEnrolledPerson() {
        EnrolledPerson actualEnrolledPerson = enrolledPersonRepository.read(enrolledPerson.getId());
        assertNotNull(actualEnrolledPerson);
        assertEquals(ENROLLED_PERSON_FULL_NAME, actualEnrolledPerson.getFullName());
        assertEquals(ENROLLED_PERSON_TOTAL_SCORE, actualEnrolledPerson.getTotalScore());
        assertEquals(faculty.getId(), actualEnrolledPerson.getFacultyId());
        assertEquals(statement.getId(), actualEnrolledPerson.getStatementId());
    }

    @Test
    void testUpdateEnrolledPerson() {
        Faculty newFaculty = buildFaculty(77, "test_new_certificate", "test_new_name",
                "test_new_subject1", "test_new_subject3", "test_new_subject3");
        sFacultyRepository.create(newFaculty);
        StatementByEntrant newStatement = buildStatementByEntrant(LocalDate.now(), newFaculty, 34,
                42, 99, 100, "test_update_firstName",
                "test_update_lastName", "test_update_passportId", "test_update_patronymic",
                statement.getUserId());
        sStatementRepository.create(newStatement);
        enrolledPerson.setFullName(ENROLLED_PERSON_UPDATE_FULL_NAME);
        enrolledPerson.setTotalScore(ENROLLED_PERSON_UPDATE_TOTAL_SCORE);
        enrolledPerson.setFacultyId(newFaculty.getId());
        enrolledPerson.setStatementId(newStatement.getId());
        enrolledPersonRepository.update(enrolledPerson);
        EnrolledPerson actualEnrolledPerson = enrolledPersonRepository.read(enrolledPerson.getId());
        assertEquals(enrolledPerson, actualEnrolledPerson);
        sStatementRepository.delete(statement.getId());
        statement = newStatement;   // to remove this statement in @AfterEach
        sFacultyRepository.delete(faculty.getId());
        faculty = newFaculty;   // to remove this faculty in @AfterEach
    }

    @Test
    void testDeleteEnrolledPerson() {
        enrolledPersonRepository.delete(enrolledPerson.getId());
        EnrolledPerson actualEnrolledPerson = enrolledPersonRepository.read(enrolledPerson.getId());
        assertNull(actualEnrolledPerson);
    }

    private EnrolledPerson buildEnrolledPerson() {
        EnrolledPerson newEnrolledPerson = new EnrolledPerson();
        newEnrolledPerson.setFullName(ENROLLED_PERSON_FULL_NAME);
        newEnrolledPerson.setTotalScore(ENROLLED_PERSON_TOTAL_SCORE);
        newEnrolledPerson.setFacultyId(faculty.getId());
        newEnrolledPerson.setStatementId(statement.getId());
        return newEnrolledPerson;
    }

    private StatementByEntrant buildStatementByEntrant(
            LocalDate statementDate, Faculty statementFaculty, int certificateScore, int subjectScore1,
            int subjectScore2, int subjectScore3, String firstName, String lastName, String passportId,
            String patronymic, long statementUserId) {
        StatementByEntrant newStatement = new StatementByEntrant();
        newStatement.setDate(statementDate);
        newStatement.setFaculty(statementFaculty);
        newStatement.setCertificateScore(certificateScore);
        newStatement.setSubjectScore1(subjectScore1);
        newStatement.setSubjectScore2(subjectScore2);
        newStatement.setSubjectScore3(subjectScore3);
        newStatement.setFirstName(firstName);
        newStatement.setLastName(lastName);
        newStatement.setPassportId(passportId);
        newStatement.setPatronymic(patronymic);
        newStatement.setUserId(statementUserId);
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
