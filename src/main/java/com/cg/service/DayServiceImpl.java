package com.cg.service;

import com.cg.bean.Day;
import com.cg.bean.Game;
import com.cg.repo.DayRepo;
import com.cg.repo.GameRepo;

public class DayServiceImpl implements DayService {

	
	private DayRepo repo;
	public DayServiceImpl(DayRepo repo) {
		super();
		this.repo=repo;
	}
	
	public Day add(Day d) {
		// TODO Auto-generated method stub
		System.out.println("hello i am fffffgggg here");
		if(d.equals(null)) {
			System.out.println("hello i am null here");
			throw new NullPointerException();
			
		}
		else if(d.getDayName().equalsIgnoreCase(null)) {
			System.out.println("hello i nme null here");
			throw new IllegalArgumentException();
			
		}
		else {
			Day day=new Day(d.getDayName(),d.getGames());
			System.out.println("hello i am fffff here");
			/*if(repo.save(day).equals(day)) {
				return day;
			}*/
			
			if(repo.save(day).getDayName().equals(d.getDayName())) {
				System.out.println("hello i am here");
				return day;
			}
		}
		return null;
	}


	
}
