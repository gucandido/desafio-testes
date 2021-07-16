package com.desafioteste.desafioteste.integration;

import com.desafioteste.desafioteste.dto.DistrictDto;
import com.desafioteste.desafioteste.entity.District;
import com.desafioteste.desafioteste.exception.disctrict.DistrictAlreadyExistsException;
import com.desafioteste.desafioteste.repository.DistrictRepo;
import com.desafioteste.desafioteste.service.DistrictService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class IntegrationTests {

    private DistrictRepo mockedRepo;
    private DistrictService mockedService;

    private District dist;

    @BeforeEach
    public void init(){

        mockedRepo = Mockito.mock(DistrictRepo.class);
        mockedService = new DistrictService(mockedRepo);

        dist = new District(new DistrictDto("bairro teste", new BigDecimal("525.0")));

    }

    @Test
    public void should_throwException_when_savingDuplicatedDistrict(){

        Mockito.when(mockedRepo.exists(dist)).thenReturn(true);
        Mockito.when(mockedRepo.save(dist)).thenCallRealMethod();

        assertThrows(DistrictAlreadyExistsException.class, ()-> mockedService.saveNewDistrict(dist));

    }

    @Test
    public void should_throwException_when_savingDuplicatedProperty(){

        Mockito.when(mockedRepo.exists(dist)).thenReturn(true);
        Mockito.when(mockedRepo.save(dist)).thenCallRealMethod();

        assertThrows(DistrictAlreadyExistsException.class, ()-> mockedService.saveNewDistrict(dist));

    }

    @Test
    public void should_throwException_when_savingProperty_and_DistrictNotExists(){

        Mockito.when(mockedRepo.exists(dist)).thenReturn(true);
        Mockito.when(mockedRepo.save(dist)).thenCallRealMethod();

        assertThrows(DistrictAlreadyExistsException.class, ()-> mockedService.saveNewDistrict(dist));

    }

    @Test
    public void should_saveNewProperty(){

        Mockito.when(mockedRepo.exists(dist)).thenReturn(true);
        Mockito.when(mockedRepo.save(dist)).thenCallRealMethod();

        assertThrows(DistrictAlreadyExistsException.class, ()-> mockedService.saveNewDistrict(dist));

    }



}
