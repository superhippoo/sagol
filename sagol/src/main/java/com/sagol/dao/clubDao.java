package com.sagol.dao;

import java.util.List;

import com.sagol.dto.clubVO;
import com.sagol.dto.searchVO;

public interface clubDao {
	
	public List<clubVO> selectClubList(clubVO clubvo);
	
	public List<clubVO> selectClubListByCcId(clubVO clubvo);
	
	public clubVO selectClub(clubVO clubvo);

	public int insertClub(clubVO clubvo);
	
	public int updateClub(clubVO clubvo);

	public int deleteClub(clubVO clubvo);
	
	public int isExistByClubId(clubVO clubvo);
	
	public int addClubMemNum(clubVO clubvo);
	
	public int minusClubMemNum(clubVO clubvo);
	
	public List<searchVO> search(searchVO searchvo);

}
