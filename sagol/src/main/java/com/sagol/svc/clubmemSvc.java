package com.sagol.svc;

import java.util.List;

import com.sagol.dto.clubmemVO;
import com.sagol.dto.searchVO;

public interface  clubmemSvc {
	
	public List<clubmemVO> selectClubmemList(clubmemVO clubmemvo);
	
	public List<clubmemVO> selectClubmemListByClubId(clubmemVO clubmemvo);
	
	public clubmemVO selectClubmem(clubmemVO clubmemvo);
	
	public int insertClubmem(clubmemVO clubmemvo);
	
	public int updateClubmem(clubmemVO clubmemvo);
	
	public int deleteClubmem(clubmemVO clubmemvo);
	
	public List<searchVO> search(searchVO searchvo);

}
