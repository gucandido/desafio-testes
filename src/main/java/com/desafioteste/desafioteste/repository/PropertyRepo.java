package com.desafioteste.desafioteste.repository;

import com.desafioteste.desafioteste.dto.PropertyDto;
import com.desafioteste.desafioteste.entity.Property;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Repository
public class PropertyRepo implements Repo<Property>{

    private static List<Property> properties = new ArrayList<>();

    @Override
    public Property save(Object obj) {

        PropertyDto dto = (PropertyDto) obj;
        Property property = new Property(dto);

        long id = 0;

        if(!properties.isEmpty())
            id = properties.stream().max((Comparator.comparingLong(Property::getId))).get().getId()+1;

        property.setId(id);
        properties.add(property);

        return property;
    }

    @Override
    public List<Property> findAll() {
        return properties;
    }

    @Override
    public Property findById(long id) {

        Optional<Property> property = properties.stream().filter(x->x.getId() == id).findFirst();

        if(property.isPresent())
            return property.get();
        else
            throw new RuntimeException("nao achei");

    }

    @Override
    public Property findByName(String name) {

        Optional<Property> property = properties.stream().filter(x->x.getProp_name().equals(name)).findAny();

        if(property.isPresent())
            return property.get();
        else
            throw new RuntimeException("nao achei");

    }

    @Override
    public boolean delete(long id) {
        return properties.removeIf(x->x.getId() == id);
    }
}
