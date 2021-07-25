package com.sagol.dao;

import java.util.List;

import com.sagol.dto.ccVO;
import com.sagol.dto.searchVO;

public interface ccDao {
	
	public List<ccVO> selectCcList(ccVO ccvo);
	
	public List<ccVO> selectCcListByCompCd(ccVO ccvo);
	
	public ccVO selectCc(ccVO ccvo);

	public int insertCc(ccVO ccvo);
	
	public int updateCc(ccVO ccvo);

	public int deleteCc(ccVO ccvo);
	
	public int isExistByCcId(ccVO ccvo);

	public List<searchVO> search(searchVO searchvo);
	
	public int addClubNum(ccVO ccvo);
	
	public int minusClubNum(ccVO ccvo);
}
