package com.desafioteste.desafioteste.entity;

import com.desafioteste.desafioteste.dto.RoomDto;

public class Room {

    private String room_name;
    private double room_width;
    private double room_length;

    public Room(RoomDto dto) {
        this.room_name = dto.getRoom_name();
        this.room_width = dto.getRoom_width();
        this.room_length = dto.getRoom_length();
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

    public void setRoom_width(double room_width) {
        this.room_width = room_width;
    }

    public double getRoom_length() {
        return room_length;
    }

    public void setRoom_length(double room_length) {
        this.room_length = room_length;
    }
}
