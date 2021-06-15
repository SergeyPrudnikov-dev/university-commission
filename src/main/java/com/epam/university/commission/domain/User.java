package com.epam.university.commission.domain;

import java.util.Objects;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * The data of this class is used to log into the application.
 * <p/>
 * University-commission 2021  epam.com
 * <p/>
 * Date: 04/14/2021
 *
 * @author Siarhei Prudnikau1
 */
public class User extends Entity {
    private static final long serialVersionUID = 5881422459102994885L;

    @NotNull(message = "Role is mandatory.")
    private Role role;

    @NotBlank(message = "Login is mandatory.")
    @Size(max = 50, message = "Login must be no more than 50 characters.")
    private String login;

    @NotBlank(message = "Password is mandatory.")
    @Size(max = 50, message = "Password must be no more than 50 characters.")
    private String password;

    @NotBlank(message = "Email is mandatory.")
    @Email(message = "Email should be valid")
    private String email;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User [id =" + this.getId() + ", login=" + login + ", password=" + password + ", role=" + role +
                ", email=" + email + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        User user = (User) o;
        return getRole() == user.getRole() && getLogin().equals(user.getLogin())
                && getPassword().equals(user.getPassword()) && getEmail().equals(user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getRole(), getLogin(), getPassword(), getEmail());
    }
}
