package com.cg.repo;

import com.cg.bean.Player;

public interface PlayerRepo {

	
	public Player save(Player player);
	public Player findByDayName(String dayName);
	public Player findByGamesName(String gameName);

}
