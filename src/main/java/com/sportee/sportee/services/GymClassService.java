package com.sportee.sportee.services;

import com.sportee.sportee.data.DAO.GymClass;
import com.sportee.sportee.data.DAO.GymClassType;
import com.sportee.sportee.data.DAO.Room;
import com.sportee.sportee.data.DAO.StartHour;
import com.sportee.sportee.data.DTO.GymClassDTO;
import com.sportee.sportee.data.repositories.GymClassRepository;
import com.sportee.sportee.data.repositories.GymClassTypeRepository;
import com.sportee.sportee.data.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GymClassService implements IGymClassService {
    private GymClassRepository gymClassRepository;
    private RoomRepository roomRepository;
    private GymClassTypeRepository gymClassTypeRepository;


    @Autowired
    public GymClassService(GymClassRepository gymClassRepository, RoomRepository roomRepository, GymClassTypeRepository gymClassTypeRepository) {
        this.gymClassRepository = gymClassRepository;
        this.roomRepository = roomRepository;
        this.gymClassTypeRepository = gymClassTypeRepository;

    }

    @Override
    public List<GymClassDTO> getAllGymClasses() {
        List<GymClassDTO> gymClasses = new ArrayList<GymClassDTO>();
        Iterable<GymClass> all = gymClassRepository.findAll();
        all.forEach(g -> gymClasses.add(new GymClassDTO(g)));
        return gymClasses;
    }

//    @Override
//    public List<HourDTO> getAllGymClassesByHours(ArrayList<Date> week) {
//
//        List<HourDTO> hourSchedule = new ArrayList<HourDTO>();
//        for (Date date : week) {
//            Iterable<GymClass> all = gymClassRepository.findAllGymClassByDate(date);
//            for (GymClass g : all) {
//                for (int i = 9; i <= 20; i++) {
//                    if (g.getStartHour() == i) {
//                        hourSchedule.add(new HourDTO(g));
//                    } else{
//                        hourSchedule.add(new HourDTO());
//                    }
//                }
//            }
//
//        }
//            return hourSchedule;
//    }
//    @Override
//    public List<GymClassDTO> getAllGymClassesForSchedule(ArrayList<Date> week) {
//        List<GymClassDTO> weekSchedule = new ArrayList<GymClassDTO>();
//for (Date date: week){
//        Iterable<GymClass> all = gymClassRepository.findAllGymClassByDate(date);
//        all.forEach(
//                g -> weekSchedule.add(new GymClassDTO(g)));}
//        return weekSchedule;
//    }







    @Override
    public void insertGymClass(Date date, StartHour startHour, int gymClassTypeId, int roomId) {
        Optional<GymClassType> gymClassType = gymClassTypeRepository.findById(gymClassTypeId);
        Optional<Room> room = roomRepository.findById(roomId);
        gymClassType.ifPresent(g -> {
            room.ifPresent(r -> {
                GymClass m = GymClass.builder().date(date).startHour(startHour)
                        .gymClassType(g).room(r).build();

                gymClassRepository.save(m);


            });
        });
    }

    @Override
    public void deleteGymClass(Integer id) {
        gymClassRepository.deleteById(id);
    }
}
