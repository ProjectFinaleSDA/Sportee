package com.sportee.sportee.controllers;

import com.sportee.sportee.services.StartHourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StartHourController {

    private StartHourService startHourService;

    @Autowired
    public StartHourController(StartHourService startHourService) {
        this.startHourService = startHourService;
    }

    @GetMapping({"/dailyTimetable"})
    public ModelAndView showAll() {
        ModelAndView mv = new ModelAndView("dailyTimetable");
        mv.addObject("dailyTimetable", startHourService.getAllStartHours());
        return mv;
    }
}
