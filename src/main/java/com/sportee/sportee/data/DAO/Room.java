package com.sportee.sportee.data.DAO;



import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@NoArgsConstructor

public class Room {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Id
    private int id;
    private String name;
    private int capacity;


    @OneToOne(mappedBy = "room")
    private GymClass gymClass;


}