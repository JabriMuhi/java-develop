package com.itmo.lab3.service.impl;

import com.itmo.lab3.exception.ServiceException;
import com.itmo.lab3.model.entity.BeastMaster;
import com.itmo.lab3.model.entity.Cat;
import com.itmo.lab3.repository.IBeastMasterRepository;
import com.itmo.lab3.service.IBeastMasterService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BeastMasterServiceImpl implements IBeastMasterService {
    private final IBeastMasterRepository beastMasterRepository;

    public BeastMasterServiceImpl(IBeastMasterRepository beastMasterRepository) {
        this.beastMasterRepository = beastMasterRepository;
    }

    @Override
    public List<BeastMaster> findAll() {
        return beastMasterRepository.findAll();
    }

    @Override
    public BeastMaster findById(long id) throws ServiceException {

        Optional<BeastMaster> optionalBeastMaster = beastMasterRepository.findById(id);
        if(optionalBeastMaster.isPresent()){
            return optionalBeastMaster.get();
        } else{
            throw new ServiceException("Cat with id " + id + " doesn't exist");
        }
    }

    @Override
    public BeastMaster save(BeastMaster beastMaster) throws ServiceException {
        if(null != beastMaster) {
            if(beastMaster.getDateOfBorn() == null){
                beastMaster.setDateOfBorn(LocalDateTime.now());
            }
            return beastMasterRepository.save(beastMaster);
        } else {
            throw new ServiceException("Beast master is empty");
        }
    }

    @Override
    public Long delete(BeastMaster beastMaster) throws ServiceException {
        if(null != beastMaster) {
            beastMasterRepository.delete(beastMaster);
            return beastMaster.getId();
        } else {
            throw new ServiceException("Beast master is empty");
        }
    }
}
