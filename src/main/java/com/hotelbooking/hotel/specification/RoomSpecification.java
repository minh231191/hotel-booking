package com.hotelbooking.hotel.specification;

import com.hotelbooking.hotel.model.Room;
import org.springframework.data.jpa.domain.Specification;

public class RoomSpecification {

  private RoomSpecification() {

  }

  private static final String MAX_OCCUPANCY = "maxOccupancy";
  private static final String ACTIVE = "isActive";

  public static Specification<Room> maxOccupancyLessThan(Integer maxOccupancy) {
    return (room, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(room.get(MAX_OCCUPANCY), maxOccupancy);
  }

  public static Specification<Room> isActive() {
    return (room, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(room.get(ACTIVE), Boolean.TRUE);
  }

}
