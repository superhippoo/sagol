package com.sagol.svc;

import java.util.List;

import com.sagol.dto.ccVO;

public interface  ccSvc {
	
	public List<ccVO> selectCcList(ccVO ccvO);
	
	public List<ccVO> selectCcListByCompCd(ccVO ccvo);

	public ccVO selectCc(ccVO ccvO);

	public int insertCc(ccVO ccvO);
	
	public int updateCc(ccVO ccvO);
	
	public int deleteCc(ccVO ccvO);
}
