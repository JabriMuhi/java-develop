package com.itmo.lab3.controller;

import com.itmo.lab3.dto.BeastMasterDto;
import com.itmo.lab3.dto.CatDto;
import com.itmo.lab3.dto.convertors.BeastMasterConvertor;
import com.itmo.lab3.exception.ControllerException;
import com.itmo.lab3.exception.ServiceException;
import com.itmo.lab3.model.entity.BeastMaster;
import com.itmo.lab3.model.entity.Cat;
import com.itmo.lab3.service.IBeastMasterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/beast_masters")
public class BeastMasterController {
    private final IBeastMasterService beastMasterService;
    private final BeastMasterConvertor beastMasterConvertor;

    public BeastMasterController(IBeastMasterService beastMasterService,
                                 BeastMasterConvertor beastMasterConvertor) {
        this.beastMasterService = beastMasterService;
        this.beastMasterConvertor = beastMasterConvertor;
    }

    @GetMapping
    public ResponseEntity<List<BeastMasterDto>> findAll() {
        List<BeastMaster> beastMastersList = beastMasterService.findAll();
        List<BeastMasterDto> beastMasterDtoList = new ArrayList<>();
        for (BeastMaster beastMaster : beastMastersList) {
            beastMasterDtoList.add(beastMasterConvertor.convertToDto(beastMaster));
        }
        return new ResponseEntity<>(beastMasterDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id_beast_master}")
    public ResponseEntity<BeastMaster> getById(@PathVariable("id_beast_master") Long id) {
        try {
            return new ResponseEntity<>(beastMasterService.findById(id), HttpStatus.OK);
        } catch (ServiceException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<BeastMasterDto> save(@RequestBody BeastMasterDto beastMasterDto) {
        BeastMaster beastMaster = beastMasterConvertor.convertToEntity(beastMasterDto);
        try {
            beastMaster = beastMasterService.save(beastMaster);
            beastMasterDto = beastMasterConvertor.convertToDto(beastMaster);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(beastMasterDto, HttpStatus.CREATED);
    }
}
