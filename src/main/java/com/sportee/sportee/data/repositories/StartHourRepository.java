package com.sportee.sportee.data.repositories;

import com.sportee.sportee.data.DAO.StartHour;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StartHourRepository extends CrudRepository<StartHour, Integer> {
}
