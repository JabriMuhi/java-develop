package com.tutor.bvs.controller.impl;

import com.tutor.bvs.controller.CatController;
import com.tutor.bvs.entity.Cat;
import com.tutor.bvs.exception.ServiceException;
import com.tutor.bvs.service.CatService;
import com.tutor.bvs.service.impl.CatServiceImpl;

public class CatControllerImpl implements CatController {

    private final CatService catService = new CatServiceImpl();
    @Override
    public void save(Cat cat) {
        try {
            catService.save(cat);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Cat cat) {
        try {
            catService.delete(cat);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Cat cat) {
        try {
            catService.update(cat);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
