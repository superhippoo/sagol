package com.sagol.svc;

import java.sql.Timestamp;
//import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sagol.dao.clubmemDao;
import com.sagol.dto.clubmemVO;

@Service("clubmemSvc")
@Transactional
public class clubmemSvcImpl implements clubmemSvc {
	@Autowired
	private clubmemDao clubmemdao;

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
		Timestamp time = new Timestamp(System.currentTimeMillis());
		clubmemvo.setReg_dt(time);
		return clubmemdao.insertClubmem(clubmemvo);
	}

	@Override
	public int updateClubmem(clubmemVO clubmemvo) {
		return clubmemdao.updateClubmem(clubmemvo);
	}

	@Override
	public int deleteClubmem(clubmemVO clubmemvo) {
		return clubmemdao.deleteClubmem(clubmemvo);
	}



}
