package com.sportee.sportee.controllers;

import com.sportee.sportee.data.DAO.SporteeMember;
import com.sportee.sportee.services.MeasurementService;
import com.sportee.sportee.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;

@Controller
public class MeasurementController {

    private MeasurementService measurementService;
    private MemberService memberService;

    @Autowired
    public MeasurementController(MeasurementService measurementService, MemberService memberService) {
        this.measurementService = measurementService;
        this.memberService = memberService;
    }

    @GetMapping({"/measurements/showAll", "/"})
    public ModelAndView showAllMeasurements() {
        ModelAndView mv = new ModelAndView("measurements");
        mv.addObject("measurements", measurementService.getAllMeasurements());
        return mv;
    }

    @GetMapping("/measurements/insertMeasurement")
    public ModelAndView insertMeasurement() {
        ModelAndView mv = new ModelAndView("insertMeasurement");
        mv.addObject("members", memberService.getAllMembers());
        mv.addObject("selectedMember", "");
        return mv;
    }

    @PostMapping("/measurements/insertMeasurement")
    public ModelAndView insertMeasurement(Date date, int value, int measurementType, String member) {
        System.out.println(member);
        //measurementService.insertMeasurement(date, value, measurementType, member.getId());
        return showAllMeasurements();
    }

    @RequestMapping("/measurements/{id}/delete")
    public ModelAndView deleteMeasurement(@PathVariable Integer id) {
        measurementService.deleteMeasurement(id);
        return showAllMeasurements();

    }
}
