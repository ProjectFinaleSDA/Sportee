package com.sportee.sportee.controllers;

import com.sportee.sportee.services.MemberService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping({"/members/showAll", "/"})
    public ModelAndView showAllMembers() {
        ModelAndView mv = new ModelAndView("members");
        mv.addObject("members", memberService.getAllMembers());
        return mv;
    }
}
