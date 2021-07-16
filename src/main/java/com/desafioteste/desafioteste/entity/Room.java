package com.desafioteste.desafioteste.entity;

import com.desafioteste.desafioteste.dto.RoomDto;

import java.util.Objects;

public class Room {

    private String room_name;
    private double room_width;
    private double room_length;
    private double room_area;

    public Room(RoomDto dto) {
        this.room_name = dto.getRoom_name();
        this.room_width = dto.getRoom_width();
        this.room_length = dto.getRoom_length();
        this.room_area = this.calcArea();
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

    public double calcArea(){
        return this.room_length * this.room_width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Double.compare(room.room_width, room_width) == 0 && Double.compare(room.room_length, room_length) == 0 && Objects.equals(room_name, room.room_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(room_name, room_width, room_length);
    }
}
