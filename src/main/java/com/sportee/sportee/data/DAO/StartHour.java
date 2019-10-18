package com.sportee.sportee.data.DAO;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@NoArgsConstructor
public class StartHour {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Id
    private int id;
    private String name;


    @OneToMany(mappedBy = "startHour")
    private List<GymClass> gymClasses;

    @Builder
    public StartHour(String name, List<GymClass> gymClasses) {
        this.name = name;
        this.gymClasses = gymClasses;
    }
}
