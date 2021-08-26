package com.sagol.svc;

import java.sql.Timestamp;
//import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sagol.dao.clubDao;
import com.sagol.dao.clubmemDao;
import com.sagol.dao.userDao;
import com.sagol.dto.clubVO;
import com.sagol.dto.clubmemVO;
import com.sagol.dto.searchVO;
import com.sagol.dto.userVO;

@Service("clubmemSvc")
@Transactional
public class clubmemSvcImpl implements clubmemSvc {
	@Autowired
	private clubmemDao clubmemdao;
	
	@Autowired
	private clubDao clubdao;
	
	@Autowired
	private userDao userdao;

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
		userVO uservo = new userVO();
		uservo.setUid(clubmemvo.getUid());
		if (Integer.parseInt(userdao.selectUser(uservo).getJoin_club_num()) >= 4) {
			return 3;
		}
		Timestamp time = new Timestamp(System.currentTimeMillis());
		clubmemvo.setReg_dt(time);
		clubmemvo.setOwner_yn("N");
		// owner Y는 클럽 생성시, 오너가 클럽을 나가면서 새로운 오너가 설정될때 정해지기 때문에 멤버 추가시에는 N으로 고정한다.
		int result = clubmemdao.insertClubmem(clubmemvo);
		if (result == 1) {
			clubVO clubvo = new clubVO();
			clubvo.setClub_id(clubmemvo.getClub_id());
			clubdao.addClubMemNum(clubvo);//Club 멤버 추가 성공시 클럽의 멤버수 컬럼을 1증가한다.
			userdao.addJoinClubNum(uservo);//사용자의 가입 클럽수를 1 증가한다.
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
		}//1. 존재하는 멤버인지 확인 후 
		int result = clubmemdao.deleteClubmem(clubmemvo);//2. 존재하면 멤버에서 삭제 
		if (result == 1) {// 삭제가 정상적으로 되면
			clubVO clubvo = new clubVO();
			clubvo.setClub_id(clubmemvo.getClub_id());
			clubvo.setClub_type("C");// Todo 나중에 바꿔야될지도
			clubdao.minusClubMemNum(clubvo);//3. 멤버를 삭제한 클럽의 멤버수를 1 감소 
			
			userVO uservo = new userVO();
			uservo.setUid(clubmemvo.getUid());
			userdao.minusJoinClubNum(uservo);//사용자의 가입 클럽수를 1 감소한다.

			clubVO resultclubvo = clubdao.selectClub(clubvo);	
			if (Integer.parseInt(resultclubvo.getClub_mem_num()) == 0) {//4. 해당 클럽을 조회해서 멤버가 0명일경우
				clubdao.deleteClub(clubvo);// 5. 해당클럽을 삭제
			}else {//4. 해당 클럽의 멤버가 아직 있을경우 (0명이 아닌경우)				
				if (clubmemdao.isExistOwnerInClubByClubid(clubmemvo) == 0) {// 5. 해당 클럽에 오너가 존내하는지 보고 없으면(삭제한 멤버가 오너인지 확인하는것)
					clubmemVO newownervo = clubmemdao.selectOwnerClubmem(clubmemvo);//6. 등록일이 가장 빠른 사용자를 찾아서
//					System.out.println("newownervo.getUid() : "+newownervo.getUid());
					newownervo.setOwner_yn("Y");
					clubmemdao.updateClubmem(newownervo);//7. 그 사용자를 오너로 업데이트 한다.
				}
			}

		}
		return result;
	}

	@Override
	public List<searchVO> search(searchVO searchvo) {
		// TODO Auto-generated method stub
		return clubmemdao.search(searchvo);
	}



}
