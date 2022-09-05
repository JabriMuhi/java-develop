package com.itmo.lab3.controller;

import com.itmo.lab3.dto.CatDto;
import com.itmo.lab3.dto.convertors.CatConvertor;
import com.itmo.lab3.exception.ServiceException;
import com.itmo.lab3.model.entity.Cat;
import com.itmo.lab3.service.ICatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cats")
public class CatController {
    private final ICatService catService;
    private final CatConvertor catConvertor;

    public CatController(ICatService catService,
                         CatConvertor catConvertor) {
        this.catService = catService;
        this.catConvertor = catConvertor;
    }

    @GetMapping("/{id_cat}")
    public ResponseEntity<CatDto> findById(@PathVariable("id_cat") Long id) {
        CatDto catDto = new CatDto();
        try {
            Cat cat = catService.findById(id);
            catDto = catConvertor.convertToDto(cat);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(catDto, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<CatDto>> findAll() {
        List<Cat> catList = catService.findAll();
        List<CatDto> catDtoList = new ArrayList<>();
        for (Cat cat : catList) {
            catDtoList.add(catConvertor.convertToDto(cat));
        }
        return new ResponseEntity<>(catDtoList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CatDto> save(@RequestBody CatDto catDto) {
        Cat cat = catConvertor.convertToEntity(catDto);
        try {
            cat = catService.save(cat);
            catDto = catConvertor.convertToDto(cat);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(catDto, HttpStatus.CREATED);
    }

//    @DeleteMapping()
//    public ResponseEntity<CatDto> delete(@RequestParam("cat_id") Long id) {
//        try {
//            Cat cat = catService.findById(id);
//            catService.delete(cat);
//            return new ResponseEntity<>(catConvertor.convertToDto(cat), HttpStatus.OK);
//        } catch (ServiceException e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

//    @DeleteMapping()
//    public ResponseEntity<Long> delete(@PathVariable(value = "id") Long id){
//        try {
//            Cat cat = catService.findById(id);
//            catService.delete(cat);
//            return new ResponseEntity<>(id, HttpStatus.OK);
//        } catch (ServiceException e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

    @DeleteMapping("/{cat_id}")
    public void delete(@PathVariable(value = "cat_id") Long id){
        try {
            Cat cat = catService.findById(id);
            catService.delete(cat);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
    // TODO: 17.05.2022 update on passVariable; 
}
