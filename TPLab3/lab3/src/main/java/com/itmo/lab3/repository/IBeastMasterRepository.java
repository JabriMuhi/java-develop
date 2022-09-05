package com.itmo.lab3.repository;

import com.itmo.lab3.model.entity.BeastMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBeastMasterRepository extends JpaRepository <BeastMaster, Long> {
}
