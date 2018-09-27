package com.cg.repo;

import com.cg.bean.Day;

public interface DayRepo {

	public Day save(Day d);
	public Day findByName(String day);
	public Day findByPlayerName(String playerName);
	public Day findByGamesName(String gameName);
}
