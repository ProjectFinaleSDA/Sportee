package com.sportee.sportee.data.repositories;

import com.sportee.sportee.data.DAO.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Integer> {
}
