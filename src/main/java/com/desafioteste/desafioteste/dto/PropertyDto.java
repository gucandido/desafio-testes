package com.desafioteste.desafioteste.dto;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

public class PropertyDto {

    @NotNull(message = "O nome da propriedade não pode estar vazio.")
    @NotEmpty(message = "O nome da propriedade não pode estar vazio.")
    @NotBlank(message = "O nome da propriedade não pode estar em branco")
    @Size(max = 30, message = "O comprimento do nome não pode exceder 30 caracteres")
    @Pattern(regexp = "^[A-Z]\\w+", message = "O nome da propriedade deve começar com uma letra maiúscula.")
    private String prop_name;

    @NotNull(message = "O nome do bairro não pode estar vazio.")
    @NotEmpty(message = "O nome do bairro não pode estar vazio.")
    @NotBlank(message = "O nome do bairro não pode estar em branco.")
    @Size(max = 45, message = "O comprimento do bairro não pode exceder 45 caracteres")
    private String prop_district;

    @NotNull(message = "O valor do metro quadrado no bairro não pode estar vazio")
    @Digits(integer = 11, fraction = 2, message = "O comprimento não pode exceder 13 dígitos, sendo 11 inteiros e 2 decimais")
    @PositiveOrZero(message = "O valor não pode ser negativo")
    private BigDecimal value_district_m2;

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

    public List<RoomDto> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomDto> rooms) {
        this.rooms = rooms;
    }
}
