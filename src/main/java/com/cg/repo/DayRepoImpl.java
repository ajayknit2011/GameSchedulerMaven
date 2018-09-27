package com.cg.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.cg.bean.Day;
import com.cg.bean.Game;
import com.cg.exception.DuplicateEntriesException;


public class DayRepoImpl implements DayRepo {
	private List<Day> days;

	
	public DayRepoImpl(List<Day> days) {
		
		super();
		this.days = days;
	}
	public List<Day> findByPlayerName(String playerName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public Day save(Day day) throws DuplicateEntriesException {
		if(day == null || day.getDayName()==null) {
			throw new NullPointerException();
		}
		days.add(day);
		
		return day;
	}

	public List<Day> findByGamesName(String gameName) {
		
		if(gameName == null) {
			throw new NullPointerException();
		}
		List<Day> d1 = new ArrayList<Day>();
		
		for(Day d:days) {
			
			Set<Game> games=d.getGames();
			
			for(Game g:games) {
				
				String sname=g.getGameName();						
				
				if(sname==gameName)
				{
					d1.add(d);
				}
			}
		}
		
		return d1;
	}


	// To Find Duplicate Day
	public Day findByName(String name) {
		if(name == null) {
			throw new NullPointerException();
		}
		for (Day day : days) {
			
			if(day.getDayName()==name) {
			
				return day;
			}
		}
		return null;
	}

}
