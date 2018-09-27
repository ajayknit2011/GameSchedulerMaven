package com.cg.repo;

import java.util.List;

import com.cg.bean.Day;

public interface DayRepo {

	public Day save(Day d);
	public Day findByName(String day);
	public List<Day> findByPlayerName(String playerName);
	public List<Day> findByGamesName(String gameName);
}
