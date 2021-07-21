package com.sagol.svc;

import java.sql.Timestamp;
//import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sagol.dao.clubDao;
import com.sagol.dao.clubmemDao;
import com.sagol.dto.clubVO;
import com.sagol.dto.clubmemVO;
import com.sagol.dto.searchVO;

@Service("clubmemSvc")
@Transactional
public class clubmemSvcImpl implements clubmemSvc {
	@Autowired
	private clubmemDao clubmemdao;
	
	@Autowired
	private clubDao clubdao;

	@Override
	public List<clubmemVO> selectClubmemList(clubmemVO clubmemvo) {
		// TODO Auto-generated method stub
		return clubmemdao.selectClubmemList(clubmemvo);
	}
	
	public List<clubmemVO> selectClubmemListByClubId(clubmemVO clubmemvo){
		return clubmemdao.selectClubmemListByClubId(clubmemvo);
	};


	@Override
	public clubmemVO selectClubmem(clubmemVO clubmemvo) {
		// TODO Auto-generated method stub
		return clubmemdao.selectClubmem(clubmemvo);
	}

	@Override
	public int insertClubmem(clubmemVO clubmemvo) {
		if (clubmemdao.isExistMemberInClubByUid(clubmemvo) != 0) {
			return 2;
		}
		Timestamp time = new Timestamp(System.currentTimeMillis());
		clubmemvo.setReg_dt(time);
		int result = clubmemdao.insertClubmem(clubmemvo);
		if (result == 1) {//Club 멤버 추가 성공시 클럽의 멤버수 컬럼을 1증가한다.
			clubVO clubvo = new clubVO();
			clubvo.setClub_id(clubmemvo.getClub_id());
			clubdao.addClubMemNum(clubvo);
		}
		return result;
	}

	@Override
	public int updateClubmem(clubmemVO clubmemvo) {
		if (clubmemdao.isExistMemberInClubByUid(clubmemvo) == 0) {
			return 2;
		}
		return clubmemdao.updateClubmem(clubmemvo);
	}

	@Override
	public int deleteClubmem(clubmemVO clubmemvo) {
		if (clubmemdao.isExistMemberInClubByUid(clubmemvo) == 0) {
			return 2;
		}
		int result = clubmemdao.deleteClubmem(clubmemvo);
		if (result == 1) {//Club 멤버 삭제 성공시 클럽의 멤버수 컬럼을 1감소한다.
			clubVO clubvo = new clubVO();
			clubvo.setClub_id(clubmemvo.getClub_id());
			clubdao.minusClubMemNum(clubvo);
		}
		return result;
	}

	@Override
	public List<searchVO> search(searchVO searchvo) {
		// TODO Auto-generated method stub
		return clubdao.search(searchvo);
	}



}
