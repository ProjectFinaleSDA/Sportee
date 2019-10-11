package com.sportee.sportee.data.DAO;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

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
    private MeasurementType measurementType;

    @ManyToOne
    @JoinColumn(name="member_id")
    private SporteeMember sporteeMember;

    @Builder
    public Measurement(Date date, int value, MeasurementType measurementType, SporteeMember sporteeMember) {
        this.date = date;
        this.value = value;
        this.measurementType = measurementType;
        this.sporteeMember = sporteeMember;
    }
}
