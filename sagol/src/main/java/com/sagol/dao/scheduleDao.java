package com.sagol.dao;

import java.util.List;

import com.sagol.dto.scheduleVO;
import com.sagol.dto.searchVO;

public interface scheduleDao {
	
	public List<scheduleVO> selectScheduleList(scheduleVO schedulevo);
	
	public List<scheduleVO> selectScheduleListByClubId(scheduleVO schedulevo);

	public scheduleVO selectSchedule(scheduleVO schedulevo);
	
	public List<scheduleVO> selectScheduleListByClubIdList(List<String> list);
	
	public int insertSchedule(scheduleVO schedulevo);
	
	public int updateSchedule(scheduleVO schedulevo);
	
	public int deleteSchedule(scheduleVO schedulevo);
	
	public int isExistByScheduleId(scheduleVO schedulevo);
	
	public List<searchVO> search(searchVO searchvo);
	
	public int deleteScheduleByClubId(scheduleVO schedulevo);


}
