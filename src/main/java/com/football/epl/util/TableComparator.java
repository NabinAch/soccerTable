package com.football.epl.util;

import java.util.Comparator;

import org.springframework.stereotype.Component;

import com.football.epl.model.Table;

@Component
public class TableComparator implements Comparator<Table> {

	@Override
	public int compare(Table o1, Table o2) {
		if(o1.getPoint() > o2.getPoint()) {
			return -1;
		}
		if(o1.getPoint() < o2.getPoint()) {
			return 1;
		}
		if(o1.getPoint() == o2.getPoint()) {
			if(o1.getGoalDifference() > o2.getGoalDifference()) {
				return -1;
			}
			if(o1.getGoalDifference() < o2.getGoalDifference()) {
				return 1;
			}
		}
		return 0;
	}

}
