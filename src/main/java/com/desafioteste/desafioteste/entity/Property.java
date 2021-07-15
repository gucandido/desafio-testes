package com.desafioteste.desafioteste.entity;

import com.desafioteste.desafioteste.dto.PropertyDto;
import com.desafioteste.desafioteste.dto.RoomDto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Property {

    private long id;
    private String prop_name;
    private String prop_district;
    private BigDecimal value_district_m2;
    private List<Room> rooms = new ArrayList<>();

    public Property(PropertyDto dto) {
        this.prop_name = dto.getProp_name();
        this.prop_district = dto.getProp_district();
        this.value_district_m2 = dto.getValue_district_m2();

        dto.getRooms().forEach(x->this.rooms.add(RoomDto.dtoToClass(x)));
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProp_name() {
        return prop_name;
    }

    public void setProp_name(String prop_name) {
        this.prop_name = prop_name;
    }

    public String getProp_district() {
        return prop_district;
    }

    public void setProp_district(String prop_district) {
        this.prop_district = prop_district;
    }

    public BigDecimal getValue_district_m2() {
        return value_district_m2;
    }

    public void setValue_district_m2(BigDecimal value_district_m2) {
        this.value_district_m2 = value_district_m2;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return id == property.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
