package com.desafioteste.desafioteste.dto;

import com.desafioteste.desafioteste.entity.Room;

import javax.validation.constraints.*;

public class RoomDto {

    @NotNull(message = "O nome do cômodo não pode estar vazio.")
    @NotEmpty(message = "O nome do cômodo não pode estar vazio.")
    @NotBlank(message = "O nome do cômodo não pode estar em branco")
    @Size(max = 30, message = "O comprimento do nome do cômodo não pode exceder 30 caracteres")
    @Pattern(regexp = "^[A-Z]\\w+", message = "O nome do cômodo deve começar com uma letra maiúscula.")
    private String room_name;

    @NotNull(message = "A largura do cômodo não pode estar vazia")
    @PositiveOrZero(message = "A largura do cômodo não pode ser negativa")
    @Max(value = 25, message = "A largura máxima permitida por cômodo é de 25 metros")
    private Double room_width;

    @NotNull(message = "O comprimento do cômodo não pode estar vazia")
    @PositiveOrZero(message = "O comprimento do cômodo não pode ser negativo")
    @Max(value = 33, message = "O comprimento máximo permitido por cômodo é de 33 metros")
    private Double room_length;

    public RoomDto(String room_name, Double room_width, Double room_length) {
        this.room_name = room_name;
        this.room_width = room_width;
        this.room_length = room_length;
    }

    public RoomDto(Room room) {
        this.room_name = room.getRoom_name();
        this.room_width = room.getRoom_width();
        this.room_length = room.getRoom_length();
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public double getRoom_width() {
        return room_width;
    }

    public void setRoom_width(Double room_width) {
        this.room_width = room_width;
    }

    public Double getRoom_length() {
        return room_length;
    }

    public void setRoom_length(Double room_length) {
        this.room_length = room_length;
    }

    public static Room dtoToClass(RoomDto dto){
        return new Room(dto);
    }

    public static RoomDto classToDto(Room room){
        return new RoomDto(room);
    }

}
