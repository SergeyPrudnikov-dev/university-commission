package com.epam.university.commission.mappers;

import com.epam.university.commission.domain.StatementByEntrant;

/**
 * It is mapper interface to deal with {@link StatementByEntrant}.
 * <p/>
 * University-commission 2021  epam.com
 * <p/>
 * Date: 05/19/2021
 *
 * @author Siarhei Prudnikau1
 */
public interface IStatementByEntrantMapper {
    /**
     * Inserts {@link StatementByEntrant} to the database.
     *
     * @param statement which is inserted into the database.
     * @return id is the identifier of the {@link StatementByEntrant}.
     */
    Long insert(StatementByEntrant statement);

    /**
     * Finds and returns an {@link StatementByEntrant} with the given identifier.
     *
     * @param id is the identifier of the {@link StatementByEntrant}.
     * @return StatementByEntrant.
     */
    StatementByEntrant findById(Long id);

    /**
     * Updates a given {@link StatementByEntrant}.
     *
     * @param statement which is updated.
     */
    void update(StatementByEntrant statement);

    /**
     * Deletes {@link StatementByEntrant} with the given identifier.
     *
     * @param statementId is the identifier of the {@link StatementByEntrant}.
     */
    void delete(Long statementId);
}
