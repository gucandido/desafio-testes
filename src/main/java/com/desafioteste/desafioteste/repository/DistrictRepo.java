package com.desafioteste.desafioteste.repository;

import com.desafioteste.desafioteste.entity.District;
import com.desafioteste.desafioteste.exception.disctrict.DistrictAlreadyExistsException;
import com.desafioteste.desafioteste.exception.disctrict.DistrictNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class DistrictRepo implements Repo<District> {

    private static List<District> districts = new ArrayList<>();

    @Override
    public District save(Object obj) {

        District district = (District) obj;

        if(!exists(obj)) {
            long id = 0;

            if (!districts.isEmpty())
                id = districts.stream().max((Comparator.comparingLong(District::getId))).get().getId() + 1;

            district.setId(id);
            districts.add(district);

            return district;
        }else{
            throw new DistrictAlreadyExistsException("Este Bairro já existe");
        }

    }

    @Override
    public List<District> findAll() {
        return districts;
    }

    @Override
    public District findById(long id) {
        Optional<District> district = districts.stream().filter(x->x.getId() == id).findFirst();

        if(district.isPresent())
            return district.get();
        else
            throw new DistrictNotFoundException("Bairro não encontrado");
    }

    @Override
    public List<District> findByName(String name) {
        List<District> districtList = districts.stream().filter(x->x.getDistrict_name().equals(name)).collect(Collectors.toList());

        if(districtList.size() > 0)
            return districtList;
        else
            throw new DistrictNotFoundException("Bairro não encontrado");
    }

    @Override
    public boolean delete(long id) {
        return districts.removeIf(x->x.getId() == id);
    }

    @Override
    public boolean exists(Object obj) {

        District dist = (District) obj;

        return districts.contains(dist);
    }

}
