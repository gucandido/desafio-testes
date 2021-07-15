package com.desafioteste.desafioteste.repository;

import com.desafioteste.desafioteste.entity.District;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Repository
public class DistrictRepo implements Repo<District> {

    private static List<District> districts = new ArrayList<>();

    @Override
    public District save(Object obj) {

        District district = (District) obj;

        long id = 0;

        if(!districts.isEmpty())
            id = districts.stream().max((Comparator.comparingLong(District::getId))).get().getId();

        district.setId(id);
        districts.add(district);

        return district;

    }

    @Override
    public District findById(long id) {
        Optional<District> district = districts.stream().filter(x->x.getId() == id).findFirst();

        if(district.isPresent())
            return district.get();
        else
            throw new RuntimeException("nao achei");
    }

    @Override
    public District findByName(String name) {
        Optional<District> district = districts.stream().filter(x->x.getDistrict_name().equals(name)).findFirst();

        if(district.isPresent())
            return district.get();
        else
            throw new RuntimeException("nao achei");
    }
}
