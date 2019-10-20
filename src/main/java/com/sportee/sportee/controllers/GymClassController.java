package com.sportee.sportee.controllers;

import com.sportee.sportee.services.GymClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;


@Controller
public class GymClassController {
    private GymClassService gymClassService;

    @Autowired
    public GymClassController(GymClassService gymClassService) {
        this.gymClassService = gymClassService;
    }

   @GetMapping({"/gymClasses/showAll"})
    public ModelAndView showAllGymClasses() {
        ModelAndView mv = new ModelAndView("gymClasses");
        mv.addObject("gymClasses", gymClassService.getAllGymClasses());
        return mv;
    }


    @GetMapping({"/timetable"})
    public ModelAndView showTimetable() {
        ModelAndView mv = new ModelAndView("timetable");
        mv.addObject("timetable", gymClassService.getTimetable());
        return mv;
    }

    @GetMapping("/gymClasses/insertGymClass")
    public String insertGymClass() {
        return "insertGymClass";

    }

    @PostMapping("/gymClasses/insertGymClass" )

    public ModelAndView insertGymClass(@RequestParam(value="date")
                                           @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,

                                       @RequestParam(value="time")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime time, int gymClassType, int room ) {

        LocalDateTime dateTime = LocalDateTime.of(date, time);
        gymClassService.insertGymClass(dateTime, gymClassType,room);
        return showAllGymClasses();
    }

    @RequestMapping("/gymClasses/{id}/delete")
    public ModelAndView deleteGymClass(@PathVariable Integer id) {
        gymClassService.deleteGymClass(id);
        return showAllGymClasses();

    }



}
