package com.sportee.sportee.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/home","/"})
    public String home()
    {
        return "home";
    }

    @GetMapping({"/gym"})
    public String gym()
    {
        return "gym";
    }

    @GetMapping({"/trainers"})
    public String trainers()
    {
        return "trainers";
    }

    @GetMapping({"/schedule"})
    public String schedule()
    {
        return "schedule";
    }

    @GetMapping({"/contact"})
    public String contact()
    {
        return "contact";
    }


    @GetMapping({"/membership"})
    public String login()
    {
        return "membership";
    }



}
