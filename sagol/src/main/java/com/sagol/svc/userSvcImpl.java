package com.sagol.svc;

import java.sql.Timestamp;
//import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sagol.dao.userDao;
import com.sagol.dto.userVO;
import com.sagol.util.uidUtil;

@Service("userSvc")
public class userSvcImpl implements userSvc {
	@Autowired
	private userDao userdao;

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
		uservo.setUid(uidUtil.generateUid("U"));
		uservo.setAct_yn("Y");
		Timestamp time = new Timestamp(System.currentTimeMillis());
		uservo.setReg_dt(time);
		uservo.setMdfy_dt(time);		
		return userdao.insertUser(uservo);
	}
	
	@Override
	public int updateUser(userVO uservo) {
		Timestamp time = new Timestamp(System.currentTimeMillis());
		uservo.setMdfy_dt(time);
		return userdao.updateUser(uservo);
	}
	

	@Override
	public int deleteUser(userVO uservo) {
		Timestamp time = new Timestamp(System.currentTimeMillis());
		uservo.setMdfy_dt(time);
		uservo.setAct_yn("N");
		return userdao.deleteUser(uservo);	
	}
}
