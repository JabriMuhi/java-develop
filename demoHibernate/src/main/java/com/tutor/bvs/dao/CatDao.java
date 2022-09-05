package com.tutor.bvs.dao;

import com.tutor.bvs.entity.Cat;
import com.tutor.bvs.exception.DaoException;

public interface CatDao {
    void save(Cat cat) throws DaoException;
    void delete(Cat cat) throws DaoException;
    void update(Cat cat) throws  DaoException;
}
