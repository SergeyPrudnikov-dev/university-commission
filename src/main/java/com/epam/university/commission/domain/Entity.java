package com.epam.university.commission.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * Base class for entity classes.
 * <p/>
 * University-commission 2021  epam.com
 * <p/>
 * Date: 04/14/2021
 *
 * @author Siarhei Prudnikau1
 */
public abstract class Entity implements Serializable {

    private static final long serialVersionUID = -754545940130075070L;
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Entity)) {
            return false;
        }
        Entity entity = (Entity) o;
        return getId().equals(entity.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
