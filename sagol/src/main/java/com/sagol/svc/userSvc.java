package com.sagol.svc;

import java.util.List;

import com.sagol.dto.userVO;

public interface  userSvc {
	
	public List<userVO> selectUserList(userVO uservo);

	public userVO selectUser(userVO uservo);

	public int insertUser(userVO uservo);
	
	public int updateUser(userVO uservo);
	
	public int deleteUser(userVO uservo);
	
}
