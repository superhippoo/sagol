package com.sagol.svc;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sagol.dao.qnaDao;
import com.sagol.dto.qnaVO;
import com.sagol.util.uidUtil;

@Service("qnaSvc")
public class qnaSvcImpl implements qnaSvc {
	@Autowired
	private qnaDao qnadao;

	@Override
	public List<qnaVO> selectQnaList(qnaVO qnavo) {
		// TODO Auto-generated method stub
		return qnadao.selectQnaList(qnavo);
	}
	
	@Override
	public List<qnaVO> selectQnaListByUid(qnaVO qnavo) {
		return qnadao.selectQnaListByUid(qnavo);
	}

	@Override
	public qnaVO selectQna(qnaVO qnavo) {
		// TODO Auto-generated method stub
		return qnadao.selectQna(qnavo);
	}

	@Override
	public int insertQna(qnaVO qnavo) {
		Timestamp time = new Timestamp(System.currentTimeMillis());
		qnavo.setQna_id(uidUtil.generateUid("Q"));
		qnavo.setAnswer_yn("N");
		qnavo.setReg_dt(time);
		qnavo.setMdfy_dt(time);
		return qnadao.insertQna(qnavo);
	}

	@Override
	public int updateQna(qnaVO qnavo) {
		Timestamp time = new Timestamp(System.currentTimeMillis());
		qnavo.setMdfy_dt(time);
		return qnadao.updateQna(qnavo);
	}

	@Override
	public int deleteQna(qnaVO qnavo) {
		return qnadao.deleteQna(qnavo);
	}




}
