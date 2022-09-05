package com.itmo.lab3.service.impl;

import com.itmo.lab3.dto.CatDto;
import com.itmo.lab3.exception.ServiceException;
import com.itmo.lab3.model.entity.Cat;
import com.itmo.lab3.repository.ICatRepository;
import com.itmo.lab3.service.ICatService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
public class CatServiceImpl implements ICatService {
    private final ICatRepository catRepository;

    public CatServiceImpl(ICatRepository catRepository) {
        this.catRepository = catRepository;
    }

    @Override
    public List<Cat> findAll() {
        return catRepository.findAll();
    }

    @Override
    public Cat findById(Long id) throws ServiceException {
        Optional<Cat> optionalCat = catRepository.findById(id);
        if(optionalCat.isPresent()){
            return optionalCat.get();
        } else{
            throw new ServiceException("Cat with id " + id + " doesn't exist");
        }
    }

    @Override
    public Cat save(Cat cat) throws ServiceException {
        if(null != cat) {
            if(cat.getDateOfBorn() == null){
                cat.setDateOfBorn(LocalDateTime.now());
            }
            return catRepository.save(cat);
        } else {
            throw new ServiceException("Cat is empty");
        }
    }

    @Override
    public Long delete(Cat cat) throws ServiceException {
        if(null != cat) {
            catRepository.delete(cat);
            return cat.getId();
        } else {
            throw new ServiceException("Cat is empty");
        }
    }
}
