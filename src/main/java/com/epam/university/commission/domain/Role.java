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
    ADMIN("role.admin"),
    ENTRANT("role.entrant"),
    STUDENT("role.student"), // this role for example (not implemented at this stage)
    CURATOR("role.curator"); // this role for example (not implemented at this stage)
    
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
