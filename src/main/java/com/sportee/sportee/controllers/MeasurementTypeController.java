package com.sportee.sportee.controllers;

import com.sportee.sportee.services.MeasurementTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MeasurementTypeController {
    private MeasurementTypeService measurementTypeService;

    @Autowired
    public MeasurementTypeController(MeasurementTypeService measurementTypeService) {
        this.measurementTypeService = measurementTypeService;
    }

    @GetMapping({"/measurementTypes/showAll", "/"})
    public ModelAndView showAllMeasurementTypes() {
        ModelAndView mv = new ModelAndView("measurementTypes");
        mv.addObject("measurementTypes", measurementTypeService.getAllMeasurementTypes());
        return mv;
    }
}
