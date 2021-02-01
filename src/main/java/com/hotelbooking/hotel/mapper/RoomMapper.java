package com.hotelbooking.hotel.mapper;

import com.hotelbooking.common.dto.hotel.RoomDto;
import com.hotelbooking.common.mapper.EntityMapper;
import com.hotelbooking.hotel.model.Room;
import org.mapstruct.Mapper;

@Mapper(uses = {HotelMapper.class, AmenityMapper.class}, componentModel = "spring")
public interface RoomMapper extends EntityMapper<RoomDto, Room> {

}
