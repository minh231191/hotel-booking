package com.hotelbooking.hotel.controller;

import com.hotelbooking.common.dto.hotel.HotelDto;
import com.hotelbooking.hotel.service.HotelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hotels")
public class HotelController {

  private final HotelService hotelService;

  public HotelController(HotelService hotelService) {
    this.hotelService = hotelService;
  }

  @GetMapping
  public ResponseEntity<List<HotelDto>> getHotels() {
    return ResponseEntity.ok().body(hotelService.getHotels());
  }

  @PostMapping
  public ResponseEntity<HotelDto> createHotel(@RequestBody HotelDto hotelDto) {
    return ResponseEntity.ok().body(hotelService.createHotel(hotelDto));
  }

  @PutMapping("{hotelId}")
  public ResponseEntity<HotelDto> updateHotel(@PathVariable Long hotelId, @RequestBody HotelDto hotelDto) {
    return ResponseEntity.ok().body(hotelService.updateHotel(hotelId, hotelDto));
  }

}
