package com.sagol.svc;

import java.sql.Timestamp;
//import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sagol.dao.ccDao;
import com.sagol.dto.ccVO;

@Service("ccSvc")
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
		ccvo.setCc_stat("Y");
		Timestamp time = new Timestamp(System.currentTimeMillis());
		ccvo.setReg_dt(time);
		ccvo.setMdfy_dt(time);
		return ccdao.insertCc(ccvo);
	}

	@Override
	public int updateCc(ccVO ccvo) {
		Timestamp time = new Timestamp(System.currentTimeMillis());
		ccvo.setMdfy_dt(time);
		return ccdao.updateCc(ccvo);
	}

	@Override
	public int deleteCc(ccVO ccvo) {
		Timestamp time = new Timestamp(System.currentTimeMillis());
		ccvo.setMdfy_dt(time);		
		ccvo.setCc_stat("N");
		return ccdao.deleteCc(ccvo);
	}

}
