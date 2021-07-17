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
		
		if(tempvo.getUid() != null) {//����� ������ ������
			if ("Y".equals(tempvo.getAct_yn())) {//Ȱ��ȭ �����̶��
				tempvo.setMessage("Login ok");
			}else {//Ȱ��ȭ ������ �ƴ϶��(�Ű�)
				tempvo.setMessage("In Active user");
			}
		}else {//����� ������ ���ٸ�
			tempvo.setMessage("Sign up required");
		}
		
		return tempvo; 
	}

}
