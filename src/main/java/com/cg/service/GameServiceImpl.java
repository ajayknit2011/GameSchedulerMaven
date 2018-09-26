package com.cg.service;

import com.cg.bean.Game;
import com.cg.repo.GameRepo;

public class GameServiceImpl implements GameService {
	

	private GameRepo repo;

	public GameServiceImpl(GameRepo repo) {
	super();
	this.repo = repo;
	}
	

	public Game add(Game g) {
		
		if(g.equals(null)) {
			
			throw new NullPointerException();
		}
		
	
		else if (g.getGameName() == null ) {
		throw new IllegalArgumentException();
		}
		
		else {
		Game game = new Game(g.getGameName(),g.getNoOfPlayers());
		
		if (repo.save(game).equals(g)) {
		return game;
		}
	    }
		return null;
		}
	


}
