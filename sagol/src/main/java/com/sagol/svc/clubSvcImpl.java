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
import com.sagol.dao.scheduleDao;
import com.sagol.dao.userDao;
import com.sagol.dto.ccVO;
import com.sagol.dto.clubVO;
import com.sagol.dto.clubmemVO;
import com.sagol.dto.pageVO;
import com.sagol.dto.scheduleVO;
import com.sagol.dto.searchVO;
import com.sagol.dto.userVO;
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
	
	@Autowired
	private userDao userdao;
	
	@Autowired
	private scheduleDao scheduledao; 


	@Override
	public List<clubVO> selectClubList(clubVO clubvo) {
		// TODO Auto-generated method stub
		return clubdao.selectClubList(clubvo);
	}
	
	@Override
	public List<clubVO> selectClubListPaging(pageVO pagevo) {
		return clubdao.selectClubListPaging(pagevo.getClubvo(), pagevo.getPageStart(), pagevo.getPagesize());
	}
	
	public List<clubVO> selectClubListByCcId(clubVO clubvo){
		return clubdao.selectClubListByCcId(clubvo);
	};

	@Override
	public List<clubVO> selectClubListByCcIdPaging(pageVO pagevo) {
		// TODO Auto-generated method stub
		return clubdao.selectClubListByCcIdPaging(pagevo.getClubvo(), pagevo.getPageStart(), pagevo.getPagesize());
	}

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
		}//������ �����ϴ� Ŭ��id �ϰ�� 
		
		HttpSession session = request.getSession();
		userVO uservo = (userVO) session.getAttribute("userVO");
		
		if (Integer.parseInt(userdao.selectUser(uservo).getJoin_club_num()) >= 4) {
			return 3;
		}
		
		Timestamp time = new Timestamp(System.currentTimeMillis());
		clubvo.setClub_mem_num("1");
		clubvo.setReg_dt(time);
		clubvo.setMdfy_dt(time);
		int result = clubdao.insertClub(clubvo);
		// Ŭ������
		
		if (result == 1) {
			clubmemVO clubmemvo = new clubmemVO();
//			HttpSession session = request.getSession();
//			userVO uservo = (userVO) session.getAttribute("userVO");
			clubmemvo.setUid(uservo.getUid());
			clubmemvo.setClub_id(clubvo.getClub_id());
			clubmemvo.setOwner_yn("Y");
			clubmemvo.setReg_dt(time);
			clubmemdao.insertClubmem(clubmemvo);
			//Ŭ������ ������ �������� ���� ������ Ŭ����� �߰�
			userdao.addJoinClubNum(uservo);
			//������� ���� Ŭ������ 1 �����Ѵ�.
			ccVO ccvo = new ccVO();
			ccvo.setCc_id(clubvo.getCc_id());
			ccdao.addClubNum(ccvo);
			//�Ҽ� CC�� Ŭ������ 1 �����Ѵ�.
		}//@Transactional�� ���� ���н� �� �ѹ��
		
		return result;
	}

	@Override
	public int updateClub(clubVO clubvo,HttpServletRequest request) {
		
		if (clubdao.isExistByClubId(clubvo) == 0) {
			return 2;
		}
		
		HttpSession session = request.getSession();
		userVO sessionUservo = (userVO) session.getAttribute("userVO");	
		
		clubmemVO clubmemvo = new clubmemVO();
		clubmemvo.setClub_id(clubvo.getClub_id());
		
		clubmemVO resultclubmemvo = clubmemdao.selectOwnerByClubId(clubmemvo);
//		System.out.println(!(sessionUservo.getUid().equals(resultclubmemvo.getUid())));
//		System.out.println(!("Y".equals(sessionUservo.getAdmin_yn())));
		if (resultclubmemvo ==null) {
			return 4;
		}

		
		if (!(sessionUservo.getUid().equals(resultclubmemvo.getUid())) && !("Y".equals(sessionUservo.getAdmin_yn()))) {
			//������Ʈ �����ڰ� owner�� �ƴϰų� ������ �ƴҰ��
			return 3;
		}
		

		Timestamp time = new Timestamp(System.currentTimeMillis());
		clubvo.setMdfy_dt(time);
		return clubdao.updateClub(clubvo);
	}

	@Override
	public int deleteClub(clubVO clubvo,HttpServletRequest request) {
		
		if (clubdao.isExistByClubId(clubvo) == 0) {// �����ϴ� Ŭ���� �ƴϸ�
			return 2;
		}
		
		HttpSession session = request.getSession();
		userVO sessionUservo = (userVO) session.getAttribute("userVO");	
		
		clubmemVO clubmemvo = new clubmemVO();
		clubmemvo.setClub_id(clubvo.getClub_id());
		
		clubmemVO resultclubmemvo = clubmemdao.selectOwnerByClubId(clubmemvo);
		
		if (!(sessionUservo.getUid().equals(resultclubmemvo.getUid())) && !("Y".equals(sessionUservo.getAdmin_yn()))) {
			//������Ʈ �����ڰ� owner�� �ƴϰų� ������ �ƴҰ��
			return 3;
		}

		List<clubmemVO> list = clubmemdao.selectClubmemListByClubId(clubmemvo);//���ԵǾ��ִ� ����� ����� ��ȸ�ؼ�
		userVO uservo = new userVO();
		if (list.size() != 0) {//����� ���� ������			
			for (int i = 0; i < list.size(); i++) {
				uservo.setUid(list.get(i).getUid());
				userdao.minusJoinClubNum(uservo);//������� ���� Ŭ������ 1 �����Ѵ�.
			}			
		}
		//������� ���� Ŭ������ 1�� �� �����Ŀ� Ŭ�� ���� ��� ����
		clubmemdao.deleteClubmemsByClubid(clubmemvo);
		//�ܷ�Ű �������� ���� Club ���� ����� ���� ���� �� Club���� ����
		
		scheduleVO schedulevo = new scheduleVO();
		schedulevo.setClub_id(clubvo.getClub_id());
		scheduledao.deleteScheduleByClubId(schedulevo);
		//�ܷ�Ű �������� ���� Club ���� ������ ���� ���� �� Club���� ����
		int result = clubdao.deleteClub(clubvo);
		if (result ==1) {
			ccVO ccvo = new ccVO();
			ccvo.setCc_id(clubvo.getCc_id());
			ccdao.minusClubNum(ccvo);
			//Ŭ�� ������ �����Ǹ� CC�� Ŭ������ 1 ���δ�.
		}
		return result;

	}

	@Override
	public List<searchVO> search(searchVO searchvo) {
		// TODO Auto-generated method stub
		return clubdao.search(searchvo);
	}

	@Override
	public List<searchVO> searchPaging(pageVO pagevo) {
		// TODO Auto-generated method stub
		return clubdao.searchPaging(pagevo.getSearchvo(), pagevo.getPageStart(), pagevo.getPagesize());
	}






}
