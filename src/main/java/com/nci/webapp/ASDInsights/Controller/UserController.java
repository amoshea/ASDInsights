package com.nci.webapp.ASDInsights.Controller;


import com.nci.webapp.ASDInsights.Model.UserDtls;
import com.nci.webapp.ASDInsights.Service.UserService;
import jakarta.servlet.http.HttpSession;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class  UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("userDtls", new UserDtls());
        mv.setViewName("/login");
        return mv;
    }
    @GetMapping("/register")
    public String register(){
        return "register";
    }


    @PostMapping("/createUser")
    public String createuser(@ModelAttribute UserDtls user, HttpSession session){

        System.out.println(user);

        boolean f= userService.checkUsername(user.getUsername());

        if(f){
            session.setAttribute("msg", "Username already exist!");
        } else {
            UserDtls userDtls=userService.createUser(user);
            if(userDtls!=null){
                session.setAttribute("msg", "Register Successful!");
                return "/login";
            }else{
                session.setAttribute("msg", "Sorry!!! Something wrong on server.");;
            }
        }
        return "redirect:/register";
    }


    @PostMapping("login")
    public ModelAndView logar(UserDtls userDtls, HttpSession session) throws NoSuchAlgorithmException{
        UserDtls userLogin = this.userService.loginUser(userDtls.getEmail(), userDtls.getPassword());
        String typeTeacher = "teacher_assistant";
        if(userLogin.getUserProfile().equalsIgnoreCase(typeTeacher)){
            ModelAndView mv = new ModelAndView("welcomeTeacher");
            mv.addObject("username", userLogin.getFName());
            session.setAttribute("userTeacherLoginSuccess", userLogin);
            return mv;
        }else{
            ModelAndView mv = new ModelAndView("welcomeDoctor");
            mv.addObject("username", userLogin.getFName());
            session.setAttribute("userDoctorLoginSuccess", userLogin);
            return mv;
        }
    }

    @GetMapping("/dash")
    public ModelAndView dash(){
        ModelAndView mv = new ModelAndView("Dashboard");
        return mv;
    }

 }
