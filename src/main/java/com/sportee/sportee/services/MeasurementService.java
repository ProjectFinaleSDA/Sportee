package com.sportee.sportee.services;

import com.sportee.sportee.data.DAO.Measurement;
import com.sportee.sportee.data.DAO.MeasurementType;
import com.sportee.sportee.data.DAO.Role;
import com.sportee.sportee.data.DAO.SporteeMember;
import com.sportee.sportee.data.DTO.MeasurementDTO;
import com.sportee.sportee.data.repositories.MeasurementRepository;
import com.sportee.sportee.data.repositories.MeasurementTypeRepository;
import com.sportee.sportee.data.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MeasurementService implements IMeasurementService {
    private MeasurementRepository measurementRepository;
    private MeasurementTypeRepository measurementTypeRepository;
    private MemberRepository memberRepository;

    @Autowired
    public MeasurementService(MeasurementRepository measurementRepository,
                              MeasurementTypeRepository measurementTypeRepository, MemberRepository memberRepository) {
        this.measurementRepository = measurementRepository;
        this.measurementTypeRepository = measurementTypeRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    public List<MeasurementDTO> getAllMeasurements() {
        List<MeasurementDTO> measurementTypes = new ArrayList<MeasurementDTO>();
        Iterable<Measurement> all = measurementRepository.findAll();
        all.forEach(m -> measurementTypes.add(new MeasurementDTO(m)));
        return measurementTypes;
    }

    @Override
    public void insertMeasurement(Date date, int value, int measurementTypeId, int sporteeMemberId) {
        Optional<MeasurementType> measurementType = measurementTypeRepository.findById(measurementTypeId);
        Optional<SporteeMember> sporteeMember = memberRepository.findById(sporteeMemberId);
        measurementType.ifPresent(t -> {
//            sporteeMember.ifPresent(s -> {
                Measurement m = Measurement.builder().date(date).value(value)
                        .measurementType(t).sporteeMember(sporteeMember.get()).build();

                measurementRepository.save(m);


//            });
        });
    }

    @Override
    public void deleteMeasurement(Integer id){
        measurementRepository.deleteById(id);
    }
}
