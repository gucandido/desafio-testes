package com.desafioteste.desafioteste.service;

import com.desafioteste.desafioteste.dto.GenericResponseDto;
import com.desafioteste.desafioteste.entity.District;
import com.desafioteste.desafioteste.entity.Property;
import com.desafioteste.desafioteste.repository.DistrictRepo;
import com.desafioteste.desafioteste.repository.PropertyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepo repository;
    @Autowired
    private DistrictRepo districtRepo;

    public PropertyService(PropertyRepo repository, DistrictRepo districtRepo) {
        this.repository = repository;
        this.districtRepo = districtRepo;
    }

    public Property createNewProperty(Property prop){
        if(districtExists(prop.getDistrict_id()))
            return repository.save(prop);
        else
            throw new RuntimeException("não é possivel cadastrar imovel em bairro inexistente inexistente");
    }

    public List<Property> getAllProperties(){

        return repository.findAll();

    }

    public Property getProperty(long id){
        return repository.findById(id);
    }

    public Property getProperty(String districtName){
        return repository.findByName(districtName);
    }

    public GenericResponseDto deleteDistrict(long id){

        if(!repository.delete(id))
            throw new RuntimeException("Propriedade não encontrada");

        return new GenericResponseDto("Propriedade deletada com sucesso");

    }

    private boolean districtExists(long districtId){

        try {
            districtRepo.findById(districtId);
            return true;
        }catch(RuntimeException e){
            return false;
        }

    }

}
