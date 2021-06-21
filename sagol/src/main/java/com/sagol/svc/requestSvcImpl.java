package com.sagol.svc;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sagol.dao.requestDao;
import com.sagol.dto.requestVO;
import com.sagol.util.uidUtil;

@Service("requestSvc")
@Transactional
public class requestSvcImpl implements requestSvc {
	@Autowired
	private requestDao requestdao;

	@Override
	public List<requestVO> selectRequestList(requestVO requestvo) {
		// TODO Auto-generated method stub
		return requestdao.selectRequestList(requestvo);
	}
	
	@Override
	public List<requestVO> selectRequestListByUid(requestVO requestvo) {
		return requestdao.selectRequestListByUid(requestvo);
	}
	
	@Override
	public List<requestVO> selectRequestListByCompleteYn(requestVO requestvo) {
		// TODO Auto-generated method stub
		return requestdao.selectRequestListByCompleteYn(requestvo);
	}
	
	@Override
	public List<requestVO> selectRequestListByReqCd(requestVO requestvo) {
		// TODO Auto-generated method stub
		return requestdao.selectRequestListByReqCd(requestvo);
	}


	@Override
	public requestVO selectRequest(requestVO requestvo) {
		// TODO Auto-generated method stub
		return requestdao.selectRequest(requestvo);
	}

	@Override
	public int insertRequest(requestVO requestvo) {
		Timestamp time = new Timestamp(System.currentTimeMillis());
		requestvo.setReq_id(uidUtil.generateUid("R"));
		requestvo.setComplete_yn("N");
		requestvo.setReg_dt(time);
		requestvo.setMdfy_dt(time);
		return requestdao.insertRequest(requestvo);
	}

	@Override
	public int updateRequest(requestVO requestvo) {
		Timestamp time = new Timestamp(System.currentTimeMillis());
		requestvo.setMdfy_dt(time);
		return requestdao.updateRequest(requestvo);
	}

	@Override
	public int deleteRequest(requestVO requestvo) {
		return requestdao.deleteRequest(requestvo);
	}



}
