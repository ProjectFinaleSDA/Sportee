package com.sportee.sportee.services;

import com.sportee.sportee.data.DAO.Room;
import com.sportee.sportee.data.DAO.StartHour;
import com.sportee.sportee.data.DTO.RoomDTO;
import com.sportee.sportee.data.DTO.StartHourDTO;
import com.sportee.sportee.data.repositories.StartHourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class StartHourService implements IStartHourService {

    private StartHourRepository startHourRepository;

    @Autowired
    public StartHourService(StartHourRepository startHourRepository) {
        this.startHourRepository = startHourRepository;
    }


    @Override
    public List<StartHourDTO> getAllStartHours() {
        List<StartHourDTO> startHourDTOS = new ArrayList<StartHourDTO>();
        Iterable<StartHour> all = startHourRepository.findAll();
        all.forEach(s -> startHourDTOS.add(new StartHourDTO(s)));
        return startHourDTOS;
    }




}
