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
public class StatementByEntrantService implements IStatementByEntrantService {
    private IStatementByEntrantRepository statementByEntrantRepository;

    public IStatementByEntrantRepository getStatementByEntrantRepository() {
        return statementByEntrantRepository;
    }

    public void setStatementByEntrantRepository(IStatementByEntrantRepository statementByEntrantRepository) {
        this.statementByEntrantRepository = statementByEntrantRepository;
    }

    @Override
    public StatementByEntrant findById(Long id) {
        return statementByEntrantRepository.read(id);
    }

    /**
     * Saves an object with the given identifier.
     *
     * @param statementByEntrant of the entity.
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
     * Deletes an object with the given identifier.
     *
     * @param id of the entity.
     */
    @Override
    public void delete(Long id) {
        statementByEntrantRepository.delete(id);
    }
}
