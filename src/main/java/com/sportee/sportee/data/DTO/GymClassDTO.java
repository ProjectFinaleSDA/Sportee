package com.sportee.sportee.data.DTO;

import com.sportee.sportee.data.DAO.GymClass;
import com.sportee.sportee.data.DAO.GymClassType;
import com.sportee.sportee.data.DAO.Room;
import com.sportee.sportee.data.DAO.StartHour;
import lombok.Getter;

import java.sql.Date;

@Getter
public class GymClassDTO {


    private Date date;
    private String startHour;
    private String gymClassType;
    private String room;

    public GymClassDTO(GymClass gymClass) {
        this.date = gymClass.getDate();
        this.startHour = gymClass.getStartHour().getName();
        this.gymClassType = gymClass.getGymClassType().getName();
        this.room = gymClass.getRoom().getName();
    }


}
