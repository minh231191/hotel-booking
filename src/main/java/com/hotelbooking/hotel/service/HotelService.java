package com.hotelbooking.hotel.service;

import com.hotelbooking.common.dto.hotel.HotelDto;
import com.hotelbooking.hotel.mapper.HotelMapper;
import com.hotelbooking.hotel.model.Hotel;
import com.hotelbooking.hotel.repository.HotelRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class HotelService {

  private final HotelRepository hotelRepository;
  private final HotelMapper hotelMapper;

  public HotelService(HotelRepository hotelRepository, HotelMapper hotelMapper) {
    this.hotelRepository = hotelRepository;
    this.hotelMapper = hotelMapper;
  }

  public List<HotelDto> getHotels() {
    return hotelMapper.toDtoList(hotelRepository.findAll());
  }

  public HotelDto createHotel(HotelDto hotelDto) {
    Hotel savedHotel = hotelRepository.save(hotelMapper.toEntity(hotelDto));
    return hotelMapper.toDto(savedHotel);
  }

  public HotelDto updateHotel(Long hotelId, HotelDto hotelDto) {
    Hotel fromDb = hotelRepository.findById(hotelId)
        .orElseThrow(() -> new EntityNotFoundException("Not found hotel with id: " + hotelId));
    if (fromDb.getId().compareTo(hotelDto.getId()) != 0) {
      throw new EntityNotFoundException("Not found hotel with id: " + hotelDto.getId());
    }
    Hotel savedHotel = hotelRepository.save(hotelMapper.toEntity(hotelDto));
    return hotelMapper.toDto(savedHotel);
  }

}
