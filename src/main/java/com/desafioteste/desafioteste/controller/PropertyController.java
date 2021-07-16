package com.desafioteste.desafioteste.controller;

import com.desafioteste.desafioteste.dto.PropertyDto;
import com.desafioteste.desafioteste.dto.RoomDto;
import com.desafioteste.desafioteste.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping
    public ResponseEntity<?> postProperty(@RequestBody @Valid PropertyDto dto){
        return new ResponseEntity<>(PropertyDto.classToDto(propertyService.createNewProperty(PropertyDto.dtoToClass(dto))), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getDistricts(@RequestParam(required = false, defaultValue = "") String name){

        if(name.isEmpty()) {

            List<PropertyDto> properties = new ArrayList<>();

            propertyService.getAllProperties().forEach(x->properties.add(PropertyDto.classToDto(x)));

            return new ResponseEntity<>(properties, HttpStatus.ACCEPTED);

        }else {
            return new ResponseEntity<>(PropertyDto.classToDto(propertyService.getProperty(name)), HttpStatus.ACCEPTED);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDistrictById(@PathVariable long id){
        return new ResponseEntity<>(PropertyDto.classToDto(propertyService.getProperty(id)), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDistrict(@PathVariable long id){
        return new ResponseEntity<>(propertyService.deleteDistrict(id), HttpStatus.ACCEPTED);
    }

    @GetMapping("/value/{id}")
    public ResponseEntity<?> getPropertyValue(@PathVariable long id){
        return new ResponseEntity<>(propertyService.getPropertyValue(id), HttpStatus.ACCEPTED);
    }

    @GetMapping("/biggest-room/{id}")
    public ResponseEntity<?> getPropertyBiggestRoom(@PathVariable long id){
        return new ResponseEntity<>(RoomDto.classToDto(propertyService.getBiggestPropertyRoom(id)), HttpStatus.ACCEPTED);
    }

    @GetMapping("/property-area/{id}")
    public ResponseEntity<?> getPropertyTotalArea(@PathVariable long id){
        return new ResponseEntity<>(propertyService.CalcPropertyArea(id), HttpStatus.ACCEPTED);
    }

    @GetMapping("/rooms-area/{id}")
    public ResponseEntity<?> getRoomsArea(@PathVariable long id){

        List<RoomDto> list = new ArrayList<>();

        propertyService.getRooms(id).forEach(x->list.add(RoomDto.classToDto(x)));

        return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
    }



}
