package com.itmo.lab3.repository;

import com.itmo.lab3.model.entity.BeastMaster;
import com.itmo.lab3.model.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICatRepository extends JpaRepository<Cat, Long> {
}
