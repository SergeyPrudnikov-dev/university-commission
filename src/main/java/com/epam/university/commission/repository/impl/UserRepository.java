package com.epam.university.commission.repository.impl;

import com.epam.university.commission.domain.User;
import com.epam.university.commission.mappers.IUserMapper;
import com.epam.university.commission.repository.api.IUserRepository;
import com.epam.university.commission.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

/**
 * Repository to operate with {@link User}.
 * <p/>
 * University-commission 2021  epam.com
 * <p/>
 * Date: 05/15/2021
 *
 * @author Siarhei Prudnikau1
 */
@Repository
public class UserRepository implements IUserRepository {
    /**
     * Creates a given {@link User}.
     *
     * @param user which is created.
     * @return id is the identifier of the {@link User}.
     */
    @Override
    public Long create(User user) {
        try (SqlSession sqlSession = MyBatisUtil.openSession()) {
            IUserMapper iUserMapper = sqlSession.getMapper(IUserMapper.class);
            iUserMapper.insert(user);
            sqlSession.commit();
            return user.getId();
        }
    }

    /**
     * Finds and returns an {@link User} with the given identifier.
     *
     * @param userId is the identifier of the {@link User}.
     * @return User - entity.
     */
    @Override
    public User read(Long userId) {
        try (SqlSession sqlSession = MyBatisUtil.openSession()) {
            IUserMapper iUserMapper = sqlSession.getMapper(IUserMapper.class);
            return iUserMapper.findById(userId);
        }
    }

    /**
     * Updates a given {@link User}.
     *
     * @param user which is updated.
     */
    @Override
    public void update(User user) {
        try (SqlSession sqlSession = MyBatisUtil.openSession()) {
            IUserMapper iUserMapper = sqlSession.getMapper(IUserMapper.class);
            iUserMapper.update(user);
            sqlSession.commit();
        }
    }

    /**
     * Deletes {@link User} with the given identifier.
     *
     * @param userId is the identifier of the {@link User}.
     */
    @Override
    public void delete(Long userId) {
        try (SqlSession sqlSession = MyBatisUtil.openSession()) {
            IUserMapper iUserMapper = sqlSession.getMapper(IUserMapper.class);
            iUserMapper.delete(userId);
            sqlSession.commit();
        }
    }
}
