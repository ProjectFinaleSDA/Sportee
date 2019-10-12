package com.sportee.sportee.controllers;

import com.sportee.sportee.services.GymClassTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GymClassTypeController {

    private GymClassTypeService gymClassTypeService;

    @Autowired
    public GymClassTypeController(GymClassTypeService gymClassTypeService) {
        this.gymClassTypeService = gymClassTypeService;
    }

    @GetMapping({"/gymClassTypes/showAll", "/"})
    public ModelAndView showAllGymClassTypes() {
        ModelAndView mv = new ModelAndView("gymClassTypes");
        mv.addObject("gymClassTypes", gymClassTypeService.getAllGymClassTypes());
        return mv;
    }

//    @GetMapping("/measurementTypes/insertMeasurementType")
//    public String insertMeasurementType() {
//        return "insertMeasurementType";
//
//    }
//
//    @PostMapping("/measurementTypes/insertMeasurementType")
//    public ModelAndView insertMeasurementType(String name, String unit) {
//        measurementTypeService.insertMeasurementType(name, unit);
//        return showAllMeasurementTypes();
//    }
//
//    @RequestMapping("/measurementTypes/{id}/delete")
//    public ModelAndView deleteMeasurementType(@PathVariable Integer id) {
//        measurementTypeService.deleteMeasurementType(id);
//        return showAllMeasurementTypes();
//
//    }
}
