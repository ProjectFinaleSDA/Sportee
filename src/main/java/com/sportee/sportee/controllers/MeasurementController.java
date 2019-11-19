package com.sportee.sportee.controllers;

import com.sportee.sportee.data.DAO.MeasurementType;
import com.sportee.sportee.data.DAO.SporteeMember;
import com.sportee.sportee.services.MeasurementService;
import com.sportee.sportee.services.MeasurementTypeService;
import com.sportee.sportee.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.Optional;

@Controller
public class MeasurementController {

    private MeasurementService measurementService;
    private MemberService memberService;
    private MeasurementTypeService measurementTypeService;

    @Autowired
    public MeasurementController(MeasurementService measurementService, MemberService memberService, MeasurementTypeService measurementTypeService) {
        this.measurementService = measurementService;
        this.memberService = memberService;
        this.measurementTypeService = measurementTypeService;
    }

    @GetMapping({"/measurements/showAll"})
    public ModelAndView showAllMeasurements() {
        ModelAndView mv = new ModelAndView("measurements");
        mv.addObject("measurements", measurementService.getAllMeasurements());
        return mv;
    }

    @GetMapping("/measurements/insertMeasurement")
    public ModelAndView insertMeasurement() {
        ModelAndView mv = new ModelAndView("insertMeasurement");
        mv.addObject("members", memberService.getAllMembers());
        mv.addObject("measurementTypes", measurementTypeService.getAllMeasurementTypes());

        mv.addObject("selectedMember", "");
        mv.addObject("selectedMeasurementType", "");
        return mv;
    }

    @PostMapping("/measurements/insertMeasurement")
    public ModelAndView insertMeasurement(Date date, int value, int measurementType, int sporteeMember) {
//        System.out.println(sporteeMember);
        measurementService.insertMeasurement(date, value, measurementType, sporteeMember);
        return showAllMeasurements();
    }

    @RequestMapping("/measurements/{id}/delete")
    public ModelAndView deleteMeasurement(@PathVariable Integer id) {
        measurementService.deleteMeasurement(id);
        return showAllMeasurements();

    }

    @GetMapping("/measurements/{id}/editMeasurement")
    public ModelAndView editMeasurement() {
        ModelAndView mv = new ModelAndView("editMeasurement");
        mv.addObject("members", memberService.getAllMembers());
        mv.addObject("measurementTypes", measurementTypeService.getAllMeasurementTypes());

        mv.addObject("selectedMember", "");
        mv.addObject("selectedMeasurementType", "");
        return mv;

    }

    @PostMapping("/measurements/{id}/editMeasurement")
    public ModelAndView editMeasurement(@PathVariable Integer id, Optional<Date> date, Optional<Integer> value, Optional<MeasurementType> measurementType, Optional<SporteeMember> sporteeMember) {
        measurementService.editMeasurement(id, date, value, measurementType, sporteeMember);
        return showAllMeasurements();
    }


}
