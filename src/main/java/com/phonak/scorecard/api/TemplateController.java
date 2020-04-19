package com.phonak.scorecard.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")

public class TemplateController {

    @GetMapping("login")
    public String getLoginView(){return "login";}



    @GetMapping("hello")
    public String getHello(Model model){
        model.addAttribute("loggedInUsername","tom");
        return "hello";}

    @GetMapping("/")
    public String getHello(){

        return "loginRegisterForm";}
}
