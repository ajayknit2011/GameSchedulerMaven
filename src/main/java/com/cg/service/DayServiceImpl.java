package com.cg.service;

import com.cg.bean.Day;
import com.cg.bean.Game;
import com.cg.exception.DuplicateEntriesException;
import com.cg.repo.DayRepo;
import com.cg.repo.GameRepo;

public class DayServiceImpl implements DayService {
	DayRepo repod;
	public DayServiceImpl(DayRepo repod) {
		this.repod=repod;
	}
	public Day add(Day d)throws DuplicateEntriesException {
		Day existingday=repod.findByName(d.getDayName());
		if (d==null ||d.getDayName()==null) {
			throw new IllegalArgumentException();
		}
		if(existingday!=null) {
			throw new DuplicateEntriesException();
		}
		return repod.save(d);
	}
}
