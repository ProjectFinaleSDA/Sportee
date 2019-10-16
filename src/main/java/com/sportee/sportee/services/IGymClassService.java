package com.sportee.sportee.services;

import com.sportee.sportee.data.DAO.GymClassType;
import com.sportee.sportee.data.DAO.Room;
import com.sportee.sportee.data.DTO.GymClassDTO;
import com.sportee.sportee.data.DTO.GymClassTypeDTO;

import java.sql.Date;
import java.util.List;

public interface IGymClassService {
    List<GymClassDTO> getAllGymClasses();

    List<GymClassDTO> getAllGymClassesForSchedule(Date date);

    void insertGymClass(Date date, int startHour, int gymClassTypeId, int roomId);

    void deleteGymClass(Integer id);


}
