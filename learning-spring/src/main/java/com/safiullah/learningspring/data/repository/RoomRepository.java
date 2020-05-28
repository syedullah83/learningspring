package com.safiullah.learningspring.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.safiullah.learningspring.data.entity.Room;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long>{

}
