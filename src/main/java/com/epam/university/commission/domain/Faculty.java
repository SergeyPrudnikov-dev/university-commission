package com.epam.university.commission.domain;

import java.util.Objects;

/**
 * This class describes the faculties at the university.
 * <p/>
 * University-commission 2021  epam.com
 * <p/>
 * Date: 04/14/2021
 *
 * @author Siarhei Prudnikau1
 */
public class Faculty extends Entity {

    private static final long serialVersionUID = -5654502854474146353L;
    private String name;
    private int recruitmentPlan;
    private String certificate;
    private String subject1;
    private String subject2;
    private String subject3;

    /**
     * Constructor without parameters.
     */
    public Faculty() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRecruitmentPlan() {
        return recruitmentPlan;
    }

    public void setRecruitmentPlan(int recruitmentPlan) {
        this.recruitmentPlan = recruitmentPlan;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getSubject1() {
        return subject1;
    }

    public void setSubject1(String subject1) {
        this.subject1 = subject1;
    }

    public String getSubject2() {
        return subject2;
    }

    public void setSubject2(String subject2) {
        this.subject2 = subject2;
    }

    public String getSubject3() {
        return subject3;
    }

    public void setSubject3(String subject3) {
        this.subject3 = subject3;
    }

    @Override
    public String toString() {
        return "Faculty [name=" + name + ", recruitment_plan=" + recruitmentPlan + ", certificate=" + certificate +
                ", subject_1=" + subject1 + ", subject_2=" + subject2 + ", subject_3=" + subject3 + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Faculty)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Faculty faculty = (Faculty) o;
        return getRecruitmentPlan() == faculty.getRecruitmentPlan() && getName().equals(faculty.getName())
                && getCertificate().equals(faculty.getCertificate()) && getSubject1().equals(faculty.getSubject1())
                && getSubject2().equals(faculty.getSubject2()) && getSubject3().equals(faculty.getSubject3());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getName(), getRecruitmentPlan(), getCertificate(), getSubject1(),
                getSubject2(), getSubject3());
    }
}
