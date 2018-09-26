package com.cg.bean;

import java.util.Set;

public class Day {

	private String dayName;
	private Set<Game> games;
	

	public Day() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Day(String dayName, Set<Game> games) {
		super();
		this.dayName = dayName;
		this.games = games;
	}

	public String getDayName() {
		return dayName;
	}

	public void setDayName(String dayName) {
		this.dayName = dayName;
	}

	public Set<Game> getGames() {
		return games;
	}

	public void setGames(Set<Game> games) {
		this.games = games;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dayName == null) ? 0 : dayName.hashCode());
		result = prime * result + ((games == null) ? 0 : games.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Day other = (Day) obj;
		if (dayName == null) {
			if (other.dayName != null)
				return false;
		} else if (!dayName.equals(other.dayName))
			return false;
		if (games == null) {
			if (other.games != null)
				return false;
		} else if (!games.equals(other.games))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Day [dayName=" + dayName + ", games=" + games + "]";
	}
	
	
}
