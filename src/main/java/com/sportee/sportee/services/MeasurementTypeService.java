package com.sportee.sportee.services;

import com.sportee.sportee.data.DAO.MeasurementType;
import com.sportee.sportee.data.DAO.SporteeMember;
import com.sportee.sportee.data.DTO.MeasurementTypeDTO;
import com.sportee.sportee.data.DTO.MemberDTO;
import com.sportee.sportee.data.repositories.MeasurementTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MeasurementTypeService implements IMeasurementTypeService {

    private MeasurementTypeRepository measurementTypeRepository;

    @Autowired
    public MeasurementTypeService(MeasurementTypeRepository measurementTypeRepository) {
        this.measurementTypeRepository = measurementTypeRepository;



    }


    @Override
    public List<MeasurementTypeDTO> getAllMeasurementTypes() {
        List<MeasurementTypeDTO> measurementTypes = new ArrayList<MeasurementTypeDTO>();
        Iterable<MeasurementType> all = measurementTypeRepository.findAll();
        all.forEach(m -> measurementTypes.add(new MeasurementTypeDTO(m)));
        return measurementTypes;
    }

    @Override
    public void insertMeasurementType(String name, String unit) {
        MeasurementType m = MeasurementType.builder().name(name).unit(unit).build();
        measurementTypeRepository.save(m);
    }

    @Override
    public void deleteMeasurementType(Integer id) {
        measurementTypeRepository.deleteById(id);
    }
}
