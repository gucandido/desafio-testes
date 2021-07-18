package com.desafioteste.desafioteste.integration;

import com.desafioteste.desafioteste.dto.DistrictDto;
import com.desafioteste.desafioteste.dto.PropertyDto;
import com.desafioteste.desafioteste.dto.RoomDto;
import com.desafioteste.desafioteste.entity.District;
import com.desafioteste.desafioteste.entity.Property;
import com.desafioteste.desafioteste.exception.disctrict.DistrictAlreadyExistsException;
import com.desafioteste.desafioteste.exception.disctrict.DistrictNotFoundException;
import com.desafioteste.desafioteste.exception.property.PropertyAlreadyExistsException;
import com.desafioteste.desafioteste.exception.property.PropertyCreateException;
import com.desafioteste.desafioteste.repository.DistrictRepo;
import com.desafioteste.desafioteste.repository.PropertyRepo;
import com.desafioteste.desafioteste.service.DistrictService;
import com.desafioteste.desafioteste.service.PropertyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class IntegrationTests {

    private DistrictRepo mockedDistrictRepo;
    private DistrictService districtService;

    private PropertyRepo mockedPropertyRepo;
    private PropertyService propertyService;

    private District dist;
    private Property prop;

    @BeforeEach
    public void init(){

        mockedDistrictRepo = Mockito.mock(DistrictRepo.class);
        districtService = new DistrictService(mockedDistrictRepo);

        mockedPropertyRepo = Mockito.mock(PropertyRepo.class);
        propertyService = new PropertyService(mockedPropertyRepo, mockedDistrictRepo);

        dist = new District(new DistrictDto("bairro teste", new BigDecimal("525.0")));


        List<RoomDto> rooms = new ArrayList<>();
        rooms.add(new RoomDto("Quarto", 2.0,3.0));
        rooms.add(new RoomDto("Cozinha", 4.0,3.0));
        rooms.add(new RoomDto("GuaritaSnipper", 1.0,1.5));

        prop = new Property(new PropertyDto("CafofoDoOsama", 0,rooms));

    }

    @Test
    public void should_throwException_when_savingDuplicatedDistrict(){

        Mockito.when(mockedDistrictRepo.exists(dist)).thenReturn(true);
        Mockito.when(mockedDistrictRepo.save(dist)).thenCallRealMethod();

        assertThrows(DistrictAlreadyExistsException.class, ()-> districtService.saveNewDistrict(dist));

        Mockito.verify(mockedDistrictRepo).exists(dist);
        Mockito.verify(mockedDistrictRepo).save(dist);

    }

    @Test
    public void should_throwException_when_savingDuplicatedProperty(){

        Mockito.when(mockedDistrictRepo.findById(0)).thenReturn(dist);
        Mockito.when(mockedPropertyRepo.exists(prop)).thenReturn(true);
        Mockito.when(mockedPropertyRepo.save(prop)).thenCallRealMethod();

        assertThrows(PropertyAlreadyExistsException.class, ()-> propertyService.createNewProperty(prop));

        Mockito.verify(mockedDistrictRepo, Mockito.times(2)).findById(0);
        Mockito.verify(mockedPropertyRepo).exists(prop);
        Mockito.verify(mockedPropertyRepo).save(prop);

    }

    @Test
    public void should_throwException_when_savingProperty_and_DistrictNotExists(){

        Mockito.when(mockedPropertyRepo.exists(prop)).thenReturn(false);
        Mockito.when(mockedPropertyRepo.save(prop)).thenCallRealMethod();
        Mockito.when(mockedDistrictRepo.findById(0)).thenThrow(DistrictNotFoundException.class);

        assertThrows(PropertyCreateException.class, ()-> propertyService.createNewProperty(prop));

        Mockito.verify(mockedPropertyRepo, Mockito.times(0)).exists(prop);
        Mockito.verify(mockedPropertyRepo, Mockito.times(0)).save(prop);
        Mockito.verify(mockedDistrictRepo).findById(0);

    }

    @Test
    public void should_saveNewDistrict(){

        List<District> list = new ArrayList<>();
        list.add(dist);

        Mockito.when(mockedDistrictRepo.save(dist)).thenReturn(dist);
        Mockito.when(mockedDistrictRepo.findAll()).thenReturn(list);

        districtService.saveNewDistrict(dist);
        List<District> result =  districtService.getAllDistricts();

        assertTrue(result.contains(dist));

        Mockito.verify(mockedDistrictRepo).save(dist);
        Mockito.verify(mockedDistrictRepo).findAll();

    }

    @Test
    public void should_saveNewProperty(){

        List<Property> list = new ArrayList<>();
        list.add(prop);

        Mockito.when(mockedDistrictRepo.findById(0)).thenReturn(dist);
        Mockito.when(mockedPropertyRepo.save(prop)).thenReturn(prop);
        Mockito.when(mockedPropertyRepo.findAll()).thenReturn(list);

        propertyService.createNewProperty(prop);
        List<Property> result =  propertyService.getAllProperties();

        assertTrue(result.contains(prop));

        Mockito.verify(mockedDistrictRepo, Mockito.times(2)).findById(0);
        Mockito.verify(mockedPropertyRepo).save(prop);
        Mockito.verify(mockedPropertyRepo).findAll();

    }


}
