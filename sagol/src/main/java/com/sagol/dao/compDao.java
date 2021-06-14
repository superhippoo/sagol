package com.sagol.dao;

import java.util.List;

import com.sagol.dto.compVO;

public interface compDao {
	
	public List<compVO> selectCompList(compVO compvo);
	
	public compVO selectComp(compVO compvo);

	public int insertComp(compVO compvo);
	
	public int updateComp(compVO compvo);

	public int deleteComp(compVO compvo);

}
