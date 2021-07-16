package com.desafioteste.desafioteste.service;

import com.desafioteste.desafioteste.dto.GenericResponseDto;
import com.desafioteste.desafioteste.entity.District;
import com.desafioteste.desafioteste.entity.Property;
import com.desafioteste.desafioteste.entity.Room;
import com.desafioteste.desafioteste.repository.DistrictRepo;
import com.desafioteste.desafioteste.repository.PropertyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
        if(districtExists(prop.getDistrict_id())) {

            prop.setProp_value(calcPropertyValue(prop));

            return repository.save(prop);
        }else {
            throw new RuntimeException("não é possivel cadastrar imovel em bairro inexistente");
        }
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

    public BigDecimal getPropertyValue(long idProperty){

        Property prop = repository.findById(idProperty);

        return prop.getProp_value();

    }

    public double CalcPropertyArea(long idProperty){

        Property prop = repository.findById(idProperty);

        return prop.calcTotalArea();


    }

    public Room getBiggestPropertyRoom(long idProperty){

        Property prop = repository.findById(idProperty);

        return prop.getBiggestRoom();

    }

    public List<Room> getRooms(long idProperty){

        Property prop = repository.findById(idProperty);

        return prop.getRooms();

    }

    private boolean districtExists(long districtId){

        try {
            districtRepo.findById(districtId);
            return true;
        }catch(RuntimeException e){
            return false;
        }

    }

    public BigDecimal calcPropertyValue(Property prop){

        District dist = districtRepo.findById(prop.getDistrict_id());

        return dist.getValue_district_m2().multiply(BigDecimal.valueOf(prop.calcTotalArea()));

    }

}
