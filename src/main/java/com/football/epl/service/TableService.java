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
		
		System.out.println(results);
		
		if(results == null) return new ArrayList<Table>();
		
		ArrayList<Table> table = new ArrayList<>();
		
		for(Game game : results) {
			System.out.println(game);
			String winner = findWinner(game);
			table = calculateTable(table, game, winner);
		}

		return table;
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
		
		System.out.println(table);
		addInTable(table, game, winner, "home");
		addInTable(table, game, winner, "away");
		return table;
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
		
		System.out.println(homeInTable);
		System.out.println(awayInTable);
		
		if(teamToAdd.equals("home") && homeInTable != -1) 
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
		
		if(teamToAdd.equals("away") && awayInTable != -1) 
		{
			Table awayTable = table.get(awayInTable);
			
			int newGamePlayed = awayTable.getGamePlayed() + 1;
			int newGoalFor = awayTable.getGoalFor() + game.getHomeScore();
			int newGoalAgainst = awayTable.getGoalAgainst() + game.getAwayScore();
			int newGoalDifference = newGoalFor - newGoalAgainst;
			
			awayTable.setGamePlayed(newGamePlayed);
			awayTable.setGoalFor(newGoalFor);
			awayTable.setGoalAgainst(newGoalAgainst);
			awayTable.setGoalDifference(newGoalDifference);
			
			if(winner.equals("away"))
			{
				int newPoint = awayTable.getPoint() + 3;	
				int newWin = awayTable.getWin() + 1;

				awayTable.setPoint(newPoint);
				awayTable.setWin(newWin);
			}
			if(winner.equals("home"))
			{
				int newLoss = awayTable.getLoss() + 1;
				awayTable.setLoss(newLoss);
			}
			if(winner.equals("draw")) 
			{
				int newHomeDraw = awayTable.getDraw() + 1;
				int newPoint = awayTable.getPoint() + 1;
				awayTable.setDraw(newHomeDraw);
				awayTable.setPoint(newPoint);
			}
			table.add(homeInTable, awayTable);
		}
		
		if(teamToAdd.equals("away") && awayInTable == -1) {
			Table newTable = new Table();
			newTable.setGamePlayed(1);
			newTable.setTeam(game.getAway());
			newTable.setGoalFor(game.getAwayScore());
			newTable.setGoalAgainst(game.getHomeScore());
			newTable.setGoalDifference(game.getAwayScore()-game.getHomeScore());
			if(winner.equals("away")) {
				newTable.setPoint(3);
				newTable.setWin(1);
			}
			if(winner.equals("draw")) {
				newTable.setPoint(1);
				newTable.setDraw(1);
			}
			if(winner.equals("home")) {
				newTable.setLoss(1);
			}
			table.add(newTable);
		}
		
		if(teamToAdd.equals("home") && homeInTable == -1) {
			Table newTable = new Table();
			newTable.setGamePlayed(1);
			newTable.setTeam(game.getHome());
			newTable.setGoalFor(game.getHomeScore());
			newTable.setGoalAgainst(game.getAwayScore());
			newTable.setGoalDifference(game.getHomeScore()-game.getAwayScore());
			if(winner.equals("home")) {
				newTable.setPoint(3);
				newTable.setWin(1);
			}
			if(winner.equals("draw")) {
				newTable.setPoint(1);
				newTable.setDraw(1);
			}
			if(winner.equals("loss")) {
				newTable.setLoss(1);
			}
			table.add(newTable);
		}
		return true;
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
