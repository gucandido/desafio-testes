package com.desafioteste.desafioteste.dto;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

public class PropertyDto {

    @NotNull(message = "O nome da propriedade não pode estar vazio.")
    @NotEmpty(message = "O nome da propriedade não pode estar vazio.")
    @NotBlank(message = "O nome da propriedade não pode estar em branco")
    @Size(max = 30, message = "O comprimento do nome não pode exceder 30 caracteres")
    @Pattern(regexp = "^[A-Z]\\w+", message = "O nome da propriedade deve começar com uma letra maiúscula.")
    private String prop_name;

    @NotNull
    private long district_id;

    @Valid
    private List<RoomDto> rooms;

    public PropertyDto() {
    }

    public String getProp_name() {
        return prop_name;
    }

    public void setProp_name(String prop_name) {
        this.prop_name = prop_name;
    }

    public long getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(long district_id) {
        this.district_id = district_id;
    }

    public List<RoomDto> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomDto> rooms) {
        this.rooms = rooms;
    }
}
