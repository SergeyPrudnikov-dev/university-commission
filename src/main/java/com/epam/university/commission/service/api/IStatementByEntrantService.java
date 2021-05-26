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
     * Finds and returns an {@link StatementByEntrant} with the given identifier.
     *
     * @param id is the identifier of the {@link StatementByEntrant}.
     * @return StatementByEntrant - entity.
     */
    StatementByEntrant findById(Long id);

    /**
     * Saves a given {@link StatementByEntrant}.
     *
     * @param statementByEntrant which is saved.
     */
    void save(StatementByEntrant statementByEntrant);

    /**
     * Deletes an {@link StatementByEntrant} with the given identifier.
     *
     * @param id is the identifier of the {@link StatementByEntrant}.
     */
    void delete(Long id);
}
