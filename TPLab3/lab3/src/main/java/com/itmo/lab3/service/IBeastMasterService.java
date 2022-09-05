package com.itmo.lab3.service;

import com.itmo.lab3.exception.ServiceException;
import com.itmo.lab3.model.entity.BeastMaster;

import java.util.List;

public interface IBeastMasterService {
    List<BeastMaster> findAll();

    BeastMaster findById(long id) throws ServiceException;

    BeastMaster save(BeastMaster beastMaster) throws ServiceException;

    Long delete(BeastMaster beastMaster) throws ServiceException;
}
