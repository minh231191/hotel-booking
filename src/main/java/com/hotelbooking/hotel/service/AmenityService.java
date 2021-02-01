package com.hotelbooking.hotel.service;

import com.hotelbooking.common.dto.resource.AmenityDto;
import com.hotelbooking.hotel.mapper.AmenityMapper;
import com.hotelbooking.hotel.model.Amenity;
import com.hotelbooking.hotel.repository.AmenityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmenityService {

  private final AmenityRepository amenityRepository;
  private final AmenityMapper amenityMapper;

  public AmenityService(AmenityRepository amenityRepository, AmenityMapper amenityMapper) {
    this.amenityRepository = amenityRepository;
    this.amenityMapper = amenityMapper;
  }

  public List<AmenityDto> getAmenities() {
    return amenityMapper.toDtoList(amenityRepository.findAll());
  }

  public AmenityDto createAmenity(AmenityDto amenityDto) {
    Amenity toBeSaved = amenityMapper.toEntity(amenityDto);
    return amenityMapper.toDto(amenityRepository.save(toBeSaved));
  }

}
