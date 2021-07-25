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
		// owner Y�� Ŭ�� ������, ���ʰ� Ŭ���� �����鼭 ���ο� ���ʰ� �����ɶ� �������� ������ ��� �߰��ÿ��� N���� �����Ѵ�.
		int result = clubmemdao.insertClubmem(clubmemvo);
		if (result == 1) {
			clubVO clubvo = new clubVO();
			clubvo.setClub_id(clubmemvo.getClub_id());
			clubdao.addClubMemNum(clubvo);//Club ��� �߰� ������ Ŭ���� ����� �÷��� 1�����Ѵ�.
			userdao.addJoinClubNum(uservo);//������� ���� Ŭ������ 1 �����Ѵ�.
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
		}//1. �����ϴ� ������� Ȯ�� �� 
		int result = clubmemdao.deleteClubmem(clubmemvo);//2. �����ϸ� ������� ���� 
		if (result == 1) {// ������ ���������� �Ǹ�
			clubVO clubvo = new clubVO();
			clubvo.setClub_id(clubmemvo.getClub_id());
			clubvo.setClub_type("C");// Todo ���߿� �ٲ�ߵ�����
			clubdao.minusClubMemNum(clubvo);//3. ����� ������ Ŭ���� ������� 1 ���� 
			
			userVO uservo = new userVO();
			uservo.setUid(clubmemvo.getUid());
			userdao.minusJoinClubNum(uservo);//������� ���� Ŭ������ 1 �����Ѵ�.

			clubVO resultclubvo = clubdao.selectClub(clubvo);	
			if (Integer.parseInt(resultclubvo.getClub_mem_num()) == 0) {//4. �ش� Ŭ���� ��ȸ�ؼ� ����� 0���ϰ��
				clubdao.deleteClub(clubvo);// 5. �ش�Ŭ���� ����
			}else {//4. �ش� Ŭ���� ����� ���� ������� (0���� �ƴѰ��)				
				if (clubmemdao.isExistOwnerInClubByClubid(clubmemvo) == 0) {// 5. �ش� Ŭ���� ���ʰ� �����ϴ��� ���� ������(������ ����� �������� Ȯ���ϴ°�)
					clubmemVO newownervo = clubmemdao.selectOwnerClubmem(clubmemvo);//6. ������� ���� ���� ����ڸ� ã�Ƽ�
//					System.out.println("newownervo.getUid() : "+newownervo.getUid());
					newownervo.setOwner_yn("Y");
					clubmemdao.updateClubmem(newownervo);//7. �� ����ڸ� ���ʷ� ������Ʈ �Ѵ�.
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
