package com.sportee.sportee.services;

import com.sportee.sportee.data.DAO.StartHour;
import com.sportee.sportee.data.DTO.RoomDTO;
import com.sportee.sportee.data.DTO.StartHourDTO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public interface IStartHourService {

    List<StartHourDTO> getAllStartHours();


}
