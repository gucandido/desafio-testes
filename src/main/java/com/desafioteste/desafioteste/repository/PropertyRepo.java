package com.desafioteste.desafioteste.repository;

import com.desafioteste.desafioteste.entity.Property;
import com.desafioteste.desafioteste.exception.property.PropertyAlreadyExistsException;
import com.desafioteste.desafioteste.exception.property.PropertyNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PropertyRepo implements Repo<Property>{

    private static List<Property> properties = new ArrayList<>();

    @Override
    public Property save(Object obj) {

        if(!exists(obj)) {
            Property property = (Property) obj;

            long id = 0;

            if (!properties.isEmpty())
                id = properties.stream().max((Comparator.comparingLong(Property::getId))).get().getId() + 1;

            property.setId(id);
            properties.add(property);

            return property;
        }else{
            throw new PropertyAlreadyExistsException("Esta Propriedade já existe");
        }
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
            throw new PropertyNotFoundException("Propriedade não encontrada");

    }

    @Override
    public List<Property> findByName(String name) {

        List<Property> propertyList = properties.stream().filter(x->x.getProp_name().equals(name)).collect(Collectors.toList());

        if(propertyList.size() > 0)
            return propertyList;
        else
            throw new PropertyNotFoundException("Propriedade não encontrada");

    }

    @Override
    public boolean delete(long id) {
        return properties.removeIf(x->x.getId() == id);
    }

    @Override
    public boolean exists(Object obj) {

        Property prop = (Property) obj;

        return properties.contains(prop);
    }

}
