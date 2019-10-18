package com.sportee.sportee.services;

import com.sportee.sportee.data.DAO.GymClassType;
import com.sportee.sportee.data.DAO.Room;
import com.sportee.sportee.data.DAO.StartHour;
import com.sportee.sportee.data.DTO.GymClassDTO;
import com.sportee.sportee.data.DTO.GymClassTypeDTO;
import com.sportee.sportee.data.DTO.StartHourDTO;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public interface IGymClassService {
    List<GymClassDTO> getAllGymClasses();

//    List<GymClassDTO> getAllGymClassesForSchedule(ArrayList<Date> week);
//    List<HourDTO> getAllGymClassesByHours(ArrayList<Date> week);

    void insertGymClass(Date date, StartHour startHour, int gymClassTypeId, int roomId);

    void deleteGymClass(Integer id);


}
