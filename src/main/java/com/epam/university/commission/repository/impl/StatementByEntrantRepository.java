package com.epam.university.commission.repository.impl;

import com.epam.university.commission.domain.StatementByEntrant;
import com.epam.university.commission.mappers.IStatementByEntrantMapper;
import com.epam.university.commission.repository.api.IStatementByEntrantRepository;
import com.epam.university.commission.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * Repository to operate with {@link StatementByEntrant}.
 * <p/>
 * University-commission 2021  epam.com
 * <p/>
 * Date: 05/19/2021
 *
 * @author Siarhei Prudnikau1
 */
public class StatementByEntrantRepository implements IStatementByEntrantRepository {
    /**
     * Creates a given {@link StatementByEntrant}.
     *
     * @param statement which is created.
     * @return id is the identifier of the {@link StatementByEntrant}.
     */
    @Override
    public Long create(StatementByEntrant statement) {
        try (SqlSession sqlSession = MyBatisUtil.openSession()) {
            IStatementByEntrantMapper iStatementByEntrantMapper = sqlSession.getMapper(IStatementByEntrantMapper.class);
            iStatementByEntrantMapper.insert(statement);
            sqlSession.commit();
            return statement.getId();
        }
    }

    /**
     * Finds and returns an {@link StatementByEntrant} with the given identifier.
     *
     * @param statementId is the identifier of the {@link StatementByEntrant}.
     * @return StatementByEntrant - entity.
     */
    @Override
    public StatementByEntrant read(Long statementId) {
        try (SqlSession sqlSession = MyBatisUtil.openSession()) {
            IStatementByEntrantMapper iStatementByEntrantMapper = sqlSession.getMapper(IStatementByEntrantMapper.class);
            return iStatementByEntrantMapper.findById(statementId);
        }
    }

    /**
     * Updates a given {@link StatementByEntrant}.
     *
     * @param statement which is updated.
     */
    @Override
    public void update(StatementByEntrant statement) {
        try (SqlSession sqlSession = MyBatisUtil.openSession()) {
            IStatementByEntrantMapper iStatementByEntrantMapper = sqlSession.getMapper(IStatementByEntrantMapper.class);
            iStatementByEntrantMapper.update(statement);
            sqlSession.commit();
        }
    }

    /**
     * Deletes {@link StatementByEntrant} with the given identifier.
     *
     * @param statementId is the identifier of the {@link StatementByEntrant}.
     */
    @Override
    public void delete(Long statementId) {
        try (SqlSession sqlSession = MyBatisUtil.openSession()) {
            IStatementByEntrantMapper iStatementByEntrantMapper = sqlSession.getMapper(IStatementByEntrantMapper.class);
            iStatementByEntrantMapper.delete(statementId);
            sqlSession.commit();
        }
    }
}
