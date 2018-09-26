package com.cg.bean;

import java.util.List;

public class GameReport {

	private String gameName;
	private List<Player> players;
	private List<Day> days;
	
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	public List<Day> getDays() {
		return days;
	}
	public void setDays(List<Day> days) {
		this.days = days;
	}


	
}
