package com.desafioteste.desafioteste.controller;

import com.desafioteste.desafioteste.dto.DistrictDto;
import com.desafioteste.desafioteste.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/district")
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    @PostMapping
    public ResponseEntity<?> postCreateDistrict(@RequestBody @Valid DistrictDto dto){
        return new ResponseEntity<>(districtService.saveNewDistrict(DistrictDto.dtoToClass(dto)), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDistrictById(@PathVariable long id){
        return new ResponseEntity<>(districtService.getDistrict(id), HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<?> getDistricts(@RequestParam(required = false, defaultValue = "") String name){

        if(name.isEmpty())
            return new ResponseEntity<>(districtService.getAllDistricts(), HttpStatus.ACCEPTED);
        else
            return new ResponseEntity<>(districtService.getDistrict(name), HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDistrict(@PathVariable long id){
        return new ResponseEntity<>(districtService.deleteDistrict(id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteDistrict(@RequestHeader("district-name") String name){
        return new ResponseEntity<>(districtService.deleteDistrict(name), HttpStatus.ACCEPTED);
    }

}
