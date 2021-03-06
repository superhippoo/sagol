package com.sagol.svc;

import java.sql.Timestamp;
//import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sagol.dao.compDao;
import com.sagol.dto.compVO;
import com.sagol.dto.searchVO;

@Service("compSvc")
@Transactional
public class compSvcImpl implements compSvc {
	@Autowired
	private compDao compdao;

	@Override
	public List<compVO> selectCompList(compVO compvo) {
		// TODO Auto-generated method stub
		return compdao.selectCompList(compvo);
	}

	@Override
	public compVO selectComp(compVO compvo) {
		// TODO Auto-generated method stub
		return compdao.selectComp(compvo);
	}

	@Override
	public int insertComp(compVO compvo) {
		// code definition
		// return 1 = success ,  2 = existcomp, 0 = fail		
		if (compdao.isExistByCompCd(compvo) != 0) {
			return 2;
		}
		
		compvo.setComp_stat("Y");
		Timestamp time = new Timestamp(System.currentTimeMillis());
		compvo.setReg_dt(time);
		compvo.setMdfy_dt(time);
		return compdao.insertComp(compvo);
	}

	@Override
	public int updateComp(compVO compvo) {
		// code definition
		// return 1 = success ,  2 = existcomp, 0 = fail		
		if (compdao.isExistByCompCd(compvo) == 0) {
			return 2;
		}
		Timestamp time = new Timestamp(System.currentTimeMillis());
		compvo.setMdfy_dt(time);
		return compdao.updateComp(compvo);
	}

	@Override
	public int deleteComp(compVO compvo) {
		// code definition
		// return 1 = success ,  2 = existcomp, 0 = fail		
		if (compdao.isExistByCompCd(compvo) == 0) {
			return 2;
		}
		Timestamp time = new Timestamp(System.currentTimeMillis());
		compvo.setMdfy_dt(time);		
		compvo.setComp_stat("N");
		return compdao.deleteComp(compvo);
	}

	@Override
	public List<searchVO> search(searchVO searchvo) {
		// TODO Auto-generated method stub
		return compdao.search(searchvo);
	}

	@Override
	public List<compVO> selectActiveCompList(compVO compvo) {
		// TODO Auto-generated method stub
		return compdao.selectActiveCompList(compvo);
	}

}
