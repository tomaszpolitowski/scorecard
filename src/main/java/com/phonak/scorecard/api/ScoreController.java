package com.phonak.scorecard.api;


import com.phonak.scorecard.model.Score;
import com.phonak.scorecard.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@RequestMapping
@Controller
public class ScoreController {
    private final ScoreService scoreService;


    @Autowired
    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @RequestMapping(value = "/scorecard", method = RequestMethod.GET)
        public String getAllScore(Model model) {
        List<Score> scores = scoreService.getAllScoreByUsername(getoggedInUsername());
        model.addAttribute("scores", scores);
        model.addAttribute("loggedInUsername", getoggedInUsername());
        model.addAttribute("scorek", new Score());

        return "scorecard";
    }



    @RequestMapping(value = "/add-score", method=RequestMethod.POST)
    public String addScore(@ModelAttribute("scorek") @Valid Score scorek, BindingResult result) {
        if (result.hasErrors()){
            return "scorecard";}
        scorek.setUsername(getoggedInUsername());
        scoreService.insertScore(scorek);
        return "redirect:/scorecard";
    }


    private String getoggedInUsername() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ((UserDetails) principal).getUsername();
    }
//    @GetMapping("{loggedInUsername}")
//    public Score selectScore(@PathVariable("loggedInUsername") String loggedInUsername) {
//        return scoreService.selectScore(loggedInUsername).orElse(null);
//    }

//    @PutMapping("{loggedInUsername}")
//    public int updateScore(@PathVariable("loggedInUsername") String loggedInUsername, @RequestBody Score score) {
//        return scoreService.updateScore(loggedInUsername, score);
//    }


}
