package com.sportee.sportee.data.DAO;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@NoArgsConstructor
public class Measurement {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Id
    private int id;
    private Date date;
    private int value;


    @ManyToOne
    @JoinColumn(name="measurement_type_id")
    private Measurement measurement;

    @ManyToOne
    @JoinColumn(name="member_id")
    private SporteeMember sporteeMember;

}
