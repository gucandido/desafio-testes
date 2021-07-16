package com.desafioteste.desafioteste.entity;

import com.desafioteste.desafioteste.dto.DistrictDto;
import java.math.BigDecimal;
import java.util.Objects;

public class District {

    private long id;
    private String district_name;
    private BigDecimal value_district_m2;

    public District(DistrictDto dist) {
        this.district_name = dist.getDistrict_name();
        this.value_district_m2 = dist.getValue_district_m2();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDistrict_name() {
        return district_name;
    }

    public void setDistrict_name(String district_name) {
        this.district_name = district_name;
    }

    public BigDecimal getValue_district_m2() {
        return value_district_m2;
    }

    public void setValue_district_m2(BigDecimal value_district_m2) {
        this.value_district_m2 = value_district_m2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        District district = (District) o;
        return Objects.equals(district_name, district.district_name) && Objects.equals(value_district_m2, district.value_district_m2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(district_name, value_district_m2);
    }
}
