package com.sagol.svc;

import java.util.List;

import com.sagol.dto.qnaVO;
import com.sagol.dto.searchVO;

public interface  qnaSvc {
	
	public List<qnaVO> selectQnaList(qnaVO qnavo);
	
	public List<qnaVO> selectQnaListByUid(qnaVO qnavo);
	
	public qnaVO selectQna(qnaVO qnavo);
	
	public int insertQna(qnaVO qnavo);
	
	public int updateQna(qnaVO qnavo);
	
	public int deleteQna(qnaVO qnavo);
	
	public List<searchVO> search(searchVO searchvo);

}
