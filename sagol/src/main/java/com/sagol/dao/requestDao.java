package com.sagol.dao;

import java.util.List;

import com.sagol.dto.requestVO;
import com.sagol.dto.searchVO;

public interface requestDao {
	
	public List<requestVO> selectRequestList(requestVO requestvo);
	
	public List<requestVO> selectRequestListByUid(requestVO requestvo);
	
	public List<requestVO> selectRequestListByCompleteYn(requestVO requestvo);

	public List<requestVO> selectRequestListByReqCd(requestVO requestvo);
		
	public requestVO selectRequest(requestVO requestvo);
	
	public int insertRequest(requestVO requestvo);
	
	public int updateRequest(requestVO requestvo);
	
	public int deleteRequest(requestVO requestvo);
	
	public int isExistByReqId(requestVO requestvo);
	
	public List<searchVO> search(searchVO searchvo);

}
