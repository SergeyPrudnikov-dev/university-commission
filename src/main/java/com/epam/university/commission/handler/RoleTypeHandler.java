package com.epam.university.commission.handler;

import com.epam.university.commission.domain.Role;
import org.apache.ibatis.type.EnumOrdinalTypeHandler;

/**
 * TypeHandler for Role enumeration {@link Role}.
 * <p/>
 * University-commission 2021  epam.com
 * <p/>
 * Date: 05/17/2021
 *
 * @author Siarhei Prudnikau1
 */
public class RoleTypeHandler extends EnumOrdinalTypeHandler<Role> {

    /**
     * @param type Role enumeration.
     */
    public RoleTypeHandler(Class<Role> type) {
        super(type);
    }

}
