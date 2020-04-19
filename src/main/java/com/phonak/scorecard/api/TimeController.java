package com.phonak.scorecard.api;

import com.phonak.scorecard.model.Time;
import com.phonak.scorecard.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping
@Controller
public class TimeController {
    private final TimeService timeService;
@Autowired
    public TimeController(TimeService timeService) {
        this.timeService = timeService;
    }
    @RequestMapping(value="/addTime",method = RequestMethod.GET)
    public String getTimeForm(Model model){
    model.addAttribute("timek", new Time());
    return "addTime";}

    @RequestMapping(value="/add-time", method = RequestMethod.POST)
public String addTime(@ModelAttribute("timek") Time time){
    timeService.addTime(time);
    return "redirect:/addTime";}
}
