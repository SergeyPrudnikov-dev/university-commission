package com.epam.university.commission.service.impl;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.epam.university.commission.domain.StatementByEntrant;
import com.epam.university.commission.repository.api.IStatementByEntrantRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test to verify the functionality of the {@link StatementByEntrantService}.
 * <p/>
 * University-commission 2021  epam.com
 * <p/>
 * Date: 04/26/2021
 *
 * @author Siarhei Prudnikau1
 */
class StatementByEntrantServiceImplTest {
    private static final long STATEMENT_BY_ENTRANT_ID = 123;
    private StatementByEntrant testStatementByEntrant;
    private IStatementByEntrantRepository repository;
    private StatementByEntrantService statementByEntrantService;

    @BeforeEach
    void setUp() {
        testStatementByEntrant = new StatementByEntrant();
        testStatementByEntrant.setId(STATEMENT_BY_ENTRANT_ID);
        repository = createMock(IStatementByEntrantRepository.class);
        statementByEntrantService = new StatementByEntrantService();
        statementByEntrantService.setStatementByEntrantRepository(repository);
    }

    @Test
    void findById() {
        expect(repository.read(STATEMENT_BY_ENTRANT_ID)).andReturn(testStatementByEntrant);
        replay(repository);

        assertEquals(testStatementByEntrant, statementByEntrantService.findById(STATEMENT_BY_ENTRANT_ID));
        verify(repository);
    }
}
