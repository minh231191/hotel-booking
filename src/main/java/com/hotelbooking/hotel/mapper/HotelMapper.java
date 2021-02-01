package com.hotelbooking.hotel.mapper;

import com.hotelbooking.common.dto.hotel.HotelDto;
import com.hotelbooking.common.mapper.EntityMapper;
import com.hotelbooking.hotel.model.Hotel;
import org.mapstruct.Mapper;

@Mapper(uses = {AmenityMapper.class}, componentModel = "spring")
public interface HotelMapper extends EntityMapper<HotelDto, Hotel> {

}
