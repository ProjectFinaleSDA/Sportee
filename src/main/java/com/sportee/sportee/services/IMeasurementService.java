package com.sportee.sportee.services;

import com.sportee.sportee.data.DAO.MeasurementType;
import com.sportee.sportee.data.DAO.SporteeMember;
import com.sportee.sportee.data.DTO.MeasurementDTO;
import com.sportee.sportee.data.DTO.MeasurementTypeDTO;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface IMeasurementService {

    List<MeasurementDTO> getAllMeasurements();

    void insertMeasurement(Date date, int value, int measurementTypeId, int sporteeMemberId);

    void deleteMeasurement(Integer id);

    void editMeasurement(Integer id, Optional<Date> date, Optional<Integer> value, Optional<MeasurementType> measurementType, Optional<SporteeMember> sporteeMember);
}
