package com.desafioteste.desafioteste.controller;

import com.desafioteste.desafioteste.dto.DistrictDto;
import com.desafioteste.desafioteste.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/district")
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    @PostMapping
    public ResponseEntity<?> postCreateDistrict(@RequestBody @Valid DistrictDto dto){
        return new ResponseEntity<>(DistrictDto.classToDto(districtService.saveNewDistrict(DistrictDto.dtoToClass(dto))), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDistrictById(@PathVariable long id){
        return new ResponseEntity<>(DistrictDto.classToDto(districtService.getDistrict(id)), HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<?> getDistricts(@RequestParam(required = false, defaultValue = "") String name){

        if(name.isEmpty()) {

            List<DistrictDto> districts = new ArrayList<>();

            districtService.getAllDistricts().forEach(x->districts.add(DistrictDto.classToDto(x)));

            return new ResponseEntity<>( districts, HttpStatus.ACCEPTED);

        }else {
            return new ResponseEntity<>(DistrictDto.classToDto(districtService.getDistrict(name)), HttpStatus.ACCEPTED);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDistrict(@PathVariable long id){
        return new ResponseEntity<>(districtService.deleteDistrict(id), HttpStatus.ACCEPTED);
    }


}
