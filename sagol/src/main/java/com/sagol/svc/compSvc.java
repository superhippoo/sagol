package com.sagol.svc;

import java.util.List;

import com.sagol.dto.compVO;
import com.sagol.dto.searchVO;

public interface  compSvc {
	
	public List<compVO> selectCompList(compVO compvo);

	public compVO selectComp(compVO compvo);

	public int insertComp(compVO compvo);
	
	public int updateComp(compVO compvo);
	
	public int deleteComp(compVO compvo);
	
	public List<searchVO> search(searchVO searchvo);

}
