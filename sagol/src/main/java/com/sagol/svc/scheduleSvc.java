package com.sagol.svc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sagol.dto.scheduleVO;
import com.sagol.dto.searchVO;

public interface  scheduleSvc {
	
	public List<scheduleVO> selectScheduleList(scheduleVO schedulevo);
	
	public List<scheduleVO> selectScheduleListByClubId(scheduleVO schedulevo);
	
	public List<scheduleVO> selectScheduleListByUid(HttpServletRequest request);

	public scheduleVO selectSchedule(scheduleVO schedulevo);

	public int insertSchedule(scheduleVO schedulevo);
	
	public int updateSchedule(scheduleVO schedulevo);
	
	public int deleteSchedule(scheduleVO schedulevo);
	
	public List<searchVO> search(searchVO searchvo);

}
