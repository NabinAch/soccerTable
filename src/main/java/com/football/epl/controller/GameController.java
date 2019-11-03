package com.football.epl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.football.epl.model.Game;
import com.football.epl.service.GameService;

@RestController
@RequestMapping("/game")
public class GameController {
	
	@Autowired
	GameService gameService;
	
	@PostMapping
	public Game addResult(@RequestBody Game game) {
		return gameService.addResult(game);
	}

}
