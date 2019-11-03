package com.football.epl.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.football.epl.model.Game;
import com.football.epl.repository.GameRepository;

@Service
public class GameService {

	@Autowired
	GameRepository gameRepository;
	
	public Game addResult(Game game) {
		return gameRepository.save(game);
	}
	
	public ArrayList<Game> getAllResults(){
		return (ArrayList<Game>) gameRepository.findAll();
	}
}
