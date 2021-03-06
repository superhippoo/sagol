package com.sagol.svc;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sagol.dao.requestDao;
import com.sagol.dto.requestVO;
import com.sagol.dto.searchVO;
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
		requestvo.setReq_id(uidUtil.generateUid("R"));

		if (requestdao.isExistByReqId(requestvo) != 0) {
			return 2;
		}
		
		Timestamp time = new Timestamp(System.currentTimeMillis());
		requestvo.setComplete_yn("N");
		requestvo.setReg_dt(time);
		requestvo.setMdfy_dt(time);
		return requestdao.insertRequest(requestvo);
	}

	@Override
	public int updateRequest(requestVO requestvo) {
		if (requestdao.isExistByReqId(requestvo) == 0) {
			return 2;
		}
		Timestamp time = new Timestamp(System.currentTimeMillis());
		requestvo.setMdfy_dt(time);
		return requestdao.updateRequest(requestvo);
	}

	@Override
	public int deleteRequest(requestVO requestvo) {
		if (requestdao.isExistByReqId(requestvo) == 0) {
			return 2;
		}
		return requestdao.deleteRequest(requestvo);
	}

	@Override
	public List<searchVO> search(searchVO searchvo) {
		// TODO Auto-generated method stub
		return requestdao.search(searchvo);
	}



}
