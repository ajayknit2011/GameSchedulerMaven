package com.cg.bean;

import java.util.List;
import java.util.Map;

public class PlayerReport {

	private String playername;
	private Map<Game, List<Day>> map;

	public String getPlayername() {
		return playername;
	}

	public void setPlayername(String playername) {
		this.playername = playername;
	}

	public Map<Game, List<Day>> getMap() {
		return map;
	}

	public void setMap(Map<Game, List<Day>> map) {
		this.map = map;
	}

}
