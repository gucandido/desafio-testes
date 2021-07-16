package com.desafioteste.desafioteste.unit;


import com.desafioteste.desafioteste.dto.DistrictDto;
import com.desafioteste.desafioteste.dto.GenericResponseDto;
import com.desafioteste.desafioteste.entity.District;
import com.desafioteste.desafioteste.repository.DistrictRepo;
import com.desafioteste.desafioteste.service.DistrictService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DistrictTests {

    private DistrictRepo repository;
    private DistrictService service;
    private District dist;

    @BeforeEach
    public void init(){

        repository = Mockito.mock(DistrictRepo.class);
        service = new DistrictService(repository);

        dist = new District(new DistrictDto("bairro teste", new BigDecimal(525.0)));

    }

    @Test
    public void should_saveNewDistrict(){

        service.saveNewDistrict(dist);

        Mockito.when(repository.findAll()).thenReturn(Arrays.asList(dist));
        Mockito.verify(repository).save(dist);

        List<District> dists = repository.findAll();
        assertTrue(dists.contains(dist));

    }

    @Test
    public void should_getDistrictById(){

        service.saveNewDistrict(dist);

       Mockito.when(repository.findById(0)).thenReturn(dist);

       District district = service.getDistrict(0);

       Mockito.verify(repository).findById(0);

       assertTrue(district.equals(dist));

    }

    @Test
    public void should_getDistrictByName(){

        service.saveNewDistrict(dist);

        Mockito.when(repository.findByName("bairro teste")).thenReturn(dist);

        District district = service.getDistrict("bairro teste");

        Mockito.verify(repository).findByName("bairro teste");

        assertTrue(district.equals(dist));

    }

    @Test
    public void should_getAllDistricts(){

        service.saveNewDistrict(dist);

        Mockito.when(repository.findAll()).thenReturn(Arrays.asList(dist));
        List<District> district = service.getAllDistricts();
        Mockito.verify(repository).findAll();


        assertTrue(district.contains(dist));

    }

    @Test
    public void should_deleteDistrictById(){

        service.saveNewDistrict(dist);

        Mockito.when(repository.delete(0)).thenReturn(true);

        GenericResponseDto deleted = service.deleteDistrict(0);
        Mockito.verify(repository).delete(0);

        assertTrue(deleted.getMessage().equals("Bairro deletado com sucesso"));

    }

    @Test
    public void shouldNot_saveNewDistrictWithNameLengthOver45Characters(){

        District district = new District(new DistrictDto("bairro teste 123456789987654321123456789987654321", new BigDecimal(525.0)));

        Mockito.doThrow(new RuntimeException()).when(repository).save(district);

        try {
            service.saveNewDistrict(district);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

        Mockito.verify(repository).save(district);
        assertTrue(service.getAllDistricts().size() == 0);

    }

    @Test
    public void shouldNot_saveNewDistrictWithNegativeValue(){

        dist.setValue_district_m2(new BigDecimal("-1.0"));

        Mockito.doThrow(new RuntimeException()).when(repository).save(dist);

        try {
            service.saveNewDistrict(dist);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

        Mockito.verify(repository).save(dist);
        assertTrue(service.getAllDistricts().size() == 0);

    }

}