package com.sagol.svc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sagol.dao.loginDao;
import com.sagol.dto.userVO;

@Service("loginSvc")
@Transactional
public class loginSvcImpl implements loginSvc {
	@Autowired
	private loginDao logindao;

	@Override
	public userVO login(userVO uservo) {
		// TODO Auto-generated method stub
		userVO tempvo = new userVO();
		tempvo = logindao.login(uservo);
		
		if(tempvo.getUid() != null) {//사용자 정보가 있으면
			if ("Y".equals(tempvo.getAct_yn())) {//활성화 계정이라면
				tempvo.setMessage("Login ok");
			}else {//활성화 계정이 아니라면(신고)
				tempvo.setMessage("In Active user");
			}
		}else {//사용자 계정이 없다면
			tempvo.setMessage("Sign up required");
		}
		
		return tempvo; 
	}

}
