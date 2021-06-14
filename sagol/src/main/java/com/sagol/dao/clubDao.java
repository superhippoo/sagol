package com.sagol.dao;

import java.util.List;

import com.sagol.dto.clubVO;

public interface clubDao {
	
	public List<clubVO> selectClubList(clubVO clubvo);
	
	public List<clubVO> selectClubListByCcId(clubVO clubvo);
	
	public clubVO selectClub(clubVO clubvo);

	public int insertClub(clubVO clubvo);
	
	public int updateClub(clubVO clubvo);

	public int deleteClub(clubVO clubvo);

}
