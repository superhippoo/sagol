package com.sagol.svc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sagol.dto.searchVO;
import com.sagol.dto.userVO;

public interface  userSvc {
	
	public List<userVO> selectUserList(userVO uservo);

	public userVO selectUser(userVO uservo);

	public int insertUser(userVO uservo);
	
	public int updateUser(userVO uservo,HttpServletRequest request);
	
	public int deleteUser(userVO uservo);
	
	public int sendAuthMail(userVO uservo);
	
	public boolean checkAuthCd(userVO uservo);
	
	public List<searchVO> search(searchVO searchvo);
	
	public int isExistByKakaoEmail(userVO uservo);
	
	public int isExistByCompEmail(userVO uservo);
	
	public String selectUserByKakaoEmail(userVO uservo);

}
