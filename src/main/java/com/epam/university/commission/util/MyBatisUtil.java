package com.epam.university.commission.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * This is the class for getting the SqlSessionFactory instance.
 * <p/>
 * University-commission 2021  epam.com
 * <p/>
 * Date: 05/15/2021
 *
 * @author Siarhei Prudnikau1
 */
public final class MyBatisUtil {
    private MyBatisUtil() {
    }

    private static SqlSessionFactory sQLSessionFactory;

    /**
     * Returns a SqlSessionFactory instance that is used to receive a session.
     *
     * @return SqlSessionFactory.
     */
    public static SqlSessionFactory getsQLSessionFactory() {
        if (sQLSessionFactory == null) {
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream("db/mybatis/mybatis-config.xml");
                sQLSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        return sQLSessionFactory;
    }

    /**
     * Gets a SqlSession instance that is used to connect to the database.
     *
     * @return SqlSession.
     */
    public static SqlSession openSession() {
        return getsQLSessionFactory().openSession();
    }
}

