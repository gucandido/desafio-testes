package com.desafioteste.desafioteste.unit;


import com.desafioteste.desafioteste.dto.DistrictDto;
import com.desafioteste.desafioteste.dto.PropertyDto;
import com.desafioteste.desafioteste.dto.RoomDto;
import com.desafioteste.desafioteste.entity.District;
import com.desafioteste.desafioteste.entity.Property;
import com.desafioteste.desafioteste.entity.Room;
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


    //US0001
    @Test
    public void should_calculatePropertyTotalArea(){

        Mockito.when(repository.findById(0)).thenReturn(prop);
        double propArea = service.CalcPropertyArea(0);
        Mockito.verify(repository).findById(0);

        assertEquals(propArea,19.5);

    }

    //US0002
    @Test
    public void should_returnTheBiggestRoom(){

        Mockito.when(repository.findById(0)).thenReturn(prop);

        Room biggest = service.getBiggestPropertyRoom(0);

        Mockito.verify(repository).findById(0);

        assertEquals(biggest, prop.getRooms().get(1));

    }

    //US0003
    public void should_returnTheAreaForEachRoom(){



    }

    //US0004
    public void should_calculateRoomArea(){

    }

}
