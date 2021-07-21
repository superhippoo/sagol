package com.sagol.svc;

import java.sql.Timestamp;
//import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sagol.dao.ccDao;
import com.sagol.dto.ccVO;
import com.sagol.dto.searchVO;
import com.sagol.util.uidUtil;

@Service("ccSvc")
@Transactional
public class ccSvcImpl implements ccSvc {
	@Autowired
	private ccDao ccdao;

	@Override
	public List<ccVO> selectCcList(ccVO ccvo) {
		// TODO Auto-generated method stub
		return ccdao.selectCcList(ccvo);
	}
	
	public List<ccVO> selectCcListByCompCd(ccVO ccvo){
		return ccdao.selectCcListByCompCd(ccvo);
	};


	@Override
	public ccVO selectCc(ccVO ccvo) {
		// TODO Auto-generated method stub
		return ccdao.selectCc(ccvo);
	}

	@Override
	public int insertCc(ccVO ccvo) {
		// code definition
		// return 1 = success ,  2 = existcc, 0 = fail		

		ccvo.setCc_id(uidUtil.generateUid("D"));
		if (ccdao.isExistByCcId(ccvo) != 0) {
			return 2;
		}
		ccvo.setCc_stat("Y");
		Timestamp time = new Timestamp(System.currentTimeMillis());
		ccvo.setReg_dt(time);
		ccvo.setMdfy_dt(time);
		return ccdao.insertCc(ccvo);
	}

	@Override
	public int updateCc(ccVO ccvo) {
		if (ccdao.isExistByCcId(ccvo) == 0) {
			return 2;
		}
		Timestamp time = new Timestamp(System.currentTimeMillis());
		ccvo.setMdfy_dt(time);
		return ccdao.updateCc(ccvo);
	}

	@Override
	public int deleteCc(ccVO ccvo) {
		if (ccdao.isExistByCcId(ccvo) == 0) {
			return 2;
		}
		Timestamp time = new Timestamp(System.currentTimeMillis());
		ccvo.setMdfy_dt(time);		
		ccvo.setCc_stat("N");
		return ccdao.deleteCc(ccvo);
	}

	@Override
	public List<searchVO> search(searchVO searchvo) {
		// TODO Auto-generated method stub
		return ccdao.search(searchvo);
	}

}
