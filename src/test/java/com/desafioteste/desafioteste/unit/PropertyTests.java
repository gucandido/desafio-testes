package com.desafioteste.desafioteste.unit;


import com.desafioteste.desafioteste.dto.DistrictDto;
import com.desafioteste.desafioteste.dto.PropertyDto;
import com.desafioteste.desafioteste.dto.RoomDto;
import com.desafioteste.desafioteste.entity.District;
import com.desafioteste.desafioteste.entity.Property;
import com.desafioteste.desafioteste.repository.DistrictRepo;
import com.desafioteste.desafioteste.repository.PropertyRepo;
import com.desafioteste.desafioteste.service.DistrictService;
import com.desafioteste.desafioteste.service.PropertyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PropertyTests {

    private PropertyRepo repository;
    private DistrictRepo districtRepo;
    private PropertyService service;
    private DistrictService distService;
    private District dist;
    private Property prop;

    @BeforeEach
    public void init(){

        repository = Mockito.mock(PropertyRepo.class);
        districtRepo = Mockito.mock(DistrictRepo.class);
        service = new PropertyService(repository, districtRepo);
        distService = new DistrictService(districtRepo);

        dist = new District(new DistrictDto("bairro teste", new BigDecimal("525.0")));

        List<RoomDto> rooms = new ArrayList<>();
        rooms.add(new RoomDto("Quarto", 2.0,3.0));
        rooms.add(new RoomDto("Cozinha", 4.0,3.0));
        rooms.add(new RoomDto("GuaritaSnipper", 1.0,1.5));

        prop = new Property(new PropertyDto("CafofoDoOsama", 0,rooms));

    }

    @Test
    public void should_createNewProperty_when_districtExists(){
        distService.saveNewDistrict(dist);

        service.createNewProperty(prop);

        Mockito.when(repository.findAll()).thenReturn(Arrays.asList(prop));
        Mockito.verify(repository).save(prop);

        List<Property> props = repository.findAll();
        assertTrue(props.contains(prop));

    }

    @Test
    public void shouldNot_createNewProperty_when_districtNotExists(){
        service.createNewProperty(prop);

        Mockito.doThrow(new RuntimeException()).when(repository).save(prop);
        Mockito.verify(repository).save(prop);

        List<Property> props = repository.findAll();
        assertFalse(props.contains(prop));
    }


    //US0001
    @Test
    public void should_calculatePropertyTotalArea(){

        Mockito.when(repository.findById(0)).thenReturn(prop);

        Property p = repository.findById(0);
        Mockito.verify(repository).findById(0);

        assertEquals(p.calcTotalArea(),19.5);

    }

    //US0002
    public void should_calculatePropertyTotalValue(){

    }

    //US0003
    public void should_returnTheBiggestRoom(){

    }

    //US0004
    public void should_calculateRoomArea(){

    }

}
