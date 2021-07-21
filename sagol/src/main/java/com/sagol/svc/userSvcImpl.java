package com.sagol.svc;

import java.sql.Timestamp;
//import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sagol.dao.userDao;
import com.sagol.dto.emailVO;
import com.sagol.dto.searchVO;
import com.sagol.dto.userVO;
import com.sagol.util.authcdUtil;
import com.sagol.util.emailUtil;
import com.sagol.util.uidUtil;

@Service("userSvc")
@Transactional
public class userSvcImpl implements userSvc {
	@Autowired
	private userDao userdao;
	
	@Autowired
	private emailUtil emailutil;

	@Override
	public List<userVO> selectUserList(userVO uservo) {
		// TODO Auto-generated method stub
		return userdao.selectUserList(uservo);
	}

	@Override
	public userVO selectUser(userVO uservo) {
		// TODO Auto-generated method stub
		return userdao.selectUser(uservo);
	}
	
	@Override
	public int insertUser(userVO uservo) {
		// code definition
		// return 1 = success ,  2 = existuser, 0 = fail		
		if (userdao.isExistByKakaoEmail(uservo) != 0) {
			return 2;
		}
		
		uservo.setUid(uidUtil.generateUid("U"));
		uservo.setAct_yn("Y");
		Timestamp time = new Timestamp(System.currentTimeMillis());
		uservo.setReg_dt(time);
		uservo.setMdfy_dt(time);		
		return userdao.insertUser(uservo);
	}
	
	@Override
	public int updateUser(userVO uservo) {
		
		if (userdao.isExistByUid(uservo) == 0) {
			return 2;
		}
		
		Timestamp time = new Timestamp(System.currentTimeMillis());
		uservo.setMdfy_dt(time);
		return userdao.updateUser(uservo);
	}
	

	@Override
	public int deleteUser(userVO uservo) {
		if (userdao.isExistByUid(uservo) == 0) {
			return 2;
		}
		Timestamp time = new Timestamp(System.currentTimeMillis());
		uservo.setMdfy_dt(time);
		uservo.setAct_yn("N");
		return userdao.deleteUser(uservo);	
	}

	@Override
	public int sendAuthMail(userVO uservo) {

		try {
			uservo.setAuth_cd(authcdUtil.generateAuthcd());
			userdao.saveauthcd(uservo);
			emailVO emailvo = new emailVO();
			emailvo.setToAddress(uservo.getComp_email());
			emailvo.setSubject("��� ���� ���� ��û");
			emailvo.setBody(uservo.getAuth_cd());
			emailutil.sendEmail(emailvo);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public boolean checkAuthCd(userVO uservo) {
		
		String authCd = userdao.selectUser(uservo).getAuth_cd();
		
		if (uservo.getAuth_cd().equals(authCd)) {
			uservo.setAuth_yn("Y");
			userdao.auth(uservo);
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public List<searchVO> search(searchVO searchvo) {
		// TODO Auto-generated method stub
		return userdao.search(searchvo);
	}

	

}
