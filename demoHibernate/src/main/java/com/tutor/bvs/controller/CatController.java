package com.tutor.bvs.controller;

import com.tutor.bvs.entity.Cat;

public interface CatController {
    void save(Cat cat);
    void delete(Cat cat);
    void update(Cat cat);
}
