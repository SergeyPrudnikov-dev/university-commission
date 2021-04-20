package com.epam.university.commission.domain;

import java.util.Objects;

/**
 * An EnrolledPerson is a person who has been enrolled in a university.
 * <p/>
 * University-commission 2021  epam.com
 * <p/>
 * Date: 04/14/2021
 *
 * @author Siarhei Prudnikau1
 */
public class EnrolledPerson extends Entity {

    private static final long serialVersionUID = -5474036953900814824L;
    private String fullName;
    private int totalScore;
    private long facultyId;
    private long statementId;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public long getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(long facultyId) {
        this.facultyId = facultyId;
    }

    public long getStatementId() {
        return statementId;
    }

    public void setStatementId(long statementId) {
        this.statementId = statementId;
    }

    @Override
    public String toString() {
        return "EnrolledPerson [fullName=" + fullName + ", totalScore=" + totalScore + ", facultyId=" + facultyId +
                ", statementId=" + statementId + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EnrolledPerson)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        EnrolledPerson that = (EnrolledPerson) o;
        return getTotalScore() == that.getTotalScore() && getFacultyId() == that.getFacultyId()
                && getStatementId() == that.getStatementId() && getFullName().equals(that.getFullName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getFullName(), getTotalScore(), getFacultyId(), getStatementId());
    }
}
