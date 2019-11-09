package com.football.epl.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.football.epl.model.Game;
import com.football.epl.model.Table;

@Service
public class TableService {
	
	@Autowired
	GameService gameService;

	public ArrayList<Table> getTable() {
		
		ArrayList<Game> results = gameService.getAllResults();
		
		
		
		return null;
	}
	
	public String findWinner(Game game) {
		if(game.getHomeScore() > game.getAwayScore()) 
		{
			return "home";
		}else if(game.getHomeScore() < game.getAwayScore()) 
		{
			return "away";
		}else 
		{
			return "draw";
		}
	}

	public ArrayList<Table> calculateTable(ArrayList<Table> table, Game game, String winner){
		if(winner.equals("home")) {
			
		}
		if(winner.equals("away")) {
			
		}
		if(winner.equals("draw")){
			
		}
	}
	
	public boolean alreadyInTable(ArrayList<Table> table, String team) {
		boolean status = false;
		for(Table t : table) {
			if(t.getTeam().equals(team)) {
				return true;
			}
		}
		return status;
	}
	
	public boolean addInTable(ArrayList<Table> table, Game game, String winner, String teamToAdd) {
		int homeInTable = findInTable(table, game.getHome());
		int awayInTable = findInTable(table, game.getAway());
		
		if(teamToAdd.equals("home")) 
		{
			Table homeTable = table.get(homeInTable);
			
			int newGamePlayed = homeTable.getGamePlayed() + 1;
			int newGoalFor = homeTable.getGoalFor() + game.getHomeScore();
			int newGoalAgainst = homeTable.getGoalAgainst() + game.getAwayScore();
			int newGoalDifference = newGoalFor - newGoalAgainst;
			
			homeTable.setGamePlayed(newGamePlayed);
			homeTable.setGoalFor(newGoalFor);
			homeTable.setGoalAgainst(newGoalAgainst);
			homeTable.setGoalDifference(newGoalDifference);
			
			if(winner.equals("home"))
			{
				int newPoint = homeTable.getPoint() + 3;	
				int newWin = homeTable.getWin() + 1;

				homeTable.setPoint(newPoint);
				homeTable.setWin(newWin);
			}
			if(winner.equals("away"))
			{
				int newLoss = homeTable.getLoss() + 1;
				homeTable.setLoss(newLoss);
			}
			if(winner.equals("draw")) 
			{
				int newHomeDraw = homeTable.getDraw() + 1;
				int newPoint = homeTable.getPoint() + 1;
				homeTable.setDraw(newHomeDraw);
				homeTable.setPoint(newPoint);
			}
			table.add(homeInTable, homeTable);
		}
		if(teamToAdd.equals("away")) 
		{
			
		}
		if(teamToAdd.equals("draw"))
		{
			
		}
	}

	private int findInTable(ArrayList<Table> table, String team) {
		int position = -1;
		for(Table t : table) 
		{
			if(t.getTeam().equals(team)) 
			{
				position = table.indexOf(t);
				break;
			}
		}
		return position;
	}
	

	
}
