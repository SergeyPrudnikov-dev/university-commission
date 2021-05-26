package com.epam.university.commission.repository.impl;

import com.epam.university.commission.domain.Faculty;
import com.epam.university.commission.mappers.IFacultyMapper;
import com.epam.university.commission.repository.api.IFacultyRepository;
import com.epam.university.commission.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * Repository to operate with {@link Faculty}.
 * <p/>
 * University-commission 2021  epam.com
 * <p/>
 * Date: 05/18/2021
 *
 * @author Siarhei Prudnikau1
 */
public class FacultyRepository implements IFacultyRepository {
    /**
     * Creates a given {@link Faculty}.
     *
     * @param faculty which is created.
     * @return id is the identifier of the {@link Faculty}.
     */
    @Override
    public Long create(Faculty faculty) {
        try (SqlSession sqlSession = MyBatisUtil.openSession()) {
            IFacultyMapper iFacultyMapper = sqlSession.getMapper(IFacultyMapper.class);
            iFacultyMapper.insert(faculty);
            sqlSession.commit();
            return faculty.getId();
        }
    }

    /**
     * Finds and returns an {@link Faculty} with the given identifier.
     *
     * @param facultyId is the identifier of the {@link Faculty}.
     * @return Faculty - entity.
     */
    @Override
    public Faculty read(Long facultyId) {
        try (SqlSession sqlSession = MyBatisUtil.openSession()) {
            IFacultyMapper iFacultyMapper = sqlSession.getMapper(IFacultyMapper.class);
            return iFacultyMapper.findById(facultyId);
        }
    }

    /**
     * Updates a given {@link Faculty}.
     *
     * @param faculty which is updated.
     */
    @Override
    public void update(Faculty faculty) {
        try (SqlSession sqlSession = MyBatisUtil.openSession()) {
            IFacultyMapper iFacultyMapper = sqlSession.getMapper(IFacultyMapper.class);
            iFacultyMapper.update(faculty);
            sqlSession.commit();
        }
    }

    /**
     * Deletes {@link Faculty} with the given identifier.
     *
     * @param facultyId is the identifier of the {@link Faculty}.
     */
    @Override
    public void delete(Long facultyId) {
        try (SqlSession sqlSession = MyBatisUtil.openSession()) {
            IFacultyMapper iFacultyMapper = sqlSession.getMapper(IFacultyMapper.class);
            iFacultyMapper.delete(facultyId);
            sqlSession.commit();
        }
    }
}
