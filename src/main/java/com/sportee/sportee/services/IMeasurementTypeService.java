package com.sportee.sportee.services;

import com.sportee.sportee.data.DTO.MeasurementTypeDTO;

import java.sql.Date;
import java.util.List;

public interface IMeasurementTypeService {
    List<MeasurementTypeDTO> getAllMeasurementTypes();

    void insertMeasurementType(String name, String unit);

    void deleteMeasurementType(Integer id);
}
