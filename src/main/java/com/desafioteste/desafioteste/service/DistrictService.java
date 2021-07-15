package com.desafioteste.desafioteste.service;

import com.desafioteste.desafioteste.dto.DistrictDto;
import com.desafioteste.desafioteste.dto.GenericResponseDto;
import com.desafioteste.desafioteste.entity.District;
import com.desafioteste.desafioteste.repository.DistrictRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DistrictService {

    @Autowired
    private DistrictRepo repository;

    public DistrictService(DistrictRepo repo) {
        this.repository = repo;
    }

    public DistrictDto saveNewDistrict(DistrictDto dto){
        return DistrictDto.classToDto(repository.save(dto));
    }

    public DistrictDto getDistrict(long id){
        return DistrictDto.classToDto(repository.findById(id));
    }

    public DistrictDto getDistrict(String districtName){
        return DistrictDto.classToDto(repository.findByName(districtName));
    }

    public List<DistrictDto> getAllDistricts(){

        List<DistrictDto> list = new ArrayList<>();

        repository.findAll().forEach(x->list.add(DistrictDto.classToDto(x)));

        return list;

    }

    public GenericResponseDto deleteDistrict(long id){

        if(!repository.delete(id))
            throw new RuntimeException("bairro não encontrado");

        return new GenericResponseDto("Bairro deletado com sucesso");

    }

    public GenericResponseDto deleteDistrict(String districtName){

        long id = repository.findByName(districtName).getId();

        if(!repository.delete(id))
            throw new RuntimeException("bairro não encontrado");

        return new GenericResponseDto("Bairro(s) deletado(s) com sucesso");

    }


}
