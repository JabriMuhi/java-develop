package com.tutor.bvs.service.impl;

import com.tutor.bvs.dao.CatDao;
import com.tutor.bvs.dao.impl.CatDaoImpl;
import com.tutor.bvs.entity.Cat;
import com.tutor.bvs.exception.DaoException;
import com.tutor.bvs.exception.ServiceException;
import com.tutor.bvs.service.CatService;

public class CatServiceImpl implements CatService {

    private final CatDao catDao = new CatDaoImpl();

    @Override
    public void save(Cat cat) throws ServiceException {
        if (cat == null) {
            throw new ServiceException("Cat is null");
        }
        try {
            catDao.save(cat);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(Cat cat) throws ServiceException {
        if (cat == null) {
            throw new ServiceException("Cat is null");
        }
        try {
            catDao.delete(cat);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void update(Cat cat) throws ServiceException {
        if (cat == null) {
            throw new ServiceException("Cat is null");
        }
        try {
            catDao.update(cat);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
