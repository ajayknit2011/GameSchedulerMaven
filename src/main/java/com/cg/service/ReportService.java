package com.cg.service;

import com.cg.bean.DayReport;
import com.cg.bean.GameReport;
import com.cg.bean.PlayerReport;

public interface ReportService {

	public GameReport gameWiseReport(String gameName);
	public PlayerReport playerWiseReport(String playerName);
	public DayReport dayWiseReport(String dayName);
	
}
