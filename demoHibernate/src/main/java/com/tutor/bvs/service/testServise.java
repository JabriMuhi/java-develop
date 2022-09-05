package com.tutor.bvs.service;

import com.tutor.bvs.config.HibernateConfig;
import com.tutor.bvs.entity.BeastMaster;
import com.tutor.bvs.entity.Cat;
import org.hibernate.Session;

public class testServise {

    public void test() {
        Session session = HibernateConfig.getInstance().getSession();

        //session.save(Cat.builder().name("Barsik").dateOfBorn(new Date()).breed("Siam").color(Color.BLACK).build());
//        session.save(BeastMaster.builder()
//                .name("Eva")
//                .dateOfBorn(LocalDateTime.now()).build());
//                .beastMasterCats(List
//                        .of(/*(Cat.builder()
//                                .id(3L)
//                                .name("Barsik")
//                                .dateOfBorn(LocalDateTime.parse("2022-05-03T15:54:48.339000"))
//                                .breed("Siam")
//                                .color(Color.BLACK)
//                                        .build(),*/
//                            Cat.builder()
//                                .name("Huba")
//                                .breed("NotSiam")
//                                .color(Color.WHITE)
//                                .dateOfBorn(LocalDateTime.now())
//                                        .build()
//                )));
//        session.createQuery("select c from Cat c", Cat.class)
//                .list()
//                .forEach(System.out::println);
        Cat cat = session.createQuery("select s from Cat s where id = 3", Cat.class).uniqueResult();
        BeastMaster beastMaster = session.createQuery("select b from BeastMaster b where id = 1", BeastMaster.class).uniqueResult();
//        session.save(Cat.builder()
//                                .name("NotHuba")
//                                .breed("NotSiam")
//                                .color(Color.WHITE)
//                                .dateOfBorn(LocalDateTime.now())
//                        .beastMaster(beastMaster)
//                    .build());

//        session.createQuery("select c from Cat c where beastMaster = beastMaster", Cat.class)
//                        .list()
//                                .forEach(System.out::println);

//        System.out.println(session.createQuery("select b from BeastMaster b where id = 1", BeastMaster.class).uniqueResult()
//                .toString());

//        session.save(BeastMaster.builder()
//                .name("Ivan")
//                .dateOfBorn(LocalDateTime.now())
//                .build());
        Cat newCat = session.get(Cat.class, 11L);
        BeastMaster newBeastMaster = session.createQuery("select c from BeastMaster c where name = 'Ivan'", BeastMaster.class).uniqueResult();
        newCat.setBeastMaster(newBeastMaster);
        session.getTransaction().begin();
        session.update(newCat);
        session.getTransaction().commit();
        System.out.println("hello");
    }

}
