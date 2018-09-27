package com.cg.repo;

import java.util.Set;

import com.cg.bean.Game;


public class GameRepoImpl implements GameRepo {

	private Set<Game> games;
	public GameRepoImpl(Set<Game> games) {
		super();
		this.games=games;
	}
	
	public Game save(Game game) {
		
		if(game == null || game.getGameName()==null) {
			 throw new NullPointerException();
		}
		games.add(game);
		
		return game;
	}


	public Game findByName(String name) {
		
		if(name == null) {
			throw new NullPointerException();
		}
		for (Game game : games) {
			
			if(game.getGameName()==name) {
			
				return game;
			}
		}
		return null;
	}

}
