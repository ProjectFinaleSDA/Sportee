package com.sportee.sportee.data.repositories;

import com.sportee.sportee.data.DAO.GymClass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymClassRepository extends CrudRepository<GymClass, Integer> {
}
