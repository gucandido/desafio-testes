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

    public District saveNewDistrict(District district){
        return repository.save(district);
    }

    public District getDistrict(long id){
        return repository.findById(id);
    }

    public District getDistrict(String districtName){
        return repository.findByName(districtName);
    }

    public List<District> getAllDistricts(){

        return repository.findAll();

    }

    public GenericResponseDto deleteDistrict(long id){

        if(!repository.delete(id))
            throw new RuntimeException("bairro não encontrado");

        return new GenericResponseDto("Bairro deletado com sucesso");

    }


}
