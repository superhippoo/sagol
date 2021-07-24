package com.sagol.dao;

import java.util.List;

import com.sagol.dto.clubmemVO;
import com.sagol.dto.searchVO;

public interface clubmemDao {
	
	public List<clubmemVO> selectClubmemList(clubmemVO clubmemvo);
	
	public List<clubmemVO> selectClubmemListByClubId(clubmemVO clubmemvo);
	
	public clubmemVO selectClubmem(clubmemVO clubmemvo);
	
	public int insertClubmem(clubmemVO clubmemvo);
	
	public int updateClubmem(clubmemVO clubmemvo);
	
	public int deleteClubmem(clubmemVO clubmemvo);
	
	public int deleteClubmemsByClubid(clubmemVO clubmemvo);
	
	public int isExistMemberInClubByUid(clubmemVO clubmemvo);
	
	public List<searchVO> search(searchVO searchvo);
	
	public int isExistOwnerInClubByClubid(clubmemVO clubmemvo);

	public clubmemVO selectOwnerClubmem(clubmemVO clubmemvo);
	
	public clubmemVO selectOwnerByClubId(clubmemVO clubmemvo);



}
