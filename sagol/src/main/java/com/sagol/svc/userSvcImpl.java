package com.sagol.svc;

import java.sql.Timestamp;
//import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static Logger logger = LoggerFactory.getLogger(userSvcImpl.class);
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
	public int updateUser(userVO uservo,HttpServletRequest request) {

		if (userdao.isExistByUid(uservo) == 0) {
			return 2;
		}
		
		HttpSession session = request.getSession();
		userVO sessionUservo = (userVO) session.getAttribute("userVO");		

		if (!(sessionUservo.getUid().equals(uservo.getUid())) && !("Y".equals(sessionUservo.getAdmin_yn()))) {
			//업데이트 행위자가 본인이 아니거나 어드민이 아닐경우
			return 3;
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
			Timestamp time = new Timestamp(System.currentTimeMillis());
			uservo.setAuth_cd(authcdUtil.generateAuthcd());
			uservo.setMailsend_dt(time);
			userdao.saveauthcd(uservo);
			emailVO emailvo = new emailVO();
			emailvo.setToAddress(uservo.getComp_email());
			emailvo.setSubject("사골동 서비스 인증 요청");
			emailvo.setBody(uservo.getAuth_cd());
			emailutil.sendEmail(emailvo);
			return 1;
		} catch (Exception e) {
			logger.info("error : "+e);
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

	@Override
	public int isExistByKakaoEmail(userVO uservo) {
		if (userdao.isExistByKakaoEmail(uservo) != 0) {
			return 2;
		}
	
		return 1;		
	}

	@Override
	public int isExistByCompEmail(userVO uservo) {
		if (userdao.isExistByCompEmail(uservo) != 0) {
			return 2;
		}
		
		return 1;
	}

	@Override
	public String selectUserAuthYnByKakaoEmail(userVO uservo) {
		userVO result = userdao.selectUserByKakaoEmail(uservo);
		return result.getAuth_yn();
	}

	@Override
	public String selectUserAuthYnByCompEmail(userVO uservo) {
		userVO result = userdao.selectUserByCompEmail(uservo);
		return result.getAuth_yn();
	}


}
