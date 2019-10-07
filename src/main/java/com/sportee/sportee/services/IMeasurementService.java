package com.sportee.sportee.services;

import com.sportee.sportee.data.DTO.MeasurementDTO;
import com.sportee.sportee.data.DTO.MeasurementTypeDTO;

import java.util.List;

public interface IMeasurementService {

    List<MeasurementDTO> getAllMeasurements();
}
