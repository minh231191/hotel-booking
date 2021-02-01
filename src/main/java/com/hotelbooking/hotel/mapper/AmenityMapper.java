package com.hotelbooking.hotel.mapper;

import com.hotelbooking.common.dto.resource.AmenityDto;
import com.hotelbooking.common.mapper.EntityMapper;
import com.hotelbooking.hotel.model.Amenity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AmenityMapper extends EntityMapper<AmenityDto, Amenity> {
}
