package com.sportee.sportee.controllers;

import com.sportee.sportee.services.GymClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GymClassController {
    private GymClassService gymClassService;

    @Autowired
    public GymClassController(GymClassService gymClassService) {
        this.gymClassService = gymClassService;
    }

    @GetMapping({"/gymClasses/showAll", "/"})
    public ModelAndView showAllGymClasses() {
        ModelAndView mv = new ModelAndView("gymClasses");
        mv.addObject("gymClasses", gymClassService.getAllGymClasses());
        return mv;
    }
}
