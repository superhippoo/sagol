package com.sagol.svc;

import java.sql.Timestamp;
import java.util.ArrayList;
//import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sagol.dao.clubmemDao;
import com.sagol.dao.scheduleDao;
import com.sagol.dto.scheduleVO;
import com.sagol.dto.searchVO;
import com.sagol.dto.userVO;
import com.sagol.util.uidUtil;

@Service("scheduleSvc")
@Transactional
public class scheduleSvcImpl implements scheduleSvc {
	@Autowired
	private scheduleDao scheduledao;
	
	@Autowired
	private clubmemDao clubmemdao;

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
	public List<scheduleVO> selectScheduleListByUid(HttpServletRequest request) {
		searchVO searchvo = new searchVO();
		HttpSession session = request.getSession();
		userVO uservo = (userVO) session.getAttribute("userVO");
		searchvo.setUid(uservo.getUid());//세션의 사용자 uid를 받아와서
		List<searchVO> list = clubmemdao.search(searchvo);//uid가 있는 클럽 멤버 테이블의 데이터를 조회해서 clubid를 가져온다			
		
		if (!list.isEmpty()) {
			List<String> clubidlist = new ArrayList<String>();
			for (int i = 0; i < list.size(); i++) {
				clubidlist.add(list.get(i).getClub_id());
			}
			return scheduledao.selectScheduleListByClubIdList(clubidlist);
			
		}else {
			return null;

		}
		
		
	}

	@Override
	public scheduleVO selectSchedule(scheduleVO schedulevo) {
		// TODO Auto-generated method stub
		return scheduledao.selectSchedule(schedulevo);
	}

	@Override
	public int insertSchedule(scheduleVO schedulevo) {
		schedulevo.setSchedule_id(uidUtil.generateUid("S"));
		
		if (scheduledao.isExistByScheduleId(schedulevo) != 0) {
			return 2;
		}
		Timestamp time = new Timestamp(System.currentTimeMillis());
		schedulevo.setReg_dt(time);
		schedulevo.setMdfy_dt(time);
		return scheduledao.insertSchedule(schedulevo);
	}

	@Override
	public int updateSchedule(scheduleVO schedulevo) {
		if (scheduledao.isExistByScheduleId(schedulevo) == 0) {
			return 2;
		}
		Timestamp time = new Timestamp(System.currentTimeMillis());
		schedulevo.setMdfy_dt(time);
		return scheduledao.updateSchedule(schedulevo);
	}

	@Override
	public int deleteSchedule(scheduleVO schedulevo) {
		if (scheduledao.isExistByScheduleId(schedulevo) == 0) {
			return 2;
		}
		
		return scheduledao.deleteSchedule(schedulevo);
	}

	@Override
	public List<searchVO> search(searchVO searchvo) {
		// TODO Auto-generated method stub
		return scheduledao.search(searchvo);
	}


}
