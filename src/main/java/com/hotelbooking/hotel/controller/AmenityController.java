package com.hotelbooking.hotel.controller;

import com.hotelbooking.common.dto.resource.AmenityDto;
import com.hotelbooking.hotel.service.AmenityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("amenities")
public class AmenityController {

  private final AmenityService amenityService;

  public AmenityController(AmenityService amenityService) {
    this.amenityService = amenityService;
  }

  @GetMapping
  public ResponseEntity<List<AmenityDto>> getAmenities() {
    return ResponseEntity.ok().body(amenityService.getAmenities());
  }

  @PostMapping
  public ResponseEntity<AmenityDto> createAmenity(@RequestBody AmenityDto amenityDto) {
    return ResponseEntity.ok().body(amenityService.createAmenity(amenityDto));
  }

}
