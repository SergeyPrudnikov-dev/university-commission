package com.epam.university.commission.service.impl;

import com.epam.university.commission.domain.StatementByEntrant;
import com.epam.university.commission.repository.api.IStatementByEntrantRepository;
import com.epam.university.commission.service.api.IStatementByEntrantService;

/**
 * This is a method for finding an entity {@link StatementByEntrant} in a database by id.
 * <p/>
 * University-commission 2021  epam.com
 * <p/>
 * Date: 04/22/2021
 *
 * @author Siarhei Prudnikau1
 */
public class StatementByEntrantServiceImpl implements IStatementByEntrantService {
    private IStatementByEntrantRepository statementByEntrantRepository;

    @Override
    public StatementByEntrant findById(Long id) {
        return statementByEntrantRepository.read(id);
    }
}
