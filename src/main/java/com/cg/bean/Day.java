package com.cg.bean;

import java.util.Set;

public class Day {

	private String dayName;
	private Set<Game> games;

	public String getDayName() {
		return dayName;
	}

	public void setDayName(String dayName) {
		this.dayName = dayName;
	}

	public Set<Game> getGames() {
		return games;
	}

	public void setGames(Set<Game> games) {
		this.games = games;
	}
}
