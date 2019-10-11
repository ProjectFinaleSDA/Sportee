package com.sportee.sportee.controllers;

import com.sportee.sportee.services.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;

@Controller
public class MeasurementController {

    private MeasurementService measurementService;

    @Autowired
    public MeasurementController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @GetMapping({"/measurements/showAll", "/"})
    public ModelAndView showAllMeasurements() {
        ModelAndView mv = new ModelAndView("measurements");
        mv.addObject("measurements", measurementService.getAllMeasurements());
        return mv;
    }

    @GetMapping("/measurements/insertMeasurement")
    public String insertMeasurement() {
        return "insertMeasurement";

    }

    @PostMapping("/measurements/insertMeasurement")
    public ModelAndView insertMeasurement(Date date, int value, int measurementType, int member) {
        measurementService.insertMeasurement(date, value, measurementType, member);
        return showAllMeasurements();
    }

    @RequestMapping("/measurements/{id}/delete")
    public ModelAndView deleteMeasurement(@PathVariable Integer id) {
        measurementService.deleteMeasurement(id);
        return showAllMeasurements();

    }
}
