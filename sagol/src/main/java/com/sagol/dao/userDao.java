package com.sagol.dao;

import java.util.List;

import com.sagol.dto.searchVO;
import com.sagol.dto.userVO;

public interface userDao {
	
	public List<userVO> selectUserList(userVO uservo);
	
	public userVO selectUser(userVO uservo);

	public int insertUser(userVO uservo);
	
	public int updateUser(userVO uservo);

	public int deleteUser(userVO uservo);
	
	public int saveauthcd(userVO uservo);
	
	public int auth(userVO uservo);
	
	public int isExistByKakaoEmail(userVO uservo);

	public int isExistByUid(userVO uservo);
	
	public List<searchVO> search(searchVO searchvo);
	
	public int addJoinClubNum(userVO uservo);
	
	public int minusJoinClubNum(userVO uservo);
	
}
