package com.football.epl.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Game {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String home;
	private String away;
	private int homeScore;
	private int awayScore;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public String getAway() {
		return away;
	}
	public void setAway(String away) {
		this.away = away;
	}
	public int getHomeScore() {
		return homeScore;
	}
	public void setHomeScore(int homeScore) {
		this.homeScore = homeScore;
	}
	public int getAwayScore() {
		return awayScore;
	}
	public void setAwayScore(int awayScore) {
		this.awayScore = awayScore;
	}
	@Override
	public String toString() {
		return "Game [id=" + id + ", home=" + home + ", away=" + away + ", homeScore=" + homeScore + ", awayScore="
				+ awayScore + "]";
	}
	
}
