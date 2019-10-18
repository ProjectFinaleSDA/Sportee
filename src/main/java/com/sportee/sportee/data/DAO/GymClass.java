package com.sportee.sportee.data.DAO;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@NoArgsConstructor
public class GymClass {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Id
    private int id;
    private Date date;


    @ManyToOne
    @JoinColumn(name = "gym_class_type_id")
    private GymClassType gymClassType;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "start_hour_id")
    private StartHour startHour;

    @ManyToMany(mappedBy = "gymClass")
    List<SporteeMember> sporteeMember;

    @Builder
    public GymClass(Date date, StartHour startHour, GymClassType gymClassType, Room room) {
        this.date = date;
        this.startHour = startHour;
        this.gymClassType = gymClassType;
        this.room = room;
    }


}
