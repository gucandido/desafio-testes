package com.desafioteste.desafioteste.controller;

import com.desafioteste.desafioteste.dto.GenericResponseDto;
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

        List<PropertyDto> properties = new ArrayList<>();

        if(name.isEmpty()) {
            propertyService.getAllProperties().forEach(x->properties.add(PropertyDto.classToDto(x)));
        }else {
            propertyService.getProperty(name).forEach(x->properties.add(PropertyDto.classToDto(x)));
        }

        return new ResponseEntity<>(properties, HttpStatus.ACCEPTED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDistrictById(@PathVariable long id){
        return new ResponseEntity<>(PropertyDto.classToDto(propertyService.getProperty(id)), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDistrict(@PathVariable long id){
        return new ResponseEntity<>(propertyService.deleteDistrict(id), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}/value")
    public ResponseEntity<?> getPropertyValue(@PathVariable long id){
        return new ResponseEntity<>(new GenericResponseDto("O valor da propriedade é: "+propertyService.getPropertyValue(id)), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}/room/biggest")
    public ResponseEntity<?> getPropertyBiggestRoom(@PathVariable long id){
        return new ResponseEntity<>(RoomDto.classToDto(propertyService.getBiggestPropertyRoom(id)), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}/area")
    public ResponseEntity<?> getPropertyTotalArea(@PathVariable long id){
        return new ResponseEntity<>(new GenericResponseDto("A área total da propriedade é: "+propertyService.CalcPropertyArea(id)), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}/room/area")
    public ResponseEntity<?> getRoomsArea(@PathVariable long id){

        List<RoomDto> list = new ArrayList<>();

        propertyService.getRooms(id).forEach(x->list.add(RoomDto.classToDto(x)));

        return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
    }

}
