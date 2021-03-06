package com.sagol.dao;

import java.util.List;

import com.sagol.dto.compVO;
import com.sagol.dto.searchVO;

public interface compDao {
	
	public List<compVO> selectCompList(compVO compvo);
	
	public compVO selectComp(compVO compvo);

	public int insertComp(compVO compvo);
	
	public int updateComp(compVO compvo);

	public int deleteComp(compVO compvo);
	
	public int isExistByCompCd(compVO compvo);
	
	public List<searchVO> search(searchVO searchvo);
	
	public List<compVO> selectActiveCompList(compVO compvo);


}
