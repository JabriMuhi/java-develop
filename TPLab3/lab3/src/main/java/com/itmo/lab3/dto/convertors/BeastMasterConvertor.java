package com.itmo.lab3.dto.convertors;

import com.itmo.lab3.dto.BeastMasterDto;
import com.itmo.lab3.model.entity.BeastMaster;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BeastMasterConvertor {
    private final ModelMapper modelMapper;

    public BeastMasterConvertor() {
        this.modelMapper = new ModelMapper();
    }

    public BeastMasterDto convertToDto(BeastMaster beastMaster) {
        return modelMapper.map(beastMaster, BeastMasterDto.class);
    }

    public BeastMaster convertToEntity(BeastMasterDto beastMasterDto){
        return modelMapper.map(beastMasterDto, BeastMaster.class);
    }
}
