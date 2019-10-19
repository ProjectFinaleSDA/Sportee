package com.sportee.sportee.services;

import com.sportee.sportee.data.DTO.GymClassDTO;
import com.sportee.sportee.data.DTO.HourDTO;


import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

public interface IGymClassService {
    List<GymClassDTO> getAllGymClasses();

//    List<GymClassDTO> getAllGymClassesForSchedule(ArrayList<Date> week);
//    List<HourDTO> getAllGymClassesByHours(ArrayList<Date> week);

    void insertGymClass(LocalDateTime date, int gymClassTypeId, int roomId);

    void deleteGymClass(Integer id);

    HourDTO[] getTimetable();


}
