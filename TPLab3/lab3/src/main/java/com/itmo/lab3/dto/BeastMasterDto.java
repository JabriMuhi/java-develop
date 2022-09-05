package com.itmo.lab3.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
@Component
public class BeastMasterDto {
    private Long id;
    private String name;
    private LocalDateTime dateOfBorn;

//    public DtoBeastMaster convertToDto(BeastMaster beastMaster){
//        DtoBeastMaster dtoBeastMaster = new ModelMapper()
//    }
}
