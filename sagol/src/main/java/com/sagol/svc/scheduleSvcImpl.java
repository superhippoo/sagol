package com.sagol.svc;

//import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sagol.dao.scheduleDao;
import com.sagol.dto.scheduleVO;

@Service("scheduleSvc")
@Transactional
public class scheduleSvcImpl implements scheduleSvc {
	@Autowired
	private scheduleDao scheduledao;

	@Override
	public List<scheduleVO> selectScheduleList(scheduleVO schedulevo) {
		// TODO Auto-generated method stub
		return scheduledao.selectScheduleList(schedulevo);
	}

	@Override
	public List<scheduleVO> selectScheduleListByClubId(scheduleVO schedulevo) {
		// TODO Auto-generated method stub
		return scheduledao.selectScheduleListByClubId(schedulevo);
	}

	@Override
	public scheduleVO selectSchedule(scheduleVO schedulevo) {
		// TODO Auto-generated method stub
		return scheduledao.selectSchedule(schedulevo);
	}

}
