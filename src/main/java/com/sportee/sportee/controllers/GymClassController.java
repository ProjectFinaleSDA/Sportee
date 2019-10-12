package com.sportee.sportee.controllers;

import com.sportee.sportee.services.GymClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;


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

    @GetMapping("/gymClasses/insertGymClass")
    public String insertGymClass() {
        return "insertGymClass";

    }

    @PostMapping("/gymClasses/insertGymClass")
    public ModelAndView insertGymClass(Date date, int startHour, int gymClassType, int room ) {
        gymClassService.insertGymClass(date, startHour, gymClassType,room);
        return showAllGymClasses();
    }

    @RequestMapping("/gymClasses/{id}/delete")
    public ModelAndView deleteGymClass(@PathVariable Integer id) {
        gymClassService.deleteGymClass(id);
        return showAllGymClasses();

    }
}
