package com.hotelbooking.hotel.controller;

import com.hotelbooking.common.dto.hotel.RoomDto;
import com.hotelbooking.common.dto.hotel.RoomFilterDto;
import com.hotelbooking.hotel.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rooms")
public class RoomController {

  private final RoomService roomService;

  public RoomController(RoomService roomService) {
    this.roomService = roomService;
  }

  @GetMapping
  public ResponseEntity<List<RoomDto>> getRooms(RoomFilterDto roomFilterDto) {
    return ResponseEntity.ok().body(roomService.getRooms(roomFilterDto));
  }

  @PostMapping
  public ResponseEntity<RoomDto> createRoom(@RequestBody RoomDto roomDto) {
    return ResponseEntity.ok().body(roomService.createRoom(roomDto));
  }

  @PutMapping("{roomId}")
  public ResponseEntity<RoomDto> updateRoom(@PathVariable Long roomId, @RequestBody RoomDto roomDto) {
    return ResponseEntity.ok().body(roomService.updateRoom(roomId, roomDto));
  }

}
