package com.cg.repo;

import com.cg.bean.Game;

public interface GameRepo {
	
	public boolean save(Game game);
	public Game findByName(String name);

}
