package com.itmo.lab3.service;

import com.itmo.lab3.dto.CatDto;
import com.itmo.lab3.exception.ServiceException;
import com.itmo.lab3.model.entity.Cat;

import java.util.List;

public interface ICatService {
    List<Cat> findAll();

    Cat findById(Long id) throws ServiceException;

    Cat save(Cat cat) throws ServiceException;

    Long delete(Cat cat) throws ServiceException;

}
