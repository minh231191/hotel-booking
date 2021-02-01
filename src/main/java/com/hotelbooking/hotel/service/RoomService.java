package com.hotelbooking.hotel.service;

import com.hotelbooking.common.dto.hotel.RoomDto;
import com.hotelbooking.common.dto.hotel.RoomFilterDto;
import com.hotelbooking.hotel.mapper.RoomMapper;
import com.hotelbooking.hotel.model.Hotel;
import com.hotelbooking.hotel.model.Room;
import com.hotelbooking.hotel.repository.HotelRepository;
import com.hotelbooking.hotel.repository.RoomRepository;
import com.hotelbooking.hotel.specification.RoomSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class RoomService {

  private final RoomRepository roomRepository;
  private final HotelRepository hotelRepository;
  private final RoomMapper roomMapper;

  public RoomService(RoomRepository roomRepository, HotelRepository hotelRepository, RoomMapper roomMapper) {
    this.roomRepository = roomRepository;
    this.hotelRepository = hotelRepository;
    this.roomMapper = roomMapper;
  }

  public List<RoomDto> getRooms(RoomFilterDto roomFilterDto) {
    Specification<Room> romSpec = Specification.where(RoomSpecification.isActive());
    if (roomFilterDto.getMaxOccupancy() != null) {
      romSpec = romSpec.and(RoomSpecification.maxOccupancyLessThan(roomFilterDto.getMaxOccupancy()));
    }
    return roomMapper.toDtoList(roomRepository.findAll(romSpec));
  }

  public RoomDto getRoomById(Long roomId) {
    return roomMapper.toDto(roomRepository.findById(roomId)
        .orElseThrow(() -> new EntityNotFoundException("Not found room with ID: " + roomId)));
  }

  public RoomDto createRoom(RoomDto roomDto) {
    Room room = roomMapper.toEntity(roomDto);
    Long hotelId = room.getHotel().getId();
    Hotel hotel = hotelRepository.findById(hotelId)
        .orElseThrow(() -> new EntityNotFoundException("Not found Hotel with id: " + hotelId));
    room.setHotel(hotel);
    return roomMapper.toDto(roomRepository.save(room));
  }
  
  public RoomDto updateRoom(Long roomId, RoomDto roomDto) {
    Room fromDb = roomRepository.findById(roomId)
        .orElseThrow(() -> new EntityNotFoundException("Not found room with id: " + roomId));
    if (fromDb.getId().compareTo(roomDto.getId()) != 0) {
      throw new EntityNotFoundException("Not found room with id: " + roomDto.getId());
    }
    Room savedRoom = roomRepository.save(roomMapper.toEntity(roomDto));
    return roomMapper.toDto(savedRoom);
  }

}
