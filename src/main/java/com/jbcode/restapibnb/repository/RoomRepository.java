package com.jbcode.restapibnb.repository;

import com.jbcode.restapibnb.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Long> {

}
