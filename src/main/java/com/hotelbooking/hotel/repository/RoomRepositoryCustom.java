package com.hotelbooking.hotel.repository;

import com.hotelbooking.hotel.model.Room;

import java.util.List;

public interface RoomRepositoryCustom {

  List<Room> findRoomByHotel(Long hotelId);

}
