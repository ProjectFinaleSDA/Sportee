package com.sportee.sportee.data.DTO;

import com.sportee.sportee.data.DAO.Measurement;
import com.sportee.sportee.data.DAO.MeasurementType;
import com.sportee.sportee.data.DAO.SporteeMember;
import lombok.Getter;

import java.sql.Date;

@Getter
public class MeasurementDTO {
    private int id;

    private Date date;
    private int value;

    private String measurementType;
    private String unit;
    private String sporteeMember;

    public MeasurementDTO(Measurement measurement) {
        this.date = measurement.getDate();
        this.value = measurement.getValue();
        this.unit = measurement.getMeasurementType().getUnit();
        this.measurementType = measurement.getMeasurementType().getName();
        this.sporteeMember = measurement.getSporteeMember().getFirstName()+" "+measurement.getSporteeMember().getLastName();
    }
}
