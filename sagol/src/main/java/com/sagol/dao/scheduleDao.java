package com.sagol.dao;

import java.util.List;

import com.sagol.dto.scheduleVO;

public interface scheduleDao {
	
	public List<scheduleVO> selectScheduleList(scheduleVO shedulevo);
	
	public List<scheduleVO> selectScheduleListByClubId(scheduleVO shedulevo);

	public scheduleVO selectSchedule(scheduleVO shedulevo);

}
