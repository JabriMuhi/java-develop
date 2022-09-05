package com.tutor.bvs.dao.impl;

import com.tutor.bvs.config.HibernateConfig;
import com.tutor.bvs.dao.CatDao;
import com.tutor.bvs.entity.Cat;
import com.tutor.bvs.exception.DaoException;

public class CatDaoImpl implements CatDao {

    private static final HibernateConfig hibernate = HibernateConfig.getInstance();

    @Override
    public void save(Cat cat) throws DaoException {
        try {
            hibernate.getSession().save(cat);
        } catch (Exception e) {
            throw new DaoException("Dsdjfhsjkd", e);
        }


    }

    @Override
    public void delete(Cat cat) throws DaoException {
        try {
            hibernate.beginTransaction();
            hibernate.getSession().delete(cat);
            hibernate.commitTransaction();
        } catch (Exception e) {
            throw new DaoException("Any problems with connection", e);
        }
    }

    @Override
    public void update(Cat cat) throws DaoException {
        try {
            hibernate.beginTransaction();
            hibernate.getSession().update(cat);
            hibernate.commitTransaction();
        } catch (Exception e) {
            throw new DaoException("Any problems with connection", e);
        }
    }
}
