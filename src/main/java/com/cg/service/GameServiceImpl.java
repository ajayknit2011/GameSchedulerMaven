package com.cg.service;

import com.cg.bean.Game;
import com.cg.exception.DuplicateEntriesException;
import com.cg.repo.GameRepo;

public class GameServiceImpl implements GameService {
	

	private GameRepo repo;

	public GameServiceImpl(GameRepo repo) {
	super();
	this.repo = repo;
	}
	public Game add(Game g) {
		Game existinggame=repo.findByName(g.getGameName());
		if(g==null ||g.getGameName()==null) {
			throw new IllegalArgumentException();
		}
		if(existinggame !=null) {
			throw new DuplicateEntriesException();
		}
		return repo.save(g);
		}
}
