package com.sportee.sportee.data.repositories;

import com.sportee.sportee.data.DAO.GymClass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface GymClassRepository extends CrudRepository<GymClass, Integer> {

    List<GymClass> findAllGymClassByDate(Date date);
}
