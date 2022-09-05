package com.tutor.bvs;

import com.tutor.bvs.config.HibernateConfig;
import com.tutor.bvs.controller.CatController;
import com.tutor.bvs.controller.impl.CatControllerImpl;
import com.tutor.bvs.entity.Cat;
import com.tutor.bvs.entity.Color;
import com.tutor.bvs.service.testServise;

import java.time.LocalDateTime;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        HibernateConfig hibernateConfig = HibernateConfig.getInstance();
        hibernateConfig.openSession();
//
//        new testServise().test();
//
//

        Cat cat1 = hibernateConfig.getSession().get(Cat.class, 2L);
        Cat cat2 = hibernateConfig.getSession().get(Cat.class, 11L);
        CatController controller = new CatControllerImpl();
        controller.update(Cat.builder()
                        .name(cat2.getName())
                        .id(cat2.getId())
                        .color(cat2.getColor())
                        .breed(cat2.getBreed())
                        .beastMaster(cat2.getBeastMaster())
                        .dateOfBorn(cat2.getDateOfBorn())
                        .catList(Collections.singletonList(cat1))
                .build());
        hibernateConfig.closeSession();
    }

}
