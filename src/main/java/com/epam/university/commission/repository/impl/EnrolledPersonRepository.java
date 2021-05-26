package com.epam.university.commission.repository.impl;

import com.epam.university.commission.domain.EnrolledPerson;

import com.epam.university.commission.mappers.IEnrolledPersonMapper;
import com.epam.university.commission.repository.api.IEnrolledPersonRepository;
import com.epam.university.commission.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * Repository to operate with {@link EnrolledPerson}.
 * <p/>
 * University-commission 2021  epam.com
 * <p/>
 * Date: 05/24/2021
 *
 * @author Siarhei Prudnikau1
 */
public class EnrolledPersonRepository implements IEnrolledPersonRepository  {
    /**
     * Creates a given {@link EnrolledPerson}.
     *
     * @param enrolledPerson which is created.
     * @return id is the identifier of the {@link EnrolledPerson}.
     */
    @Override
    public Long create(EnrolledPerson enrolledPerson) {
        try (SqlSession sqlSession = MyBatisUtil.openSession()) {
            IEnrolledPersonMapper iEnrolledPersonMapper = sqlSession.getMapper(IEnrolledPersonMapper.class);
            iEnrolledPersonMapper.insert(enrolledPerson);
            sqlSession.commit();
            return enrolledPerson.getId();
        }
    }

    /**
     * Finds and returns an {@link EnrolledPerson} with the given identifier.
     *
     * @param enrolledPersonId is the identifier of the {@link EnrolledPerson}.
     * @return EnrolledPerson - entity.
     */
    @Override
    public EnrolledPerson read(Long enrolledPersonId) {
        try (SqlSession sqlSession = MyBatisUtil.openSession()) {
            IEnrolledPersonMapper iEnrolledPersonMapper = sqlSession.getMapper(IEnrolledPersonMapper.class);
            return iEnrolledPersonMapper.findById(enrolledPersonId);
        }
    }

    /**
     * Updates a given {@link EnrolledPerson}.
     *
     * @param enrolledPerson which is updated.
     */
    @Override
    public void update(EnrolledPerson enrolledPerson) {
        try (SqlSession sqlSession = MyBatisUtil.openSession()) {
            IEnrolledPersonMapper iEnrolledPersonMapper = sqlSession.getMapper(IEnrolledPersonMapper.class);
            iEnrolledPersonMapper.update(enrolledPerson);
            sqlSession.commit();
        }
    }

    /**
     * Deletes {@link EnrolledPerson} with the given identifier.
     *
     * @param enrolledPersonId is the identifier of the {@link EnrolledPerson}.
     */
    @Override
    public void delete(Long enrolledPersonId) {
        try (SqlSession sqlSession = MyBatisUtil.openSession()) {
            IEnrolledPersonMapper iEnrolledPersonMapper = sqlSession.getMapper(IEnrolledPersonMapper.class);
            iEnrolledPersonMapper.delete(enrolledPersonId);
            sqlSession.commit();
        }
    }
}
