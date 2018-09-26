package com.cg.bean;

import java.util.List;
import java.util.Map;

public class DayReport {

	private String dayName;
	private Map<Game, List<Player>> games;

	public String getDayName() {
		return dayName;
	}

	public void setDayName(String dayName) {
		this.dayName = dayName;
	}

	public Map<Game, List<Player>> getGames() {
		return games;
	}

	public void setGames(Map<Game, List<Player>> games) {
		this.games = games;
	}

}
