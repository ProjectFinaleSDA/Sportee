package com.sportee.sportee.services;

import com.sportee.sportee.data.DAO.Measurement;
import com.sportee.sportee.data.DAO.MeasurementType;
import com.sportee.sportee.data.DTO.MeasurementDTO;
import com.sportee.sportee.data.DTO.MeasurementTypeDTO;
import com.sportee.sportee.data.repositories.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MeasurementService implements IMeasurementService {
    private MeasurementRepository measurementRepository;

    @Autowired
    public MeasurementService(MeasurementRepository measurementRepository) {
        this.measurementRepository = measurementRepository;
    }

    @Override
    public List<MeasurementDTO> getAllMeasurements() {
        List<MeasurementDTO> measurementTypes = new ArrayList<MeasurementDTO>();
        Iterable<Measurement> all = measurementRepository.findAll();
        all.forEach(m -> measurementTypes.add(new MeasurementDTO(m)));
        return measurementTypes;
    }
}
