package com.tutor.bvs.service;

import com.tutor.bvs.entity.Cat;
import com.tutor.bvs.exception.ServiceException;

public interface CatService {
    void save(Cat cat) throws ServiceException;
    void delete(Cat cat) throws ServiceException;
    void update(Cat cat) throws ServiceException;
}
