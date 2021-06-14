package com.sagol.dao;

import java.util.List;

import com.sagol.dto.clubmemVO;

public interface clubmemDao {
	
	public List<clubmemVO> selectClubmemList(clubmemVO clubmemvo);
	
	public List<clubmemVO> selectClubmemListByClubId(clubmemVO clubmemvo);
	
	public clubmemVO selectClubmem(clubmemVO clubmemvo);
	
	public int insertClubmem(clubmemVO clubmemvo);
	
	public int updateClubmem(clubmemVO clubmemvo);
	
	public int deleteClubmem(clubmemVO clubmemvo);


}
