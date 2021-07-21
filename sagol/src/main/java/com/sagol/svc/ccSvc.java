package com.sagol.svc;

import java.util.List;

import com.sagol.dto.ccVO;
import com.sagol.dto.searchVO;

public interface  ccSvc {
	
	public List<ccVO> selectCcList(ccVO ccvO);
	
	public List<ccVO> selectCcListByCompCd(ccVO ccvo);

	public ccVO selectCc(ccVO ccvO);

	public int insertCc(ccVO ccvO);
	
	public int updateCc(ccVO ccvO);
	
	public int deleteCc(ccVO ccvO);
	
	public List<searchVO> search(searchVO searchvo);
}
