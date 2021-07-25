package com.sagol.svc;

import java.sql.Timestamp;
//import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sagol.dao.ccDao;
import com.sagol.dao.clubDao;
import com.sagol.dao.clubmemDao;
import com.sagol.dto.ccVO;
import com.sagol.dto.clubVO;
import com.sagol.dto.clubmemVO;
import com.sagol.dto.searchVO;
import com.sagol.dto.userVO;
import com.sagol.util.sessionUtil;
import com.sagol.util.uidUtil;

@Service("clubSvc")
@Transactional
public class clubSvcImpl implements clubSvc {
	@Autowired
	private clubDao clubdao;
	
	@Autowired
	private clubmemDao clubmemdao;
	
	@Autowired
	private ccDao ccdao;


	@Override
	public List<clubVO> selectClubList(clubVO clubvo) {
		// TODO Auto-generated method stub
		return clubdao.selectClubList(clubvo);
	}
	
	public List<clubVO> selectClubListByCcId(clubVO clubvo){
		return clubdao.selectClubListByCcId(clubvo);
	};


	@Override
	public clubVO selectClub(clubVO clubvo) {
		// TODO Auto-generated method stub
		return clubdao.selectClub(clubvo);
	}

	@Override
	public int insertClub(clubVO clubvo,HttpServletRequest request) {
		clubvo.setClub_id(uidUtil.generateUid("C"));
		if (clubdao.isExistByClubId(clubvo) != 0) {
			return 2;
		}//기존에 존재하는 클럽id 일경우 
		
		Timestamp time = new Timestamp(System.currentTimeMillis());
		clubvo.setClub_mem_num("1");
		clubvo.setReg_dt(time);
		clubvo.setMdfy_dt(time);
		int result = clubdao.insertClub(clubvo);
		// 클럽생성
		
		if (result == 1) {
			clubmemVO clubmemvo = new clubmemVO();
			HttpSession session = request.getSession();
			userVO uservo = (userVO) session.getAttribute("userVO");
			clubmemvo.setUid(uservo.getUid());
			clubmemvo.setClub_id(clubvo.getClub_id());
			clubmemvo.setOwner_yn("Y");
			clubmemvo.setReg_dt(time);
			clubmemdao.insertClubmem(clubmemvo);
			//클럽생성 성공시 생성자의 세션 정보로 클럽멤버 추가
			ccVO ccvo = new ccVO();
			ccvo.setCc_id(clubvo.getCc_id());
			ccdao.addClubNum(ccvo);
			//소속 CC의 클럽수를 1 증가한다.
		}//@Transactional로 인해 실패시 올 롤백됨
		
		return result;
	}

	@Override
	public int updateClub(clubVO clubvo,HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		userVO sessionUservo = (userVO) session.getAttribute("userVO");	
		
		clubmemVO clubmemvo = new clubmemVO();
		clubmemvo.setClub_id(clubvo.getClub_id());
		
		clubmemVO resultclubmemvo = clubmemdao.selectOwnerByClubId(clubmemvo);
//		System.out.println(!(sessionUservo.getUid().equals(resultclubmemvo.getUid())));
//		System.out.println(!("Y".equals(sessionUservo.getAdmin_yn())));
		if (!(sessionUservo.getUid().equals(resultclubmemvo.getUid())) && !("Y".equals(sessionUservo.getAdmin_yn()))) {
			//업데이트 행위자가 owner가 아니거나 어드민이 아닐경우
			return 3;
		}
		
		if (clubdao.isExistByClubId(clubvo) == 0) {
			return 2;
		}
		Timestamp time = new Timestamp(System.currentTimeMillis());
		clubvo.setMdfy_dt(time);
		return clubdao.updateClub(clubvo);
	}

	@Override
	public int deleteClub(clubVO clubvo,HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		userVO sessionUservo = (userVO) session.getAttribute("userVO");	
		
		clubmemVO clubmemvo = new clubmemVO();
		clubmemvo.setClub_id(clubvo.getClub_id());
		
		clubmemVO resultclubmemvo = clubmemdao.selectOwnerByClubId(clubmemvo);
//		System.out.println(!(sessionUservo.getUid().equals(resultclubmemvo.getUid())));
//		System.out.println(!("Y".equals(sessionUservo.getAdmin_yn())));
		if (!(sessionUservo.getUid().equals(resultclubmemvo.getUid())) && !("Y".equals(sessionUservo.getAdmin_yn()))) {
			//업데이트 행위자가 owner가 아니거나 어드민이 아닐경우
			return 3;
		}
		if (clubdao.isExistByClubId(clubvo) == 0) {
			return 2;
		}
//		clubmemVO clubmemvo = new clubmemVO();
//		clubmemvo.setClub_id(clubvo.getClub_id());
		clubmemdao.deleteClubmemsByClubid(clubmemvo);
		//외래키 제약으로 인해 Club 하위 멤버들 먼저 삭제 후 Club삭제 진행
		int result = clubdao.deleteClub(clubvo);
		if (result ==1) {
			ccVO ccvo = new ccVO();
			ccvo.setCc_id(clubvo.getCc_id());
			ccdao.minusClubNum(ccvo);
			//클럽 삭제가 성공되면 CC의 클럽수를 1 줄인다.
		}
		return result;

	}

	@Override
	public List<searchVO> search(searchVO searchvo) {
		// TODO Auto-generated method stub
		return clubdao.search(searchvo);
	}



}
