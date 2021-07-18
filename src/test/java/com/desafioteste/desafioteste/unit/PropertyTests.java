package com.desafioteste.desafioteste.unit;


import com.desafioteste.desafioteste.dto.DistrictDto;
import com.desafioteste.desafioteste.dto.PropertyDto;
import com.desafioteste.desafioteste.dto.RoomDto;
import com.desafioteste.desafioteste.entity.District;
import com.desafioteste.desafioteste.entity.Property;
import com.desafioteste.desafioteste.entity.Room;
import com.desafioteste.desafioteste.repository.DistrictRepo;
import com.desafioteste.desafioteste.repository.PropertyRepo;
import com.desafioteste.desafioteste.service.PropertyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PropertyTests {

    private PropertyRepo repository;
    private DistrictRepo districtRepo;
    private PropertyService service;
    private District dist;
    private Property prop;

    @BeforeEach
    public void init(){

        repository = Mockito.mock(PropertyRepo.class);
        districtRepo = Mockito.mock(DistrictRepo.class);
        service = new PropertyService(repository, districtRepo);

        dist = new District(new DistrictDto("bairro teste", new BigDecimal("525.0")));

        List<RoomDto> rooms = new ArrayList<>();
        rooms.add(new RoomDto("Quarto", 2.0,3.0));
        rooms.add(new RoomDto("Cozinha", 4.0,3.0));
        rooms.add(new RoomDto("GuaritaSnipper", 1.0,1.5));

        prop = new Property(new PropertyDto("CafofoDoOsama", 0,rooms));

    }


    @Test
    public void should_calculatePropertyTotalArea(){

        Mockito.when(repository.findById(0)).thenReturn(prop);
        double propArea = service.CalcPropertyArea(0);
        Mockito.verify(repository).findById(0);

        assertEquals(propArea,19.5);

    }


    @Test
    public void should_returnTheBiggestRoom(){

        Mockito.when(repository.findById(0)).thenReturn(prop);
        Room biggest = service.getBiggestPropertyRoom(0);
        Mockito.verify(repository).findById(0);

        assertEquals(biggest, prop.getRooms().get(1));

    }


    @Test
    public void should_calculateRoomArea(){

        Mockito.when(repository.findById(0)).thenReturn(prop);
        List<Room> rooms = service.getRooms(0);
        Mockito.verify(repository).findById(0);

        // respostas da area de cada comodo
        List<Double> results = new ArrayList<>();
        results.add(6.0); // quarto
        results.add(12.0); // cozinha
        results.add(1.5); // guarita do snipper

        List<Double> areas = new ArrayList<>();

        // cada comodo tem em si o metodo que calcula sua area
        rooms.forEach(x->areas.add(x.calcArea()));

        assertArrayEquals(areas.toArray(),results.toArray());

    }

    @Test
    public void should_calculatePropertyValue(){

        Mockito.when(districtRepo.findById(0)).thenReturn(dist);
        BigDecimal propValue = service.calcPropertyValue(prop);
        Mockito.verify(districtRepo).findById(0);

        // 19.5 * 525.0 = 10237.50
        assertEquals(propValue, new BigDecimal("10237.50"));

    }

}
