package com.cg.service;

import com.cg.bean.Player;
import com.cg.exception.DuplicateEntriesException;
import com.cg.repo.PlayerRepo;

public class PlayerServiceImpl implements PlayerService {
	private PlayerRepo repop;
	public PlayerServiceImpl(PlayerRepo repop) {
		this.repop=repop;
	}
	public Player add(Player player) {
		// TODO Auto-generated method stub
		Player playerexist=repop.findByName(player.getPlayerName());
		if(player ==null ||player.getPlayerName()==null) {
			
			throw new IllegalArgumentException();
		}
		
		if(player.getGames().size()<=1) {
			
			throw new NullPointerException();
		}
		if(playerexist!=null) {
			throw new DuplicateEntriesException();
		}
		return repop.save(player);
	}

}
