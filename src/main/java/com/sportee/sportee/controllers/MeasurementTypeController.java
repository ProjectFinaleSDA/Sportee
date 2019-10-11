package com.sportee.sportee.controllers;

import com.sportee.sportee.services.MeasurementTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;

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

    @GetMapping("/measurementTypes/insertMeasurementType")
    public String insertMeasurementType() {
        return "insertMeasurementType";

    }

    @PostMapping("/measurementTypes/insertMeasurementType")
    public ModelAndView insertMeasurementType(String name, String unit) {
        measurementTypeService.insertMeasurementType(name, unit);
        return showAllMeasurementTypes();
    }

    @RequestMapping("/measurementTypes/{id}/delete")
    public ModelAndView deleteMeasurementType(@PathVariable Integer id) {
        measurementTypeService.deleteMeasurementType(id);
        return showAllMeasurementTypes();

    }
}
