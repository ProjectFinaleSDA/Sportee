package com.sportee.sportee.controllers;

import com.sportee.sportee.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;

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



    @GetMapping("/members/insertMember")
    public String insertMember() {
        return "insertMember";

    }

    @PostMapping("/members/insertMember")
    public ModelAndView insertMember(String firstName, String lastName, /*@DateTimeFormat(pattern = "yyyy-MM-dd")*/
            Date birthDate, int height, int role) {
        memberService.insertMember(firstName, lastName, birthDate, height, role);
        return showAllMembers();
    }

    @RequestMapping("/members/{id}/delete")
    public ModelAndView deleteUser(@PathVariable Integer id) {
        memberService.deleteMember(id);
        return showAllMembers();

    }
}
