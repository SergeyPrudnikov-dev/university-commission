package com.epam.university.commission.domain;

/**
 * "Role" is used to log into the application with specific rights.
 * <p/>
 * University-commission 2021  epam.com
 * <p/>
 * Date: 04/14/2021
 *
 * @author Siarhei Prudnikau1
 */
public enum Role {
    /**
     * The administrator role corresponds to the maximum user rights (worker of university commission).
     */
    ADMIN("role.admin"),
    /**
     * The ENTRANT corresponds to the user rights required to submit the application.
     */
    ENTRANT("role.entrant"),
    /**
     * this role for example (not implemented at this stage)
     */
    STUDENT("role.student"),
    /**
     * this role for example (not implemented at this stage)
     */
    CURATOR("role.curator");

    private String name;

    private Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return Long.valueOf(ordinal());
    }
}
