package com.sportee.sportee.controllers;

import com.sportee.sportee.services.MemberService;
import com.sportee.sportee.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class UserController {
    private UserService userService;
    private MemberService memberService;

    @Autowired
    public UserController(UserService userService, MemberService memberService) {
        this.userService = userService;
        this.memberService = memberService;
    }


//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String showRegistrationForm(WebRequest request, Model model) {
//        UserDTO userDTO = new UserDTO();
//        model.addAttribute("user", userDTO);
//        return "login";
//    }

    @RequestMapping({"/user/showAll", "/"})
    public ModelAndView showAllUsers() {
        ModelAndView mv = new ModelAndView("users");
        mv.addObject("users", userService.getAllUsers());
        return mv;
    }

    @GetMapping("/user/insert")
    public String insertUser() {
        return "insertUser";

    }

    @RequestMapping({"/member/insertMember", "/"})
    public ModelAndView insertMemberDetails() {
        ModelAndView mv = new ModelAndView("insertMember");
                return mv;
    }

    @PostMapping("/user/insert")
    public ModelAndView insertUser(String name,  String password) {
        userService.insertUser(name, password);
        return insertMemberDetails();


    }

    @RequestMapping("/user/{id}/delete")
    public ModelAndView deleteUser(@PathVariable Integer id) {
        userService.delete(id);
        return showAllUsers();

    }
}
