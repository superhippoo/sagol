package com.sagol.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sagol.dto.ccVO;

@Repository
public class ccDaoImple implements ccDao {

	@Autowired
	private JdbcTemplate jdbdtemplate;

	@Override
	public List<ccVO> selectCcList(ccVO ccvo) {

		String q = "select * from sg_cc";
		return jdbdtemplate.query(q, new BeanPropertyRowMapper<ccVO>(ccVO.class));

	}
	
	@Override
	public List<ccVO> selectCcListByCompCd(ccVO ccvo) {

		String q = "select * from sg_cc " 
					+ "where comp_cd = ?" ;
		Object[] args = { ccvo.getComp_cd()};
		return jdbdtemplate.query(q, args, new BeanPropertyRowMapper<ccVO>(ccVO.class));
	}

	@Override
	public ccVO selectCc(ccVO ccvo) {
		String q = "select * from sg_cc where cc_id = ?";
		Object[] args = { ccvo.getCc_id()};
		try {
			return jdbdtemplate.queryForObject(q, args, new BeanPropertyRowMapper<ccVO>(ccVO.class));
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int insertCc(ccVO ccvo) {
		String q = "  INSERT INTO sg_cc VALUES(?,?,?,?,?,?,?,?)";
		Object[] args = { ccvo.getCc_id(), ccvo.getCc_nm(), ccvo.getComp_cd(), ccvo.getCc_stat(), ccvo.getUid(),
				ccvo.getCc_user_num(), ccvo.getReg_dt(), ccvo.getMdfy_dt() };
		return jdbdtemplate.update(q, args);
	}

	@Override
	public int updateCc(ccVO ccvo) {
		String q = "update sg_cc set " 
				+ "cc_nm = ? , " 
				+ "comp_cd = ? , " 
				+ "cc_stat = ? , " 
				+ "uid = ? , " 
				+ "cc_user_num = ? , " 
			    + "mdfy_dt = ?"
			+ "where cc_id = ?";
		Object[] args = { ccvo.getCc_nm(), ccvo.getComp_cd(), ccvo.getCc_stat(), ccvo.getUid(), ccvo.getCc_user_num(),
				ccvo.getMdfy_dt(), ccvo.getCc_id() };
	return jdbdtemplate.update(q, args);
	}

	@Override
	public int deleteCc(ccVO ccvo) {
		String q = "update sg_cc set " 
	              + "cc_stat = ? ," 
				  + "mdfy_dt = ? "
	              + "where cc_id = ?";
		Object[] args = { ccvo.getCc_stat(),ccvo.getMdfy_dt(),ccvo.getCc_id()};
		return jdbdtemplate.update(q, args);
	}

	@Override
	public int isExistByCcId(ccVO ccvo) {
		String q = "select count(*) from sg_cc where cc_id = ?";
		Object[] args = { ccvo.getCc_id() };
		try {
			return jdbdtemplate.queryForObject(q, args, Integer.class);
		} catch (Exception e) {
			return 0;
		}
	}


}
