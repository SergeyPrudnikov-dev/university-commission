package com.epam.university.commission.service.impl;

import com.epam.university.commission.domain.StatementByEntrant;
import com.epam.university.commission.repository.api.IStatementByEntrantRepository;
import com.epam.university.commission.service.api.IStatementByEntrantService;

/**
 * This service contains the basic methods of the service layer for {@link StatementByEntrant} entities.
 * <p/>
 * University-commission 2021  epam.com
 * <p/>
 * Date: 04/22/2021
 *
 * @author Siarhei Prudnikau1
 */
public class StatementByEntrantService implements IStatementByEntrantService {
    private IStatementByEntrantRepository statementByEntrantRepository;

    public IStatementByEntrantRepository getStatementByEntrantRepository() {
        return statementByEntrantRepository;
    }

    public void setStatementByEntrantRepository(IStatementByEntrantRepository statementByEntrantRepository) {
        this.statementByEntrantRepository = statementByEntrantRepository;
    }

    /**
     * Finds and returns an {@link StatementByEntrant} with the given identifier.
     *
     * @param id is the identifier of the {@link StatementByEntrant}.
     * @return StatementByEntrant - entity.
     */
    @Override
    public StatementByEntrant findById(Long id) {
        return statementByEntrantRepository.read(id);
    }

    /**
     * Saves a given {@link StatementByEntrant}.
     *
     * @param statementByEntrant which is saved.
     */
    @Override
    public void save(StatementByEntrant statementByEntrant) {
        if (statementByEntrant.getId() != null) {
            StatementByEntrant storedStatementByEntrant = statementByEntrantRepository.read(statementByEntrant.getId());
            if (storedStatementByEntrant != null) {
                statementByEntrantRepository.update(statementByEntrant);
            }
        } else {
            statementByEntrantRepository.create(statementByEntrant);
        }
    }

    /**
     * Deletes an {@link StatementByEntrant} with the given identifier.
     *
     * @param id is the identifier of the {@link StatementByEntrant}.
     */
    @Override
    public void delete(Long id) {
        statementByEntrantRepository.delete(id);
    }
}
