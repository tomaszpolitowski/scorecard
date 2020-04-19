package com.phonak.scorecard.api;

import com.phonak.scorecard.model.User;
import com.phonak.scorecard.security.PasswordConfig;
import com.phonak.scorecard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    private final UserService userService;
   @Autowired
    public UserController(UserService userService) {
        this.userService = userService;

}

    @RequestMapping(value = "/registerForm", method = RequestMethod.GET)
    public String getRegisterForm(Model model){
    model.addAttribute("newUser", new User());
    return "registerForm";}



    @RequestMapping(value="/add-newUser", method=RequestMethod.POST)
    public String addUser(@ModelAttribute("newUser") User newUser){
        System.out.println(newUser.toString());
    userService.insertUser(newUser);
    return "hello";}
}
