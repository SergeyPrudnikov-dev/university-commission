package com.epam.university.commission.domain;

import java.util.Date;
import java.util.Objects;

/**
 * "StatementByEntrant" is an application (questionnaire) of an entrant for applying to
 * a university for a specific faculty.
 * <p/>
 * University-commission 2021  epam.com
 * <p/>
 * Date: 04/14/2021
 *
 * @author Siarhei Prudnikau1
 */
public class StatementByEntrant extends Entity {

    private static final long serialVersionUID = -6271859875463148364L;
    private Faculty faculty;
    private Date date;
    private String lastName;
    private String firstName;
    private String patronymic;
    private String passportId;
    private int certificateScore;
    private int subjectScore1;
    private int subjectScore2;
    private int subjectScore3;
    private long userId;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public int getCertificateScore() {
        return certificateScore;
    }

    public void setCertificateScore(int certificateScore) {
        this.certificateScore = certificateScore;
    }

    public int getSubjectScore1() {
        return subjectScore1;
    }

    public void setSubjectScore1(int subjectScore1) {
        this.subjectScore1 = subjectScore1;
    }

    public int getSubjectScore2() {
        return subjectScore2;
    }

    public void setSubjectScore2(int subjectScore2) {
        this.subjectScore2 = subjectScore2;
    }

    public int getSubjectScore3() {
        return subjectScore3;
    }

    public void setSubjectScore3(int subjectScore3) {
        this.subjectScore3 = subjectScore3;
    }

    public Date getDate() {
        return date != null ? new Date(date.getTime()) : null;
    }

    public void setDate(Date date) {
        this.date = date != null ? new Date(date.getTime()) : null;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "StatementByEntrant [lastName=" + lastName + ", firstName=" + firstName + ", patronymic=" +
                patronymic + ", passportId=" + passportId + ", faculty=" + faculty + ", certificateScore=" +
                certificateScore + ", subjectScore1=" + subjectScore1 + ", subjectScore2=" + subjectScore2 +
                ", subjectScore3=" + subjectScore3 + ", date=" + date + ", userId=" + userId + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StatementByEntrant)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        StatementByEntrant that = (StatementByEntrant) o;
        return getCertificateScore() == that.getCertificateScore() && getSubjectScore1() == that.getSubjectScore1()
                && getSubjectScore2() == that.getSubjectScore2() && getSubjectScore3() == that.getSubjectScore3()
                && getUserId() == that.getUserId() && getFaculty().equals(that.getFaculty())
                && getDate().equals(that.getDate()) && getLastName().equals(that.getLastName())
                && getFirstName().equals(that.getFirstName()) && getPatronymic().equals(that.getPatronymic())
                && getPassportId().equals(that.getPassportId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getFaculty(), getDate(), getLastName(), getFirstName(), getPatronymic()
                , getPassportId(), getCertificateScore(), getSubjectScore1(), getSubjectScore2(), getSubjectScore3(),
                getUserId());
    }
}
