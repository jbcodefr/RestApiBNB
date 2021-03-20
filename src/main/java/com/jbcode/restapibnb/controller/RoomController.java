package com.jbcode.restapibnb.controller;

import com.jbcode.restapibnb.entity.Room;
import com.jbcode.restapibnb.exception.ResourceNotFoundException;
import com.jbcode.restapibnb.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Room controller.
 */
@RestController
@RequestMapping("v1/rooms")
public class RoomController {

    //injection of Room repo..
    @Autowired
    private RoomRepository roomRepository;

    /**
     * Gets all rooms.
     *
     * @return the all rooms
     */
//get all rooms
    @GetMapping
    public List<Room> getAllRooms() {
        return this.roomRepository.findAll();
    }

    /**
     * Gets room by id.
     *
     * @param roomId the room id
     * @return the room by id
     */
//get all rooms by id
    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable(value = "id") long roomId) {
        return this.roomRepository.findById(roomId).orElseThrow(
                ()->new ResourceNotFoundException("Room not found with id : " +
                        ""+roomId)
        );
    }

    /**
     * Create room room.
     *
     * @param room the room
     * @return the room
     */
//create
    @PostMapping
    public Room createRoom(@RequestBody Room room){
        return this.roomRepository.save(room);
    }

    /**
     * Update room room.
     *
     * @param room   the room
     * @param roomId the room id
     * @return the room
     */
//Update
    @PutMapping("/{id}")
    public Room updateRoom(@RequestBody Room room,@PathVariable("id") Long roomId){
        Room isRoom = roomRepository.findById(roomId).orElseThrow(
                ()-> new ResourceNotFoundException("User not found with id :"+roomId));
        isRoom.setAddress(room.getAddress());
        isRoom.setSize(room.getSize());
        isRoom.setCity(room.getCity());
        isRoom.setPrice(room.getPrice());
        return this.roomRepository.save(isRoom);
    }

    /**
     * Delete roombyid response entity.
     *
     * @param roomId the room id
     * @return the response entity
     */
//Delete by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Room> deleteRoombyid(@PathVariable("id") Long roomId){
        Room isRoom =this.roomRepository.findById(roomId).orElseThrow(
                ()-> new ResourceNotFoundException("User not found with id :"+roomId));
        this.roomRepository.delete(isRoom);
        return ResponseEntity.ok().build();
    }

//    TODO: 20/03/2021
//    Delete by city
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Room> deleteRoombycity(@PathVariable("city") String city){
//        List<Room> isRoom;
//        return ResponseEntity.ok().build();
//    }



}
