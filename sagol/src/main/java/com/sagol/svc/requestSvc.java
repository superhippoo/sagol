package com.sagol.svc;

import java.util.List;

import com.sagol.dto.requestVO;

public interface  requestSvc {
	
	public List<requestVO> selectRequestList(requestVO requestvo);
	
	public List<requestVO> selectRequestListByUid(requestVO requestvo);
	
	public List<requestVO> selectRequestListByCompleteYn(requestVO requestvo);
	
	public List<requestVO> selectRequestListByReqCd(requestVO requestvo);
		
	public requestVO selectRequest(requestVO requestvo);
	
	public int insertRequest(requestVO requestvo);
	
	public int updateRequest(requestVO requestvo);
	
	public int deleteRequest(requestVO requestvo);
}
