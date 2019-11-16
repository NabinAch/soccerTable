package com.football.epl.model;

public class Table {

	private String team;
	private int gamePlayed;
	private int win;
	private int draw;
	private int loss;
	private int point;
	private int goalFor;
	private int goalAgainst;
	private int goalDifference;
	
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public int getGamePlayed() {
		return gamePlayed;
	}
	public void setGamePlayed(int gamePlayed) {
		this.gamePlayed = gamePlayed;
	}
	public int getWin() {
		return win;
	}
	public void setWin(int win) {
		this.win = win;
	}
	public int getDraw() {
		return draw;
	}
	public void setDraw(int draw) {
		this.draw = draw;
	}
	public int getLoss() {
		return loss;
	}
	public void setLoss(int loss) {
		this.loss = loss;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getGoalFor() {
		return goalFor;
	}
	public void setGoalFor(int goalFor) {
		this.goalFor = goalFor;
	}
	public int getGoalAgainst() {
		return goalAgainst;
	}
	public void setGoalAgainst(int goalAgainst) {
		this.goalAgainst = goalAgainst;
	}
	public int getGoalDifference() {
		return goalDifference;
	}
	public void setGoalDifference(int goalDifference) {
		this.goalDifference = goalDifference;
	}
	@Override
	public String toString() {
		return "Table [team=" + team + ", gamePlayed=" + gamePlayed + ", win=" + win + ", draw=" + draw + ", loss="
				+ loss + ", point=" + point + ", goalFor=" + goalFor + ", goalAgainst=" + goalAgainst
				+ ", goalDifference=" + goalDifference + "]";
	}
	
	
}
