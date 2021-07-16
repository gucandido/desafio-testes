package com.desafioteste.desafioteste.unit;

import com.desafioteste.desafioteste.dto.DistrictDto;
import com.desafioteste.desafioteste.entity.District;
import com.desafioteste.desafioteste.exception.disctrict.DistrictAlreadyExistsException;
import com.desafioteste.desafioteste.exception.disctrict.DistrictNotFoundException;
import com.desafioteste.desafioteste.repository.DistrictRepo;
import com.desafioteste.desafioteste.service.DistrictService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;


public class DistrictTests {

    private DistrictRepo repository;
    private DistrictService service;

    private DistrictRepo mockedRepo;
    private DistrictService mockedService;

    private District dist;

    @BeforeEach
    public void init(){

        repository = new DistrictRepo();
        service = new DistrictService(repository);

        mockedRepo = Mockito.mock(DistrictRepo.class);
        mockedService = new DistrictService(mockedRepo);

        dist = new District(new DistrictDto("bairro teste", new BigDecimal("525.0")));

    }

    @Test
    public void should_throwException_when_DistrictNotExists(){

        assertThrows(DistrictNotFoundException.class, () -> service.getDistrict(0));

    }

    @Test
    public void should_throwException_when_savingDuplicatedDistrict(){

        Mockito.when(mockedRepo.exists(dist)).thenReturn(true);

        Mockito.when(mockedRepo.save(dist)).thenCallRealMethod();

        assertThrows(DistrictAlreadyExistsException.class, ()-> mockedService.saveNewDistrict(dist));

    }

}
