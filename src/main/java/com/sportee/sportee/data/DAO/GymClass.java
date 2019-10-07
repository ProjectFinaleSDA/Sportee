package com.sportee.sportee.data.DAO;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
    private int startHour;

    @ManyToOne
    @JoinColumn(name = "gym_class_type_id")
    private GymClassType gymClassType;

    @OneToOne
    @JoinColumn(name = "room_id")
    private Room room;





}
