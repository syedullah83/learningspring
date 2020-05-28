package com.safiullah.learningspring.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Reservation extends CrudRepository<Reservation, Long>{
	
}
