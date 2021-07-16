package com.desafioteste.desafioteste.unit;

import com.desafioteste.desafioteste.dto.DistrictDto;
import com.desafioteste.desafioteste.entity.District;
import com.desafioteste.desafioteste.repository.DistrictRepo;
import com.desafioteste.desafioteste.service.DistrictService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

public class DistrictTests {

    private DistrictRepo repository;
    private DistrictService service;
    private District dist;


    @BeforeEach
    public void init(){

        repository = new DistrictRepo();
        service = new DistrictService(repository);

        dist = new District(new DistrictDto("bairro teste", new BigDecimal("525.0")));

    }

    @Test
    public void should_throwException_when_DistrictNotExists(){

        assertThrows(RuntimeException.class, () -> service.getDistrict(0));

    }

}
