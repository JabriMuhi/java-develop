package com.itmo.lab3.dto.convertors;

import com.itmo.lab3.dto.BeastMasterDto;
import com.itmo.lab3.dto.CatDto;
import com.itmo.lab3.model.entity.BeastMaster;
import com.itmo.lab3.model.entity.Cat;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CatConvertor {
    private final ModelMapper modelMapper;

    public CatConvertor(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CatDto convertToDto(Cat cat) {
        return modelMapper.map(cat, CatDto.class);
    }

    public Cat convertToEntity(CatDto catDto) {
        return modelMapper.map(catDto, Cat.class);
    }
}
