package com.epam.university.commission.service.api;

import com.epam.university.commission.domain.StatementByEntrant;

/**
 * This interface contains the basic methods of the service layer for {@link StatementByEntrant} entities.
 * <p/>
 * University-commission 2021  epam.com
 * <p/>
 * Date: 04/22/2021
 *
 * @author Siarhei Prudnikau1
 */
public interface IStatementByEntrantService {
    /**
     * Finds and returns an object with the given identifier.
     *
     * @param id of the entity.
     * @return StatementByEntrant - entity.
     */
    StatementByEntrant findById(Long id);

    /**
     * Saves an object with the given identifier.
     *
     * @param statementByEntrant of the entity.
     */
    void save(StatementByEntrant statementByEntrant);

    /**
     * Deletes an object with the given identifier.
     *
     * @param id of the entity.
     */
    void delete(Long id);
}
