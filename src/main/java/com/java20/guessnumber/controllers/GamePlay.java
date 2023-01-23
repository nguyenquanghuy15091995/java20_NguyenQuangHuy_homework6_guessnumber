package com.java20.guessnumber.controllers;

import com.java20.models.GameData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("/")
public class GamePlay {

    private GameData gameData = new GameData();

    @GetMapping("")
    public String gamePlay(Model model) {
        model.addAttribute("gameData", gameData);
        return "index";
    }

    @PostMapping("/api/bingo/{guessTimes}")
    public String bingo(@PathVariable int guessTimes) {
        this.gameData.randomNewNumber();
        this.gameData.getMemories().add(guessTimes);
        return "";
    }
}
