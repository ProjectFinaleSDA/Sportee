package com.sportee.sportee.services;

import com.sportee.sportee.data.DAO.GymClass;
import com.sportee.sportee.data.DAO.GymClassType;
import com.sportee.sportee.data.DTO.GymClassDTO;
import com.sportee.sportee.data.DTO.GymClassTypeDTO;
import com.sportee.sportee.data.repositories.GymClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class GymClassService implements IGymClassService {
    private GymClassRepository gymClassRepository;

    @Autowired
    public GymClassService(GymClassRepository gymClassRepository) {
        this.gymClassRepository = gymClassRepository;
    }

    @Override
    public List<GymClassDTO> getAllGymClasses() {
        List<GymClassDTO> gymClasses = new ArrayList<GymClassDTO>();
        Iterable<GymClass> all = gymClassRepository.findAll();
        all.forEach(g -> gymClasses.add(new GymClassDTO(g)));
        return gymClasses;
    }

    @Override
    public void insertGymClass(Date date, int startHour, int gymClassTypeId, int roomId) {

    }

    @Override
    public void deleteGymClass(Integer id) {

    }
}
